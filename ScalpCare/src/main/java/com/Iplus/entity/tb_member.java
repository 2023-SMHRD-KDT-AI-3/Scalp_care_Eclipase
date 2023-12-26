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
	private String uid;
	
	@Column(length = 20)
	private String name;
	
	@Column
	private String classes;
	
	@Column(length = 50)
	private String email;
	
	
	// FK 지정
	// 회원(m_uid) 1<----->N 유저 두피 케어(uid)
	@OneToMany(mappedBy = "ucUid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_user_scalp_care> ucUid;	// List<연결된 테이블의 자료형>

	// 회원(m_uid) 1<----->N 관리자 두피 케어(uid)
	@OneToMany(mappedBy = "acUid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_admin_scalp_care> acUid;	// List<연결된 테이블의 자료형>
	
	// 회원(m_uid) 1<----->N 관리자 두피 케어(uid)
	@OneToMany(mappedBy = "reUid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_review> reUid;	// List<연결된 테이블의 자료형>
	
	// 회원(m_uid) 1<----->N 관리자 두피 케어(uid)
	@OneToMany(mappedBy = "likeUid")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_user_like> likeUid;	// List<연결된 테이블의 자료형>
	
	
	
	
	@Override
	public String toString() {
		return "tb_member";
	}


	public tb_member(String uid, String name, String classes, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.classes = classes;
		this.email = email;
	}


			
}
