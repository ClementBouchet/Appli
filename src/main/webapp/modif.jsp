<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Modification</title>
<link rel="stylesheet" href="style2.css"/>
</head>
<body>
<header>
<div id = "titre">
	<div class = "elementlien"><a href = "accueil">Accueil</a></div>
	<div class = "element"><h1>Modification</h1></div>
	<div class = "elementlien"><c:if test ="${sessionScope.utilisateur.identifiant != null }"><a href = "espace_user">Profil</a></c:if></div>
</div>
</header>
<section>
<c:if test = "${type == 'site' }">
<p>
Veuillez compléter les champs pour modifier le site <c:out value="${site.nom }"/>
</p>

<p>
	<form method = "post" action = "detailSite">
	
		<p>
		<label for="nom"> Nom du site : </label>
		<input type="text" value = "<c:out value ="${site.nom }" />" id="nom" name="nom"/>
		</p>
		
		<p>
		<label for="lieu"> Lieu ou se trouve le site: </label>
		<input type="text" value = "<c:out value ="${site.lieu }" />" id="lieu" name="lieu"/>
		</p>
		
		<p>
		<label for="description"> Description du site: </label>
		</br>
		<textarea id="description" name="description" rows="10" cols="50"><c:out value ="${site.description }" /> </textarea>
		</p>
		<p>
		<label for="id"></label>
		<input type="hidden" value = "<c:out value ="${site.num }" />" id="id" name="id"/>
		</p>
			
		<input type="submit" value = "Modifier"/>
	</form>
</p>
</c:if>
<c:if test = "${type == 'secteur' }">
<p>
Veuillez compléter les champs pour modifier le secteur <c:out value="${secteur.nom }"/>
</p>

<p>
	<form method = "post" action = "detailSecteur">
	
		<p>
		<label for="nom"> Nom du secteur : </label>
		<input type="text" value = "<c:out value ="${secteur.nom }" />" id="nom" name="nom"/>
		</p>
		
		<p>
		<label for="site"> Site sur lequel se trouve le secteur : </label>
		
            <select name="site" id="site">
            <c:forEach var="site" items="${ sites }">
       		<option value="<c:out value="${ site.nom }" />"<c:if test ="${ site.nom == secteur.site}"> selected </c:if>><c:out value="${ site.nom }" /></option>       		   
           	</c:forEach>      	
       	</select>
        
		</p>
		
		<p>
		<label for="rocher"> Rocher du secteur: </label>
		</br>
		<input type="text" value = "<c:out value ="${secteur.rocher }" />" id="rocher" name="rocher"/>
		</p>
		<p>
		<label for="id"></label>
		<input type="hidden" value = "<c:out value ="${secteur.num }" />" id="id" name="id"/>
		</p>
			
		<input type="submit" value = "Modifier"/>
	</form>
</p>
</c:if>
<c:if test = "${type == 'voie' }">
<p>
Veuillez compléter les champs pour modifier la voie <c:out value="${voie.nom }"/>
</p>

<p>
	<form method = "post" action = "detailVoie">
	
		<p>
		<label for="nom"> Nom de la voie : </label>
		<input type="text" value = "<c:out value ="${voie.nom }" />" id="nom" name="nom"/>
		</p>
		
		<p>
		<label for="secteur"> Secteur sur lequel se trouve la voie : </label>
		
            <select name="secteur" id="secteur">
            <c:forEach var="secteur" items="${ secteurs }">
       		<option value="<c:out value="${ secteur.nom }" />"<c:if test ="${ secteur.nom == voie.secteur}"> selected </c:if>><c:out value="${ secteur.nom }" /></option>       		   
           	</c:forEach>      	
       	</select> 
		</p>
		
		<p>
       	<label for="cotation">Sélectionnez le niveau de difficulté de la voie :  </label>
       	<select name="cotation" id="cotation">
       		<option value="">--Sélection--</option>
       		<optgroup label="A">
       			<option value="3a"<c:if test ="${ voie.cotation == '3a'}"> selected </c:if>>3a</option>
       			<option value="4a"<c:if test ="${ voie.cotation == '4a'}"> selected </c:if>>4a</option>
           		<option value="5a"<c:if test ="${ voie.cotation == '5a'}"> selected </c:if>>5a</option>
           		<option value="6a"<c:if test ="${ voie.cotation == '6a'}"> selected </c:if>>6a</option>
       			<option value="7a"<c:if test ="${ voie.cotation == '7a'}"> selected </c:if>>7a</option>
           		<option value="8a"<c:if test ="${ voie.cotation == '8a'}"> selected </c:if>>8a</option>
           		<option value="9a"<c:if test ="${ voie.cotation == '9a'}"> selected </c:if>>9a</option>
           		</optgroup>
           	<optgroup label="B">
           		<option value="3b"<c:if test ="${ voie.cotation == '3b'}"> selected </c:if>>3b</option>
       			<option value="4b"<c:if test ="${ voie.cotation == '4b'}"> selected </c:if>>4b</option>
           		<option value="5b"<c:if test ="${ voie.cotation == '5b'}"> selected </c:if>>5b</option>
           		<option value="6b"<c:if test ="${ voie.cotation == '6b'}"> selected </c:if>>6b</option>
       			<option value="7b"<c:if test ="${ voie.cotation == '7b'}"> selected </c:if>>7b</option>
           		<option value="8b"<c:if test ="${ voie.cotation == '8b'}"> selected </c:if>>8b</option>
           		<option value="9b"<c:if test ="${ voie.cotation == '9b'}"> selected </c:if>>9b</option>
           		</optgroup>
           	<optgroup label="C">
           		<option value="3c"<c:if test ="${ voie.cotation == '3c'}"> selected </c:if>>3c</option>
       			<option value="4c"<c:if test ="${ voie.cotation == '4c'}"> selected </c:if>>4c</option>
           		<option value="5c"<c:if test ="${ voie.cotation == '5c'}"> selected </c:if>>5c</option>
           		<option value="6c"<c:if test ="${ voie.cotation == '6c'}"> selected </c:if>>6c</option>
       			<option value="7c"<c:if test ="${ voie.cotation == '7c'}"> selected </c:if>>7c</option>
           		<option value="8c"<c:if test ="${ voie.cotation == '8c'}"> selected </c:if>>8c</option>
           		<option value="9c"<c:if test ="${ voie.cotation == '9c'}"> selected </c:if>>9c</option>
           	</optgroup>         	
       	</select>
       	</p>
       	
       	<p>
		<label for="longueur"> Longueur de la voie : </label>
		<input type="text" value = "<c:out value ="${voie.longueur }" />" id="longueur" name="longueur"/>
		</p>
       	
		<p>
		<label for="id"></label>
		<input type="hidden" value = "<c:out value ="${voie.num }" />" id="id" name="id"/>
		</p>
			
		<input type="submit" value = "Modifier"/>
	</form>
</p>
</c:if>
</section>
</body>
</html>