package com.hyun.myproject2.web.myboard;

import java.io.IOException;
import java.io.PrintWriter;
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
public class myBoardListServlet extends HttpServlet { //추상 클래스를 상속받는다.

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
    out.println("<link href=\"/css/myboardindex.css\" rel=\"stylesheet\">");
    out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css\">");
    out.println("<title>My board</title>");
    out.println("</head>");

    out.println("<body>");

    out.println("<div id=\"header\">");
    req.getRequestDispatcher("/header").include(req, resp);
    out.println("</div>");

    out.println("<div class=\"content\">");
    out.println("<div class=\"contentInner\">");
    out.println("<table class=\"table table-hover table-sm\" id=\"boardTable\">");
    out.println("<thead class=\"table-light\">");
    out.println("<tr>");
    out.println("<th scope=\"col\" width=\"50px\">#</th>");
    out.println("<th scope=\"col\" width=\"400px\">Title</th>");
    out.println("<th scope=\"col\" width=\"100px\">Writer</th>");
    out.println("<th scope=\"col\" width=\"80px\">ViewCount</th>");
    out.println("<th scope=\"col\" width=\"100px\">Date</th>");
    out.println("</tr>");
    out.println("</thead>");
    out.println("<tbody style=\"border: white\">");

    List<myBoard> boards = myboardService.list();
    for (myBoard board : boards) {
      out.println("<tr>");
      out.printf("<td>%d</td>\n", board.getNo());
      out.printf("<td><a href='detail?no=%d'>%s</td>\n", board.getNo(), board.getTitle());
      out.printf("<td>%s</td>\n", board.getWriter().getName());
      out.printf("<td>%d</td>\n", board.getViewCount());
      out.printf("<td>%s</td>\n", board.getCreatedDate());
      out.println("</tr>");
    }

    out.println("</tbody>");
    out.println("</table>");

    out.println("<div class=\"btnDiv\">");
    out.println("<button id=\"createBtn\" type=\"button\" class=\"btn btn-success\">Add</button>");
    out.println("</div>");

    out.println("</div>");
    out.println("</div>");

    out.println("<div id=\"footer\">");
    req.getRequestDispatcher("/footer").include(req, resp);
    out.println("</div>");

    out.println("</div>");
    out.println("<script>");
    out.println("document.querySelector('#createBtn').onclick = () => {");
    out.println("  location.href ='add';");
    out.println("}");
    out.println("</script>");

    out.println("</body>");
    out.println("</html>");


  }
}
