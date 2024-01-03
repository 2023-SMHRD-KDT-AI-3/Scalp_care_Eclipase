package com.Iplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Iplus.entity.tb_admin_scalp_care;

@Repository
public interface AdminScalpCareRepository extends JpaRepository<tb_admin_scalp_care, Long> {

	tb_admin_scalp_care findByAcNum(Long valueOf);

	
}
