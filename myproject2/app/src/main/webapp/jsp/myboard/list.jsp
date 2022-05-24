<%@ page import="com.hyun.myproject2.domain.myBoard"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="/css/header.css" rel="stylesheet">
<link href="/css/footer.css" rel="stylesheet">
<link href="/css/myboardindex.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<title>My board5</title>
</head>
<body>

<div id="header">
<jsp:include page="/jsp/header.jsp"></jsp:include>
</div>

<div class="content">
<div class="contentInner">
<table class="table table-hover table-sm" id="boardTable">
<thead class="table-light">
<tr>
<th scope="col" width="50px">#</th>
<th scope="col" width="400px">Title</th>
<th scope="col" width="100px">Writer</th>
<th scope="col" width="80px">ViewCount</th>
<th scope="col" width="100px">Date</th>
</tr>
</thead>
<tbody style="border: white">

<c:forEach var="myboard" items="${list}">
  <tr>
    <td>${myboard.no}</td>
    <td><a href='detail?no=${pageScope.myboard.no}'>${myboard.title}</a></td>
    <td>${myboard.writer.name}</td>
    <td>${myboard.viewCount}</td>
    <td>${myboard.createdDate}</td>
  </tr>
</c:forEach>
</tbody>
</table>
<div class="pagination justify-content-center">
  <div class="list-group list-group-horizontal">
  <c:if test="${pageNo > 1 }">
    <li class="list-group-item list-group-item-success"><a href="list?pageNo=${pageNo-1}&pageSize=${pageSize}">&laquo;</a></li>
  </c:if>
  <c:if test="${pageNo <= 1 }">
    <li class="list-group-item list-group-item-success">&laquo;</li>
  </c:if>
    <li class="list-group-item list-group-item-success"><span>${pageNo}</span></li>
  <c:choose>
    <c:when test="${pageNo < totalPageSize}">
      <li class="list-group-item list-group-item-success"><a href="list?pageNo=${pageNo+1}&pageSize=${pageSize}">&raquo;</a></li>
    </c:when>
    <c:otherwise>
      <li class="list-group-item list-group-item-success">&raquo;</li>
    </c:otherwise>
  </c:choose>
  </div>
</div>
<div class="btnDiv">
<button id="createBtn" type="button" class="btn btn-success">Add</button>
</div>
</div>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div> 

<script>
document.querySelector('#createBtn').onclick = () => {
  location.href ='add';
}
</script>
</body>
</html>
