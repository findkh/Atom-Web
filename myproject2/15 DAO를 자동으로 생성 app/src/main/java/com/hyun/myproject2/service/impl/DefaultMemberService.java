package com.hyun.myproject2.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hyun.myproject2.dao.MemberDao;
import com.hyun.myproject2.domain.Member;
import com.hyun.myproject2.service.MemberService;


public class DefaultMemberService implements MemberService{

  SqlSessionFactory sqlSessionFactory;

  public DefaultMemberService(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int add(Member member) {
    SqlSession session = sqlSessionFactory.openSession();
    MemberDao memberDao = session.getMapper(MemberDao.class);
    return memberDao.insert(member);
  }

  @Override
  public Member get(String email, String password) {
    SqlSession session = sqlSessionFactory.openSession();
    MemberDao memberDao = session.getMapper(MemberDao.class);
    return memberDao.finByEmailAndPassword(email, password);
  }

  @Override
  public Member get(String email) {
    SqlSession session = sqlSessionFactory.openSession();
    MemberDao memberDao = session.getMapper(MemberDao.class);
    return memberDao.finByEmail(email);
  }


}
