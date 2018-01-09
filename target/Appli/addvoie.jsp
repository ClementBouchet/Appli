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
Veuillez compléter les champs pour ajouter une nouvelle voie.
</p>

<p>
	<form method = "post" action = "addVoie">
	
		<p>
		<label for="nom"> Nom de la voie : </label>
		<input type="text" id="nom" name="nom" required/>
		</p>
		
		<p>
		<label for="secteur"> Secteur dans lequel se trouve la voie : </label>
		
            <select name="secteur" id="secteur">
            <c:forEach var="secteur" items="${ secteurs }">
       		<option value="<c:out value="${ secteur.nom }" />"><c:out value="${ secteur.nom }" /></option>       		   
           	</c:forEach>      	
       	</select>
        
		</p>
			
		<p>
		<label for="longueur"> Longueur de la voie (en mètre): </label>
		<input type="text" id="longueur" name="longueur"/>
		</p>
		
		<p>
       	<label for="cotation">Sélectionnez le niveau de difficulté de la voie :  </label>
       	<select name="cotation" id="cotation">
       		<option value="">--Sélection--</option>
       		<optgroup label="A">
       			<option value="3a">3a</option>
       			<option value="4a">4a</option>
           		<option value="5a">5a</option>
           		<option value="6a">6a</option>
       			<option value="7a">7a</option>
           		<option value="8a">8a</option>
           		<option value="9a">9a</option>
           		</optgroup>
           	<optgroup label="B">
           		<option value="3b">3b</option>
       			<option value="4b">4b</option>
           		<option value="5b">5b</option>
           		<option value="6b">6b</option>
       			<option value="7b">7b</option>
           		<option value="8b">8b</option>
           		<option value="9b">9b</option>
           		</optgroup>
           	<optgroup label="C">
           		<option value="3c">3c</option>
       			<option value="4c">4c</option>
           		<option value="5c">5c</option>
           		<option value="6c">6c</option>
       			<option value="7c">7c</option>
           		<option value="8c">8c</option>
           		<option value="9c">9c</option>
           	</optgroup>         	
       	</select>
       	</p>
			
		<input type="submit" value = "Ajouter"/>
	</form>
</p>
<c:out value ="${message }"/>

</section>
</body>
</html>