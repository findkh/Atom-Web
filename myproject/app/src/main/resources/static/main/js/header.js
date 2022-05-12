css(".login-Menu", "display", "none");

fetch("/member/getLoginUser").then(function(response) {
  return response.json();
}).then(function(result) {
  if(result.status == "success") {
    // console.log(result);
    // console.log(result.data.photo);
    if(result.data.photo == null) {
      result.data.photo = "default.jpg";
    }
    const img = document.createElement("img");
    img.id = "profileImg";
    img.src="/member/photo?filename=50x50_"
    const imgpath = `${result.data.photo}`;
    img.src += imgpath
    img.id = "profileImg";
    // console.log(img.src);
    document.querySelector("#profile").appendChild(img);
    document.querySelector("#userName").innerHTML = result.data.name;
    css(".login-Menu", "display", "");
    css(".notLogin-Menu", "display", "none");
  }
});

function css(selector, name, value) {
  var el = document.querySelectorAll(selector);
    for (var e of el) {
      e.style[name] = value;
    }
};

document.querySelector("#loginBtn").onclick = function() {
  location.href="/member/signin.html";
};

document.querySelector("#logoutBtn").onclick = function() {
  fetch("/member/signout").then(function(response) {
    location.href="/main/index.html";
  });
};

document.querySelector("#signupBtn").onclick = function() {
  location.href="/member/signup.html";
}