	package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffGroup;
import com.sk.dep.staff.admin.menu.repository.staffGroupRepository;

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 2. 13.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 2. 13.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@Service
public class staffGroupService {
	@Autowired
	private staffGroupRepository objGroupRepo;
	
	public staffGroup ListOne(Long id){		
		return objGroupRepo.findOne(id);
	}
	
	public List<staffGroup> ListAll(){		
		return objGroupRepo.findAll();
	}
	
	public List<staffGroup> ListAllGroupUse(String GroupUse){		
		return objGroupRepo.findByGroupUse(GroupUse);
	}
	
	public Page<staffGroup> ListAll(Pageable page){		
		return objGroupRepo.findAll(page);
	}	
	
	public Page<staffGroup> ListfindByRoleCodeContaining(String RoleCode,Pageable page){
		return objGroupRepo.findByRoleCodeContaining(RoleCode, page);
	}	
	public Page<staffGroup> ListfindByGroupCodeContaining(String GroupCode,Pageable page){
		return objGroupRepo.findByGroupCodeContaining(GroupCode, page);
	}
	public Page<staffGroup> ListfindByRoleCodeContainingAndGroupUse(String RoleCode,String GroupUse,Pageable page){
		return objGroupRepo.findByGroupCodeContainingAndGroupUse(RoleCode, GroupUse, page);
	} 
	public Page<staffGroup> ListfindByRoleCodeContainingAndGroupCodeContainingAndGroupUse(String RoleCode,String GroupCode,String GroupUse,Pageable page){
		return objGroupRepo.findByRoleCodeContainingAndGroupCodeContainingAndGroupUse(RoleCode,GroupCode, GroupUse, page);
	}  
	public Page<staffGroup> ListfindByRoleCodeContainingAndGroupNameContainingAndGroupUse(String RoleCode,String GroupName,String GroupUse,Pageable page){
		return objGroupRepo.findByRoleCodeContainingAndGroupNameContainingAndGroupUse(RoleCode,GroupName,GroupUse,page);
	}  
	
	public Page<staffGroup> ListfindByGroupUse(String GroupUse,Pageable page){
		return objGroupRepo.findByGroupUse(GroupUse, page);
	}
	
	public void Insert(staffGroup objGroup) throws Exception{ 
		//objApi.setApiId(5L);
		objGroupRepo.save(objGroup);		 
	}

	public void Update(staffGroup objGroup) throws Exception{ 
		//objApi.setApiId(5L);
		objGroupRepo.save(objGroup);		 
	}
}
