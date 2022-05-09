package com.myproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.myproject.domain.Member;

@Mapper
public interface MemberDao {

  int insert(Member member);

  Member finByEmailAndPassword(@Param("email") String email, @Param("password") String password);

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
