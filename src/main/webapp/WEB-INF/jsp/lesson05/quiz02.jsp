<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Quiz02</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>HOT 5</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th>순위</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="music" items="${musics}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${music}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h1>멤버십</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>등급</th>
					<th>포인트</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${membership}" varStatus="status">
					<tr>
						<td>${member.name}</td>
						<td>${member.phoneNumber}</td>
						<c:choose>
							<c:when test="${member.grade eq 'VIP'}">
								<td><span class="text-danger">${member.grade}</span></td>
							</c:when>
							<c:when test="${member.grade eq 'GOLD'}">
								<td><span class="text-warning">${member.grade}</span></td>
							</c:when>
							<c:otherwise>
								<td>${member.grade}</td>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${member.point > 5000}">
								<td><span class="text-primary">${member.point}</span></td>
							</c:when>
							<c:otherwise>
								<td>${member.point}</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>