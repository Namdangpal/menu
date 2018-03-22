	package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMember;
import com.sk.dep.staff.admin.menu.repository.staffMemberRepository;


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
@Service
public class staffMemberService {
	@Autowired
	private staffMemberRepository objStaffMember;
	
	public staffMember ListOne(String id){		
		return objStaffMember.findOne(id);
	}
	
	public List<staffMember> ListAll(){		
		return objStaffMember.findAll();
	}
	public Page<staffMember> ListAll(Pageable page){		
		return objStaffMember.findAll(page);
	}
	public Page<staffMember> ListAllStaffState(String StaffState,Pageable page){		
		return objStaffMember.findByStaffState(StaffState,page);
	}
	
	public Page<staffMember> ListFindByStaffName(String StaffName,Pageable page){		
		return objStaffMember.findByStaffNameContaining(StaffName,page);
	}
	
	public Page<staffMember> ListFindByRoleCodeAndGroupCode(String RoleCode,String GroupCode,Pageable page){		
		return objStaffMember.findByRoleCodeAndGroupCode(RoleCode, GroupCode,page);
	}
	
	public List<staffMember> ListFindByRoleCodeAndGroupCode(String RoleCode,String GroupCode){		
		return objStaffMember.findByRoleCodeAndGroupCode(RoleCode, GroupCode);
	}
	
	public List<staffMember> ListFindByStaffAccountManager(String StaffAccountManager){		
		return objStaffMember.findByStaffAccountManager(StaffAccountManager);
	}
	
	public Page<staffMember> ListFindByStaffCompanyName(String StaffCompany,Pageable page){		
		return objStaffMember.findByStaffCompanyContaining(StaffCompany, page);
	}
	
	public void Insert(staffMember objStaff) throws Exception{ 		 
		objStaffMember.save(objStaff);		 
	}

	public void Update(staffMember objStaff) throws Exception{  
		objStaffMember.save(objStaff);		 
	}
	
	public boolean staffMemberExists(String id) throws Exception{ 		 
		return objStaffMember.exists(id);
	}
	
	public List<Object[]> staffMemberCompanyList() throws Exception{ 		 
		return objStaffMember.findByDistinctStaffCompany();
	}
	 
}
