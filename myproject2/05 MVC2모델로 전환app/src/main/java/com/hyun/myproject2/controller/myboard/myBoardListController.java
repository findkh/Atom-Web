package com.hyun.myproject2.controller.myboard;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@SuppressWarnings("serial")
@WebServlet("/myboard/list") 
public class myBoardListController extends HttpServlet { //추상 클래스를 상속받는다.

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
      //입력 데이터 가공 및 검증
      int pageNo = 1;
      int pageSize = 5;
      int totalPageSize = 0;

      try {
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
        if (pageSize < 5 || pageSize > 100) {
          pageSize = 5;
        }
      } catch (Exception e) {}

      int myboardSize = myboardService.size();
      totalPageSize = myboardSize / pageSize;
      if ((myboardSize % pageSize) > 0) {
        totalPageSize++;
      }

      try {
        pageNo = Integer.parseInt(request.getParameter("pageNo"));
        if (pageNo < 1 || pageNo > totalPageSize) {
          pageNo = 1;
        }
      } catch (Exception e) {}

      // 2. 서비스 객체 실행
      List<myBoard> boards = myboardService.list(pageSize, pageNo);

      // 3. 출력 데이터 준비
      request.setAttribute("list", boards);
      request.setAttribute("pageNo", pageNo);
      request.setAttribute("pageSize", pageSize);
      request.setAttribute("totalPageSize", totalPageSize);

      // 4. 뷰 객체에게 실행을 위임한다.
      request.getRequestDispatcher("/jsp/myboard/list.jsp").forward(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}
