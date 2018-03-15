package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffMenuAclDTO;
import com.sk.dep.staff.admin.menu.service.staffMenuAclDTOService;
/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 2. 27.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 2. 27.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@RestController
@RequestMapping(value="/staff")
public class staffMenuAclDTOController {
	@Autowired
	private staffMenuAclDTOService  objMenuAclDTOService;   
	 
	@RequestMapping(value="/staffMenuAclList/{roleCode}/{groupCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenuAclDTO> getMenuAclList(@PathVariable String roleCode,@PathVariable String groupCode) throws Exception{	
		
		return  objMenuAclDTOService.ListMenuAcl(roleCode, groupCode);
	}
	
	@RequestMapping(value="/staffMenuAclOne/{roleCode}/{groupCode}/{menuCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public  staffMenuAclDTO  getListJoinOne(@PathVariable String roleCode,@PathVariable String groupCode,@PathVariable String menuCode) throws Exception{	
			
		return  objMenuAclDTOService.ListMenuAclOne(roleCode, groupCode, menuCode);
	}
}
