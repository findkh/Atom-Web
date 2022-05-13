$("#header").load("/main/header.html");
$("#footer").load("/main/footer.html");

var arr = location.href.split("?");
console.log(arr);

if (arr.length == 1) {
  alert("요청 형식이 올바르지 않습니다.")
  throw "URL 형식 오류!";
}

var qs = arr[1];
// console.log(qs);

var params = new URLSearchParams(qs);
var no = params.get("no");

if (no == null) {
  alert("게시물 번호가 없습니다.");
  throw "파라미터 오류!";
}
// console.log(no);

var xNo = document.querySelector("#inputNo");
var xTitle = document.querySelector("#title");
var PhotoBox = document.querySelector("#photoBox")
console.log(PhotoBox);
var xPhoto = document.querySelector("#x-photo");
var xContent = document.querySelector("#floatingTextarea2");
var xWriter = document.querySelector("#writer");
var xViewCount = document.querySelector("#viewCount");
var xCreatedDate = document.querySelector("#date");

fetch(`/myboard/get?no=${no}`)
.then(function(response) {
  return response.json();
})
.then(function (result) {
  if (result.status == "fail") {
    window.alert("서버 요청 오류");
    console.log(result.data);
    return;
  }
  console.log(result.data);
  xNo.value = result.data.no;
  xTitle.value = result.data.title;
  xContent.value = result.data.content;
  if (result.data.photo != null) {
  xPhoto.src="/myboard/photo?filename=" + result.data.photo;
  } else {
    PhotoBox.style.display = "none";
  }
  xWriter.value = result.data.writer.name;
  xViewCount.value = result.data.viewCount;
  xCreatedDate.value = result.data.createdDate;
});

document.querySelector("#updateBtn").onclick = function() {
  if (xTitle.value == "" || xContent.value == "") {
    window.alert("필수 입력 항목이 비어 있습니다.");
    return;
  }

  var fd = new FormData(document.forms.namedItem("viewForm"));

  console.log(document.querySelector("input[name=no]").value);
  fd.append("no", xNo.value)

  fetch("/myboard/update", {
    method: "POST",
    body: fd
  })
  .then(function(response) {
    return response.json();
  })
    .then(function (result) {
    if (result.status == "success") {
      console.log("성공");
      location.href = "index.html";
    } else {
      window.alert(result.data);
    }
  });
};

document.querySelector("#cancleBtn").onclick = function() {
  window.location.href = "index.html";
};

document.querySelector("#deleteBtn").onclick = function() {
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