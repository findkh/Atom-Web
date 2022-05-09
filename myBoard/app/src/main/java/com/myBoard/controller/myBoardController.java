package com.myBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myBoard.domain.myBoard;
import com.myBoard.service.myBoardService;

@RestController 
public class myBoardController {

  @Autowired
  myBoardService myboardService;

  @RequestMapping("/myboard/list")
  public Object list() {
    return myboardService.list();
  }

  @RequestMapping("/myboard/add")
  public Object add(myBoard myboard) {
    return myboardService.add(myboard);
  }


  @RequestMapping("/myboard/get")
  public Object get(int no) {
    myBoard board = myboardService.get(no);
    if (board == null) {
      return "";
    }
    return board;
  }

  @RequestMapping("/myboard/update")
  public Object update(myBoard board) {
    return myboardService.update(board);
  }

  @RequestMapping("/myboard/delete")
  public Object delete(int no) {
    return myboardService.delete(no);
  }
}


