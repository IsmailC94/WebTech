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
		<br><b>productId: </b>${form.productId}
		<br><b>productName: </b>${form.productName}
		<br><b>articleGroup: </b>${form.articleGroup}
		<br><b>quantity: </b>${form.quantity}
		<br><b>price: </b>${form.price}
		<br><b>proddate: </b>${form.proddate}
		<br><b>prodtime: </b>${form.prodtime}
	</body>
</html>