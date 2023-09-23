<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<center>
    <div class="container">
<head>
    <style><%@include file="/CSS/formCSS.css"%></style>
    <div class="header">
        <h2>Gestion des Etudiants ENSAT</h2></div>
</head>
<body>
<h1><%= "Bienvenue!" %>
</h1>
<br/>
<button onclick="window.location.href='EtudiantServlet?action=affichage';" > Acceder>></button>
</body>
    </div>
</center>
</html>