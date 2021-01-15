<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="account" scope="session" type="beans.AccountBeans"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文内容</title>
</head>
<body>
<h1>${account.userName}さんの予約状況</h1>
<% String room = request.getParameter("room");
   String cook = request.getParameter("cook");
%>

<table align="center" border="2">
<tr>
<td>到着日</td>
<td>出発日</td>
<td>人数</td>
<td>部屋</td>
<td>食事</td>
</tr>

<tr>
<td><%= request.getAttribute("startInputdate") %></td>
<td><%= request.getAttribute("goalInputdate") %></td>
<td><%= request.getParameter("people") %></td>
<td><%= request.getParameter("room") %></td>
<td><%= request.getParameter("cook") %></td>
</tr>
</table>
<p><a href=<%= request.getContextPath() + "/Logout" %>><button type="button" >ログアウト</button></a></p>
</body>
</html>