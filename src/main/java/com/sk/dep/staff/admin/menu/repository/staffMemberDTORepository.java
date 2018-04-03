package com.sk.dep.staff.admin.menu.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sk.dep.staff.admin.menu.domain.staffMemberDTO;



 

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
 
public interface staffMemberDTORepository extends JpaRepository<staffMemberDTO, String>,JpaSpecificationExecutor<staffMemberDTO>{ 	
	public Page<staffMemberDTO> findAll(Pageable page);
	public List<staffMemberDTO> findAll();
	public Page<staffMemberDTO> findByStaffState(String StaffState,Pageable page);
	public Page<staffMemberDTO> findByStaffNameContaining(String StaffName,Pageable page);
	public Page<staffMemberDTO> findByStaffIdContaining(String StaffId,Pageable page);
	public Page<staffMemberDTO> findByStaffManagerNameContaining(String StaffManagerName,Pageable page);
	public List<staffMemberDTO> findByStaffAccountManager(String StaffAccountManager);
	public Page<staffMemberDTO> findByStaffCompanyContaining(String StaffCompany,Pageable page);
	public Page<staffMemberDTO> findByRoleCodeAndGroupCode(String RoleCode,String GroupCode,Pageable page);
	public Page<staffMemberDTO> findByStaffCompanyContainingAndRoleCodeAndGroupCode(String StaffCompany,String RoleCode,String GroupCode,Pageable page);
	public Page<staffMemberDTO> findByStaffCompanyContainingAndStaffNameContainingAndStaffIdContaining(String StaffCompany,String StaffName,String StaffId,Pageable page);
	public Page<staffMemberDTO> findByStaffCompanyContainingOrStaffNameContainingOrStaffIdContainingOrRoleCodeAndGroupCodeOrStaffStateOrStaffManagerNameContaining(
									String StaffCompany,
									String StaffName,
									String StaffId,
									String RoleCode,
									String GroupCode,
									String StaffState,
									String StaffManagerName,
									Pageable page);
	public Page<staffMemberDTO> findAll(Specification<staffMemberDTO> spec, Pageable pageable);
	/*@Query(value = "SELECT * FROM view_state_member WHERE staff_name like '%?1' " , nativeQuery = true)
	public Page<staffMemberDTO> findByDanamicQueryTest(String StaffName,Pageable page);*/
}
 