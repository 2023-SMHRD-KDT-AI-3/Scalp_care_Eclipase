package com.Iplus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class tb_user_scalp_care {

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uc_num;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "m_uid")
	private tb_member uc_m_uid;
	
	@Column(length = 600)
	private String uc_img;
	
	@Column(length = 1)
	private String uc_result;
	
	@Column(length = 1000)
	private String uc_content;
	
	@Column(length = 1)
	private String uc_condition;
	
	@Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
	private Date uc_indate;
	
	
	@Override
	public String toString() {
		return "tb_member";
	}
}
