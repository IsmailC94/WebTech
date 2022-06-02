<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Erfolgreiches Suchen von Produkten</title>
		<base href="${pageContext.request.requestURI}" />
		<style>
			table, th, td {
				border: 1px solid; 
				border-collapse: collapse;
				padding: 5px;
				text-align: center;
			}
		</style>
		<script>
		  document.addEventListener("DOMContentLoaded", init);
		  
		  function init() {
			  var links = document.getElementsByTagName("a");
			  for (var i=0; i<links.length; i++) {
				  links[i].addEventListener("click", click);
			  }
		  }
		  
		  function click(evt) {
			  var doDelete = confirm("Eintrag wirklich löschen?");
			  if (!doDelete) {
				  evt.preventDefault();
			  }
		  }
		</script>
	</head>
	<body>
		<h2>Erfolgreiches Suchen von Produkten</h2>
		<h3>Gelesene Daten</h3>
		<table>
			<tr>
				<th>Id</th>
				<th>Produktname</th>
				<th>Menge</th>
				<th>Produktionsdatum</th>
				<th>Produktionszeit</th>
				<th>Aktion</th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td>${product.productname}</td>
					<td>${product.quantity}</td>
					<td>${product.proddate}</td>
					<td>${product.prodtime}</td>
					<td><a href="../deleteservlet?id=${product.id}">Löschen</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>