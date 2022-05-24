package com.hyun.myproject2.controller.myboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.controller.Component;
import com.hyun.myproject2.controller.Controller;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@Component("/myboard/detail")
public class myBoardDetailController implements Controller {

  myBoardService myboardService;

  public myBoardDetailController(myBoardService myboardService)  {
    this.myboardService = myboardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
    int no = Integer.parseInt(request.getParameter("no"));
    myBoard myboard = myboardService.get(no);
    request.setAttribute("myboard", myboard);
    return "/jsp/myboard/detail.jsp";
  }
}
