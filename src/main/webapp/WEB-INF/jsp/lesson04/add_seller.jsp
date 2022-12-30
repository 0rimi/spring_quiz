<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 등록</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>판매자 추가</h1>
		<!-- http://localhost/lesson04/quiz01/add_seller -->
		<form method="post" action="/lesson04/quiz01/add_seller">
			<div class="form-group">
				<label for="nickname">닉네임</label>
				<input type="text" id="nickname" name="nickname" class="form-control col-3" placeholder="닉네임을 입력해주세요">
			</div>
			<div class="form-group">
				<label for="profileImageUrl">프로필 사진 url</label>
				<input type="text" id="profileImageUrl" name="profileImageUrl" class="form-control col-8">
			</div>
			<div class="form-group">
				<label for="temperature">온도</label>
				<input type="text" id="temperature" name="temperature" class="form-control col-3">
			</div>
			<button type="submit" class="btn btn-primary">추가</button>
		</form>
	</div>
</body>
</html>