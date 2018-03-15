package com.sk.dep.staff.admin.menu.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.staffMenuAclJson;
 

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
 
public interface staffMenuAclJsonRepository extends JpaRepository<staffMenuAclJson,Long>{ 	
	@Query(value = "SELECT * FROM menu_acl_json Where role_code = ?1 and group_code = ?2 and menu_code =?3" , nativeQuery = true)
	public staffMenuAclJson findByMenuAclJsonOne(String roleCode,String groupCode,String menuCode);
	
	@Query(value = "SELECT * FROM menu_acl_json Where role_code = ?1 and group_code = ?2" , nativeQuery = true)
	public List<staffMenuAclJson> findByMenuAclJsonAll(String roleCode,String groupCode);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM staff_acl_json Where role_code = ?1 and group_code = ?2 and menu_code =?3" , nativeQuery = true)
	public void strffMenuAclJson_Delete(String roleCode,String groupCode,String menuCode);
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO staff_acl_json (role_code,\r\n" + 
			"										group_code,\r\n" + 
			"										menu_code,\r\n" + 
			"										acl_json_data)\r\n" + 
			"										VALUES(?1,?2,?3,?4)" , nativeQuery = true)
	public void strffMenuAclJson_Insert(String roleCode,String groupCode,String menuCode,String aclJsonData);
}
 