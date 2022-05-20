<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<title>My board</title>
</head>
<body>
<div id="header">
<nav class="navbar fixed-top navbar-expand-lg">
<div class="inner">
<a class="navbar-brand" href="/main/index.html">My Project</a>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav me-auto mb-2 mb-lg-0">
<li class="nav-item">
<a class="nav-link active" aria-current="page" href="/main/index.html" style="color:white; font-size: 18px;">Home</a>
</li>
<li class="nav-item dropdown">
<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color:white; font-size: 18px;">
Project List
</a>
<ul class="dropdown-menu" aria-labelledby="navbarDropdown"  style="margin-top: 10px;">
<li><a class="dropdown-item" href="/myboard/index.html">Board</a></li>
</ul>
</li>
</ul>
</div>
<div class="loginmenuDiv">
<ul class="menu">
<li class="notLogin-Menu"><button id="loginBtn" type="button" class="btn btn-outline-light notLogin">Signin</button></li>
<li class="notLogin-Menu"><button id="signupBtn" type="button" class="btn btn-outline-light notLogin">Signup</button></li>
<li class="login-Menu"><div id="profile"></div></li>
<li class="login-Menu"><div id="userNameDiv"><span id="userName" class="login"></span></div></li>
<li class="login-Menu"><button id="logoutBtn" type="button" class="btn btn-outline-light login">Logout</button></li>
</ul>
</div>
</div>
</nav>
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
<tr>
<td>64</td>
<td><a href='detail?no=64'>된다 된다 된다22</td>
<td>하파</td>
<td>17</td>
<td>2022-05-19</td>
</tr>
<tr>
<td>63</td>
<td><a href='detail?no=63'>ssss</td>
<td>하파</td>
<td>3</td>
<td>2022-05-19</td>
</tr>
<tr>
<td>62</td>
<td><a href='detail?no=62'>bbb</td>
<td>하파</td>
<td>2</td>
<td>2022-05-19</td>
</tr>
<tr>
<td>61</td>
<td><a href='detail?no=61'>test6</td>
<td>user2</td>
<td>58</td>
<td>2022-05-17</td>
</tr>
<tr>
<td>60</td>
<td><a href='detail?no=60'>test5</td>
<td>user2</td>
<td>0</td>
<td>2022-05-17</td>
</tr>
<tr>
<td>59</td>
<td><a href='detail?no=59'>test4</td>
<td>user2</td>
<td>4</td>
<td>2022-05-17</td>
</tr>
<tr>
<td>58</td>
<td><a href='detail?no=58'>test3</td>
<td>user1</td>
<td>0</td>
<td>2022-05-17</td>
</tr>
<tr>
<td>57</td>
<td><a href='detail?no=57'>test2</td>
<td>user1</td>
<td>1</td>
<td>2022-05-17</td>
</tr>
<tr>
<td>56</td>
<td><a href='detail?no=56'>test1</td>
<td>user1</td>
<td>1</td>
<td>2022-05-17</td>
</tr>
<tr>
<td>55</td>
<td><a href='detail?no=55'>게시글 등록</td>
<td>수달</td>
<td>4</td>
<td>2022-05-17</td>
</tr>
<tr>
<td>51</td>
<td><a href='detail?no=51'>bbb333</td>
<td>하파</td>
<td>3</td>
<td>2022-05-13</td>
</tr>
<tr>
<td>50</td>
<td><a href='detail?no=50'>수정 222 오호 수정됨 수정됨</td>
<td>하파</td>
<td>5</td>
<td>2022-05-13</td>
</tr>
<tr>
<td>49</td>
<td><a href='detail?no=49'>myboard</td>
<td>user1</td>
<td>4</td>
<td>2022-05-13</td>
</tr>
<tr>
<td>48</td>
<td><a href='detail?no=48'>test</td>
<td>하파</td>
<td>12</td>
<td>2022-05-13</td>
</tr>
<tr>
<td>47</td>
<td><a href='detail?no=47'>오호라!!!!</td>
<td>user1</td>
<td>4</td>
<td>2022-05-13</td>
</tr>
<tr>
<td>46</td>
<td><a href='detail?no=46'>사진첨부 시도</td>
<td>하파</td>
<td>3</td>
<td>2022-05-13</td>
</tr>
<tr>
<td>37</td>
<td><a href='detail?no=37'>사진 등록1</td>
<td>user2</td>
<td>34</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>30</td>
<td><a href='detail?no=30'>사진 없이 등록</td>
<td>user3</td>
<td>16</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>28</td>
<td><a href='detail?no=28'>프로젝트!!!</td>
<td>user1</td>
<td>1</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>27</td>
<td><a href='detail?no=27'>된다 된다 된다!</td>
<td>user1</td>
<td>3</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>26</td>
<td><a href='detail?no=26'>ㅇㅇㅇ</td>
<td>user1</td>
<td>3</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>25</td>
<td><a href='detail?no=25'>ㅁㅁㅁ</td>
<td>user1</td>
<td>10</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>24</td>
<td><a href='detail?no=24'>사진</td>
<td>user1</td>
<td>2</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>23</td>
<td><a href='detail?no=23'>ccc</td>
<td>user1</td>
<td>2</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>22</td>
<td><a href='detail?no=22'>bbb</td>
<td>user2</td>
<td>1</td>
<td>2022-05-10</td>
</tr>
<tr>
<td>21</td>
<td><a href='detail?no=21'>다른 사람!</td>
<td>user2</td>
<td>29</td>
<td>2022-05-09</td>
</tr>
<tr>
<td>19</td>
<td><a href='detail?no=19'>ccc</td>
<td>user1</td>
<td>6</td>
<td>2022-05-09</td>
</tr>
<tr>
<td>18</td>
<td><a href='detail?no=18'>수정함! bbb</td>
<td>user1</td>
<td>7</td>
<td>2022-05-09</td>
</tr>
</tbody>
</table>
<div class="btnDiv">
<button id="createBtn" type="button" class="btn btn-success">Add</button>
</div>
</div>
</div>
<div id="footer">
<div id="footer navbar-fixed-bottom">
<nav class="navbar fixed-bottom navbar-expand-lg footerNavbar">
<div class="footerNavbarinner">
<div class="footerContent">
<span style="color:white">
<a href="https://github.com/findkh" data-bs-toggle="tooltip" data-bs-placement="top" title="Github로 이동합니다"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-github" viewBox="0 0 16 16">
<path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
</svg></a>
<a href="https://blog.naver.com/watermoon14" data-bs-toggle="tooltip" data-bs-placement="top" title="블로그로 이동합니다"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-journals" viewBox="0 0 16 16">
<path d="M5 0h8a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2 2 2 0 0 1-2 2H3a2 2 0 0 1-2-2h1a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1H1a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v9a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H5a1 1 0 0 0-1 1H3a2 2 0 0 1 2-2z"/>
<path d="M1 6v-.5a.5.5 0 0 1 1 0V6h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V9h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 2.5v.5H.5a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1H2v-.5a.5.5 0 0 0-1 0z"/>
</svg></a>
</span><br>
<span style="color:white; font-size: small;">Copyright 2022. ParkKyounghyun</span>
</div>
</div>
</nav>
</div>
</div>
</div>
<script>
document.querySelector('#createBtn').onclick = () => {
  location.href ='add';
}
</script>
</body>
</html>
