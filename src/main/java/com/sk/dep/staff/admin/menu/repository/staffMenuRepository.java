package com.sk.dep.staff.admin.menu.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.staffMenu;
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
 
public interface staffMenuRepository extends JpaRepository<staffMenu, String>{ 	
	@Query(value = "SELECT * FROM menu Order by menu_group,menu_step" , nativeQuery = true)
	public List<staffMenu> ListAllJson();
	@Query(value = "SELECT * FROM menu Where menu_code =?1" , nativeQuery = true)
	public staffMenu findByMenuCode(String menuCode);
	
	@Query(value = "SELECT * FROM menu Order by menu_group,menu_step" , nativeQuery = true)
	public List<staffMenu> ListAllGroup();
	
	@Query(value = "SELECT IFNULL(MAX(menu_step),0) as menu_step FROM menu WHERE menu_group = ?1" , nativeQuery = true)
	public long getGroupMaxStep(long menu_group);
	
	
	 
	@Query(value = "SELECT IFNULL(menu_step,0) menu_step FROM menu "
			+ "				WHERE menu_group = (SELECT IFNULL(MIN(menu_group),0) as menu_group FROM menu "
			+ "						WHERE menu_group != ?1 and  menu_Depth  = 1  ) AND menu_depth = 1" , nativeQuery = true)
	public long getGroupMinStep(long menu_group);
	
	
	 
	@Query(value = "select distinct IF((select count(1) from menu where menu_group =?1 and menu_parents = ?2) > 0,\r\n" + 
			"			(select max(menu_step) from menu where menu_group =?1 and menu_parents = ?2), \r\n" + 
			"			(select MIN(menu_step) from menu where  menu_group =?1 and menu_Id = ?2 )) AS menu_step from menu where menu_group = ?1 " , nativeQuery = true)
	public long getSubGroupMaxStep(long menuGroup,long menuParents); 
	
	@Query(value = "SELECT menu.*, \r\n" + 
			"		GROUP_CONCAT(acl_code) menuAcl\r\n" + 
			"	    FROM menu LEFT OUTER JOIN menu_acl_item \r\n" + 
			"		ON menu.menu_code = menu_acl_item.menu_code\r\n" + 
			"			GROUP BY menu.menu_code\r\n" + 
			"				ORDER BY menu.menu_group,menu.menu_step" , nativeQuery = true)
	public List<staffMenuDTO> ListJoinAllGroup();
	
	@Transactional
	@Modifying
	@Query(value = "Update menu SET menu_step = menu_step + 1 Where menu_group = ?1 AND menu_step >= ?2" , nativeQuery = true)
	public void stepIncrement(long menuGroup,long menuStep);

	@Transactional
	@Modifying
	@Query(value = "UPDATE menu SET menu_step = IFNULL(menu_step,0) + 1\r\n" + 
					"			  WHERE menu_step >= (SELECT menu_step FROM (SELECT menu_step "
					+ "   FROM MENU WHERE menu_group = (SELECT IFNULL(MIN(menu_group),0) FROM menu WHERE  menu_group > ?1  AND   menu_Depth  = 1  ) "
					+ "    AND menu_depth = 1 ) AA)  " , nativeQuery = true)
	public void setRootStepIncrement(long menuGroup); 
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE menu set menu_step = IFNULL(menu_step,0) + 1 WHERE menu_group= ?1 AND menu_step >= (				  															\r\n" + 
						" SELECT menu_step FROM  (SELECT IFNULL(MAX(menu_step),0) + 1 menu_step FROM menu\r\n" + 
						" WHERE menu_group = ?1 \r\n" + 
						" AND menu_depth >= ?2\r\n" + 
						" AND menu_parents = ?3 ) AA ) " , nativeQuery = true)
	public void setSubStepIncrement(long menuGroup,long menuDepth,long menuParents); 
	/*
	@Transactional
	@Modifying
	@Query(value = "UPDATE menu SET menu_step = IFNULL(menu_step,0) + 1\r\n" + 
					"			  where menu_group=?1 AND menu_step >=(select menu_step from (select IFNULL(MAX(menu_step),0) + 1 as menu_step from menu where menu_group=?1) AA)" , nativeQuery = true)
	public void setRootStepIncrement(long menuGroup);*/
	
	@Transactional
	@Modifying
	@Query(value = "\r\n" + 
			"insert into menu(menu_id,menu_type,\r\n" + 
			"menu_code,\r\n" + 
			"menu_name,\r\n" + 
			"menu_name_eng,\r\n" + 
			"menu_url,\r\n" + 
			"menu_group,\r\n" + 
			"menu_step,\r\n" + 
			"menu_depth,\r\n" + 
			"menu_parents,\r\n" + 
			"menu_use) \r\n" + 
			" SELECT ?1 as menu_id,menu_type, ?2 as menu_code, ?3 as menu_name, ?4 as menu_name, ?5 as menu_url, ?6 as menu_group, IFNULL(menu_step,0) + 1 as menu_step, ?7 as menu_depth, 0 as menu_parents, 1 as menu_use\r\n" + 
			"FROM menu where menu_group= ?5 \r\n" + 
			"					and menu_step =(select max(menu_step) from menu where menu_group = ?6 and menu_depth > ?7)" , nativeQuery = true)
	public void rootInsert(long menuId,String menuCode,String menuName,String menuNameEng,String menuUrl,long menuGroup,int menuDepth);
	
}
 