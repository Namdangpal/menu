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

import com.sk.dep.staff.admin.menu.domain.staffMenuAcl;
import com.sk.dep.staff.admin.menu.service.staffMenuAclService;
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
public class staffMenuAclController {
	@Autowired
	private staffMenuAclService  objMenuAclService;
	
	@RequestMapping(value="/aclListOne/{aclCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffMenuAcl getListOne(@PathVariable String aclCode) throws Exception{	
		 return objMenuAclService.ListOne(aclCode);
	}
	
	@RequestMapping(value="/aclAllList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenuAcl> getListALL() throws Exception{			 
		return  objMenuAclService.ListAll();
	}
	
	@RequestMapping(value="/aclRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> menuaclregister(@RequestBody staffMenuAcl staffmenuacl) throws Exception{		 
		objMenuAclService.Insert(staffmenuacl); 
		System.out.println("staffMenuRegister호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/aclUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> menuaclupdate(@RequestBody staffMenuAcl staffmenuacl) throws Exception{
		objMenuAclService.Update(staffmenuacl); 
		System.out.println("staffMenuUpdate호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
