<%@page import="java.util.List"%>
<%@page import="br.com.gerenciador.model.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada?acao=RemoverEmpresa"
	var="linkServletRemoveEmpresa" />
<c:url value="/entrada?acao=EditarEmpresaForm"
	var="linkServletEditarEmpresa" />
<c:url value="/entrada?acao=NovaEmpresaForm"
	var="linkServletNovaEmpresaForm" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standart Taglib</title>
</head>
<body>

	Usuario Logado ${usuarioLogado.login}

	<br>
	<br>
	<c:import url="logout-parcial.jsp" />



	<a href="${linkServletNovaEmpresaForm }">Nova Empresa</a>
	<ul>
		<c:forEach items="${listaDeEmpresas}" var="empresa">
			<li>${ empresa.nome }-<fmt:formatDate value="${empresa.date }"
					pattern="dd/MM/yyyy" /> <a
				href="${linkServletEditarEmpresa}&id=${empresa.id}">editar</a> <a
				href="${linkServletRemoveEmpresa}&id=${empresa.id}">remover</a>
			</li>
		</c:forEach>
	</ul>



</body>
</html>