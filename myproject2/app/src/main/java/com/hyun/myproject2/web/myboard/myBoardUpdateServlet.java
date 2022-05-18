package com.hyun.myproject2.web.myboard;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/myboard/update") 
public class myBoardUpdateServlet extends HttpServlet { //추상 클래스를 상속받는다.

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("service() 호출!");

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("게시글 변경");
  }
}
