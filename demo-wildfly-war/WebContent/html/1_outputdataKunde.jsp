
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
		<br><b>Vorname: </b>${form.id}
		<br><b>Nachname: </b>${form.vorname}
		<br><b>Nachname: </b>${form.nachname}
		<br><b>Nachname: </b>${form.strasse}
		<br><b>Nachname: </b>${form.plz}
		<br><b>Nachname: </b>${form.ort}
		<br><b>Produktionsdatum: </b>${form.proddate}
		<br><b>Produktionszeit: </b>${form.prodtime} 
	</body>
</html>






































