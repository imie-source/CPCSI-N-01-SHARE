<%@ page import="fr.imie.usercpsci.model.UserData"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="User" method="post">
		<label for="gentil">gentil</label> <input id="gentil" type="radio"
			name="faction" value="gentil" /> <label for="mechant">méchant</label><input
			id="mechant" type="radio" name="faction" value="mechant" /> <input
			type="submit">
	</form>
	<ul>
		<%
			List<UserData> users = (List<UserData>) request
					.getAttribute("filteredUsers");
			for (UserData user : users) {
		%>
		<li><%=user.getNom()%> - <%=user.getPrenom()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>