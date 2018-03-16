package com.sk.dep.staff.admin.menu.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.staffMenuType;
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
	@Query(value = "SELECT * FROM staff_role Where role_use= ?1  Order by role_id" , nativeQuery = true)
	public List<staffRole> findByRoleUseCode(int intUse); 
}
 