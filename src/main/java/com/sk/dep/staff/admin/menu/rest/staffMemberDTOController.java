package com.sk.dep.staff.admin.menu.rest;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffMemberDTO;
import com.sk.dep.staff.admin.menu.service.staffMemberDTOService;
import com.sk.dep.staff.admin.menu.spec.staffMemberSpec;
import com.sk.dep.staff.admin.menu.vo.staffMemberVO;


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
public class staffMemberDTOController {
	
	private static final Logger logger = LoggerFactory.getLogger(staffMemberController.class);
	@Autowired
	private staffMemberDTOService  objStaffDTOService;	 
	
	@RequestMapping(value="/staffMemberDTOList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMemberDTO> getListALL() throws Exception{			 
		return  objStaffDTOService.ListAll();
	}
	@RequestMapping(value="/staffMemberDTOSearch/{pNo}/{size}", method=RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public Page<staffMemberDTO> getListPage(@PathVariable Integer pNo,@PathVariable Integer size,@RequestBody staffMemberVO staffmembervo) throws Exception{	
		PageRequest request = new PageRequest(pNo,size);		
		Specifications<staffMemberDTO> spec =null;
		//logger.info("staffCompany" + data.get("staffCompany").toString());
		if(staffmembervo != null) {
			spec = Specifications.where(staffMemberSpec.findBySearch(staffmembervo));
			/*if(staffmembervo.getStaffName().length() > 0)
				spec = spec.or(staffMemberSpec.StaffNameLike(staffmembervo.getStaffName()));
			if(staffmembervo.getStaffCompany().length() > 0)
				spec = spec.or(staffMemberSpec.StaffCompanyLike(staffmembervo.getStaffCompany())); 
			if(staffmembervo.getStaffId().length() > 0)
				spec = spec.or(staffMemberSpec.StaffIdLike(staffmembervo.getStaffId())); 
			if(staffmembervo.getStaffManagerName().length() > 0)
				spec = spec.or(staffMemberSpec.StaffManamgerNameLike(staffmembervo.getStaffManagerName())); */
		}
		
		return  objStaffDTOService.ListAll(spec,request);
	}
	 
}
