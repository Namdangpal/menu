package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMemberDTO;
import com.sk.dep.staff.admin.menu.repository.staffMemberDTORepository;

 
/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 2. 19.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 2. 19.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@Service
public class staffMemberDTOService {
	@Autowired
	private staffMemberDTORepository objMemberDTORepo;
 
	public Page<staffMemberDTO> ListAll(Pageable page){		
		return objMemberDTORepo.findAll(page);
	}
	
	public Page<staffMemberDTO> ListAll(Specification<staffMemberDTO> spec,Pageable page){	
		return objMemberDTORepo.findAll(spec,page);
	}
	public List<staffMemberDTO> ListAll(){		
		return objMemberDTORepo.findAll();
	}
	public Page<staffMemberDTO> ListStaffState(String StaffState,Pageable page){		
		return objMemberDTORepo.findByStaffState(StaffState,page);
	}
	
	public Page<staffMemberDTO> ListStaffName(String StaffName,Pageable page){		
		return objMemberDTORepo.findByStaffNameContaining(StaffName,page);
	}
	public Page<staffMemberDTO> ListStaffId(String StaffId,Pageable page){		
		return objMemberDTORepo.findByStaffIdContaining(StaffId,page);
	}
	
	public Page<staffMemberDTO> ListStaffManagerName(String StaffManagerName,Pageable page){		
		return objMemberDTORepo.findByStaffManagerNameContaining(StaffManagerName,page);
	}
	public List<staffMemberDTO> ListFindByStaffAccountManager(String StaffAccountManager){		
		return objMemberDTORepo.findByStaffAccountManager(StaffAccountManager);
	}
	
	public Page<staffMemberDTO> ListStaffCompany(String StaffCompany,Pageable page){		
		return objMemberDTORepo.findByStaffCompanyContaining(StaffCompany, page);
	}
	 
	public Page<staffMemberDTO> ListStaffRoleCodeAndGroupCode(String RoleCode,String GroupCode,Pageable page){		
		return objMemberDTORepo.findByRoleCodeAndGroupCode(RoleCode, GroupCode, page);
	}
	
	public Page<staffMemberDTO> ListStaffCompanyAndRoleCodeAndGroupCode(String StaffCompany,String RoleCode,String GroupCode,Pageable page){		
		return objMemberDTORepo.findByStaffCompanyContainingAndRoleCodeAndGroupCode(StaffCompany, RoleCode, GroupCode, page);
	}
	
	public Page<staffMemberDTO> ListStaffStaffCompanyAndStaffNameAndStaffId(String StaffCompany,String StaffName,String StaffId,Pageable page){
		return objMemberDTORepo.findByStaffCompanyContainingAndStaffNameContainingAndStaffIdContaining(StaffCompany, StaffName, StaffId, page);
	}
	public Page<staffMemberDTO> ListSearchAll(
			String StaffCompany,
			String StaffName,
			String StaffId,
			String RoleCode,
			String GroupCode,
			String StaffState,
			String StaffManagerName,
			Pageable page){ 
		return objMemberDTORepo.findByStaffCompanyContainingOrStaffNameContainingOrStaffIdContainingOrRoleCodeAndGroupCodeOrStaffStateOrStaffManagerNameContaining(
				StaffCompany, StaffName, StaffId, RoleCode, GroupCode, StaffState, StaffManagerName, page);
	}
}
