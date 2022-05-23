# #Servlet/JSP 프로젝트 
## 
- 기존에 SpringBoot로 만든 프로젝트를 JSP로 변환하는 연습

05.16. ~ 05.17.  
- servlet 이론 정리 및 프로젝트 파일 설정
05.18. ~ 05.19.
- servlet과 listener를 활용하여 서버사이드랜더링방식으로 변환
  - submit 버튼 활용
  - autoLoginListener 사용하여 임시로 로그인 상태 만듦
  - add 요청(하나의 servlet에서 get요청과 post요청 동시에 처리하기)
    - <img src="https://user-images.githubusercontent.com/89373222/169262563-bde0d8f0-ce83-471f-8c89-0d6c471d08e8.png">
    302라는 값은 웹브라우저에게 응답을 받자마자 url(list)을 보고 다시 요청하라는 뜻이다.
    - GET요청은 파라미터 값을 그대로 꺼내지만 POST 한글 데이터를 보낼 때는 어떤 charSet으로 인코딩 되었는지 정확하게 알려주어야 한다.  
    (웹브라우저에서 웹서버에게 데이터를 보낼 때 UTF-8 로 인코딩 해서 보낸다.
    이렇게 인코딩 해서 보낸 문자열을 자바에서 사용하는 UTF-16 으로 바꿔서 리턴하는 것이다.)
    `req.setCharacterEncoding("UTF-8");`  
    주의할 점은 반드시 getParaemeter() 호출하기 전에 설정해야 한다.  
    단 한 번이라도 getParameter() 호출한 후 설정하게 되면 이 설정은 무시된다.
- servlet include/forward, filter 활용
  - myBoardAddServlet, myBoardDeleteServlet, myBoardDetailServlet, myBoardListServlet,  myBoardUpdateServlet에 header와 footer 코드가 중복된다.  
  서블릿을 재사용하여 중복 코드를 줄이기 위해 Header와 footer Servlet을 분리한다.
  - 인클루드와 포워드의 활용
  - filter 활용하여 UTF-8로 인코딩하는 코드를 줄인다.  
- 05.20.
  - 기존에 작성한 코드에 jsp 적용하고, header와 footer를 인클루드한다.
  - MVC1 초기모델 
    자바코드를 scriptlet element라는 특수한 언어로 자바코드를 가둬두어야 한다.
    ``` java
    <tbody style="border: white">
    <%
    myBoardService myboardService = (myBoardService) application.getAttribute("myboardService");
    List<myBoard> boards = myboardService.list();
    for (myBoard board : boards) {
    %>
      <tr>
        <td><%=board.getNo()%></td>
        <td><a href='detail?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
        <td><%=board.getWriter().getName()%></td>
        <td><%=board.getViewCount()%></td>
        <td><%=board.getCreatedDate() %></td>
      </tr>
    <%
    }
    %>
    </tbody>
    ```
    자바코드를 scriptlet element라는 특수한 언어로 자바코드를 가둬두어야 한다.
05.23.
- JSP를 사용하여 MVC 모델1으로 전환
  - JSP 기술을 사용하여 콘텐츠 중심으로 Servlet을 만드는 기술
- 페이징 처리
- MVC 모델 2로 전환


