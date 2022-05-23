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
@WebServlet("/header") 
public class HeaderServlet extends HttpServlet {
  myBoardService myboardService;

  @Override //service() 메서드는 GET, POST 요청 모두 호출된다.
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<nav class=\"navbar fixed-top navbar-expand-lg\">");
    out.println("<div class=\"inner\">");
    out.println("<a class=\"navbar-brand\" href=\"/main/index.html\">My Project</a>");
    out.println("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
    out.println("<ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">");
    out.println("<li class=\"nav-item\">");
    out.println("<a class=\"nav-link active\" aria-current=\"page\" href=\"/main/index.html\" style=\"color:white; font-size: 18px;\">Home</a>");
    out.println("</li>");
    out.println("<li class=\"nav-item dropdown\">");
    out.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\" style=\"color:white; font-size: 18px;\">");
    out.println("Project List");
    out.println("</a>");
    out.println("<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\"  style=\"margin-top: 10px;\">");
    out.println("<li><a class=\"dropdown-item\" href=\"/myboard/index.html\">Board</a></li>");
    out.println("</ul>");
    out.println("</li>");
    out.println("</ul>");
    out.println("</div>");
    out.println("<div class=\"loginmenuDiv\">");
    out.println("<ul class=\"menu\">");
    out.println("<li class=\"notLogin-Menu\"><button id=\"loginBtn\" type=\"button\" class=\"btn btn-outline-light notLogin\">Signin</button></li>");
    out.println("<li class=\"notLogin-Menu\"><button id=\"signupBtn\" type=\"button\" class=\"btn btn-outline-light notLogin\">Signup</button></li>");
    out.println("<li class=\"login-Menu\"><div id=\"profile\"></div></li>");
    out.println("<li class=\"login-Menu\"><div id=\"userNameDiv\"><span id=\"userName\" class=\"login\"></span></div></li>");
    out.println("<li class=\"login-Menu\"><button id=\"logoutBtn\" type=\"button\" class=\"btn btn-outline-light login\">Logout</button></li>");
    out.println("</ul>");
    out.println("</div>");
    out.println("</div>");
    out.println("</nav>");
  }
}
