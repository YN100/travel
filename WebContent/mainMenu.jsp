<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar, java.text.SimpleDateFormat" %>
 <jsp:useBean id="account" scope="session" type="beans.AccountBeans"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約画面</title>
</head>
<body>
<h2>日付・人数・部屋・食事を選んで下さい</h2>
<h3>人数は4人まで</h3>
<%
	Calendar startC = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	String startDate = sdf.format(startC.getTime());
	request.setAttribute("startDate", startDate);

	Calendar goalC = Calendar.getInstance();
	goalC.add(Calendar.DAY_OF_MONTH, 1);
	String goalDate = sdf.format(goalC.getTime());
	request.setAttribute("goalDate", goalDate);
%>
<form action=<%= request.getContextPath() + "/TravelControl" %> method="post">
到着日:<input type= "text" pattern="[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$"name="startDay"  value="${startDate }"><br>
出発日:<input type= "text" pattern="[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$"name="goalDay"  value="${goalDate }"><br>

人数:<input type="text" pattern="[1-4]{1}"name="people" >名<br>

部屋:<select name="room" class="form-control">
		<option value="シングル">シングル
		<option value="ダブル">ダブル
		<option value="ツイン">ツイン
</select>


食事:<select name="cook" class="form-control">
	 <option value="朝食のみ">朝食のみ
		<option value="夕食のみ">夕食のみ
		<option value="両方">両方
</select>

	 <input type="submit" name="order" value="予約">

</form>
</body>
</html>