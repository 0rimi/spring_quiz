<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>통나무 펜션</title>

    <!-- jQuery 원본 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- bootstrap CDN link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- datepicker-->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<!-- json date format -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

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

            <!--banner-->
            <section class="banner">
                <img id="bannerImage" alt="banner" src="" width="100%" height="100%">
            </section>

            <!--예약 part-->
            <section class="contents bg-info d-flex" id="part">
                <!--실시간예약하기-->
                <section class="col-4 content1 d-flex align-items-center justify-content-center">
                   <div class="text-white display-4" style="cursor: pointer;" onclick="location.href='/booking/booking_view';">
                        실시간<br>
                        예약하기
                   </div>
                </section>
                <!--예약확인-->
                <section class="col-5 content2" id="reservation-confirm">
                   <div class="m-3">
                        <span class="text-white mr-3">예약 확인</span>
                        <label for="member" class="text-white">회원</label>
                        <input type="radio" name="memberType" id="member" value="member" checked>
                        <label for="nonMember" class="text-white ml-2">비회원</label>
                        <input type="radio" name="memberType" id="nonMember" value="nonMember">
                   </div>
                   <!--예약확인(회원)-->
                   <div id="memberBox" class="col-11 text-white">
                        <div class="d-flex align-items-center justify-content-end mb-3">
                            <div>아이디:</div>
                            <input id="id" type="text" class="form-control col-8 ml-4">
                        </div>
                        <div class="d-flex align-items-center justify-content-end mb-3">
                            <div>비밀번호:</div>
                            <input id="pw" type="password" class="form-control col-8 ml-4">
                        </div>
                        <div class="d-flex align-items-center justify-content-end">
                            <button class="btn btn-success submit-btn">조회 하기</button>
                        </div>
                   </div>
                   <!--예약확인(비회원)-->
                   <div id="nonMemberBox" class="col-11 text-white d-none">
                        <div class="d-flex align-items-center justify-content-end mb-3">
                            <div>이름:</div>
                            <input id="name" type="text" class="form-control col-8 ml-4">
                        </div>
                        <div class="d-flex align-items-center justify-content-end mb-3">
                            <div>전화번호:</div>
                            <input id="phone" type="text" class="form-control col-8 ml-3">
                        </div>
                        <!-- <div class="d-flex align-items-center justify-content-end mb-3">
                            <div>날짜:</div>
                            <input id="reserveDate" type="text" class="form-control col-8 ml-4">
                        </div> -->
                        <div class="d-flex align-items-center justify-content-end">
                            <button class="btn btn-success submit-btn">조회 하기</button>
                        </div>
                   </div>
                </section>               
                <!--예약문의-->
                <section class="col-3 content3 d-flex justify-content-center align-items-center">
                    <div class="text-white">
                        <div class="reserve-text1">예약문의:</div>
                        <div class="reserve-text2">
                            010-<br>
                            0000-1111
                        </div>
                    </div>                    
                </section>
            </section>
        </section>
        
        <!--footer-->
        <jsp:include page="footer.jsp"/>
    </div>

    <script type="text/javascript">
        $(document).ready(function(){

            // 1)회원/비회원 상자 토글
            $("input[name=memberType]").on('change',function(){                
                /******내방법
                let mOn = $("input[name=memberType]:checked").val();
                console.log(mOn);
                *********/

                /*this로 풀이*/
                let mOn = $(this).val(); //change가 된 단 하나의 값

                //회원선택시
                if(mOn == 'member'){
                    $('#nonMemberBox').addClass('d-none');
                    $('#memberBox').removeClass('d-none');
                }
                //비회원선택시
                if(mOn == 'nonMember'){
                    $('#memberBox').addClass('d-none');
                    $('#nonMemberBox').removeClass('d-none');                }
                
            });

            // 2) 날짜영역 데이트피커
            $('#reserveDate').datepicker({
                dateFormat:"yy년 mm월 dd일"
                , minDate : 0
            });
            

            // 3) 조회하기 버튼
            $('.submit-btn').on('click', function(){
                console.log('조회하기'); 
                
                let mOn = $('input[name=memberType]:checked').val();

                // (1)유효성검사
                let id = $('#id').val().trim();
                let pw = $('#pw').val();
                let name = $('#name').val().trim();
                let phone = $('#phone').val().trim();

                
                if(mOn == 'member'){//회원
                    if(id == ""){
                        alert("아이디를 입력해주세요.")
                        return;
                    }
                    if(pw == ""){
                        alert("비밀번호를 입력해주세요.")
                        return;
                    }
                }else{//비회원
                    if(name == ""){
                        alert("이름을 입력해주세요.")
                        return;
                    }
                    if(phone.length < 1){
                        alert("전화번호를 입력해주세요.")
                        return;
                    }
                    //전화번호 010 시작 확인
                    //console.log($('#phone').val().trim().startWith('010'));
                    if(phone.substring(0,3) != '010'){ //! == false
                        alert("010으로 시작하는 번호만 입력 가능합니다.")
                        return;
                    }
                    
                    $.ajax({
                    	type:"post"
                    	,url:"/booking/main/CheckReservation"
                    	,data:{"name":name,"phoneNumber":phone}
                    	,success:function(data){
                    		if(data.result == 1){
                    			console.log('조회성공');
                    			console.log(data.checkResult);
                    			alert(
                    				'이름 : '+data.checkResult.name+"\n"+
                    				'날짜 : '+moment(data.checkResult.date).format("YYYY-MM-DD")+"\n"+
                   					'일수 : '+data.checkResult.day+"\n"+
                   					'인원 : '+data.checkResult.headcount+"\n"+
                   					'상태 : '+data.checkResult.state
                    			);
                    		}else if(data.result == 500){
                    			console.log('조회실패');
                    			console.log('일치정보없음');
                    		}
                    	},error:function(e){
                    		console.log("ajax에러");
                    	}
                    });
                    
                    
                }

                console.log("조회 성공")
                
            });
            
            // 3)이미지 3초 간격으로 변경
            let bannerArr = ['/img/booking/banner1.jpg'
                ,'/img/booking/banner2.jpg'
                ,'/img/booking/banner3.jpg'
                ,'/img/booking/banner4.jpg'
            ];
            let currentIndex = 0;

            setInterval(function(){
                $('#bannerImage').attr('src',bannerArr[currentIndex++])
                //console.log(currentIndex);
                
                if(currentIndex >= bannerArr.length){ //bannerArr.length(4) 이상이면 초기화
                    currentIndex = 0;
                } 
            },1500); //setInterval(함수,시간) 3000 = 3초
			
            
        });
    </script>

</body>
</html>