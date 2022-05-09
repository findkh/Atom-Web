package com.myproject.controller;

import static com.myproject.controller.ResultMap.FAIL;
import static com.myproject.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.domain.Member;
import com.myproject.domain.myBoard;
import com.myproject.service.myBoardService;

@RestController 
public class myBoardController {

  @Autowired
  myBoardService myboardService;

  @RequestMapping("/myboard/list")
  public Object list() {
    return myboardService.list();
  }

  @RequestMapping("/myboard/add")
  public Object add(myBoard myboard, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }

    myboard.setWriter(member);
    myboardService.add(myboard);
    return new ResultMap().setStatus(SUCCESS);
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
  public Object update(myBoard myboard, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }

    myboard.setWriter(member);
    int count = myboardService.update(myboard);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/myboard/delete")
  public Object delete(int no, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }

    myBoard myboard = new myBoard();
    myboard.setNo(no);
    myboard.setWriter(member);
    int count = myboardService.delete(myboard);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }
}


