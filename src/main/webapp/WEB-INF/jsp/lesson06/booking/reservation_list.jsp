<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약하기</title>

    <!-- jQuery 원본 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- bootstrap CDN link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- datepicker-->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <link rel="stylesheet" href="/css/booking/main.css">
</head>
<body>
    <div id="wrap" class="container">
        <!--헤더-->
        <jsp:include page="header.jsp"/>
        
        <!--nav-->
        <jsp:include page="nav.jsp"/>
        
        <!--section-->
        <section>
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="booking" items="${bookingList}">
						<tr>
							<td>${booking.name}</td>
							<td>
								<fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일"/>
							</td>
							<td>${booking.day}</td>
							<td>${booking.headcount}</td>
							<td>${booking.phoneNumber}</td>
							<td>
								<c:choose>
									<c:when test="${booking.state eq '대기중'}">
										<span class="text-info">${booking.state}</span>
									</c:when>
									<c:when test="${booking.state eq '확정'}">
										<span class="text-success">${booking.state}</span>
									</c:when>
								</c:choose>
							</td>
							<td>
								<button type="button" data-booking-id="${booking.id}" class="btn btn-danger delBtn">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
        </section>
        
        <!--footer-->
        <jsp:include page="footer.jsp"/>
    </div>

<!-- /////////////////////// -->
    <script>
    	$(document).ready(function(){
    		
    		// 삭제하기 > data-booking-id
			$('.delBtn').on('click',function(e){
				
				let id = $(this).data('booking-id');
				console.log('삭제 :'+id);
				
				$.ajax({
					
					//request
					type:"delete"
					,url:"/booking/reservation_del"
					,data:{"id":id}
				
					//response
					,success:function(data){
						if(data.code == 0){
							console.log(data.result);
							location.reload(true);
						}else if(data.code == 500){	
							alert(data.result);
						}
					},error:function(e){
						alert("에러");
					}
					
				});
				
			});
    		
    	});
    </script>

</body>
</html>