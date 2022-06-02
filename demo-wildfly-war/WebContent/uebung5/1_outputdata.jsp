<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Bestätigung der erfolgreichen Speicherung</title>
		<base href="${pageContext.request.requestURI}" />
	</head>
	<body>
		<h2>Bestätigung der erfolgreichen Speicherung</h2>
		<h3>Ihre Formulareingaben wurden erfolgreich gespeichert</h3>
		<br><b>Produkt-ID: </b>${form.id}
		<br><b>Produktname: </b>${form.productname}
		<br><b>Menge: </b>${form.quantity}
		<br><b>Produktionsdatum: </b>${form.proddate}
		<br><b>Produktionszeit: </b>${form.prodtime}
	</body>
</html>