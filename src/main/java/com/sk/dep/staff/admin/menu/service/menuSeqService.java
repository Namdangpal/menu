	package com.sk.dep.staff.admin.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.admin.menu.domain.menuSeq;
import com.sk.dep.staff.admin.menu.repository.menuSeqRepository;

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
@Service
public class menuSeqService {
	@Autowired
	private menuSeqRepository objMenuSeqRepo;
	public  menuSeq getMaxSeq() {
		menuSeq obj = new menuSeq();
		obj.setSeqValue("1");
		objMenuSeqRepo.save(obj);
		return objMenuSeqRepo.getMenuSeqMAX();
	}
}
