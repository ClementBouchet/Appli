<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Accueil</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
<header>
<div id = "titre">
	<div class ="elementtitre"><c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "espace_user" class = "lien">Profil</a></c:if></div>
	<div class ="elementtitre"><h1>Accueil</h1></div>
	<div class ="elementtitre"><c:if test ="${sessionScope.utilisateur.identifiant == null }"><a href = "connexion" class = "lien">Connexion</a></c:if>
		<c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "deconnexion" class = "lien">Deconnexion</a></c:if></div>
</div>
<script value ="text/javascript">
document.querySelector("h1").textContent += " du site"
</script>
</header>
<!--  <p><c:out value = "${message }"/></p>-->
<div id = "main">
<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }">Bienvenue, <strong><c:out value = "${sessionScope.utilisateur.identifiant }"/></strong></c:if>
</p>




<p>
Bonjour et bienvenue sur le site communautaire des grimpeurs!</br>

Consultez et partagez toutes les infos sur les meilleurs spots!
</p>


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
       	
       	<p>
       	<label for="critere2">Rechercher uniquement :  </label>
       	<select name="critere2" id="critere2">
       		<option value=tout>Tout</option>
       		<option value=site>Site</option>
           	<option value=secteur>Secteur</option> 
           	<option value=voie>Voie</option>
           	<option value=topo>Topo</option>        	
       	</select>
       	</p>
       	<input type="submit" value = "Rechercher"/>
	</form>
<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "deconnexion" class = "lien">Deconnexion</a></c:if>
</p>
</div>
<div id ="add">
	<div class ="elmt" ><a href = "addsite" id = "addsite">Ajouter un site</a></div>
	<div class ="elmt" ><a href = "addSecteur" id = "addsecteur">Ajouter un secteur</a></div>
	<div class ="elmt" ><a href = "addVoie" id = "addvoie">Ajouter une voie</a></div>
	<div class ="elmt" ><a href = "addTopo" id = "addtopo">Ajouter un topo</a></div>
</div>





</body>
</html>