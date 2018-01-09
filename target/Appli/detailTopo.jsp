<!DOCTYPE html>
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
	<div class = "elementlien"><c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "espace_user">Profil</a></c:if></div>
</div>
</header>
<section>
<p>
Page du topo   <c:out value = "${topo.num }"/>
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
<p>
<c:if test ="${sessionScope.utilisateur.identifiant == null }">
Pour demander un prêt, veuillez vous <a href = "connexion">connecter</a>
</c:if>
<c:if test ="${sessionScope.utilisateur.identifiant != null }">
Demander un prêt : <form method = "post" action = "detailTopo">
						<input type="hidden" value = "<c:out value ="${topo.num }" />" id="id" name="id"/>
						<input type="submit" value = "Emprunter" id = "button"/>
					</form>
</c:if>
</p>
<c:if test="${confirmation == 'yes' }">Demande d'emprunt envoyée!</c:if>
</section>
</body>
</html>