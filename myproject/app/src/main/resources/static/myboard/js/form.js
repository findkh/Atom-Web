$("#header").load("/main/header.html");
$("#footer").load("/main/footer.html");

var xTitle = document.querySelector("input[name=title]");
  var xPhoto = document.querySelector("input[name=file]");
  var xContent = document.querySelector("textarea");

  document.querySelector("#x-add-btn").onclick = function() {
    if (xTitle.value == "" || xContent.value == "") {
      window.alert("필수 입력 항목이 비어 있습니다.");
      return;
    }

    var fd = new FormData(document.forms.namedItem("boardForm"));

    fetch ("/member/getLoginUser", {
      method : "POST"
    })
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      if(result.status == "success") {
        fetch("/myboard/add", {
        method : "POST",
        body: fd
        })
        .then(function(response) {
          return response.json();
        })
        .then(function(result) {
          if (result.status == "success") {
            location.href = "index.html";
          } else {
            window.alert("게시글 등록 실패!");
            console.log(result);
          }
        });
      }
    });
  };

document.querySelector("#x-cancel-btn").onclick = function() {
  window.location.href = "index.html";
};
 
