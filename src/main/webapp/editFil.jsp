<%@ page import="ensat.dca.model.Filiere" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ola
  Date: 28/04/2023
  Time: 01:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="container">
<head>
    <style><%@include file="/CSS/formCSS.css"%></style>
    <div class="header">
        <h2>Editer Filiere</h2>
    </div>

</head>
<body>
<% Filiere fil= (Filiere) request.getAttribute("ID"); %>

<form id="form" class="form" action="FiliereServlet?action=updatefil" method="post">
    <div class="form-control">

        <input type="text" name="idFil" value="<%=fil.getIdFil()%>" readonly><br>
    </div>
    <br>
    <div class="form-control">

        <input  type="text" name="nomFil" value="<%=fil.getNomFil()%>" placeholder="Nom Filiere"><br>
    </div>
    <br><br>
    <input class="form-input" type="submit" name="updatefil" value="Modifier"><br><br>
    <button><a href="FiliereServlet?action=show">Annuler</a></button>

</form>
</body>
</div>
</html>
