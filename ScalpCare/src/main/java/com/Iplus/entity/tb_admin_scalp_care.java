package com.Iplus.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class tb_admin_scalp_care {
	
	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ac_num;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "m_uid")
	private tb_member ac_m_uid;
	
	@Column(length = 600)
	private String ac_img;
	
	@Column(length = 1000)
	private String ac_content;
	
	@Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
	private Date ac_indate;
	
	@Column(insertable = false, columnDefinition = "int default 0")
	private Long ac_views;
	
	
	// 회원(ac_num) 1<----->N 관리자 두피 케어(re_ac_num)
	@OneToMany(mappedBy = "re_ac_num")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_review> re;	// List<연결된 테이블의 자료형>
	
	@OneToMany(mappedBy = "like_ac_num")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_user_like> like;	// List<연결된 테이블의 자료형>
	
	@Override
	public String toString() {
		return "tb_admin_scalp_care";
	}

}
