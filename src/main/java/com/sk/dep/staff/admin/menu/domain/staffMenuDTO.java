package com.sk.dep.staff.admin.menu.domain;

import java.io.Serializable;
import javax.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class staffMenuDTO implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	private long menuId;
	private String menuType;
	@Id
	private String menuCode;
 	private String menuName;
 	private String menuNameEng;
	private String menuUrl;
	private int menuGroup; 	
	private int menuStep; 
	private int menuDepth; 	
	private int menuParents;
	private String menuUse; 
    private String menuAcl; 
    private String menuAclName; 
   
	
}
