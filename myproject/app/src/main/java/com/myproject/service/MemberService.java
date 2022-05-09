package com.myproject.service;

import com.myproject.domain.Member;

public interface MemberService {
  int add(Member member);

  Member get(String email, String password);

  //  List<Member> list();
  //
  //
  //  int update(Member member);
  //
  //  int delete(int no);
}
