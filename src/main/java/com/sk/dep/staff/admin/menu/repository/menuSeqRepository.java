package com.sk.dep.staff.admin.menu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sk.dep.staff.admin.menu.domain.menuSeq;
 

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
 
public interface menuSeqRepository extends JpaRepository<menuSeq, Long>{ 	
	@Query(value = "SELECT * FROM menu_seq WHERE seq_id = (SELECT IFNULL(Max(seq_id),0) FROM menu_seq) " , nativeQuery = true)
	public menuSeq getMenuSeqMAX();
	 
}
 