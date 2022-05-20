package com.hyun.myproject2.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hyun.myproject2.service.myBoardService;

@SuppressWarnings("serial")
@WebServlet("/error") 
public class errorServlet extends HttpServlet {
  myBoardService myboardService;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
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
    out.println(".errorDiv{");
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
    out.println("</style>");

    out.println("</head>");

    out.println("<body>");

    out.println("<div id=\"header\">");
    req.getRequestDispatcher("/header").include(req, resp);
    out.println("</div>");

    out.println("<div class=\"content\">");
    out.println("<div class=\"errorDiv\">");
    out.println("<div class=\"d-grid gap-2 col-11 mx-auto\">");
    out.println("<span class=\"spanTitle\">서버 오류</span>");

    Exception e = (Exception) req.getAttribute("exception");
    out.printf("<p>%s</p>\n", e.getMessage());

    out.println("</div>"); 
    out.println("</form>");
    out.println("</div>");

    out.println("<div id=\"footer\">");
    req.getRequestDispatcher("/footer").include(req, resp);
    out.println("</div>");

    out.println("</body>");
    out.println("</html>");
  }
}
