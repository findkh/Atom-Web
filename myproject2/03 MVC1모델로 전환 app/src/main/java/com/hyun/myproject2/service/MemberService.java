package com.hyun.myproject2.service;

import com.hyun.myproject2.domain.Member;

public interface MemberService {
  int add(Member member);

  Member get(String email, String password);

  Member get(String email);

  //  List<Member> list();
  //
  //
  //  int update(Member member);
  //
  //  int delete(int no);
}
