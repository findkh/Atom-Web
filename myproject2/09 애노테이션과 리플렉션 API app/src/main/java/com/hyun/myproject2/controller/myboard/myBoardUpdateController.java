package com.hyun.myproject2.controller.myboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.controller.Component;
import com.hyun.myproject2.controller.Controller;
import com.hyun.myproject2.domain.Member;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@Component("/myboard/update")
public class myBoardUpdateController  implements Controller {

  myBoardService myboardService;

  public myBoardUpdateController(myBoardService myboardService)  {
    this.myboardService = myboardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{

    myBoard myboard = new myBoard();

    myboard.setNo(Integer.parseInt(request.getParameter("no")));
    myboard.setTitle(request.getParameter("title"));
    myboard.setContent(request.getParameter("content"));

    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    myboard.setWriter(loginUser);

    myboardService.update(myboard);

    return "redirect:list";
  }
}
