package com.sk.dep.staff.admin.menu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="menu_acl_item")
public class staffMenuAclItem implements Serializable { 
		private static final long serialVersionUID = 1L;
		
		/*@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="acl_item_id") 
		private Long aclItemId;*/			
		@Id
		@Column(name="menu_code" )
		private String menuCode;	
		@Column(name="acl_code" )
		private String aclCode; 
		
 		 
	 
}
