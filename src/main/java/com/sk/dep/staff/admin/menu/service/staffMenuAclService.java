	package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMenuAcl;
import com.sk.dep.staff.admin.menu.repository.staffMenuAclRepository;

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
public class staffMenuAclService {
	@Autowired
	private staffMenuAclRepository objMenuAclRepo;
	
	public staffMenuAcl ListOne(String aclCode){		
		return objMenuAclRepo.findByMenuAclCode(aclCode);
	}
	
	public List<staffMenuAcl> ListAll(){		
		return objMenuAclRepo.findAll();
	}
	
	public void Insert(staffMenuAcl objMenuAcl) throws Exception{ 
		//objApi.setApiId(5L);
		objMenuAclRepo.save(objMenuAcl);		 
	}

	public void Update(staffMenuAcl objMenuAcl) throws Exception{ 
		//objApi.setApiId(5L);
		objMenuAclRepo.save(objMenuAcl);		 
	}
}
