<%@ page import="java.util.ArrayList" %>
<%@ page import="ensat.dca.model.Etudiant" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ola
  Date: 09/04/2023
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<center>
    <div class="container">
<head>
    <style><%@include file="/CSS/formCSS.css"%></style>
    <div class="header">
        <h2>Liste Etudiants</h2></div>


</head>
<body>
<table class="content-table">
    <tr>
        <th>ID Etudiant</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Sexe</th>
        <th>Filiere</th>
        <th colspan="2"><a href="FiliereServlet?action=ajouter"><img src="Icons/add.png"></a> </th>
    </tr>
    <% List<Etudiant> lstetu=new ArrayList<>();
        lstetu=(List<Etudiant>) request.getAttribute("etudiants");
        for(Etudiant etu:lstetu)
        {
    %>
    <tr>
        <td><%=etu.getIdEtu()%></td>
        <td><%=etu.getNom()%></td>
        <td><%=etu.getPrenom()%></td>
        <td><%=etu.getSexe()%></td>
        <td><%=etu.getFiliere()%></td>
        <td><a href="FiliereServlet?action=edit&id=<%=etu.getIdEtu()%>"><img src="Icons/modifier.png"></a></td>
        <td><a href="EtudiantServlet?action=delete&id=<%=etu.getIdEtu()%>"><img src="Icons/supprimer.png"></a></td>
    </tr>
    <% } %>
</table>
<button onclick="window.location.href='FiliereServlet?action=show';" > Gestion Filieres>></button>
</body>
    </div>
</center>
</html>
