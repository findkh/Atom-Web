$("#header").load("/main/header.html");
$("#footer").load("/main/footer.html");

var Name = document.querySelector("input[name=name]");
var Email = document.querySelector("input[name=email]");
var PassWord = document.querySelector("input[name=password]");

document.querySelector("form[name=SignupForm]").onsubmit = function() {
if (Name.value == "" ||
    Email.value == "" ||
    PassWord.value == "") {
    window.alert("필수 입력 항목이 비어있습니다.")
    return false;
}
  var fd = new FormData(document.forms.namedItem("SignupForm"));
  
fetch("/member/signup", {
  method : "POST",
  body : fd
})
.then(function(response) {
  return response.json();
})
.then(function(result) {
  if (result.status == "success") {
    window.alert("회원가입 성공!");
    location.href="/member/signin.html";
  } else {
    window.alert("회원가입 실패!");
  }
});
return false;
}

document.querySelector("#cancleBtn").onclick = function() {
window.location.href = "/main/index.html";
};