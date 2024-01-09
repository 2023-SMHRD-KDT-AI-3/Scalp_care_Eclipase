package com.Iplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Iplus.entity.tb_admin_scalp_care;
import com.Iplus.entity.tb_member;
import com.Iplus.entity.tb_user_scalp_care;

@Repository
public interface UserScalpCareRepository extends JpaRepository<tb_user_scalp_care, Long>{

	List<tb_user_scalp_care> findAllByUcUid(tb_member ucUid);

	
	tb_user_scalp_care findByUcNum(long ucNum);


	// 최근 본인기록 가져오기(최근날짜)
	@Query("SELECT uc FROM tb_user_scalp_care uc ORDER BY uc.indate DESC")
	List<tb_user_scalp_care> getBoardDataRecent();


}
