	package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return objMenuAclRepo.findByAclCode(aclCode);
	}
	
	public List<staffMenuAcl> ListAll(){		
		return objMenuAclRepo.findAll();
	}
		
	public Page<staffMenuAcl> ListAll(Pageable page){		
		return objMenuAclRepo.findAll(page);
	}
	
	public staffMenuAcl findByAclCode(String aclCode) {
		return objMenuAclRepo.findByAclCode(aclCode);
	} 
	public Page<staffMenuAcl> ListfindByAclUse(String AclUse,Pageable page){
		return objMenuAclRepo.findByAclUse(AclUse, page);
	}
	public Page<staffMenuAcl> ListfindByAclCodeContaining(String AclCode,Pageable page){
		return objMenuAclRepo.findByAclCodeContaining(AclCode, page);
	}
	public Page<staffMenuAcl> ListfindByAclNameContaining(String AclName,Pageable page){
		return objMenuAclRepo.findByAclNameContaining(AclName, page);
	}
 
	public Page<staffMenuAcl> ListfindByAclCodeContainingAndAclUse(String AclCode,String AclUse,Pageable page){
		return objMenuAclRepo.findByAclCodeContainingAndAclUse(AclCode, AclUse, page);
	}
	public Page<staffMenuAcl> ListfindByAclNameContainingAndAclUse(String AclName,String AclUse,Pageable page){
		return objMenuAclRepo.findByAclNameContainingAndAclUse(AclName, AclUse, page);
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
