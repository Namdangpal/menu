package com.sk.dep.staff.admin.menu.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.dep.staff.admin.menu.domain.staffRole;

 

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
 
public interface staffRoleRepository extends JpaRepository<staffRole, Long>{ 		
	public Page<staffRole> findByRoleUse(String RoleUse,Pageable page);
	public Page<staffRole> findByRoleCodeContaining(String RoleCode,Pageable page);
	public Page<staffRole> findByRoleNameContaining(String RoleName,Pageable page);
	public Page<staffRole> findByRoleCodeContainingAndRoleUse(String RoleCode,String RoleUse,Pageable page);
	public Page<staffRole> findByRoleNameContainingAndRoleUse(String RoleName,String RoleUse,Pageable page);
}
 