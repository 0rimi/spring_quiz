<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공인중개사 추가</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>공인중개사 추가</h1>
				<!-- http://localhost/lesson04/quiz02/add_realtor -->
		<form method="post" action="/lesson04/quiz02/add_realtor">
			<div class="form-group">
				<label for="office">상호명</label>
				<input type="text" id="office" name="office" class="form-control col-6" placeholder="상호명을 입력해주세요">
			</div>
			<div class="form-group">
				<label for="phoneNumber">전화번호</label>
				<input type="text" id="phoneNumber" name="phoneNumber" class="form-control col-6" placeholder="ex)02-111-2222">
			</div>
			<div class="form-group">
				<label for="address">주소</label>
				<input type="text" id="address" name="address" class="form-control col-6">
			</div>
			<div class="form-group">
				<label for="grade">등급</label>
				<select id="grade" name="grade" class="form-control col-5">
    				<option value="일반중개사">일반중개사</option>
    				<option value="안심중개사">안심중개사</option>
    				<option value="프리미엄중개사">프리미엄중개사</option>
				</select>
			</div>
			
			<button type="submit" class="btn btn-primary">추가</button>
		</form>
	</div>
</body>
</html>