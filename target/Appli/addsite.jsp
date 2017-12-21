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
Veuillez compléter les champs pour ajouter un nouveau site.
</p>

<p>
	<form method = "post" action = "addSite">
	
		<p>
		<label for="nom"> Nom du site : </label>
		<input type="text" id="nom" name="nom" required/>
		</p>
		
		<p>
		<label for="lieu"> Lieu ou se trouve le site: </label>
		<input type="text" id="lieu" name="lieu"/>
		</p>
		
		<p>
		<label for="description"> Description du site: </label>
		</br>
		<textarea id="description" name="description" rows="10" cols="50"/></textarea>
		</p>
			
		<input type="submit" value = "Ajouter le site"/>
	</form>
</p>

<p>
<ul>
        <c:forEach var="site" items="${ sites }">
            <li><c:out value="${ site.nom }" />  qui se trouve dans les <c:out value="${ site.lieu }" />
            </br>
            
            <a href = "detailSite?site=<c:out value = "${site.num}"/>">Check </a>
            <p>         </p>
            <p>
            <a href = "delete?site=<c:out value = "${site.num}"/>">Supprimer ce site </a>
            </p>
            
            </li>
        </c:forEach>
    </ul>
</p>
<section>
</body>
</html>