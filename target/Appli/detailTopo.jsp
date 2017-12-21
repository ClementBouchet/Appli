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
<p>
Page du topo 
</p>

<p>
Nom du Topo : <c:out value = "${topo.nom }"/>
</p>

<p>
Auteur du Topo : <c:out value = "${topo.auteur }"/>
</p>

<p>
Site du Topo : <c:out value = "${topo.site }"/>
</p>

<p>
Description : <c:out value = "${topo.description }"/>
</p>
</section>
</body>
</html>