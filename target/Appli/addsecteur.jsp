<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>Accueil</title>
<link rel="stylesheet" href="style2.css" />
</head>
<body>
<header>
<div id = "titre">
	<div class = "elementlien"><a href = "accueil">Accueil</a></div>
	<div class = "element"><h1>Site</h1></div>
	<div class = "elementlien"><c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "espaceUser">Profil</a></c:if></div>
</div>
</header>
<section>
<p>
Veuillez compléter les champs pour ajouter un nouveau secteur.
</p>

<p>
	<form method = "post" action = "addSecteur">
	
		<p>
		<label for="nom"> Nom du secteur : </label>
		<input type="text" id="nom" name="nom" required/>
		</p>
		
		<p>
		<label for="site"> Site sur lequel se trouve le secteur : </label>
		
            <select name="site" id="site">
            <c:forEach var="site" items="${ sites }">
       		<option value="<c:out value="${ site.nom }" />"><c:out value="${ site.nom }" /></option>       		   
           	</c:forEach>      	
       	</select>
        
		</p>
			
		<p>
		<label for="rocher"> Rocher du secteur : </label>
		<input type="text" id="rocher" name="rocher"/>
		</p>
			
		<input type="submit" value ="Ajouter"/>
	</form>
</p>
<section>
<p>
<ul>
        <c:forEach var="secteur" items="${ secteurs }">
            <li><c:out value="${ secteur.nom }" />  qui se trouve dans le site :  <c:out value="${ secteur.site }" />
                 </br>
            
            <a href = "detailSecteur?secteur=<c:out value = "${secteur.num}"/>">Check </a>
			<p>
            <a href = "delete?secteur=<c:out value = "${secteur.num}"/>">Supprimer ce secteur </a>
            </p>      
            </li>
        </c:forEach>
    </ul>
</p>

</body>
</html>