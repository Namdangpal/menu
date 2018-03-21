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

import com.sk.dep.staff.admin.menu.domain.staffMenuType;
import com.sk.dep.staff.admin.menu.service.staffMenuTypeService;
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
public class staffMenuTypeController {
	
	private static final Logger logger = LoggerFactory.getLogger(staffMenuTypeController.class);

	@Autowired
	private staffMenuTypeService  objMenuTypeService;
	
	@RequestMapping(value="/menuTypeListOne/{menuTypeCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffMenuType getListOne(@PathVariable String menuTypeCode) throws Exception{	
		 return objMenuTypeService.ListOne(menuTypeCode);
	}
	
	@RequestMapping(value="/menuTypeAllList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenuType> getListALL() throws Exception{			 
		return  objMenuTypeService.ListAll();
	}
	@RequestMapping(value="/menuTypeAllList/{TypeUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMenuType> getListFindByTypeUse(@PathVariable String TypeUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{	
		PageRequest request = new PageRequest(pNo,size);
		return  objMenuTypeService.ListFindByTypeUse(TypeUse,request);
	}
	
	@RequestMapping(value="/menuTypeAllList/TypeCode/{TypeCode}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMenuType> getListFindByTypeCode(@PathVariable String TypeCode, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{		
		PageRequest request = new PageRequest(pNo,size);
		return  objMenuTypeService.ListFindByTypeCode(TypeCode,request);
	}
	@RequestMapping(value="/menuTypeAllList/TypeCode/{TypeCode}/{TypeUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMenuType> getListFindByTypeCodeAndTypeUse(@PathVariable String TypeCode,@PathVariable String TypeUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{	
		PageRequest request = new PageRequest(pNo,size);
		return  objMenuTypeService.ListFindByTypeCodeAndTypeUse(TypeCode, TypeUse,request);
	}
	
	@RequestMapping(value="/menuTypeAllList/TypeName/{TypeName}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMenuType> getListFindByTypeName(@PathVariable String TypeName, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{	
		PageRequest request = new PageRequest(pNo,size);
		return  objMenuTypeService.ListFindByTypeName(TypeName,request);
	}
	
	@RequestMapping(value="/menuTypeAllList/TypeName/{TypeName}/{TypeUse}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMenuType> getListFindByTypeNameAndTypeUse(@PathVariable String TypeName,@PathVariable String TypeUse, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{	
		PageRequest request = new PageRequest(pNo,size);
		return  objMenuTypeService.ListFindByTypeCodeAndTypeUse(TypeName, TypeUse,request);
	}
	@RequestMapping(value="/menuTypeRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> menytyperegister(@RequestBody staffMenuType staffmenutype) throws Exception{		 
		objMenuTypeService.Insert(staffmenutype); 
		logger.info("menuTypeRegister");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/menuTypeUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> menutypeupdate(@RequestBody staffMenuType staffmenutype) throws Exception{
		objMenuTypeService.Update(staffmenutype); 
		logger.info("menuTypeRegister");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
