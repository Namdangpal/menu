package com.sk.dep.staff.admin.menu.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sk.dep.staff.admin.menu.domain.staffMenuDTO;
import com.sk.dep.staff.admin.menu.service.staffGroupService;
import com.sk.dep.staff.admin.menu.service.staffMemberService;
import com.sk.dep.staff.admin.menu.service.staffMenuAclDTOService;
import com.sk.dep.staff.admin.menu.service.staffMenuAclService;
import com.sk.dep.staff.admin.menu.service.staffMenuDTOService;
import com.sk.dep.staff.admin.menu.service.staffMenuTypeService;
import com.sk.dep.staff.admin.menu.service.staffRoleService;
import com.sk.dep.staff.admin.menu.service.staffStateService;

 


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
	private int INT_PAGE_BLOCK_SIZE = 10;
	private static final Logger logger = LoggerFactory.getLogger(indexController.class);
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
	
	@Autowired
	private staffMemberService  objStaffMemberService; 
		@Autowired
	private staffStateService  objStaffStateService; 
		
	@RequestMapping(value="/") 
	public String indexView() throws Exception{
		System.out.println("indexView호출");
		return "redirect:/staff/roleEdit";
	}
	
	
	@RequestMapping(value="/vueTest") 
	public String vueView() throws Exception{
		System.out.println("indexView호출");
		return "/vueTest";
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
	
	@RequestMapping(value="/staffMemberList") 
	public String staffListView(Model model) throws Exception{
		int pNo = 0 ; 
		int size = 15;
		logger.info("/staffMemberList");
		PageRequest request = new PageRequest(pNo,size);
		model.addAttribute("staffList",objStaffMemberService.ListAll(request));
		model.addAttribute("groupList",objGroupService.ListAllGroupUse("1"));
		model.addAttribute("staffStateList",objStaffStateService.ListAllStateUse("1"));
		model.addAttribute("staffCompanyList",objStaffMemberService.staffMemberCompanyList());
		model.addAttribute("staffAccountManagerList",objStaffMemberService.ListFindByStaffAccountManager("1"));
		return "staffMemberList";
	}
	@RequestMapping(value="/staffMemberList/{pNo}/{size}") 
	public String staffListView(@PathVariable Integer pNo,@PathVariable Integer size,Model model) throws Exception{
		 int nowPageGroup = (int) Math.ceil((double)(pNo + 1) / this.INT_PAGE_BLOCK_SIZE);

		logger.info("/staffMemberList");
		PageRequest request = new PageRequest(pNo,size);
		model.addAttribute("staffList",objStaffMemberService.ListAll(request));
		model.addAttribute("groupList",objGroupService.ListAllGroupUse("1"));
		model.addAttribute("staffStateList",objStaffStateService.ListAllStateUse("1"));
		model.addAttribute("staffCompanyList",objStaffMemberService.staffMemberCompanyList());
		model.addAttribute("staffAccountManagerList",objStaffMemberService.ListFindByStaffAccountManager("1"));
		model.addAttribute("nowPageGroup", nowPageGroup); 
		model.addAttribute("pageBlockSize",this.INT_PAGE_BLOCK_SIZE); 
		return "staffMemberList";
	}
	@RequestMapping(value="/staffMemberEdit") 
	public String staffView(Model model) throws Exception{
		System.out.println("staffMemberEdit호출");
		model.addAttribute("staffList",objStaffMemberService.ListAll());
		model.addAttribute("groupList",objGroupService.ListAllGroupUse("1"));
		model.addAttribute("staffStateList",objStaffStateService.ListAllStateUse("1"));
		model.addAttribute("staffCompanyList",objStaffMemberService.staffMemberCompanyList());
		model.addAttribute("staffAccountManagerList",objStaffMemberService.ListFindByStaffAccountManager("1"));
		return "staffMemberEdit";
	}
	
	@RequestMapping(value="/staffStateEdit") 
	public String staffStateView(Model model) throws Exception{
		System.out.println("staffStateEdit호출");
		model.addAttribute("staffStateList",objStaffStateService.ListAll()); 
		return "staffStateEdit";
	}
	@RequestMapping(value="/staffMenuTypeEdit") 
	public String staffMenuView(HttpServletRequest objRequest,Model model) throws Exception{
		System.out.println("groupView호출");
		model.addAttribute("menuList",objMenuAclDTOService.ListMenuAcl(objRequest.getParameter("roleCode"), objRequest.getParameter("groupCode"))); 
		model.addAttribute("groupEdit",objGroupService.ListOne(Long.parseLong(objRequest.getParameter("Id"))));
		return "staffMenuTypeEdit";
	}
	
	@RequestMapping(value="/getJsonByMap3")
	public @ResponseBody Map<String , Object> getJsonByMap3() {
		List<staffMenuDTO> objMenuList = objMenuDTOService.ListJoinAll();
		JSONObject jsonObject = new JSONObject();
	    JSONArray bookArray = new JSONArray();
	    JSONArray bookArray2 = new JSONArray();
	    JSONArray bookArray3 = new JSONArray();
	 
	    JSONObject bookInfo = new JSONObject();
	    JSONObject bookInfo2 = new JSONObject();
	    JSONObject bookInfo3 = new JSONObject();
	    long currentGroup = 0;
	    int currentLevel = 0;
	    int i = 0;
            for(staffMenuDTO objMenu : objMenuList) {	 
            	if(objMenu.getMenuGroup() !=  currentGroup) {
            		currentGroup = objMenu.getMenuGroup();
            		//currentLevel = objMenu.getMenudepth();
            		if(bookArray.size() > 0 && currentLevel == 3) {
            		   bookInfo2.put("child", bookArray3);
            		   bookInfo.put("child", bookArray2);
            		   bookArray3 = new JSONArray();
            		   bookArray2 = new JSONArray();            		   
            		   System.out.println(" 111group : " + objMenu.getMenuCode() +" depth : " + objMenu.getMenuDepth() + " name: " + objMenu.getMenuName() );
            		   //jsonObject.put("menu", bookArray);
            		}else if(bookArray.size() > 0  && currentLevel == 2) {
            			bookInfo.put("child", bookArray2);
            			bookArray2 = new JSONArray();
             			//jsonObject.put("menu", bookArray);
             			System.out.println(" 11group : " + objMenu.getMenuGroup() +" depth : " + objMenu.getMenuDepth() + " name: " + objMenu.getMenuName() );
            		}else if(bookArray.size() > 0  && currentLevel == 1) {
            			 jsonObject.put("menu", bookArray);
            			 //bookArray3 = new JSONArray();
              		     //bookArray2 = new JSONArray();
            			 System.out.println(" 1group : " + objMenu.getMenuGroup() +" depth : " + objMenu.getMenuDepth() + " name: " + objMenu.getMenuName() );
            		}
            	}else if(objMenu.getMenuDepth() != currentLevel) {
            		if(bookArray3.size() > 0 && currentLevel == 3) {
            			bookInfo2.put("child", bookArray3);
            			bookInfo.put("child", bookArray2);
              		System.out.println("["+bookArray2.size() + " ]group : " + objMenu.getMenuGroup() +" depth : " + objMenu.getMenuDepth() + " name: " + objMenu.getMenuName() );
              		bookArray3 = new JSONArray();
         		    //bookArray2 = new JSONArray();
            		} 
            	}
              	if (objMenu.getMenuDepth() == 1) { 
		    		bookInfo  = new JSONObject();
		    		bookInfo.put("id", objMenu.getMenuCode());
		    		bookInfo.put("name", objMenu.getMenuName());
		    		bookInfo.put("url", objMenu.getMenuUrl());
		    		bookInfo.put("Acl", objMenu.getMenuAcl());
			        bookArray.add(bookInfo);
			        currentLevel = objMenu.getMenuDepth();
		    	}
		    	else if(objMenu.getMenuDepth()==2) { 
		    		bookInfo2  = new JSONObject();
		    		bookInfo2.put("id", objMenu.getMenuCode());
		    		bookInfo2.put("name", objMenu.getMenuName());
		    		bookInfo2.put("url", objMenu.getMenuUrl());
		    		bookInfo2.put("Acl", objMenu.getMenuAcl());
			        bookArray2.add(bookInfo2);
			        //bookInfo.put("child", bookArray2);
			        currentLevel = objMenu.getMenuDepth();
		    	}else if(objMenu.getMenuDepth()==3) { 
		    		
		    		bookInfo3  = new JSONObject();
		    		bookInfo3.put("id", objMenu.getMenuCode());
		    		bookInfo3.put("name", objMenu.getMenuName());
		    		bookInfo3.put("url", objMenu.getMenuUrl());
		    		bookInfo3.put("Acl", objMenu.getMenuAcl());
			        bookArray3.add(bookInfo3);
			        bookInfo2.put("child", bookArray3);
			        currentLevel = objMenu.getMenuDepth();
		    	}
		    	i++;
		    	System.out.println("숫자:" + i);
            }
            
            bookInfo2.put("child", bookArray3);
			bookInfo.put("child", bookArray2);
	        jsonObject.put("menu", bookArray);
	 
	        //JSONObject를 String 객체에 할당
	        //String jsonInfo = jsonObject.toJSONString();
	 
	        //System.out.print(jsonInfo);
	          
	    return jsonObject;
	}
}
