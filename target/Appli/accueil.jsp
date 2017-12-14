<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Accueil</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
Accueil
</h1>

<script value ="text/javascript">
document.querySelector("h1").textContent += " du site"
</script>

<p><c:out value = "${message }"/></p>

<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }">Bienvenue, <strong><c:out value = "${sessionScope.utilisateur.identifiant }"/></strong></c:if>
</p>
<p>
<c:if test ="${sessionScope.utilisateur.identifiant == null }"><a href = "connexion">Connexion</a></c:if>
</p>
<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "EspaceUser">Profil</a></c:if>
</p>
<p>
Bonjour et bienvenue sur le site communautaire des grimpeurs!</br>

Consultez et partagez toutes les infos sur les meilleurs spots!
</p>

<p>
	<form method = "post" action = "affichagebdd">
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
</p>

<div id ="add">
	<div class ="elmt" ><a href = "AddSite" id = "addsite">Ajouter un site</a></div>
	<div class ="elmt" ><a href = "AddSecteur" id = "addsecteur">Ajouter un secteur</a></div>
	<div class ="elmt" ><a href = "AddVoie" id = "addvoie">Ajouter une voie</a></div>
	<div class ="elmt" ><a href = "AddTopo" id = "addtopo">Ajouter un topo</a></div>
</div>

<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "deconnexion">Deconnexion</a></c:if>
</p>

</body>
</html>