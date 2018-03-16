package com.sk.dep.staff.admin.menu.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.staffMenuDTO;
 

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
 
public interface staffMenuDTORepository extends JpaRepository<staffMenuDTO, String>{ 	
	 
	
	@Query(value = "SELECT  menu.menu_id, \r\n" + 
			"		 	  menu.menu_type, \r\n" + 
			"			  menu.menu_code, \r\n" + 
			"		 	  menu.menu_name,  \r\n" + 
			"		 	  menu.menu_name_eng,  \r\n" + 
			"			  menu.menu_url, \r\n" + 
			"			  menu.menu_group, \r\n" + 
			"			  menu.menu_step, \r\n" + 
			"			  menu.menu_depth, \r\n" + 
			"			  menu.menu_parents, \r\n" + 
			"			  menu.menu_use,  \r\n" + 
			"			  menu_acl,\r\n" + 
			"			  menu_acl_name\r\n" + 
			"		FROM menu LEFT OUTER JOIN (\r\n" + 
			"						SELECT  menu_acl_item.menu_code,\r\n" + 
			"								GROUP_CONCAT(menu_acl_item.acl_code) menu_acl,\r\n" + 
			"								GROUP_CONCAT(menu_acl.acl_name) menu_acl_name \r\n" + 
			"							FROM menu_acl_item\r\n" + 
			" 								INNER JOIN menu_acl ON menu_acl_item.acl_code = menu_acl.acl_code\r\n" + 
			"								 GROUP BY menu_acl_item.menu_code) KK ON menu.menu_code = KK.menu_code  \r\n" + 
			"		GROUP BY KK.menu_code \r\n" + 
			"		ORDER BY menu.menu_group,menu.menu_step " , nativeQuery = true)
	public List<staffMenuDTO> ListJoinAllGroup();
	
	@Query(value = "SELECT  menu.menu_id, \r\n" + 
			"		 	  menu.menu_type, \r\n" + 
			"			  menu.menu_code, \r\n" + 
			"		 	  menu.menu_name,  \r\n" + 
			"		 	  menu.menu_name_eng,  \r\n" + 
			"			  menu.menu_url, \r\n" + 
			"			  menu.menu_group, \r\n" + 
			"			  menu.menu_step, \r\n" + 
			"			  menu.menu_depth, \r\n" + 
			"			  menu.menu_parents, \r\n" + 
			"			  menu.menu_use,  \r\n" + 
			"			  menu_acl,\r\n" + 
			"			  menu_acl_name\r\n" + 
			"		FROM menu LEFT OUTER JOIN (\r\n" + 
			"						SELECT  menu_acl_item.menu_code,\r\n" + 
			"								GROUP_CONCAT(menu_acl_item.acl_code) menu_acl,\r\n" + 
			"								GROUP_CONCAT(menu_acl.acl_name) menu_acl_name \r\n" + 
			"							FROM menu_acl_item\r\n" + 
			" 								INNER JOIN menu_acl ON menu_acl_item.acl_code = menu_acl.acl_code\r\n" + 
			"								 GROUP BY menu_acl_item.menu_code) KK ON menu.menu_code = KK.menu_code  \r\n" + 
			"		WHERE  menu.menu_code =?1 "
			+     " GROUP BY menu.menu_code \r\n" + 
			"		ORDER BY menu.menu_group,menu.menu_step " , nativeQuery = true)
	public  staffMenuDTO  ListJoinGroupOne(String menuCode);
}
 