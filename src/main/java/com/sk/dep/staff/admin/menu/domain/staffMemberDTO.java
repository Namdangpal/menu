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
@Table(name="view_staff_member")
public class staffMemberDTO implements Serializable { 
		private static final long serialVersionUID = 1L;
		
		@Column(name="staff_seq") 
		private Long staffSeq;	
		
		@Id
		@Column(name="staff_id" )
		private String staffId;	
		
		@Column(name="staff_name")
		private String staffName;
		
		@Column(name="staff_mobile")
		private String staffMobile;
		
		@Column(name="staff_company")
		private String staffCompany;
		
		@Column(name="staff_part")
		private String staffPart;
		
		@Column(name="staff_position")
		private String staffPosition;
		
		@Column(name="staff_tel")
		private String staffTel;
		
		@Column(name="staff_email")
		private String staffEmail;
		
		@Column(name="role_code")
		private String roleCode;
		
		@Column(name="group_code")
		private String groupCode;
		
		@Column(name="staff_manager")
		private String staffManager;
		
		@Column(name="staff_account_manager")
		private String staffAccountManager;
		
		@Column(name="staff_state")
		private String staffState;
		
		@Column(name="staff_reg_date")
		private String staffRegDate;
		
		@Column(name="staff_last_update")
		private String staffLastUpdate;
		
		@Column(name="staff_manager_name")
		private String staffManagerName;
		
		@Column(name="staff_group_name")
		private String staffGroupName;
}
