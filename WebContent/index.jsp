<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String uname = (String) session.getAttribute("uid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホテル予約サイトログイン画面</title>
</head>
<body>
	<h1 align="center">ホテル予約(ログイン)</h1>
	<hr />
	<form action=<%= request.getContextPath() + "/Login" %> method="post">
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
				<td colspan="2" align="center"><input type="submit"
					name="submit" value="ログイン"></td>
			</tr>

			<c:if
				test="${requestScope.alert != null && requestScope.alert != '' }">
				<tr>
					<td colspan="2" class="error text-left"><c:out
							value="${requestScope.alert}" /></td>
				</tr>
			</c:if>

		</table>
	</form>
	<p>
			アカウント登録がまだの方は登録して下さい<br>
			<a href= "newAccount.jsp"><button>新規登録</button></a>
			</p>
</body>
</html>