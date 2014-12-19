<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.imie.usercpcsi.presentation.model.UserData"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./header.jspf" %>
	<form action="User" method="post">
		<label for="gentil">gentil</label> <input id="gentil" type="radio"
			name="faction" value="gentil"
			${param["faction"] eq "gentil"?"checked":""} /> <label for="mechant">méchant</label>
		<input id="mechant" type="radio" name="faction" value="mechant"
			${param["faction"] eq "mechant"?"checked":""} /> <input
			type="submit">
	</form>
	<ul>
		<c:forEach items="${filteredUsers}" var="user">
			<li><c:out value="${user.nom}" /> - <c:out
					value="${user.prenom}" /></li>
		</c:forEach>

	</ul>
</body>
</html>