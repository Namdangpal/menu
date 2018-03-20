package com.sk.dep.staff.admin.menu.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.staffMenuAcl;
 

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
 
public interface staffMenuAclRepository extends JpaRepository<staffMenuAcl, String>{ 	
	public staffMenuAcl findByAclCode(String aclCode);
	public Page<staffMenuAcl> findByAclUse(String AclUse,Pageable page);
	public Page<staffMenuAcl> findByAclCodeContaining(String AclCode,Pageable page);
	public Page<staffMenuAcl> findByAclNameContaining(String AclName,Pageable page);
	public Page<staffMenuAcl> findByAclCodeContainingAndAclUse(String AclCode,String AclUse,Pageable page);
	public Page<staffMenuAcl> findByAclNameContainingAndAclUse(String AclName,String AclUse,Pageable page);
}
 