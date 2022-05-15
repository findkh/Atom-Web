package com.myproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.myproject.domain.myBoard;

@Mapper
public interface myBoardDao {

  int countAll();

  List<myBoard> findAll(@Param("rowCount") int rowCount, @Param("offset") int offset);

  int insert(myBoard myboard);

  myBoard findByNo(int no);

  int update(myBoard myboard);

  int delete(myBoard myboard);

  int increaseViewCount(int no);

}
