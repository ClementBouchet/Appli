<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>Affichage Base de Données</title>
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

<div id = "search">
	<form method = "post" action = "rechercheResult">
		<label for="recherche"> Recherche : </label>
		<input type="text" id="recherche" name="recherche"/>
		<p>
       	<label for="critere1">Sélectionnez le massif montagneux de votre choix :  </label>
       	<select name="critere1" id="critere1">
       		<option value="">Partout</option>
       		<option value="pyrennees">Pyrénnées</option>
           	<option value="alpes">Alpes</option>         	
       	</select>
		</p>
		<input type="submit" value = "Rechercher"/>
	</form>
</div>
<div id = "main">
<p>Resultat de la recherche</br>
Recherche : <c:out value = "${mot}"/></br>
Critere : <c:out value = "${mot2}"/></br>

<h2>Sites trouvés :</h2></p>
<p>Page de résultat n° : <c:out value = "${pageSi}"/></p>
<ul>
        <c:forEach var="site" items="${ rechercheSi.sites }">
            <li><c:out value="${ site.nom }" />  qui se trouve dans les <c:out value="${ site.lieu }" />
            </br>
            
            <a href = "detailSite?site=<c:out value = "${site.num}"/>">Check </a>

            </li>
        </c:forEach>
</ul>

<p>
		<c:forEach var="a" items="${ rechercheSi.nbrPages }">
                       
            <a href = "rechercheResult?pageSi=<c:out value = "${a}"/>&recherche=<c:out value = "${mot}"/>&critere1=<c:out value = "${mot2}"/>">Page <c:out value="${ a }"/></a>      
            
        </c:forEach>
</p>
<h2>Secteurs correspondants :</h2>
<p>Page de résultat n° : <c:out value = "${pageSe}"/></p>
<p>
<ul>
        <c:forEach var="secteur" items="${ rechercheSe.secteurs }">
            <li><c:out value="${ secteur.nom }" />  qui se trouve dans le site <c:out value="${ secteur.site }" />
            </br>
            
            <a href = "detailSecteur?secteur=<c:out value = "${secteur.num}"/>">Check </a>

            </li>
        </c:forEach>
</ul>
</p>
<p>
		<c:forEach var="b" items="${ rechercheSe.nbrPages }">
                       
            <a href = "rechercheResult?pageSe=<c:out value = "${b}"/>&recherche=<c:out value = "${mot}"/>&critere1=<c:out value = "${mot2}"/>">Page <c:out value="${ b }"/></a>      
            
        </c:forEach>
</p>
</div>
</body>
</html>