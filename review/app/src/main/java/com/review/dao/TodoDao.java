package com.review.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.review.domain.Todo;

@Mapper
public interface TodoDao {

  int countAll();

  List<Todo> findAll();

  int insert(Todo todo);

  Todo findByNo(int no);

  int update(Todo todo);

  int updateDone(@Param("no") int no, @Param("done") boolean done);

  int delete(int no);
}











