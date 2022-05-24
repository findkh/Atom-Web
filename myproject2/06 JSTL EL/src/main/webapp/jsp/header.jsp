<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



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
