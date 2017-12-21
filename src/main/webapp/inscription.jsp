<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Inscription</title>
<link rel="stylesheet" href="style2.css" />
</head>
<body>
<header>
<div id = "titre">
<h1>
Inscription
</h1>
</div>
</header>
<section>
<p>
<a href ="accueil">Accueil</a>
</p>
<p>
<strong>Inscrivez-vous</strong>
</p>

<p>
	<form method = "post" action = "inscription">
	
		<p>
		<label for="identifiant"> Identifiant : </label>
		<input type="text" id="identifiant" name="identifiant" required/>
		</p>
			
		<p>
		<label for="password"> Mot de passe : </label>
		<input type="password" id="password" name="password" required/>
		</p>
		
		<p>
		<label for="password2"> Confirmez votre Mot de passe : </label>
		<input type="password" id="password2" name="password2" required/>
		</p>
		
		<c:if test="${utilisateur.erreur != null }"><c:out value="${utilisateur.erreur }"/></br></c:if>
				
		<input type="submit" value="Inscription"/>
	</form>
</p>


</section>
</body>
</html>