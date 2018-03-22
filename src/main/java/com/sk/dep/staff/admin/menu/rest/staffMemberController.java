package com.sk.dep.staff.admin.menu.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffMember;
import com.sk.dep.staff.admin.menu.service.staffMemberService;
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
public class staffMemberController {
	private static final Logger logger = LoggerFactory.getLogger(staffMemberController.class);

	@Autowired
	private staffMemberService  objService;
	@RequestMapping(value="/staffListOne/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffMember getListOne(@PathVariable String id) throws Exception{	
		 return objService.ListOne(id);
	}
	
	@RequestMapping(value="/staffMemberExists/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public boolean bloStaffMemberExists(@PathVariable String id) throws Exception{	
		 return objService.staffMemberExists(id);
	}
	
	@RequestMapping(value="/staffMemberCompanyList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public ArrayList getStaffMemberCompanyList() throws Exception{	
		 return (ArrayList)objService.staffMemberCompanyList();
	}
	
	@RequestMapping(value="/staffAllList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMember> getListALL() throws Exception{			 
		return  objService.ListAll();
	}
	
	@RequestMapping(value="/staffAllList/AcountManager/{strValue}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMember> getListFindByStaffAccountManager(@PathVariable String strValue) throws Exception{			 
		return  objService.ListFindByStaffAccountManager(strValue);
	}
	
	@RequestMapping(value="/staffAllList/roleCode/{RoleCode}/{GroupCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMember> getListFindByRoleCodeAndGroupCode(@PathVariable String RoleCode,@PathVariable String GroupCode) throws Exception{			 
		return  objService.ListFindByRoleCodeAndGroupCode(RoleCode, GroupCode);
	}
	
	
	@RequestMapping(value="/staffAllList/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMember> getListPage(@PathVariable Integer pNo,@PathVariable Integer size) throws Exception{	
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListAll(request);
	}
	
	@RequestMapping(value="/staffAllList/{StaffState}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMember> getListALLStaffState(@PathVariable String StaffState, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListAllStaffState(StaffState,request);
	}
	 
	@RequestMapping(value="/staffAllList/staffName/{staffName}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMember> getListFindByStaffName(@PathVariable String StaffName, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListFindByStaffName(StaffName, request);
	}
	@RequestMapping(value="/staffAllList/roleCode/{RoleCode}/{GroupCode}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMember> getListFindByRoleCodeAndGroupCode(@PathVariable String RoleCode,@PathVariable String GroupCode, @PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListFindByRoleCodeAndGroupCode(RoleCode, GroupCode, request);
	}
	
		
	@RequestMapping(value="/staffAllList/companyName/{CompanyName}/{pNo}/{size}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMember> getListFindByCompanyName(@PathVariable String CompanyName,@PathVariable Integer pNo,@PathVariable Integer size) throws Exception{			 
		PageRequest request = new PageRequest(pNo,size);
		return  objService.ListFindByStaffCompanyName(CompanyName, request);
	}
	
	@RequestMapping(value="/staffMemberRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> staffregister(@RequestBody staffMember staffmember) throws Exception{
		 
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		SimpleDateFormat dtdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		//logger.info(passwordEncoder.encode(staffmember.getStaffPwd()));
		staffmember.setStaffPwd(passwordEncoder.encode(staffmember.getStaffPwd())); 		
		staffmember.setStaffLastUpdate(dtdFormat.format(new Date()));
		staffmember.setStaffRegDate(dtdFormat.format(new Date()));
		objService.Insert(staffmember); 
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/staffMemberUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> staffupdate(@RequestBody staffMember staffmember) throws Exception{
		
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		//logger.info("passwordEncoder : " + passwordEncoder.matches("11111111", staffmember.getStaffPwd()));
		staffmember.setStaffLastUpdate(date.format(new Date()));
		objService.Update(staffmember); 
		System.out.println("roleUpdate호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	 
}
