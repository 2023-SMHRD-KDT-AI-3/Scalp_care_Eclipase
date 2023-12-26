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
public class tb_review {

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reNum;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "acNum")
	private tb_admin_scalp_care reAcNum;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "uid")
	private tb_member reUid;
	
	@Column(length = 1000)
	private String content;
	
	@Column(columnDefinition = "int default 0")
	private Long point;
	
	@Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
	private Date indate;
	
	@Override
	public String toString() {
		return "tb_review";
	}
	
}
