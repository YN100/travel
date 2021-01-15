<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<body>
<h1 align="center">新規登録</h1>
	<hr />
	<form action=<%= request.getContextPath() + "/AccountRegistaration" %> method="post">
		<table>
			<tr>
				<th align="right">ユーザID:</th>
				<td><input type="text" name="loginId" size="20" maxlength="30" />
				</td>
			</tr>
			<tr>
				<th align="right">パスワード:</th>
				<td><input type="password" name="password" size="20"
					maxlength="30" /></td>
			</tr>
			<tr>
				<th align="right">名前:</th>
				<td><input type="text" name="userName" size="20"
					maxlength="30" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="submit" value="登録"></td>
			</tr>
			</table>
			</form>
</body>
</html>