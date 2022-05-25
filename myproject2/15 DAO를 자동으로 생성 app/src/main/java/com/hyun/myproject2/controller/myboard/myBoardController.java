package com.hyun.myproject2.controller.myboard;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hyun.myproject2.domain.Member;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@Controller
@RequestMapping("/myboard/")
public class myBoardController {

  myBoardService myboardService;

  public myBoardController(myBoardService myboardService)  {
    this.myboardService = myboardService;
  }

  @RequestMapping("list")
  public String list(
      @RequestParam(value="pageNo", defaultValue="1") int pageNo, 
      @RequestParam(value="pageSize", defaultValue="5") int pageSize, 
      Map<String,Object> model) throws Exception{

    int totalPageSize = 0;

    try {
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
      if (pageNo < 1 || pageNo > totalPageSize) {
        pageNo = 1;
      }
    } catch (Exception e) {}

    // 2. 서비스 객체 실행
    List<myBoard> boards = myboardService.list(pageSize, pageNo);

    // 3. 출력 데이터 준비
    model.put("list", boards);
    model.put("pageNo", pageNo);
    model.put("pageSize", pageSize);
    model.put("totalPageSize", totalPageSize);

    return "/jsp/myboard/list.jsp";
  }

  @RequestMapping("detail")
  public String detail(@RequestParam("no") int no, Map<String, Object> model) throws Exception{

    myBoard myboard = myboardService.get(no);
    model.put("myboard", myboard);
    return "/jsp/myboard/detail.jsp";
  }

  @RequestMapping("update")
  public String update(
      @RequestParam("no") int no, 
      @RequestParam("title") String title, 
      @RequestParam("content") String content,
      HttpSession session) throws Exception{

    myBoard myboard = new myBoard();
    myboard.setNo(no);
    myboard.setTitle(title);
    myboard.setContent(content);

    Member loginUser = (Member) session.getAttribute("loginUser");
    myboard.setWriter(loginUser);

    myboardService.update(myboard);

    return "redirect:list";
  }

  @RequestMapping("delete")
  public String delete(@RequestParam("no") int no, HttpSession session) throws Exception{
    myBoard myboard = new myBoard();
    myboard.setNo(no);

    Member loginUser = (Member) session.getAttribute("loginUser");
    myboard.setWriter(loginUser);

    myboardService.delete(myboard);

    return "redirect:list";
  }

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception{

    if (request.getMethod().equals("GET")) {
      return "/jsp/myboard/form.jsp";

    }
    myBoard myboard = new myBoard();
    myboard.setTitle(request.getParameter("title"));
    myboard.setContent(request.getParameter("content"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    myboard.setWriter(loginUser);

    myboardService.add(myboard);

    return "redirect:list";

  }
}
