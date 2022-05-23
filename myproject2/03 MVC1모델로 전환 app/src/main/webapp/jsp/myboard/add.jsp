<%@page import="com.hyun.myproject2.domain.Member"%>
<%@page import="com.hyun.myproject2.domain.myBoard"%>
<%@page import="com.hyun.myproject2.service.myBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
  myBoard myboard = new myBoard();
  myboard.setTitle(request.getParameter("title"));
  myboard.setContent(request.getParameter("content"));

  Member loginUser = (Member) session.getAttribute("loginUser");
  myboard.setWriter(loginUser);

  myBoardService myboardService = (myBoardService) application.getAttribute("myboardService"); 
  myboardService.add(myboard);

  response.sendRedirect("list.jsp");
%>

