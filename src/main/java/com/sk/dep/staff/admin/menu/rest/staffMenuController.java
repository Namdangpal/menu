package com.sk.dep.staff.admin.menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffMenu;
import com.sk.dep.staff.admin.menu.service.menuSeqService;
import com.sk.dep.staff.admin.menu.service.staffMenuService;
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
public class staffMenuController {
	@Autowired
	private staffMenuService  objMenuService;
	
	@Autowired
	private menuSeqService  objMeneSeq;
	
	@RequestMapping(value="/menuListOne/{menuCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public staffMenu getListOne(@PathVariable String menuCode) throws Exception{	
		 return objMenuService.ListOne(menuCode);
	}
	
	@RequestMapping(value="/menuAllList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenu> getListALL() throws Exception{	
			
		return  objMenuService.ListAll();
	}
	
	@RequestMapping(value="/menuListJoinList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenu> getListJoinALL() throws Exception{	
			
		return  objMenuService.ListAll();
	}
	
	@RequestMapping(value="/menuUseChage/{menuId}/{menuDepth}/{menuUse}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public void setMenuUseChage(@PathVariable Long menuId,@PathVariable Long menuDepth,@PathVariable String menuUse) throws Exception{	
		if(menuDepth == 1) {
			objMenuService.MenuUseGroupChange(menuUse, menuId);
		}else {
			objMenuService.MenuUseChildChange(menuUse, menuId);
			objMenuService.MenuUseMineChange(menuUse, menuId);
		}
		
	}
	@RequestMapping(value="/menuRegister", method=RequestMethod.POST,  headers="Accept=application/json")
	public ResponseEntity<?> groupregister(@RequestBody staffMenu staffmenu) throws Exception{
		 
		long lngNum = objMeneSeq.getMaxSeq().getMenuSeq(); 		
		System.out.println("채번:" + lngNum + ": 그룹:" +   staffmenu.getMenuGroup());
		
		if(staffmenu.getMenuGroup() == 0 && staffmenu.getMenuParents() == 0 ) {		
			
			staffmenu.setMenuId(lngNum);
			staffmenu.setMenuGroup(staffmenu.getMenuId());
			staffmenu.setMenuStep(objMenuService.getGroupMaxStep(staffmenu.getMenuGroup()) + 1);
			objMenuService.Insert(staffmenu); 
		} 
		else if(staffmenu.getMenuGroup() != 0 && staffmenu.getMenuParents() == 0 )
		{
			staffmenu.setMenuParents(staffmenu.getMenuId());
			staffmenu.setMenuDepth(staffmenu.getMenuDepth() + 1);
			staffmenu.setMenuId(lngNum);
			staffmenu.setMenuStep(objMenuService.getGroupMaxStep(staffmenu.getMenuGroup()) + 1);	
			staffmenu.setMenuId(lngNum);
			objMenuService.Insert(staffmenu);	
		}		
		else if(staffmenu.getMenuGroup() != 0 && staffmenu.getMenuParents() != 0 )
		{
			staffmenu.setMenuStep(objMenuService.getSubGroupMaxStep(staffmenu) + 1);
			objMenuService.stepUpdate(staffmenu.getMenuGroup(),staffmenu.getMenuStep());
			staffmenu.setMenuParents(staffmenu.getMenuId());
			staffmenu.setMenuDepth(staffmenu.getMenuDepth() + 1);
			staffmenu.setMenuId(lngNum);
			objMenuService.Insert(staffmenu);
		}
		System.out.println("staffMenuRegister호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/menuUpdate", method=RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
	public ResponseEntity<?> groupupdate(@RequestBody staffMenu staffmenu) throws Exception{
		objMenuService.Update(staffmenu); 
		System.out.println("staffMenuUpdate호출");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
