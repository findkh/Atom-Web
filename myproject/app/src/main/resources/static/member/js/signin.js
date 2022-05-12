$("#header").load("/main/header.html");
$("#footer").load("/main/footer.html");

var Email = document.querySelector("input[name=email]");
var PassWord = document.querySelector("input[name=password]");

document.querySelector("form[name=SigninForm]").onsubmit = function() {
  if (Email.value == "" ||
      PassWord.value == "") {
      window.alert("필수 입력 항목이 비어있습니다.")
      return false;
  }
  var fd = new FormData(document.forms.namedItem("SigninForm"));

  fetch("/member/signin", {
    method : "POST",
    body : new URLSearchParams(fd)
  })
  .then(function(response) {
    return response.json();
  })
  .then(function(result) {
    if (result.status == "success") {
      // location.href = document.referrer;
      location.href = "/main/index.html";
    } else {
      window.alert("로그인 실패!");
    }
  })
  return false;
}

document.querySelector("#signUpBtn").onclick = function() {
  window.location.href = "/member/signup.html";
}

document.querySelector("#cancleBtn").onclick = function() {
  window.location.href = "/main/index.html";
};

//페이스북 로그인
window.fbAsyncInit = function() {
  FB.init({
    appId      : '702971957572821',
    cookie     : true,  
    xfbml      : true,  
    version    : 'v13.0' 
  });
  FB.AppEvents.logPageView();
};

(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "https://connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function FacebookLoginFn() {
  FB.login(function(response) { 
      if (response.status === 'connected') {            

        var params = new URLSearchParams();
        params.append("accessToken", response.authResponse.accessToken);

        fetch("/member/fbsingin", {
          method: "POST",
          body: params
        })
        .then(function(response) {
          return response.json();
        })
        .then(function(result) {
          console.log(result);
          if (result.status == "success") {
            // console.log(result.data);
            console.log("자동 로그인 성공!");
            location.href = document.referrer; 
          } else {
            alert("로그인 실패");
            console.log("result.data");
          }
        })
      } else { // 로그인이 되지 않았을 때,
          console.log("로그인 되지 않았음");
      }
  });
}

//userEmail 쿠키가 있다면 값을 꺼내서 이메일 입력 상자에 넣는다.
let userEmail = Cookies.get('userEmail');
if (userEmail != undefined) {
  Email.value = userEmail
}
