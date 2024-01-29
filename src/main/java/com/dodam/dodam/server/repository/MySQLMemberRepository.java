package com.dodam.dodam.server.repository;

import com.dodam.dodam.server.login.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MySQLMemberRepository implements MemberRespository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Member save(Member member) {
        String sql = "INSERT INTO member (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, member.getId(), member.getName());
        return member;
    }

    @Override
    public Member findById(String id) {
        String sql = "SELECT * FROM member WHERE id = ?";
        Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, id);
        if (resultMap == null) {
            return null;
        }
        return new Member(
                (String) resultMap.get("id"),
                (String) resultMap.get("name")
        );
    }

    @Override
    public Member findByName(String name) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}