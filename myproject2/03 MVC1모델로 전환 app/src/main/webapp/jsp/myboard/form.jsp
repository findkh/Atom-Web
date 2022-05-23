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
<form name="boardForm" class="boardForm" action='add.jsp' method='post'>
<div class="d-grid gap-2 col-11 mx-auto">
<span class="spanTitle">New Post</span>
<div class="col-12">
<label for="inputTitle" class="col-sm-2 col-form-label">Title</label>
<div class="col-sm-12">
<input type="text" class="form-control" id="inputTitle" name="title">
</div>
</div>
<div class="col-12">
<label for="formFile" class="form-label">image</label>
<input class="form-control" type="file" id="formFile" name="file">
</div>
<div class="form-floating">
<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height:200px" name="content"></textarea>
<label for="floatingTextarea2">Comments</label>
</div>
</div>
<div class="groupBtn">
<button type="button" class="btn btn-success" id="cancleBtn">Cancle</button>
<button type="submit" class="btn btn-success" id="addBtn">Save</button>
</div>
</form>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

<script>
document.querySelector('#cancleBtn').onclick = () => {
	  location.href = 'list.jsp';
}

</script>
</body>
</html>
