<%@ page import="ensat.dca.model.Filiere" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ola
  Date: 27/04/2023
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<center>
<div class="container">
<head>

    <style><%@include file="/CSS/formCSS.css"%></style>
    <div class="header"><h2>Liste Filieres</h2></div>

</head>
<body>
<table class="content-table">
    <tr>
        <th>ID Filiere</th>
        <th>Nom Filiere</th>
        <th colspan="2"><a href="FiliereServlet?action=Ajouterfil"><img src="Icons/add.png"></a> </th>
    </tr>
    <% List<Filiere> lstfil=new ArrayList<>();
        lstfil=(List<Filiere>) request.getAttribute("filieres");
        for(Filiere fil:lstfil)
        {
    %>
    <tr>
        <td><%=fil.getIdFil()%></td>
        <td><%=fil.getNomFil()%></td>
        <td><a href="FiliereServlet?action=editfil&id=<%=fil.getIdFil()%>"><img src="Icons/modifier.png"></a></td>
        <td><a href="FiliereServlet?action=deletefil&id=<%=fil.getIdFil()%>"><img src="Icons/supprimer.png"></a></td>
    </tr>
    <% } %>
</table>
<button onclick="window.location.href='EtudiantServlet?action=affichage';" > << Retour</button>
</body>
</div>
    </center>
</html>
