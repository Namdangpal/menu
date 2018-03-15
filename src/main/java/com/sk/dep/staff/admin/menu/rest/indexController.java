package com.sk.dep.staff.admin.menu.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sk.dep.staff.admin.menu.service.staffGroupService;
import com.sk.dep.staff.admin.menu.service.staffMenuAclDTOService;
import com.sk.dep.staff.admin.menu.service.staffMenuAclService;
import com.sk.dep.staff.admin.menu.service.staffMenuDTOService;
import com.sk.dep.staff.admin.menu.service.staffMenuTypeService;
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
	@Autowired
	private staffMenuDTOService  objMenuDTOService;	
	@Autowired
	private staffMenuAclDTOService  objMenuAclDTOService;	
	@Autowired
	private staffMenuAclService  objMenuAclService;	
	@Autowired
	private staffMenuTypeService  objMenuTypeService; 
	@RequestMapping(value="/") 
	public String indexView() throws Exception{
		System.out.println("indexView호출");
		return "redirect:/staff/roleEdit";
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
	@RequestMapping(value="/menuTypeEdit") 
	public String menuTypeView(Model model) throws Exception{
		System.out.println("insertView호출");
		model.addAttribute("menuTypeList",objMenuTypeService.ListAll()); 
		return "menuTypeEdit";
	}
	
	@RequestMapping(value="/menuAclEdit") 
	public String menuAclView(Model model) throws Exception{
		System.out.println("insertView호출");
		model.addAttribute("menuAclList",objMenuAclService.ListAll()); 
		return "menuAclEdit";
	}
	
	@RequestMapping(value="/menuEdit") 
	public String menuView(Model model) throws Exception{
		System.out.println("groupView호출");
		model.addAttribute("menuList",objMenuDTOService.ListJoinAll()); 
		model.addAttribute("menuAclList",objMenuAclService.ListAll());
		model.addAttribute("menuTypeList",objMenuTypeService.ListUseAll()); 
		return "menuEdit";
	}
	
	@RequestMapping(value="/staffMenuTypeEdit") 
	public String staffMenuView(HttpServletRequest objRequest,Model model) throws Exception{
		System.out.println("groupView호출");
		model.addAttribute("menuList",objMenuAclDTOService.ListMenuAcl(objRequest.getParameter("roleCode"), objRequest.getParameter("groupCode"))); 
		model.addAttribute("groupEdit",objGroupService.ListOne(Long.parseLong(objRequest.getParameter("Id"))));
		return "staffMenuTypeEdit";
	}
}
