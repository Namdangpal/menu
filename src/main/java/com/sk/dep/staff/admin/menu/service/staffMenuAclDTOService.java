package com.sk.dep.staff.admin.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.staffMenuAclDTO;
import com.sk.dep.staff.admin.menu.repository.staffMenuAclDTORepository;


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
public class staffMenuAclDTOService {
	@Autowired
	private staffMenuAclDTORepository objMenuAclDTORepo;
 
	public List<staffMenuAclDTO> ListMenuAcl(String roleCode,String groupCode){		
		return objMenuAclDTORepo.staffGroupMenuAclList(roleCode, groupCode);
	}	
	
	public  staffMenuAclDTO  ListMenuAclOne(String roleCode,String groupCode,String menuCode){		
		return  objMenuAclDTORepo.staffGroupMenuAclOne(roleCode, groupCode, menuCode);
	} 	
}
