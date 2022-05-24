package com.hyun.myproject2.controller.myboard;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.controller.Component;
import com.hyun.myproject2.controller.RequestMapping;
import com.hyun.myproject2.domain.Member;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@Component
@RequestMapping("/myboard/")
public class myBoardController {

  myBoardService myboardService;

  public myBoardController(myBoardService myboardService)  {
    this.myboardService = myboardService;
  }

  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception{

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

  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception{
    int no = Integer.parseInt(request.getParameter("no"));
    myBoard myboard = myboardService.get(no);
    request.setAttribute("myboard", myboard);
    return "/jsp/myboard/detail.jsp";
  }

  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception{

    myBoard myboard = new myBoard();

    myboard.setNo(Integer.parseInt(request.getParameter("no")));
    myboard.setTitle(request.getParameter("title"));
    myboard.setContent(request.getParameter("content"));

    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    myboard.setWriter(loginUser);

    myboardService.update(myboard);

    return "redirect:list";
  }

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
    myBoard myboard = new myBoard();
    myboard.setNo(Integer.parseInt(request.getParameter("no")));

    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    myboard.setWriter(loginUser);

    myboardService.delete(myboard);

    return "redirect:list";
  }

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception{
    if (request.getMethod().equals("GET")) {
      return "/jsp/myboard/form.jsp";

    } else {
      myBoard myboard = new myBoard();
      myboard.setTitle(request.getParameter("title"));
      myboard.setContent(request.getParameter("content"));

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      myboard.setWriter(loginUser);

      myboardService.add(myboard);

      return "redirect:list";
    }
  }
}
