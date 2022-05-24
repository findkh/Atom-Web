package com.hyun.myproject2.controller.myboard;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.controller.Component;
import com.hyun.myproject2.controller.Controller;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@Component("/myboard/list")
public class myBoardListController implements Controller {

  myBoardService myboardService;

  public myBoardListController(myBoardService myboardService)  {
    this.myboardService = myboardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{

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

    return "/jsp/myboard/list.jsp";
  }
}
