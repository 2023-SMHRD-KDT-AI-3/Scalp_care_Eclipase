package com.Iplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Iplus.entity.tb_member;
import com.Iplus.entity.tb_user_scalp_care;

@Repository
public interface UserScalpCareRepository extends JpaRepository<tb_user_scalp_care, String>{


}
