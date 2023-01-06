<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="favorite" items="${favoriteList}" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${favorite.name }</td>
						<td>${favorite.url }</td>
						<td>
							<!-- 1)name + value 속성 삭제 -->
							<%-- <button class="btn btn-danger" value="${favorite.id}" name="delBtn" type="button">삭제</button> --%>
							
							<!-- data를 이용해서 태그에 임시 저장하기 -->
							<button class="btn btn-danger delBtn" data-favorite-id="${favorite.id}" type="button">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
		$(document).ready(function(){
			
			/* value가 하나인 경우에만 가능
			$('button[name=delBtn]').on('click',function(e){
				
				//let id = $(this).val();
				//let id = $(this).attr('value');
				let id = e.target.value;	//target=this
				console.log('삭제 :'+id);
				
			});
			*/
			
			// 태그 : data-favorite-id (대문자 절대 안됨)
			$('.delBtn').on('click',function(e){
				
				let id = $(this).data('favorite-id');
				console.log('삭제 :'+id);
				
				$.ajax({
					
					//request
					type:"delete"
					,url:"/lesson06/quiz02/delete_favorite"
					,data:{"id":id}
				
					//response
					,success:function(data){
						if(data.code==1){
							console.log("삭제성공 : "+id);
							location.reload(true); //새로고침
						}else if(data.code==500){
							console.log("에러코드 :"+data.code);
						}
					},error:function(e){
						alert("에러"+e)
					}
			
					
				});

			});
			
		});
	</script>
</body>
</html>