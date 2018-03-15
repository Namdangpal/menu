	package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMenuAclJson;
import com.sk.dep.staff.admin.menu.repository.staffMenuAclJsonRepository;

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
public class staffMenuAclJsonService {
	@Autowired
	private staffMenuAclJsonRepository objMenuAclJsonRepo;
	
	public staffMenuAclJson ListOne(String roleCode,String groupCode,String menuCode){		
		return objMenuAclJsonRepo.findByMenuAclJsonOne(roleCode,groupCode,menuCode);
	}
	
	public List<staffMenuAclJson> ListAll(String roleCode,String groupCode){		
		return objMenuAclJsonRepo.findByMenuAclJsonAll(roleCode, groupCode);
	}
	
	public void Insert(String roleCode,String groupCode,String menuCode,String aclJsonData) throws Exception{ 
		objMenuAclJsonRepo.strffMenuAclJson_Delete(roleCode, groupCode, menuCode);
		objMenuAclJsonRepo.strffMenuAclJson_Insert(roleCode, groupCode, menuCode, aclJsonData); 
	}

	public void Update(String roleCode,String groupCode,String menuCode,String aclJsonData) throws Exception{ 
		objMenuAclJsonRepo.strffMenuAclJson_Delete(roleCode, groupCode, menuCode);
		objMenuAclJsonRepo.strffMenuAclJson_Insert(roleCode, groupCode, menuCode, aclJsonData); 
	}
}
