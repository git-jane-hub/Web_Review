<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글 작성 페이지</h2><hr>
	<form action = "/WebReview/boardwrite.abc" method = "post">
		<table border = "1">
		<thead>
			<tr>
				<th>글제목</th>
				<td>
					<input type = "text" name = "bTitle" placeholder = "글제목을 입력해주세요." required />
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>본문</th>
				<td>
					<textarea name = "bContent" cols = "50" row = "10" required></textarea>
				</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>
					<input type = "text" name = "bName" placeholder = "글작성자를 입력해주세요." required />
				</td>
			</tr>
			<tr>
				<td>
					<input type = "submit" value = "글쓰기" />
					<input type = "reset" value = "초기화" />
				</td>
			</tr>
			
		</tbody>
		</table>
	</form>
</body>
</html>