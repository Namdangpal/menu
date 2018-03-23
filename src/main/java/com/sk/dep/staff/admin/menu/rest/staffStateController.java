package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffState;
import com.sk.dep.staff.admin.menu.service.staffStateService;
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
public class staffStateController {
	@Autowired
	private staffStateService  objService;
	@RequestMapping(value="/staffStateOne/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffState getListOne(@PathVariable String id) throws Exception{	
		 return objService.ListOne(id);
	}
	
	@RequestMapping(value="/staffStateAllList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffState> getListALL() throws Exception{			 
		return  objService.ListAll();
	}
	
	@RequestMapping(value="/staffStateAllList/{StateUse}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffState> getListALLStateUse(@PathVariable String StateUse) throws Exception{			 
		return  objService.ListAllStateUse(StateUse);
	}
	
	@RequestMapping(value="/staffStateAllList/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffState> getListPage(@PathVariable Integer pNo,@PathVariable Integer size) throws Exception{	
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListAll(request);
	}
	
	@RequestMapping(value="/staffStateAllList/{StateUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffState> getListALLStateUse(@PathVariable String StateUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListAllStateUse(StateUse,request);
	}
	
	@RequestMapping(value="/staffStateAllList/StateCode/{StateCode}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffState> getListFindByStateCode(@PathVariable String StateCode, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListFindByStateCode(StateCode,request);
	}
	
	@RequestMapping(value="/staffStateAllList/StateName/{StateName}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffState> getListFindByStateName(@PathVariable String StateName, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListFindByStateName(StateName,request);
	}
	@RequestMapping(value="/staffStateAllList/StateCode/{StateCode}/{StateUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffState> getListFindByStateCodeAndStateUse(@PathVariable String StateCode,@PathVariable String StateUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListFindByStateCodeAndStateUse(StateCode, StateUse,request);
	}
	
	@RequestMapping(value="/staffStateAllList/StateName/{StateName}/{StateUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffState> getListFindByStateNameAndStateUse(@PathVariable String StateName,@PathVariable String StateUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListFindByStateNameAndStateUse(StateName, StateUse,request);
	}
	 
	
	@RequestMapping(value="/staffStateRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> roleregister(@RequestBody staffState staffrole) throws Exception{		 
		objService.Insert(staffrole); 
		//System.out.println("staffStateRegister호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/staffStateUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> roleupdate(@RequestBody staffState staffrole) throws Exception{
		objService.Update(staffrole); 
		//System.out.println("staffStateUpdate호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	 
}
