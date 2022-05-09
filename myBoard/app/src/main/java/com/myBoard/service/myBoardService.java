package com.myBoard.service;

import java.util.List;
import com.myBoard.domain.myBoard;

public interface myBoardService {
  int add(myBoard myboard);

  List<myBoard> list();

  myBoard get(int no);

  int update(myBoard myboard);

  int delete(int no);
}
