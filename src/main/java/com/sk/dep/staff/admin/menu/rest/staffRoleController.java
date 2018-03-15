package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffRole;
import com.sk.dep.staff.admin.menu.service.staffRoleService;


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
public class staffRoleController {
	@Autowired
	private staffRoleService  objRoleService;
	@RequestMapping(value="/roleListOne/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffRole getListOne(@PathVariable Long id) throws Exception{	
		 return objRoleService.ListOne(id);
	}
	
	@RequestMapping(value="/roleAllList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffRole> getListALL() throws Exception{			 
		return  objRoleService.ListAll();
	}
	
	@RequestMapping(value="/roleRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> roleregister(@RequestBody staffRole staffrole) throws Exception{		 
		objRoleService.Insert(staffrole); 
		System.out.println("roleRegister호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/roleUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> roleupdate(@RequestBody staffRole staffrole) throws Exception{
		objRoleService.Update(staffrole); 
		System.out.println("roleUpdate호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
