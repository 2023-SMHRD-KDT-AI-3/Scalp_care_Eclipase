package com.Iplus.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Iplus.entity.tb_admin_scalp_care;

@Repository
public interface AdminScalpCareRepository extends JpaRepository<tb_admin_scalp_care, Long> {

	tb_admin_scalp_care findByAcNum(Long valueOf);

	// 조회 수 업데이트
	@Transactional
	@Modifying
	@Query(value = "UPDATE tb_admin_scalp_care SET views = views + 1 WHERE ac_num = :acNum", nativeQuery = true)
	int ViewPlus(@Param("acNum") String acNum);

	// 조회 수 카운트
	@Query(value = "SELECT views FROM tb_admin_scalp_care WHERE ac_num = :acNum", nativeQuery = true)
	int ViewPlusCount(@Param("acNum") String acNum);

	// 인기 게시글 가져오기(조회수를 내림차순)
	@Query("SELECT ac FROM tb_admin_scalp_care ac ORDER BY ac.views DESC")
	List<tb_admin_scalp_care> NewsviewBest();
	
	
	
}
