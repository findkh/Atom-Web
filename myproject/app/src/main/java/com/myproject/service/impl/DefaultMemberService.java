package com.myproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myproject.dao.MemberDao;
import com.myproject.domain.Member;
import com.myproject.service.MemberService;

@Service
public class DefaultMemberService implements MemberService{

  @Autowired
  MemberDao memberDao;

  @Override
  public int add(Member member) {
    return memberDao.insert(member);
  }

  @Override
  public Member get(String email, String password) {
    return memberDao.finByEmailAndPassword(email, password);
  }


}
