<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<c:url value="/entrada?acao=EditarEmpresa" var="linkServletEditarEmpresa" />

<fmt:formatDate value="${empresa.date }" pattern="dd/MM/yyyy"
	var="dateEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />



	<form action="${linkServletEditarEmpresa }" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome }">
		Data: <input type="text" name="data" value="${dateEmpresa}"> <input
			type="hidden" name="id" value="${empresa.id }"> <input
			type="submit">

	</form>

</body>
</html>