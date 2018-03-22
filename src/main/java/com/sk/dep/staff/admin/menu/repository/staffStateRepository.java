package com.sk.dep.staff.admin.menu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.dep.staff.admin.menu.domain.staffState;

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 3. 22.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 3. 22.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */

public interface staffStateRepository extends JpaRepository<staffState, String>{
	public List<staffState> findByStateUse(String StateUse);
	public Page<staffState> findByStateUse(String StateUse,Pageable page);
	public Page<staffState> findByStateCodeContaining(String StateCode,Pageable page);
	public Page<staffState> findByStateNameContaining(String StateName,Pageable page);
	public Page<staffState> findByStateCodeContainingAndStateUse(String StateCode,String StateUse,Pageable page);
	public Page<staffState> findByStateNameContainingAndStateUse(String StateName,String StateUse,Pageable page);
}
 