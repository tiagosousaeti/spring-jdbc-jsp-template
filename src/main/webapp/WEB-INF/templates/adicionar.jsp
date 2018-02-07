<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<div class="col-sm-4">
				<form:form action="salvar" method="post" modelAttribute="product">        
	            	<form:hidden path="id" />
	            	
	            	<div class="form-group">
						<label>Nome</label>
						<form:input class="form-control" path="nome" placeholder="Nome" />
					</div>
					
					<button type="submit" class="btn btn-primary">Enviar</button>
	        	</form:form>
        	</div>
		</div>
		<script src="<c:url value="/resources/static/js/jquery-3.2.1.slim.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/static/js/popper.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/static/js/bootstrap.min.js" />" type="text/javascript"></script>
	</body>
</html>