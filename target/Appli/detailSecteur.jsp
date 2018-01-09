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
<h2>
Page du secteur
</h2>
<p>
<c:out value="${secteur.nom}"/> se situe dans le site <c:out value = "${secteur.site }"/>
</br>L'identifiant de ce secteur est le num�ro <c:out value="${iden}"/>
</p>
<p>Rocher : </br>
<c:out value="${secteur.rocher }"/>
</p>
<p>
Ce secteur contient les voies:  
<ul>
        <c:forEach var="voie" items="${ voies }">
            <li><c:out value="${ voie.nom }" /> </br>
            
            <a href = "detailVoie?voie=<c:out value = "${voie.num}"/>">Check </a>       
            </li>
        </c:forEach>
    </ul>

</p>
<h2>Commentaires</h2>

<p>
Ajouter un commentaire : 
</p>

<p>

	<form method = "post" action = "addCom">
		
		<p>
		<label for="description"> </label>
		</br>
		<textarea id="description" name="description" rows="6" cols="50"/></textarea>
		</p>
		
		<p>
		<label for="type_objet"></label>
		<input type="hidden" value = "secteur" id="type_objet" name="type_objet"/>
		</p>
		
		<p>
		<label for="nom_objet"></label>
		<input type="hidden" value = "<c:out value = "${secteur.nom }"/>" id="nom_objet" name="nom_objet"/>
		</p>
		
		<p>
		<label for="id_objet"></label>
		<input type="hidden" value = "<c:out value = "${iden }"/>" id="id_objet" name="id_objet"/>
		</p>
			
		<input type="submit" value = "Ajouter le commentaire"/>
	</form>
	
</p>

<p>
<ul>
	<c:forEach var="com" items="${coms }">
	<li>Post� par : <i><c:out value = "${com.auteur }"/></i></br>
	"<c:out value = "${com.description }"/>"</li>
	</c:forEach>
</ul>
</p>
</section>
<p>
<a href = "modif?secteur=<c:out value = "${secteur.num}"/>">Modifier </a>
</p>
<p><a href="addSecteur">Ajouter un secteur</a></p>
</body>
</html>