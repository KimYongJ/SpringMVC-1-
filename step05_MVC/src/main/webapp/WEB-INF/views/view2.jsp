<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<h2>view2 = getData1 일 때 </h2>
		1. url로 전달된 id와 name 값 : ${requestScope.id}<br/>
		<br><hr><br><hr>
		<h2>view2 = getData2 일 때 </h2>
		<br><hr>
		1. 요청 객체에 저장된 새로운 데이터 출력 : ${requestScope.msg}<br/>
		2. requestScope.name의 값  : ${requestScope.name}<br/>
		3.requestScope.customer.getName() - requestScope.customer.getAge()의 값 : ${requestScope.customer.getName()} - ${requestScope.customer.getAge()}<br/>
		<h2>view2 = getData3 일 때 </h2>
		1. ModelAttribute 사용 출력 : ${requestScope.customer.getAge()}<br/>
		2. ModelAttribute 사용 출력 : ${requestScope.customer.getName()}<br/>
		
		
	</body>
</html>