<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 본문</h2><hr>
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
				<td>${board.bTitle }</td>
			</tr>
			<tr>
				<td>본문</td>
				<td><textarea cols = "10" rows = "10" readonly>${board.bContent }</textarea></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td>${board.bName }</td>
			</tr>
			<tr>
				<td>
					<a href = "/WebReview/boardselect.abc">
						<input type = "button" value = "글 목록" />
					</a>
					<form action = "/WebReview/boardupdate.abc?bId=${board.bId }" method = "post">
						<input type = "submit" value = "글 수정" />
					</form>
					<form action = "/WebReview/boarddelete.abc" method = "post">
						<input type = "submit" value = "글 삭제" />
					</form>
				</td>
			</tr>
		</table>
</body>
</html>