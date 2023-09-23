<%@ page import="ensat.dca.model.Filiere" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ensat.dca.model.Etudiant" %><%--
  Created by IntelliJ IDEA.
  User: ola
  Date: 18/04/2023
  Time: 02:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<center>
<div class="container">
<head>
    <div class="header">
    <style><%@include file="/CSS/formCSS.css"%></style>
    <h2>Editer Etudiant</h2>
    </div>
</head>
<body>
<% List<Filiere> lstFil=(List<Filiere>) request.getAttribute("filieres");
    Etudiant etu= (Etudiant) request.getAttribute("ID");
    String selectF="";
    String selectM="";

    if (etu.getSexe().equals("F")){selectF="checked";} else if (etu.getSexe().equals("M")) {selectM="checked";}

%>

<form id="form" class="form" action="EtudiantServlet?action=update" method="post">
    <div class="form-control">
        <label>Id Etudiant:</label>
        <input type="text" name="idEtu" value="<%=etu.getIdEtu()%>" readonly><br>
    </div>
    <div class="form-control">
        <label>Nom:</label>
        <input  type="text" name="nom" value="<%=etu.getNom()%>" placeholder="Nom Etudiant"><br>
    </div>
    <br>
    <div class="form-control">
        <label>Prenom:</label>
        <input   type="text" name="prenom" value="<%=etu.getPrenom()%>" placeholder="Prenom Etudiant"><br>
    </div>
     <br>
    <div>
        <label>Sexe:</label>
        <input type="radio" name="Sexe" value="F"<%=selectF%>>F   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="Sexe" value="M" <%=selectM%>>M <br>
    </div>
     <br>
    <div class="form-control">
        <label>Filiere:</label>
        <select name="filiere" id="filiere">
            <% for(Filiere fil:lstFil) {
                String filCH = null;
                if (fil.getNomFil().equals(etu.getFiliere())) {
                    filCH = "selected";
                }
            %>
            <option value="<%=fil.getNomFil()%>" <%=filCH%>><%=fil.getNomFil()%></option><% } %>
        </select>
    </div>
    <br><br>
    <input class="form-input" type="submit" name="update" value="Modifier"><br><br>
    <button onclick="window.location.href='EtudiantServlet?action=affichage';" >Annuler</button>

</form>
</body>
    </div>
</center>
</html>
