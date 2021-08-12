<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글 수정</h2><hr>
	<form action = "/WebReview/boardupdateok.abc" method = "post">
		<table border = "1">
			<tr>
				<td>글번호</td>
				<td>${board.bId }</td>
				<td>조회수</td>
				<td>${board.bHit }</td>
			</tr>
			<tr>
				<td>게시일</td>
				<td>${board.bDate }</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type = "text" name = "bTitle" value = "${board.bTitle }" /></td>
			</tr>
			<tr>
				<td>본문</td>
				<td><textarea cols = "10" rows = "10">${board.bContent }</textarea></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td>${board.bName }</td>
			</tr>
			<tr>
				<td>
					<input type = "submit" value = "수정완료" />
					<input type = "reset" value = "초기화" />
					<a href = "/WebReview/boardselect.abc">
						<input type = "button" value = "글 목록" />
					</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>