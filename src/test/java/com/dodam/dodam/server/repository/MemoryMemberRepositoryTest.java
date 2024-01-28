package com.dodam.dodam.server.repository;

import com.dodam.dodam.server.login.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

    MemberRespository respository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName(String.valueOf("WhiteTor"));

        respository.save(member);

        Member result = respository.findById(member.getId());
        System.out.println("result = " + (result == member));
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("WhiteTor");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("SandDrink");
        respository.save(member2);

        Member result1 = respository.findByName("WhiteTor");

        Assertions.assertThat(result1).isEqualTo(member2);
    }
}
