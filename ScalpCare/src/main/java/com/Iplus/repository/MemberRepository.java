package com.Iplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Iplus.entity.tb_member;

@Repository
public interface MemberRepository extends JpaRepository<tb_member, String> {
	
	

}
