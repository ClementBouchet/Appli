<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>Détail du site</title>
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
<h2>
Page du site 
</h2>
<p>
<c:out value="${site.nom}"/> se situe dans les <c:out value = "${site.lieu }"/>
</br>L'identifiant de ce site est le numéro <c:out value="${iden}"/>
</p>
<p>Description : </br>
<c:out value="${site.description }"/>
</p>

<p>
Ce site contient les secteurs:  
<ul>
        <c:forEach var="secteur" items="${ secteurs }">
            <li><c:out value="${ secteur.nom }" /> </br>
            
            <a href = "detailSecteur?secteur=<c:out value = "${secteur.num}"/>">Check </a>       
            </li>
        </c:forEach>
    </ul>

</p>

<h2>Commentaires</h2>

<p>
Ajouter un commentaire : 
</p>

<p>

	<form method = "post" action = "addCom">
		
		<p>
		<label for="description"> </label>
		</br>
		<textarea id="description" name="description" rows="6" cols="50"/></textarea>
		</p>
		
		<p>
		<label for="type_objet"></label>
		<input type="hidden" value = "site" id="type_objet" name="type_objet"/>
		</p>
		
		<p>
		<label for="nom_objet"></label>
		<input type="hidden" value = "<c:out value = "${site.nom }"/>" id="nom_objet" name="nom_objet"/>
		</p>
		
		<p>
		<label for="id_objet"></label>
		<input type="hidden" value = "<c:out value = "${iden }"/>" id="id_objet" name="id_objet"/>
		</p>
			
		<input type="submit" value = "Ajouter le commentaire"/>
	</form>
	
</p>

<p>
<ul>
	<c:forEach var="com" items="${coms }">
	<li>Posté par : <i><c:out value = "${com.auteur }"/></i></br>
	"<c:out value = "${com.description }"/>"</li>
	</c:forEach>
</ul>
</p>
</section>
<p>
<a href = "modifSite?site=<c:out value = "${site.num}"/>">Modifier </a>
</p>
<p><a href="addSite">Retour ajout Sites</a></p>
</body>
</html>