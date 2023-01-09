<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="container d-flex justify-content-center">
				<div class="col-6">
					<div class="text-center mt-3">
						<h3><strong>예약하기</strong></h3>
					</div>
					<div>
					<label for="name">이름</label>
					<input type="text" class="form-control mb-1" id="name">
					<label for="date">예약날짜</label>
					<input type="text" class="form-control mb-1" id="date">
					<label for="day">숙박일수</label>
					<input type="number" class="form-control mb-1" id="day">
					<label for="headcount">숙박인원</label>
					<input type="number" class="form-control mb-1" id="headcount">
					<label for="phoneNumber">전화번호</label>
					<input type="text" class="form-control mb-1" id="phoneNumber" placeholder="010-1111-2222">
					
					<button type="button" class="mt-2 form-control btn btn-warning" id="reserveBtn">예약하기</button>
				</div>
			</div>
        </section>
        
        <!--footer-->
        <jsp:include page="footer.jsp"/>
    </div>

<!-- /////////////////////// -->
    <script>
	    $(document).ready(function() {
	    	
	    	// datepicker
			$('#date').datepicker({
				dateFormat: "yy-mm-dd"
			});
	    	
	    	// 예약하기 버튼
	    	$('#reserveBtn').on('click',function(){
	    		
	    		let name = $('#name').val().trim();
	    		let date = $('#date').val().trim();
	    		let day = $('#day').val();
	    		let headcount = $('#headcount').val();
	    		let phoneNumber = $('#phoneNumber').val().trim();
	    		
	    		// 유효성검사
	    		if(name == ''){
	    			alert('이름을 입력해주세요.');
	    			return;
	    		}
	    		if(date.length<1){
	    			alert('날짜를 입력해주세요.');
	    			return;
	    		}
	    		if(day == ''){
	    			alert('숙박일수를 입력해주세요.');
	    			return;
	    		}
	    		if(day<0){
	    			alert('숙박일수를 확인해주세요.');
	    			return;
	    		}
	    		if(headcount == ''){
	    			alert('숙박인원을 입력해주세요.');
	    			return;
	    		}
	    		if(headcount<0){
	    			alert('유효한 숙박인원을 입력해주세요.');
	    			return;
	    		}
	    		if(phoneNumber == ''){
	    			alert('전화번호를 입력해주세요');
	    			return;
	    		}
	    		if(phoneNumber.includes('-') == false){
	    			alert('전화번호 양식을 확인해주세요.');
	    			return;
	    		}
	    		if(phoneNumber.startsWith('010') == false){
	    			console.log(phoneNumber);
	    			alert('유효한 전화번호를 입력해주세요.');
	    			return;
	    		}
	    		
	    		// 예약정보 넘기기
	    		$.ajax({
	    			
	    			//rq
	    			type:"post"
	    			,url:"/booking/booking_reserve"
	    			,data:{"name":name,"date":date,"day":day,"headcount":headcount,"phoneNumber":phoneNumber}
	    			//rs
	    			,success:function(data){
	    				if(data.result > 0){
	    					alert('예약완료');
	    		    		location.href="/booking/reservation_view";
	    				}else{
	    					console.log('에러');
	    					return;
	    				}
	    			},error:function(e){
	    				console.log('ajax 에러');
	    			}
	    			
	    		});
	    	});
			
		});
    </script>

</body>
</html>