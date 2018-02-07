<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/static/css/bootstrap.min.css" />" rel="stylesheet"></link>
		<title>Home - Spring JDBC Template</title>
	</head>
	<body>
		<div class="container">
			<h1>Spring JDBC Template</h1>
			<hr />
			<a href="/springjdbc/adicionar" class="btn btn-info float-right" style="margin: 10px 0px;">Adicionar</a>
			<div class="table-responsive">
				<table class="table">
					<thead>
	    				<tr>
		        			<th>Código</th>
		           			<th>Nome</th>
		           			<th></th>
		           			<th></th>
		           		</tr>           
		           </thead>
		           <tbody>
		           		<c:forEach var="product" items="${produtos}" varStatus="i">
			           		<tr>
			               		<td>${product.id}</td>
			               		<td>${product.nome}</td>
			               		<td><a href="/springjdbc/alterar?id=${product.id}">Alterar</a></td>
			               		<td><a href="/springjdbc/excluir?id=${product.id}">Excluir</a></td>
			           		</tr>
			       		</c:forEach>
		           </tbody>             
		    	</table>
			</div>
		</div>
		<script src="<c:url value="/resources/static/js/jquery-3.2.1.slim.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/static/js/popper.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/static/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>