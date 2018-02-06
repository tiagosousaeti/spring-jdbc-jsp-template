<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home - Spring JDBC Template</title>
	</head>
	<body>
		<div>
			<h1>Spring JDBC Template</h1>
			<hr />
			<table border="1">
				<thead>
	        		<th>Código</th>
	           		<th>Nome</th>           
	           </thead>
	           <tbody>
	           		<c:forEach var="product" items="${produtos}" varStatus="i">
		           		<tr>
		               		<td>${product.id}</td>
		               		<td>${product.nome}</td>
		           		</tr>
		       		</c:forEach>
	           </tbody>             
	       </table>
		</div>
	</body>
</html>