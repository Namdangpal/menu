package com.sk.dep.staff.admin.menu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sk.dep.staff.admin.menu.service.staffGroupService;
import com.sk.dep.staff.admin.menu.service.staffRoleService;

 


/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 2. 14.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 2. 14.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@Controller
@RequestMapping(value="/staff") 
public class indexController {
	@Autowired
	private staffRoleService  objRoleService;	
	@Autowired
	private staffGroupService  objGroupService;	
	@RequestMapping(value="/") 
	public String indexView() throws Exception{
		System.out.println("indexView호출");
		return "index";
	}
	@RequestMapping(value="/roleEdit") 
	public String roleEditView(Model model) throws Exception{
		System.out.println("roleEdit호출");
		model.addAttribute("RoleList",objRoleService.ListAll());
		return "roleEdit";
	}
	@RequestMapping(value="/groupEdit") 
	public String groupView(Model model) throws Exception{
		System.out.println("groupView호출");
		model.addAttribute("GroupEdit",objGroupService.ListAll());
		model.addAttribute("RoleEdit",objRoleService.ListAll());
		return "groupEdit";
	}
}
