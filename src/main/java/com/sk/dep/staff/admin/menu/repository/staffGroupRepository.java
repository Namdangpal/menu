package com.sk.dep.staff.admin.menu.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sk.dep.staff.admin.menu.domain.staffGroup;
 

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
 
public interface staffGroupRepository extends JpaRepository<staffGroup, Long>{ 	
	public Page<staffGroup> findByRoleCodeContaining(String RoleCode,Pageable page);
	public Page<staffGroup> findByGroupCodeContaining(String GroupCode,Pageable page);
	public Page<staffGroup> findByRoleCodeContainingAndGroupUse(String RoleCode,String GroupUse,Pageable page);
	public Page<staffGroup> findByGroupCodeContainingAndGroupUse(String GroupCode,String GroupUse,Pageable page);
	public Page<staffGroup> findByRoleCodeContainingAndGroupCodeContainingAndGroupUse(String RoleCode,String GroupCode,String GroupUse,Pageable page);
	public Page<staffGroup> findByRoleCodeContainingAndGroupNameContainingAndGroupUse(String RoleCode,String GroupName,String GroupUse,Pageable page);
	public Page<staffGroup> findByGroupUse(String GroupUse,Pageable page);
}
 