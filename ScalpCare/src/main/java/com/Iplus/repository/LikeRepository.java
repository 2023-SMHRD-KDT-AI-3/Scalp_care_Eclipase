package com.Iplus.repository;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Iplus.entity.tb_user_like;
import com.Iplus.entity.tb_user_like_id;

@Repository
public interface LikeRepository extends JpaRepository<tb_user_like, tb_user_like_id>{

	// 좋아요,싫어요 클릭
	@Transactional
    @Modifying
    @Query(value = "insert into tb_user_like(good,like_ac_num_ac_num,like_uid_uid) values (:good,:likeAcNum,:likeUid)", nativeQuery = true)
    int insert(@Param("good") boolean good,@Param("likeAcNum") String likeAcNum,@Param("likeUid") String likeUid);

	// 좋아요 수 조회
	@Query(value = "SELECT COUNT(*) FROM tb_user_like WHERE like_ac_num_ac_num = :likeAcNum AND good = 1", nativeQuery = true)
    int likeView(@Param("likeAcNum") String likeAcNum);
   
	// 싫어요 수 조회
	@Query(value = "SELECT COUNT(*) FROM tb_user_like WHERE like_ac_num_ac_num = :likeAcNum AND good = 0", nativeQuery = true)
    int hateView(@Param("likeAcNum") String likeAcNum);
	   
	// 좋아요 클릭 상태 확인
	@Query(value = "SELECT COUNT(*) FROM tb_user_like WHERE like_ac_num_ac_num = :likeAcNum AND like_uid_uid = :likeUid AND good = 1", nativeQuery = true)
    int likeCheck(@Param("likeAcNum") String likeAcNum, @Param("likeUid") String likeUid);	

	// 좋아요 취소
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tb_user_like WHERE like_ac_num_ac_num = :likeAcNum AND like_uid_uid = :likeUid AND good = 1", nativeQuery = true)
	void deletegood(@Param("likeAcNum") String likeAcNum, @Param("likeUid") String likeUid);

	// 싫어요 클릭 상태 확인
	@Query(value = "SELECT COUNT(*) FROM tb_user_like WHERE like_ac_num_ac_num = :likeAcNum AND like_uid_uid = :likeUid AND good = 0", nativeQuery = true)
    int hateCheck(@Param("likeAcNum") String likeAcNum, @Param("likeUid") String likeUid);	

	// 싫어요 취소
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tb_user_like WHERE like_ac_num_ac_num = :likeAcNum AND like_uid_uid = :likeUid AND good = 0", nativeQuery = true)
	void deletehate(@Param("likeAcNum") String likeAcNum, @Param("likeUid") String likeUid);
	

	
}
