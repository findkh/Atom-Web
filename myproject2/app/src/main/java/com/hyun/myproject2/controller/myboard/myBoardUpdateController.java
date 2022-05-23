package com.hyun.myproject2.controller.myboard;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.domain.Member;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@SuppressWarnings("serial")
@WebServlet("/myboard/update") 
public class myBoardUpdateController extends HttpServlet { //추상 클래스를 상속받는다.

  myBoardService myboardService;

  @Override
  public void init() throws ServletException {
    //myBoardService 객체를 웹 애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    myboardService = (myBoardService) 웹애플리케이션보관소.getAttribute("myboardService");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      myBoard myboard = new myBoard();

      myboard.setNo(Integer.parseInt(request.getParameter("no")));
      myboard.setTitle(request.getParameter("title"));
      myboard.setContent(request.getParameter("content"));

      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      myboard.setWriter(loginUser);

      myboardService.update(myboard);

      response.sendRedirect("list"); //게시물 목록 페이지를 다시 요청하라고 클라이언트에게 명령한다.

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}
