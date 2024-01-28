package com.dodam.dodam.server.repository;

import com.dodam.dodam.server.login.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRespository {
    private static Map<String, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(String.valueOf(Long.valueOf(++sequence)));
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(String id) {
        return store.get(id);
    }

    @Override
    public Member findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny().get();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

}
