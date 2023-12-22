package com.Iplus.entity;

import java.io.Serializable;

import lombok.Data;



@Data
public class tb_user_like_id  implements Serializable{

	private tb_member like_m_uid;
	
	private tb_admin_scalp_care like_ac_num;
}
