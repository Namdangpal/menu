package com.sk.dep.staff.admin.menu.rest;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.admin.menu.domain.staffMenuDTO;
import com.sk.dep.staff.admin.menu.service.staffMenuDTOService;
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
public class staffMenuDTOController {
	
	private static final Logger logger = LoggerFactory.getLogger(staffMenuDTOController.class);

	@Autowired
	private staffMenuDTOService  objMenuDTOService;   
	 
	@RequestMapping(value="/menuDTOListJoinList", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public List<staffMenuDTO> getListJoinALL() throws Exception{	
			
		return  objMenuDTOService.ListJoinAll();
	}
	
	@RequestMapping(value="/menuDTOListJoinOne/{menuCode}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public  staffMenuDTO  getListJoinOne(@PathVariable String menuCode) throws Exception{	
			
		return  objMenuDTOService.ListJoinOne(menuCode);
	}
	
	@RequestMapping(value="/getJsonByMap3",method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public  Map<String , Object> getJsonByMap3() {
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
		    	logger.info("숫자:" + i);
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
