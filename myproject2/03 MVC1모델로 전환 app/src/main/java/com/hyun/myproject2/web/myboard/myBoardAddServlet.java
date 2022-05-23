package com.hyun.myproject2.web.myboard;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/myboard/add") 
public class myBoardAddServlet extends HttpServlet { //추상 클래스를 상속받는다.

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

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang=\"en\">");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
    out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
    out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>");
    out.println("<link href=\"/css/header.css\" rel=\"stylesheet\">");
    out.println("<link href=\"/css/footer.css\" rel=\"stylesheet\">");
    out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css\">");
    out.println("<title>My board</title>");

    out.println("<style>");
    out.println(".content{");
    out.println("width: 1000px;");
    out.println("margin: 0 auto;");
    out.println("}");
    out.println(".boardForm{");
    out.println("border: 5px double rgba(24, 183, 43, 0.357);");
    out.println("width: 800px;");
    out.println("margin: 70px auto;");
    out.println("padding: 20px;");
    out.println("}");
    out.println(".spanTitle {");
    out.println("text-align: center;");
    out.println("font-weight: bolder;");
    out.println("font-size: 25px;");
    out.println("}");
    out.println(".groupBtn{");
    out.println("text-align: right;");
    out.println("}");
    out.println("#addBtn, #cancleBtn{");
    out.println("margin: 10px 5px;");
    out.println("}");
    out.println("</style>");

    out.println("</head>");

    out.println("<body>");

    out.println("<div id=\"header\">");
    req.getRequestDispatcher("/header").include(req, resp);
    out.println("</div>");

    out.println("<div class=\"content\">");
    out.println("<form name=\"boardForm\" class=\"boardForm\" method='post'>");
    out.println("<div class=\"d-grid gap-2 col-11 mx-auto\">");
    out.println("<span class=\"spanTitle\">New Post</span>");
    out.println("<div class=\"col-12\">");
    out.println("<label for=\"inputTitle\" class=\"col-sm-2 col-form-label\">Title</label>");
    out.println("<div class=\"col-sm-12\">");
    out.println("<input type=\"text\" class=\"form-control\" id=\"inputTitle\" name=\"title\">");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=\"col-12\">");
    out.println("<label for=\"formFile\" class=\"form-label\">image</label>");
    out.println("<input class=\"form-control\" type=\"file\" id=\"formFile\" name=\"file\">");
    out.println("</div>");
    out.println("<div class=\"form-floating\">");
    out.println("<textarea class=\"form-control\" placeholder=\"Leave a comment here\" id=\"floatingTextarea2\" style=\"height:200px\" name=\"content\"></textarea>");
    out.println("<label for=\"floatingTextarea2\">Comments</label>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=\"groupBtn\">");
    out.println("<button type=\"button\" class=\"btn btn-success\" id=\"cancleBtn\">Cancle</button>");
    out.println("<button type=\"submit\" class=\"btn btn-success\" id=\"addBtn\">Save</button>");
    out.println("</div>");
    out.println("</form>");
    out.println("</div>");

    out.println("<div id=\"footer\">");
    req.getRequestDispatcher("/footer").include(req, resp);
    out.println("</div>");

    out.println("</div>");
    out.println("<script>");
    out.println("document.querySelector('#cancleBtn').onclick = () => {");
    out.println("  location.href = 'list';");
    out.println("}");
    out.println("</script>");

    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
      myBoard myboard = new myBoard();
      myboard.setTitle(req.getParameter("title"));
      myboard.setContent(req.getParameter("content"));

      Member loginUser = (Member) req.getSession().getAttribute("loginUser");
      myboard.setWriter(loginUser);

      myboardService.add(myboard);

      resp.sendRedirect("list");

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error").forward(req, resp);
    }
  }
}
