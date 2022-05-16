$("#header").load("/main/header.html");
$("#footer").load("/main/footer.html");

let tbody = document.querySelector("#boardTable tbody");
let trTemplate = document.querySelector("#tr-template");
let htmlGenerator = Handlebars.compile(trTemplate.innerHTML);
let pageNo = document.querySelector("#pageNo");
let PageNoNum = Number(pageNo.innerHTML);
let totalListCount;

fetch("/member/getLoginUser").then(function(response) {
  return response.json();
})
  .then(function (result) {
  if (result.status == "fail") {
    document.querySelector("#create-btn").style.display = "none";
  }
});

fetch(`/myboard/list?pageNo=1&pageSize=10`)
.then(function(response) {
  return response.json();
})
.then(function (result) {
  if (result.status == "fail") {
    window.alert("서버 요청 오류!");
    console.log(result.data);
    return;
  }
  tbody.innerHTML = htmlGenerator(result.data);
  pageNo.innerHTML = result.pageNo;
  PageNoNum = pageNo.innerHTML;
  totalListCount = result.totalListCount;

  preNoLiDisplay(PageNoNum);
  nextNoLiDisplay(PageNoNum, totalListCount);
});

document.querySelector("#nextNoLi").onclick = function () {
  nextNo = (Number(pageNo.innerHTML) + 1);

  fetch(`/myboard/list?pageNo=${nextNo}&pageSize=10`)
  .then(function(response) {
    return response.json();
  })
  .then(function (result) {
    if (result.status == "fail") {
      window.alert("서버 요청 오류!");
      console.log(result.data);
      return;
    }
    tbody.innerHTML = htmlGenerator(result.data);
    pageNo.innerHTML = result.pageNo;
    PageNoNum = pageNo.innerHTML;
    totalListCount = result.totalListCount;

    preNoLiDisplay(PageNoNum);
    nextNoLiDisplay(PageNoNum, totalListCount);
  });
}

document.querySelector("#preNoLi").onclick = function () {
  preNo = (Number(pageNo.innerHTML) - 1);

  fetch(`/myboard/list?pageNo=${preNo}&pageSize=10`)
  .then(function(response) {
    return response.json();
  })
  .then(function (result) {
    if (result.status == "fail") {
      window.alert("서버 요청 오류!");
      console.log(result.data);
      return;
    }
    tbody.innerHTML = htmlGenerator(result.data);
    pageNo.innerHTML = result.pageNo;
    PageNoNum = pageNo.innerHTML;
    totalListCount = result.totalListCount;

    preNoLiDisplay(PageNoNum);
    nextNoLiDisplay(PageNoNum, totalListCount);
  });
}

function preNoLiDisplay(PageNoNum) {
  if (PageNoNum == 1 || PageNoNum == 0) {
    document.querySelector("#preNoLi").style.display = "none";
  } else {
    document.querySelector("#preNoLi").style.display = "";
  }
}

function nextNoLiDisplay(PageNoNum, totalListCount) {
  if (PageNoNum == totalListCount) {
    document.querySelector("#nextNoLi").style.display = "none";
  } else {
    document.querySelector("#nextNoLi").style.display = "";
  }
}

document.querySelector("#create-btn").onclick = function () {
  window.location.href = "form.html"
}