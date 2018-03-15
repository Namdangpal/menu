package com.sk.dep.staff.admin.menu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="staff_group")
public class staffGroup implements Serializable { 
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="group_id") 
		private Long groupId;		 
		@Column(name="role_code" )
		private String roleCode;	
		
		@Column(name="group_code" )
		private String groupCode;
		 
		@Column(name="group_name" )
		private String groupName;
		
		 @Column(name="group_desc" )
		private String groupDesc; 
	 
		@Column(name="group_Use")
		private String groupUse; 
	 
}
