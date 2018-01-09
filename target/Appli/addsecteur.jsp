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
Veuillez compléter les champs pour ajouter un nouveau secteur.
</p>

<p>
	<form method = "post" action = "addSecteur">
	
		<p>
		<label for="nom"> Nom du secteur : </label>
		<input type="text" id="nom" name="nom" required/>
		</p>
		
		<p>
		<label for="site"> Site sur lequel se trouve le secteur : </label>
		
            <select name="site" id="site">
            <c:forEach var="site" items="${ sites }">
       		<option value="<c:out value="${ site.nom }" />"><c:out value="${ site.nom }" /></option>       		   
           	</c:forEach>      	
       	</select>
        
		</p>
			
		<p>
		<label for="rocher"> Rocher du secteur : </label>
		<input type="text" id="rocher" name="rocher"/>
		</p>
			
		<input type="submit" value ="Ajouter"/>
	</form>
</p>
<c:out value ="${message }"/>
</section>


</body>
</html>