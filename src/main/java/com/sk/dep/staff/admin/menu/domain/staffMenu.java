package com.sk.dep.staff.admin.menu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 2. 19.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 2. 19.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@Data
@Entity
//@EntityListeners(objectListener.class)
@Table(name="menu")
public class staffMenu implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id") 
	private Long menuId;		 
	@Column(name="menu_type" )
	private String menuType;		
	@Id 
	@Column(name="menu_code" )
	private String menuCode;
 
	@Column(name="menu_name")
	private String menuName;
	
	@Column(name="menu_name_eng")
	private String menuNameEng;
	
	@Column(name="menu_url")
	private String menuUrl;
	@Column(name="menu_group")
	private long menuGroup; 	
	@Column(name="menu_step")
	private long menuStep; 		
	@Column(name="menu_depth")
	private int menuDepth; 		
	@Column(name="menu_parents")
	private long menuParents;   
	
	@Column(name="menu_use")
	private String menuUse;  
	 
	@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_acl_item",
               joinColumns = @JoinColumn(name = "menu_Code"),
               inverseJoinColumns = @JoinColumn(name = "acl_Code"))
    private List<staffMenuAcl> staffmenuacls; 
    
   public boolean addstaffMenuAcl(staffMenuAcl staffmenuacl) {
        if(staffmenuacls == null)
        	staffmenuacls = new ArrayList<>(); 
        return staffmenuacls.add(staffmenuacl);
    }
}
