package com.myproject.service;

import java.util.List;
import com.myproject.domain.myBoard;

public interface myBoardService {
  int add(myBoard myboard);

  List<myBoard> list();

  myBoard get(int no);

  int update(myBoard myboard);

  int delete(myBoard myboard);
}
