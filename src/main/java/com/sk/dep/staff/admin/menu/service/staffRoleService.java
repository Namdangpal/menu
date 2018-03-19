	package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffGroup;
import com.sk.dep.staff.admin.menu.domain.staffRole;
import com.sk.dep.staff.admin.menu.repository.staffRoleRepository;


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
public class staffRoleService {
	@Autowired
	private staffRoleRepository objRole;
	
	public staffRole ListOne(Long id){		
		return objRole.findOne(id);
	}
	
	public List<staffRole> ListAll(){		
		return objRole.findAll();
	}
	
	public Page<staffRole> getAllStaffRole(Pageable page) {

		return objRole.findAll(page);

	}
	public void Insert(staffRole objrole) throws Exception{ 
		//objApi.setApiId(5L);
		objRole.save(objrole);		 
	}

	public void Update(staffRole objrole) throws Exception{ 
		//objApi.setApiId(5L);
		objRole.save(objrole);		 
	}
}
