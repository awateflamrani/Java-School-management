<%--
  Created by IntelliJ IDEA.
  User: ola
  Date: 28/04/2023
  Time: 03:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="container">
<head>
    <style><%@include file="/CSS/formCSS.css"%></style>
        <div class="header">
        <h2>Ajouter Filiere</h2>
    </div>

</head>
<body>
<form id="form" class="form" action="FiliereServlet?action=addfil" method="post" >
    <div class="form-control">
    </div>
    <div class="form-control">

        <input type="text" name="idFil" value="" placeholder="ID de Filiere">
    </div>
        <div class="form-control">

            <input  type="text" name="nomFil" value="" placeholder="Nom de Filiere">
      </div>

    <br><br>
    <input class="form-input" type="submit" name="add" value="Ajouter"><br><br>
    <button><a href="FiliereServlet?action=show">Annuler</a></button>

</form>

</body>
</div>
</html>
