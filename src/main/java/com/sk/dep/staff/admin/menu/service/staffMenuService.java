package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMenu;
import com.sk.dep.staff.admin.menu.domain.staffMenuDTO;
import com.sk.dep.staff.admin.menu.repository.staffMenuRepository;
 
/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 2. 19.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 2. 19.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@Service
public class staffMenuService {
	@Autowired
	private staffMenuRepository objMenuRepo;
	
	public staffMenu ListOne(String menuCode){		
		return objMenuRepo.findByMenuCode(menuCode);
	}
	
	public List<staffMenu> ListAll(){		
		return (List<staffMenu>)objMenuRepo.ListAllGroup();
	}	
	public List<staffMenuDTO> ListJoinAll(){		
		return objMenuRepo.ListJoinAllGroup();
	}	
	
	public List<staffMenu> ListAllJson(){		
		return objMenuRepo.ListAllJson();
	}
	
	public void Insert(staffMenu objMenu) throws Exception{ 
		objMenuRepo.save(objMenu);		 
	}

	public void Update(staffMenu objMenu) throws Exception{ 
		objMenuRepo.save(objMenu);		 
	}
	
	public void stepUpdate(long menuGroup,long menuStep) throws Exception{ 
		objMenuRepo.stepIncrement(menuGroup,menuStep);
	}
	
	public void stepRootStepUpdate(long menuGroup) throws Exception{ 
		 objMenuRepo.setRootStepIncrement(menuGroup);
	}
	
	public long getGroupMaxStep(long menuGroup) throws Exception{ 
		 return objMenuRepo.getGroupMaxStep(menuGroup);
	}
	public long getSubGroupMaxStep(staffMenu objMenu)
	{
		return objMenuRepo.getSubGroupMaxStep(objMenu.getMenuGroup(), objMenu.getMenuId());
	}
	 
	public long getGroupMinStep(long menuGroup) throws Exception{ 
		 return objMenuRepo.getGroupMinStep(menuGroup);
	}
	
	public void setSubStepIncrement(staffMenu objMenu) throws Exception{ 
		  objMenuRepo.setSubStepIncrement(objMenu.getMenuGroup(), objMenu.getMenuDepth(),objMenu.getMenuParents());
		  return;
	}
	public void GroupRootInsert(staffMenu objMenu) throws Exception{ 
		objMenuRepo.rootInsert(objMenu.getMenuId(),objMenu.getMenuCode(),objMenu.getMenuName(),objMenu.getMenuUrl(),objMenu.getMenuGroup(),objMenu.getMenuDepth());		 
	}
}
