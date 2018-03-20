package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return objMenuTypeRepo.findByTypeCode(typeCode);
	}
	
	public List<staffMenuType> ListAll(){		
		return objMenuTypeRepo.findAll();
	}	
	
	public Page<staffMenuType> ListAll(Pageable page){		
		return objMenuTypeRepo.findAll(page);
	}	
		 
	public Page<staffMenuType> ListFindByTypeCode(String TypeCode,Pageable page){
		return objMenuTypeRepo.findByTypeCodeContaining(TypeCode,page);	
	}
	public Page<staffMenuType> ListFindByTypeName(String TypeName,Pageable page){
		return objMenuTypeRepo.findByTypeNameContaining(TypeName,page);	
	}
	
	public Page<staffMenuType> ListFindByTypeUse(String TypeUse,Pageable page){
		return objMenuTypeRepo.findByTypeUse(TypeUse,page);
	}
	
	public Page<staffMenuType> ListFindByTypeCodeAndTypeUse(String TypeCode,String TypeUse,Pageable page){
		return objMenuTypeRepo.findByTypeCodeContainingAndTypeUse(TypeCode, TypeUse,page);
	}
	public Page<staffMenuType> ListFindByTypeNameAndTypeUse(String TypeName,String TypeUse,Pageable page){
		return objMenuTypeRepo.findByTypeNameContainingAndTypeUse(TypeName, TypeUse,page);
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
