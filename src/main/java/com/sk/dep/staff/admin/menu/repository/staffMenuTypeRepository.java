package com.sk.dep.staff.admin.menu.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.staffMenuType;
 

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
 
public interface staffMenuTypeRepository extends JpaRepository<staffMenuType, String>{ 	
	@Query(value = "SELECT * FROM menu_type Where type_code =?1" , nativeQuery = true)
	public staffMenuType findByMenuTypeCode(String typeCode);
	
	@Query(value = "SELECT * FROM menu_type Where type_use= 1 Order by type_id" , nativeQuery = true)
	public List<staffMenuType> findByMenuTypeUseCode();
}
 