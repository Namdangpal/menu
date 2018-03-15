package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffMenuAclJson;
import com.sk.dep.staff.admin.menu.service.staffMenuAclJsonService;
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
public class staffMenuAclJsonController {
	@Autowired
	private staffMenuAclJsonService  objMenuAclJsonService;
	
	@RequestMapping(value="/groupMenuAclOne/{roleCode}/{groupCode}/{menuCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffMenuAclJson getListOne(@PathVariable String roleCode,@PathVariable String groupCode,@PathVariable String menuCode) throws Exception{	
		 return objMenuAclJsonService.ListOne(roleCode, groupCode, menuCode);
	}
	
	@RequestMapping(value="/groupMenuAclAllList/{roleCode}/{groupCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenuAclJson> getListALL(@PathVariable String roleCode,@PathVariable String groupCode) throws Exception{			 
		return  objMenuAclJsonService.ListAll(roleCode, groupCode);
	}
	
	@RequestMapping(value="/groupMenuAclRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> menuaclregister(@RequestBody staffMenuAclJson staffmenuacljson) throws Exception{		 
		objMenuAclJsonService.Insert(staffmenuacljson.getRoleCode(),staffmenuacljson.getGroupCode(),staffmenuacljson.getMenuCode(),staffmenuacljson.getAclJsonData()); 
		System.out.println("groupMenuAclRegister호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/groupMenuAclUpdate", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> menuaclupdate(@RequestBody staffMenuAclJson staffmenuacljson) throws Exception{		 
		objMenuAclJsonService.Update(staffmenuacljson.getRoleCode(),staffmenuacljson.getGroupCode(),staffmenuacljson.getMenuCode(),staffmenuacljson.getAclJsonData()); 
		System.out.println("groupMenuAclRegister호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
