<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>D�tail du site</title>
<link rel="stylesheet" href="style2.css"/>
</head>
<body>
<header>
<div id = "titre">
	<div class = "elementlien"><a href = "accueil">Accueil</a></div>
	<div class = "element"><h1>Profil</h1></div>
	<div class = "elementlien"><a href = "modif">Modifier le profil</a></div>
</div>
</header>
<section>
<h2>
Nom  : <c:out value = "${utilisateur.identifiant }"/>
</h2>

<p>
<h2>
Topos post� :
</h2>
<ul>
	<c:forEach var = "topo" items = "${topos }"> 
		<li>
		<c:out value = "${topo.nom }"/>  <a href = "detailTopo?topo=<c:out value = "${topo.num }"/>">Check</a>     
		
		<form method = "post" action = "espace_user">
            <label for="dispo">Topo en cours de pr�t:   <c:out value="${topo.pret }"/></label>
       		<select name="dispo" id="dispo">
       			<option value="oui">oui</option>
           		<option value="non">non</option>         	
       		</select>  
       		<input type="hidden" value = "<c:out value ="${topo.num }" />" id="idtopo" name="idtopo"/>
       		<input type="submit" value = "Actualiser"/>
       		</form>
		</li>		
	</c:forEach>
</ul> 
</p>
<h2>
Demandes de pr�t envoy�es :
</h2>
		<c:forEach var="demande" items="${ demandesEx }">
            <li>Demande envoy�e � <c:out value="${ demande.destinataire }" />  pour le topo : <c:out value="${ demande.topo }" />
            </br>
            R�ponse : <c:out value = "${demande.reponse }"/>           
            </li>
        </c:forEach>
<h2>
Demandes d'emprunt re�ues :
</h2>
		<c:forEach var="demande" items="${ demandesInt }">
            <li>Demande de la part de <c:out value="${ demande.auteur }" />  pour le topo : <c:out value="${ demande.topo }" />
            </br>
            <form method = "post" action = "espace_user">
            <label for="reponse">R�pondre � la demande :  </label>
       		<select name="reponse" id="reponse">
       			<option value="oui">oui</option>
           		<option value="non">non</option>         	
       		</select>
       		<input type="hidden" value = "<c:out value ="${demande.id }" />" id="iddemande" name="iddemande"/>
       		<input type="hidden" value = "<c:out value ="${demande.topo }" />" id="top" name="top"/>
       		<input type="submit" value = "Envoyer la r�ponse"/></br>
       		<c:if test="${demande.reponse == 'oui'}">R�ponse envoy�e : oui</c:if>
       		<c:if test="${demande.reponse == 'non'}">R�ponse envoy�e : non</c:if>  
       		</form>       
            </li>
        </c:forEach>
</section>
</body>
</html>