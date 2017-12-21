<!DOCTYPE html>
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
	<div class = "elementlien"><c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "espace_user">Profil</a></c:if></div>
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
<c:out value ="${message }"/>

</section>
</body>
</html>