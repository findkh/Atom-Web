$("#header").load("/main/header.html");
$("#footer").load("/main/footer.html");

let tbody = document.querySelector("#boardTable tbody");
let trTemplate = document.querySelector("#tr-template");
let htmlGenerator = Handlebars.compile(trTemplate.innerHTML);

fetch("/myboard/list")
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
   });

document.querySelector("#create-btn").onclick = function () {
  window.location.href = "form.html"
}