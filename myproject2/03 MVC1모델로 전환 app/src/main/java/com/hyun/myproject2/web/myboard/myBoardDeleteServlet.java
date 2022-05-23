package com.hyun.myproject2.web.myboard;

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
@WebServlet("/myboard/delete") 
public class myBoardDeleteServlet extends HttpServlet { //추상 클래스를 상속받는다.

  myBoardService myboardService;

  @Override
  public void init() throws ServletException {
    //myBoardService 객체를 웹 애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    myboardService = (myBoardService) 웹애플리케이션보관소.getAttribute("myboardService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      myBoard myboard = new myBoard();
      myboard.setNo(Integer.parseInt(req.getParameter("no")));

      Member loginUser = (Member)req.getSession().getAttribute("loginUser");
      myboard.setWriter(loginUser);

      myboardService.delete(myboard);
      System.out.println(myboardService.delete(myboard));

      resp.sendRedirect("list");

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error").forward(req, resp);
    }
  }
}
