package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffGroup;
import com.sk.dep.staff.admin.menu.service.staffGroupService;
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
public class staffGroupController {
	@Autowired
	private staffGroupService  objGroupService;
	@RequestMapping(value="/groupListOne/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffGroup getListOne(@PathVariable Long id) throws Exception{	
		 return objGroupService.ListOne(id);
	}
	
	@RequestMapping(value="/groupAllList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffGroup> getListALL() throws Exception{			 
		return  objGroupService.ListAll();
	}
	
	@RequestMapping(value = "/groupAllList/{pNo}/{size}}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
    public Page<staffGroup> getAllPagging(@PathVariable Integer pNo,@PathVariable Integer size) {
 	   PageRequest request = new PageRequest(pNo,size);
               return objGroupService.getAllStaffGroup(request);
    }
	
	@RequestMapping(value="/groupRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> groupregister(@RequestBody staffGroup staffgroup) throws Exception{		 
		objGroupService.Insert(staffgroup); 
		System.out.println("staffGoroupRegister호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/groupUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> groupupdate(@RequestBody staffGroup staffgroup) throws Exception{
		objGroupService.Update(staffgroup); 
		System.out.println("staffGoroupUpdate호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
