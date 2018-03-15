package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMenuType;
import com.sk.dep.staff.admin.menu.repository.staffMenuTypeRepository;
 
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
public class staffMenuTypeService {
	@Autowired
	private staffMenuTypeRepository objMenuTypeRepo;
	
	public staffMenuType ListOne(String typeCode){		
		return objMenuTypeRepo.findByMenuTypeCode(typeCode);
	}
	
	public List<staffMenuType> ListAll(){		
		return objMenuTypeRepo.findAll();
	}	
	
	public List<staffMenuType> ListUseAll(){		
		return objMenuTypeRepo.findByMenuTypeUseCode();
	}
	 	
	public void Insert(staffMenuType objMenuType) throws Exception{ 
		objMenuTypeRepo.save(objMenuType);		 
	}

	public void Update(staffMenuType objMenuType) throws Exception{ 
		objMenuTypeRepo.save(objMenuType);		 
	}
	
}
