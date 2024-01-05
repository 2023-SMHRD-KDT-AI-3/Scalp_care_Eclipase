package com.Iplus.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Iplus.entity.tb_admin_scalp_care;
import com.Iplus.entity.tb_review;

@Repository
public interface ReviewRepository extends JpaRepository<tb_review, Long>{

	// 댓글 입력
	@Transactional
	@Modifying
    @Query(value = "INSERT INTO tb_review(re_ac_num_ac_num, re_uid_uid, content) VALUES (:reAcNum, :reUid, :content)", nativeQuery = true)
    int reviewInsert(
        @Param("reAcNum") String reAcNum,
        @Param("reUid") String reUid,
        @Param("content") String content
    );

	List<tb_review> findAllByReAcNum(tb_admin_scalp_care ac);
	
}
