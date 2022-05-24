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
<jsp:include page="/jsp/header.jsp"></jsp:include>
</div>

<div class="content">
<form class="viewForm" name="viewForm" action='update' method='post'>
<div class="row g-3 mx-auto">
<span class="spanTitle">View Post4</span>
<div class="col-md-6 mx-auto">
<label for="inputNo" class="form-label">No</label>
<input name="no" class="form-control" type="text" value='${myboard.no}' readonly></div>
<div class="col-md-6">
<label for="date" class="form-label">Date</label>
<input type="date" class="form-control" value='${myboard.createdDate}' disabled></div>
<div class="col-12">
<label for="title" class="form-label">Title</label>
<input type="text" class="form-control" name="title" value='${myboard.title}'></div>
<div class="col-md-6">
<label for="writer" class="form-label">Writer</label>
<input type="text" class="form-control" value='${myboard.writer.name}' disabled></div>
<div class="col-md-6">
<label for="viewCount" class="form-label">ViewCount</label>
<input type="number" class="form-control" value='${myboard.viewCount}' disabled></div>
<div class="form-floating">
<textarea class="form-control" style="height:200px" name="content">${myboard.content}</textarea></div>
<div class="col-12">
<label for="formFile" class="form-label">image</label>
<input class="form-control" type="file" id="formFile" name="file">
</div>
<div id="photoBox">
</div>
</div>
<div class="groupBtn">
<button type="submit" class="btn btn-success" id="updateBtn">Update</button>
<button type="button" class="btn btn-success" id="deleteBtn">Delete</button>
<button type="button" class="btn btn-success" id="cancleBtn">Cancle</button>
</div>
</form>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

<script>
document.querySelector('#deleteBtn').onclick = () => {
	  location.href = 'delete?no=' + document.querySelector('input[name=no]').value;
}
document.querySelector('#cancleBtn').onclick = () => {
	  location.href = 'list';
}
</script>
</body>
</html>
