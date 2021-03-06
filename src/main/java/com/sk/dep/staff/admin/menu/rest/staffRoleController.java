package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.sk.dep.staff.admin.menu.domain.staffGroup;
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
	
	private static final Logger logger = LoggerFactory.getLogger(staffRoleController.class);

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
	
	@RequestMapping(value = "/roleAllList/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
    public Page<staffRole> getListALLPagging(@PathVariable Integer pNo,@PathVariable Integer size) {
 	   PageRequest request = new PageRequest(pNo,size);
               return objRoleService.ListAll(request);
    }
	
	@RequestMapping(value="/roleAllList/{RoleUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffRole> getListALLRoleUse(@PathVariable String RoleUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{
		PageRequest request = new PageRequest(pNo,size);
		return  objRoleService.ListAllRoleUse(RoleUse,request);
	}
	
	@RequestMapping(value="/roleAllList/roleCode/{RoleCode}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffRole> getListFindByRoleCode(@PathVariable String RoleCode, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objRoleService.ListFindByRoleCode(RoleCode,request);
	}
	
	@RequestMapping(value="/roleAllList/roleName/{RoleName}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffRole> getListFindByRoleName(@PathVariable String RoleName, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objRoleService.ListFindByRoleName(RoleName,request);
	}
	@RequestMapping(value="/roleAllList/roleCode/{RoleCode}/{RoleUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffRole> getListFindByRoleCodeAndRoleUse(@PathVariable String RoleCode,@PathVariable String RoleUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objRoleService.ListFindByRoleCodeAndRoleUse(RoleCode, RoleUse,request);
	}
	
	@RequestMapping(value="/roleAllList/roleName/{RoleName}/{RoleUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffRole> getListFindByRoleNameAndRoleUse(@PathVariable String RoleName,@PathVariable String RoleUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objRoleService.ListFindByRoleNameAndRoleUse(RoleName, RoleUse,request);
	}
	 
	
	@RequestMapping(value="/roleRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> roleregister(@RequestBody staffRole staffrole) throws Exception{		 
		objRoleService.Insert(staffrole); 
		 logger.info("roleRegister");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/roleUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> roleupdate(@RequestBody staffRole staffrole) throws Exception{
		objRoleService.Update(staffrole); 
		logger.info("roleUpdate");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/roleDelete", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> roledelete(@RequestBody staffRole staffrole) throws Exception{
		objRoleService.Delete(staffrole); 
		logger.info("roleDelete");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
