<!DOCTYPE html>
<html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8">
<title>Inscription</title>
</head>
<body>
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

<p>
<ul>	
	<c:forEach var = "utilisateur" items="${utilisateurs }" >
		<li>
			<c:out value="${utilisateur.identifiant }"/>
		</li>
	</c:forEach>
</ul>
</p>

</body>
</html>