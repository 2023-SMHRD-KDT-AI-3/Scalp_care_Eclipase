package com.Iplus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(tb_user_like_id.class)
public class tb_user_like{
	
	@Id
	@ManyToOne
	@JoinColumn(referencedColumnName = "m_uid")
	private tb_member like_m_uid;
	
	@Id
	@ManyToOne
	@JoinColumn(referencedColumnName = "ac_num")
	private tb_admin_scalp_care like_ac_num;

	
	@Column
	private Boolean like_good;
	
	@Override
	public String toString() {
		return "tb_user_like";
	}
	

}
