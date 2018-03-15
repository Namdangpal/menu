package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffMenuDTO;
import com.sk.dep.staff.admin.menu.service.staffMenuDTOService;
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
public class staffMenuDTOController {
	@Autowired
	private staffMenuDTOService  objMenuDTOService;   
	 
	@RequestMapping(value="/menuDTOListJoinList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenuDTO> getListJoinALL() throws Exception{	
			
		return  objMenuDTOService.ListJoinAll();
	}
	
	@RequestMapping(value="/menuDTOListJoinOne/{menuCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public  staffMenuDTO  getListJoinOne(@PathVariable String menuCode) throws Exception{	
			
		return  objMenuDTOService.ListJoinOne(menuCode);
	}
}
