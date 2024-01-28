package com.dodam.dodam.server.repository;

import com.dodam.dodam.server.login.Member;

import java.util.List;

public interface MemberRespository {
	Member save(Member member);
	Member findById(String id);
	Member findByName(String name);
	List<Member> findAll();


}
