package com.hyun.myproject2.controller.myboard;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@SuppressWarnings("serial")
@WebServlet("/myboard/detail") 
public class myBoardDetailController extends HttpServlet { //추상 클래스를 상속받는다.


  myBoardService myboardService;

  @Override
  public void init() throws ServletException {
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    myboardService = (myBoardService) 웹애플리케이션보관소.getAttribute("myboardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      myBoard myboard = myboardService.get(no);
      request.setAttribute("myboard", myboard);
      request.getRequestDispatcher("/jsp/myboard/detail.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}
