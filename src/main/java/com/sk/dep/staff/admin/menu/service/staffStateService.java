package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffState;
import com.sk.dep.staff.admin.menu.repository.staffStateRepository;

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
public class staffStateService {
	@Autowired
	private staffStateRepository objStaffState;
	
	public staffState ListOne(String id){		
		return objStaffState.findOne(id);
	}
	
	public List<staffState> ListAll(){		
		return objStaffState.findAll();
	}
	
	public List<staffState> ListAllStateUse(String StateUse){		
		return objStaffState.findByStateUse(StateUse);
	}
	public Page<staffState> ListAll(Pageable page){		
		return objStaffState.findAll(page);
	}
	public Page<staffState> ListAllStateUse(String StateUse,Pageable page){		
		return objStaffState.findByStateUse(StateUse,page);
	}
	
	public Page<staffState> ListFindByStateCode(String StateCode,Pageable page){		
		return  objStaffState.findByStateCodeContaining(StateCode,page);
	}
	
	public Page<staffState> ListFindByStateName(String StateName,Pageable page){		
		return  objStaffState.findByStateNameContaining(StateName,page);
	}
	
	public Page<staffState> ListFindByStateCodeAndStateUse(String StateCode,String StateUse,Pageable page){		
		return objStaffState.findByStateCodeContainingAndStateUse(StateCode, StateUse, page);
	}
	
	public Page<staffState> ListFindByStateNameAndStateUse(String StateName,String StateUse,Pageable page){		
		return objStaffState.findByStateNameContainingAndStateUse(StateName, StateUse, page);
	}
	
	public void Insert(staffState objstate) throws Exception{ 
		//objApi.setApiId(5L);
		objStaffState.save(objstate);		 
	}

	public void Update(staffState objstate) throws Exception{ 
		//objApi.setApiId(5L);
		objStaffState.save(objstate);		 
	}
	 
}
