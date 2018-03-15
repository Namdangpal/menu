package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMenuDTO;
import com.sk.dep.staff.admin.menu.repository.staffMenuDTORepository;
 
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
public class staffMenuDTOService {
	@Autowired
	private staffMenuDTORepository objMenuDTORepo;
 
	public List<staffMenuDTO> ListJoinAll(){		
		return (List<staffMenuDTO>)objMenuDTORepo.ListJoinAllGroup();
	}	
	
	public  staffMenuDTO  ListJoinOne(String menuCode){		
		return  objMenuDTORepo.ListJoinGroupOne(menuCode);
	} 	
}
