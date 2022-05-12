$("#header").load("/main/header.html");
$("#footer").load("/main/footer.html");

var arr = location.href.split("?");
console.log(arr);

if (arr.length == 1) {
  alert("요청 형식이 올바르지 않습니다.")
  throw "URL 형식 오류!";
}

var qs = arr[1];
console.log(qs);

var params = new URLSearchParams(qs);
var no = params.get("no");

if (no == null) {
  alert("게시물 번호가 없습니다.");
  throw "파라미터 오류!";
}
console.log(no);

var xNo = document.querySelector("#x-no");
var xTitle = document.querySelector("#x-title");
var xPhoto = document.querySelector("#x-photo");
var xContent = document.querySelector("#x-content");
var xWriter = document.querySelector("#x-writer");
var xViewCount = document.querySelector("#x-viewCount");
var xCreatedDate = document.querySelector("#x-createdDate");
console.log(xWriter);

fetch(`/myboard/get?no=${no}`)
.then(function(response) {
  return response.json();
})
.then(function(board) {
  console.log(board);
  xNo.value = board.no;
  xTitle.value = board.title;
  xContent.value = board.content;
  if (board.photo != null) {
  xPhoto.src="/myboard/photo?filename=" + board.photo;
  };
  xWriter.innerHTML = board.writer.name;
  xViewCount.innerHTML = board.viewCount;
  xCreatedDate.innerHTML = board.createdDate;
});

document.querySelector("#x-update-btn").onclick = function() {
  if (xTitle.value == "" || xContent.value == "") {
    window.alert("필수 입력 항목이 비어 있습니다.");
    return;
  }

  var fd = new FormData(document.forms.namedItem("viewForm"));

  fetch("/myboard/update", {
    method: "POST",
    body: fd
  })
  .then(function(response) {
    return response.json();
  })
  .then(function(result) {
    if (result.status == "success") {
      location.href = "index.html";
    } else {
      window.alert("게시글 변경 실패!");
      console.log(result.data);
    }
  });
};

document.querySelector("#x-cancel-btn").onclick = function() {
  window.location.href = "index.html";
};

document.querySelector("#x-delete-btn").onclick = function() {
  fetch(`/myboard/delete?no=${no}`)
    .then(function(response) {
      return response.json();
    })
    .then(function(result) {
      if (result.status == "success") {
      location.href = "index.html";
    } else {
      window.alert("게시글 삭제 실패!");
      console.log(result.data);
    }
  });
};