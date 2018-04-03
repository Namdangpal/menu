package com.sk.dep.staff.admin.menu.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sk.dep.staff.admin.menu.domain.staffMemberDTO;
import com.sk.dep.staff.admin.menu.vo.staffMemberVO;
 

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 3. 27.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 3. 27.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
public class staffMemberSpec {  	 
    public static Specification<staffMemberDTO> StaffCompanyLike(final String keyword) {
        return new Specification<staffMemberDTO>() {
            @Override
            public Predicate toPredicate(Root<staffMemberDTO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("staffCompany"), "" + keyword + "%");
            }
        };
    }	    
    public static Specification<staffMemberDTO> StaffNameLike(final String keyword) {
        return new Specification<staffMemberDTO>() {
            @Override
            public Predicate toPredicate(Root<staffMemberDTO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("staffName"), "" + keyword + "%");
            }
        };
    }
    
    public static Specification<staffMemberDTO> StaffIdLike(final String keyword) {
        return new Specification<staffMemberDTO>() {
            @Override
            public Predicate toPredicate(Root<staffMemberDTO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("staffId"), "" + keyword + "%");
            }
        };
    }
    
    public static Specification<staffMemberDTO> RoleCode(final String keyword) {
        return new Specification<staffMemberDTO>() {
            @Override
            public Predicate toPredicate(Root<staffMemberDTO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("roleCode"),   keyword );
            }
        };
    }
    public static Specification<staffMemberDTO> GroupCode(final String keyword) {
        return new Specification<staffMemberDTO>() {
            @Override
            public Predicate toPredicate(Root<staffMemberDTO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("groupCode"), keyword );
            }
        };
    }    
    public static Specification<staffMemberDTO> StaffState(final String keyword) {
        return new Specification<staffMemberDTO>() {
            @Override
            public Predicate toPredicate(Root<staffMemberDTO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("staffState"), keyword );
            }
        };
    }
    public static Specification<staffMemberDTO> StaffManamgerNameLike(final String keyword) {
        return new Specification<staffMemberDTO>() {
            @Override
            public Predicate toPredicate(Root<staffMemberDTO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("staffManagerName"), "" + keyword + "%");
	            }
	        };
	}
    
    public static Specification<staffMemberDTO> findBySearch(final staffMemberVO staffmembervo) {

        return new Specification<staffMemberDTO>() {

            @Override
            public Predicate toPredicate(
                Root<staffMemberDTO> root,
                CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();
                if (staffmembervo.getStaffCompany() != null && !staffmembervo.getStaffCompany().isEmpty()) {
                    predicates.add(cb.like(root.get("staffCompany"), "%" + staffmembervo.getStaffCompany() + "%"));
                }
                if (staffmembervo.getStaffName() != null && !staffmembervo.getStaffName().isEmpty()) {
                    predicates.add(cb.like(root.get("staffName"), "%"+ staffmembervo.getStaffName() + "%"));
                }                
                if (staffmembervo.getStaffId() != null && !staffmembervo.getStaffId().isEmpty()) {
                    predicates.add(cb.like(root.get("staffId"), ""+ staffmembervo.getStaffId() + "%"));
                }
                if (staffmembervo.getRoleCode() != null && !staffmembervo.getRoleCode().isEmpty()) {
                    predicates.add(cb.equal(root.get("roleCode"), staffmembervo.getRoleCode()));
                }
                if (staffmembervo.getGroupCode() != null && !staffmembervo.getGroupCode().isEmpty()) {
                    predicates.add(cb.equal(root.get("groupCode"), staffmembervo.getGroupCode()));
                }
                if (staffmembervo.getStaffState() != null && !staffmembervo.getStaffState().isEmpty()) {
                    predicates.add(cb.equal(root.get("staffState"), staffmembervo.getStaffState()));
                }
                if (staffmembervo.getStaffManagerName() != null && !staffmembervo.getStaffManagerName().isEmpty()) {
                    predicates.add(cb.like(root.get("staffManagerName"), "%"+staffmembervo.getStaffManagerName() + "%"));
                }
                
                return cb.and(predicates.toArray(new Predicate[] {}));
            }
        };
    }
    
}
