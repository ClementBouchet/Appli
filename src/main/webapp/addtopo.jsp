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
Veuillez compléter les champs pour ajouter un nouveau topo.
</p>

<p>
	<form method = "post" action = "addTopo">
	
		<p>
		<label for="nom"> Nom du topo : </label>
		<input type="text" id="nom" name="nom" required/>
		</p>
		
		<p>
		<label for="description"> Description du topo: </label>
		</br>
		<textarea id="description" name="description" rows="10" cols="50"/></textarea>
		</p>
		
		<p>
		<label for="site">Quel est le site dont il est question dans ce topo :  </label>
       	<select name="site" id="site">
       		<c:forEach var = "site" items = "${sites }">
       			<option value="<c:out value = "${site.nom }"/>"><c:out value = "${site.nom }"/></option>
       		</c:forEach>        	
       	</select>
		</p>
			
		<input type="submit" value = "Ajouter le topo"/>
	</form>
</p>
<c:out value ="${message }"/>
</section>
</body>
</html>