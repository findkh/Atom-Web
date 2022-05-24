package com.hyun.myproject2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.hyun.myproject2.domain.Member;

@Mapper
public interface MemberDao {

  int insert(Member member);

  Member finByEmailAndPassword(@Param("email") String email, @Param("password") String password);

  Member finByEmail(String email);

  //  List<Member> findAll();
  //
  //  Member findByNo(int no);
  //
  //  int update(Member member);
  //
  //  int delete(int no);
  //
  //  int increaseViewCount(int no);
}
