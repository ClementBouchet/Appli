<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Connexion</title>
<link rel="stylesheet" href="style2.css" />
</head>
<body>
<header>
<div id = "titre">
<h1>
Connexion
</h1>
</div>
</header>
<section>
<p>
<a href ="accueil">Accueil</a>
</p>
<p>
<strong>Se Connecter</strong>
</p>

<p>
	<form method = "post" action = "connexion">
	
		<p>
		<label for="identifiant"> Identifiant : </label>
		<input type="text" id="identifiant" name="identifiant" required/>   <c:if test ="${validation.ident == 'notok' }">Cet identifiant n'existe pas</c:if>
		</p>
			
		<p>
		<label for="password"> Mot de passe : </label>
		<input type="password" id="password" name="password" required/>
		</p>
			
		<input type="submit" value="Connexion"/>
	</form>
</p>
<p>
<c:if test ="${validation.pass == 'ok'}">Vous vous �tes bien connect�</br>
Bienvenue sur le site, <strong><c:out value = "${sessionScope.utilisateur.identifiant }"/></strong>
</c:if>
<c:if test ="${validation.pass == 'notok' }">Mot de passe incorrect</c:if>
</p>

<p>
<c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "deconnexion">Deconnexion</a></c:if>
</p>
<c:if test ="${sessionScope.utilisateur.identifiant == null }">
<p>Si vous n'�tes pas encore inscrit, c'est par ici :  <a href = "inscription" >Inscription</a></p>
</c:if>
</section>
</body>
</html>