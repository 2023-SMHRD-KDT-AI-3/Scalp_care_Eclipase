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
	private Long acNum;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "uid")
	private tb_member acUid;
	
	@Column(length = 600)
	private String img;
	
	@Column(length = 1000)
	private String content;
	
	@Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
	private Date indate;
	
	@Column(insertable = false, columnDefinition = "int default 0")
	private Long views;
	
	
	// 회원(ac_num) 1<----->N 관리자 두피 케어(re_ac_num)
	@OneToMany(mappedBy = "reAcNum")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_review> reNum;	// List<연결된 테이블의 자료형>
	
	@OneToMany(mappedBy = "likeAcNum")	// 1대다 관계, mappedBy에 연결할 컬럼 지정
	private List<tb_user_like> likeAcNum;	// List<연결된 테이블의 자료형>
	
	@Override
	public String toString() {
		return "tb_admin_scalp_care";
	}

}
