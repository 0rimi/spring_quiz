<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<label for="name">제목</label>
		<input type="text" id="name" name="name" class="form-control">
		
		<label for="url" class="mt-2">주소</label>
		<div class="d-flex">
			<input type="text" id="url" name="url" class="form-control col-11">
			<button id="urlCheck" type="button" class="btn btn-info ml-1">중복확인</button>
		</div>			
		<small id="urlStatus"></small>
		
		<input id="add" class="form-control btn btn-success mt-3" type="button" value="추가">
	</div>
	
	<script>
		$(document).ready(function(){
			
			let clickCnt = 0;
			
			// 주소중복확인
			$('#urlCheck').on('click',function(){
				
				//console.log('중복확인버튼클릭');
				console.log("clickCnt"+clickCnt);
				clickCnt += 2;
				
				// 초기화
				$('#urlStatus').empty();		
				
				let url = $('#url').val().trim();
				
				// 유효성검사
				if(url == ''){
					console.log("url : "+url);
					$('#urlStatus').append('<span class="text-danger">주소가 비어있습니다.</span>');
					clickCnt = 0;
					return;
				}
				
				$.ajax({
					
					//request
					type:"GET"
					,url:"/lesson06/quiz02/is_duplication"
					,data:{"url":url}
					//resoponse
					,success:function(data){
						if(data.isDuplication){	/*true면 중복*/
							console.log('중복');
							$('#urlStatus').append('<span class="text-danger">중복된 주소입니다.</span>');
							clickCnt = 0;
						}
					},complete:function(){
						
					},error:function(e){
						console.log('실패');
					}
					
				});
			});
			
			$('#add').on('click', function(){
				
				// validation(유효성검사)
				let name = $('#name').val().trim();
				let url = $('#url').val().trim();
				
				if(name.length < 1){
					alert('이름을 입력해주세요');
					return;
				}
				if(url.length < 1){
					alert('주소를 입력해주세요');
					return;
				}
				// http로 시작하지 않고, https로도 시작하지 않으면 alert
				if (url.startsWith('http') == false && url.startsWith('https') == false){
					alert('주소 형식이 잘못 되었습니다.')
					return;
				}
				
				if(clickCnt == 0){
					console.log("clickCnt"+clickCnt);
					alert('주소 중복 확인이 필요합니다.');
					return;
				}
				
				console.log(name);
				console.log(url);
				 
				// AJAX
				$.ajax({
					
					// Request
					type:"POST"
					, url:"/lesson06/quiz01/favorite"
					, data:{"name":name, "url":url}
					
					// Response
					, success:function(data) {	// json string > object 
						console.log(data);
						// 화면 이동
						location.href = "/lesson06/quiz01/list";
					}
					, complete:function(data) {
						console.log('성공');
					}
					, error:function(e) {
						console.log('에러');
					}
				});
				
			});	
		});
	</script>
	
</body>
</html>