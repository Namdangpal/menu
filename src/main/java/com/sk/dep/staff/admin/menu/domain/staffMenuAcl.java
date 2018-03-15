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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import lombok.Data;

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 2. 13.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 2. 13.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */

@Data
@Entity
@Table(name="menu_acl")
public class staffMenuAcl implements Serializable { 
		private static final long serialVersionUID = 1L;
		
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="acl_id") 
		private Long aclId;			
		@Id
		@Column(name="acl_code" )
		private String aclCode;	
		
		@Column(name="acl_name" )
		private String aclName;
		
		@Column(name="acl_desc" )
		private String aclDesc; 
	 
		@Column(name="acl_Use")
		private String aclUse; 
		
 		//@OneToMany(fetch = FetchType.EAGER, mappedBy = "staffmenuacls")
		//@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
		//@Fetch(FetchMode.SUBSELECT)
//	    private List<staffMenu> staffmenus;
	    
//	    public boolean addstaffMenu(staffMenu staffmenu) {
//	        if(staffmenus == null)
//	        	staffmenus = new ArrayList<>();
//	 
//	        return staffmenus.add(staffmenu);
//	    }	    
	    @Override
	    public String toString() {
	        return  aclName;
	    }
	 
}
