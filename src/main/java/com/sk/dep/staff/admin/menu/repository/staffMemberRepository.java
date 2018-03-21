package com.sk.dep.staff.admin.menu.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.dep.staff.admin.menu.domain.staffMember;
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
 
public interface staffMemberRepository extends JpaRepository<staffMember, String>{ 		
	public Page<staffMember> findByStaffState(String StaffState,Pageable page);
	public Page<staffMember> findByStaffNameContaining(String StaffName,Pageable page);
	public Page<staffMember> findByRoleCodeAndGroupCode(String RoleCode,String GroupCode,Pageable page);
	public Page<staffMember> findByStaffCompanyContaining(String StaffCompany,Pageable page);
}
 