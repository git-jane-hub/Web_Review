<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 목록</h2><hr>
	<table border = "1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>게시일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var = "board" items = "${boardList }">
			<tr>
				<td>${board.bId }</td>
				<td><a href ="/WebReview/boarddetail.abc?bId=${board.bId }">${board.bTitle }</a></td>
				<td>${board.bName }</td>
				<td>${board.bDate }</td>
				<td>${board.bHit }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action = "/WebReview/userlogout.abc" method = "post">
		<a href = "/WebReview/reqboardwrite.abc"><input type = "button" value = "글 작성" /></a>
		<input type = "submit" value = "로그아웃" />
	</form>
</body>
</html>