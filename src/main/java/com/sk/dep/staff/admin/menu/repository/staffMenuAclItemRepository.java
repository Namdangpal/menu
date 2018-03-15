package com.sk.dep.staff.admin.menu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.staffMenuAcl;
import com.sk.dep.staff.admin.menu.domain.staffMenuAclItem;
 

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
 
public interface staffMenuAclItemRepository extends JpaRepository<staffMenuAclItem, String>{ 	
	@Query(value = "SELECT * FROM menu_acl_item Where menu_code =?1" , nativeQuery = true)
	public staffMenuAcl findByMenuAclMenuCode(String menuCode);
	
}
 