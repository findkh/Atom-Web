package com.myBoard.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.myBoard.domain.myBoard;

@Mapper
public interface myBoardDao {

  int countAll();

  List<myBoard> findAll();

  int insert(myBoard myboard);

  myBoard findByNo(int no);

  int update(myBoard board);

  int delete(int no);

  int increaseViewCount(int no);

}
