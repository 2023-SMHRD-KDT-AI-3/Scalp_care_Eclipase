package com.Iplus.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class tb_member {

	@Id
	@Column(length = 50)
	private String m_uid;
	
	@Column(length = 20)
	private String m_name;
	
	@Column
	private String m_class;
	
	@Column(length = 50)
	private String email;
	
	
	// FK 지정
	// 회원(m_uid) 1<----->N 유저 두피 케어(uc_m_uid)
	@OneToMany(mappedBy = "uc_m_uid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_user_scalp_care> usc;	// List<연결된 테이블의 자료형>

	// 회원(m_uid) 1<----->N 관리자 두피 케어(ac_m_uid)
	@OneToMany(mappedBy = "ac_m_uid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_admin_scalp_care> asc;	// List<연결된 테이블의 자료형>
	
	// 회원(m_uid) 1<----->N 관리자 두피 케어(re_m_uid)
	@OneToMany(mappedBy = "re_m_uid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_review> re;	// List<연결된 테이블의 자료형>
	
	// 회원(m_uid) 1<----->N 관리자 두피 케어(like_m_uid)
	@OneToMany(mappedBy = "like_m_uid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_user_like> like;	// List<연결된 테이블의 자료형>
	
	
	
	
	@Override
	public String toString() {
		return "tb_member";
	}
		
}
