<%@ page import="ensat.dca.model.Filiere" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ola
  Date: 13/04/2023
  Time: 03:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<center>
<div class="container">
<head>
    <style><%@include file="/CSS/formCSS.css"%></style>
    <div class="header">
        <h2>Ajouter Etudiant</h2>
    </div>

</head>

<body>
<center>
<% List<Filiere> lstFil=new ArrayList<>();
    lstFil=(List<Filiere>) request.getAttribute("filieres");
    String visibility;
%>
<form id="form" class="form" action="EtudiantServlet?action=add" method="post">
    <div class="form-control">
     <input type="text" name="idEtu" value="" placeholder="ID Etudiant"><br>
    </div>
    <br>
    <div class="form-control">
      <input  type="text" name="nom" value="" placeholder="Nom"><br>
    </div>
    <br>
    <div class="form-control">
        <input   type="text" name="prenom" value="" placeholder="Prenom"><br>
    </div>

        <label>Sexe:</label>
        <input type="radio" name="Sexe" value="F">F      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="Sexe" value="M">M

    <br> <br> <br> <br> <br>
     <div class="form-control">
         <label>Filiere:</label>
         <select name="filiere" id="filiere">
             <% for(Filiere fil:lstFil) {%><option value="<%=fil.getNomFil()%>"><%=fil.getNomFil()%></option><% } %>
         </select>
     </div>
    <div class="form-control">
        <input class="form-input" type="submit" name="add" value="Ajouter"><br><br>
        <button onclick="window.location.href='EtudiantServlet?action=affichage';" >Annuler</button>
    </div>



</form>
</center>
</body>
</div>
</center>
</html>
