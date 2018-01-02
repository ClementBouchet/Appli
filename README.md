# Appli
Projet  site communautaire escalade

Tout d’abord, vérifier que jdk 1.8 est bien installé. Si ce n’est pas le cas, il faut l’installer.

Il faut ensuite installer le serveur d’application Tomcat, peu importe la version.

Une fois que cela est fait téléchargez le projet sur le lien fourni :
https://github.com/ClementBouchet/Appli

Ensuite, importez le projet sur votre EDI eclipse ou inteliJ.
(vérifiez que l’encoding est bien en UTF-8)

Deux options sont maintenant possibles :
1)	Configurer le projet pour faire en sorte qu’il fonctionne avec la bonne version de tomcat(ex :dans Eclipse, clic droit sur le projet propertiestargeted runtimechoisissez la bonne version de tomcat et le dossier où il est installé)
2)	Déclarer le plugin Tomcat dans la section build -> PluginManagement du pom :
	<plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>2.0</version>
     </plugin>

Dans la classe DaoFactory du package com.appli.dao, adaptez les paramètres nécessaires dans la fonction getInstance() pour la connexion à la base de données.

Ensuite suivez le script SQL de création de base de données :

-	Connexion au serveur postgreSQL :
psql   -h  localhost  -u  postgres   -p

-	Création de la base de données :
CREATE DATABASE   escaladedb ;

-	Création des tables :
CREATE TABLE Utilisateur(
id		SERIAL 		PRIMARY KEY,
identifiant 	VARCHAR(20) 	NOT NULL,
password 	VARCHAR(20) 	NOT NULL
) ;

CREATE TABLE Site(
id		SERIAL 		PRIMARY KEY,
nom		VARCHAR(200)	NOT NULL,
lieu		VARCHAR(200) NOT NULL,
description	TEXT
) ;

CREATE TABLE Secteur(
id		SERIAL 		 PRIMARY KEY,
nom		VARCHAR(200)	NOT NULL,
rocher		VARCHAR(200)	NOT NULL,
site_id		SMALLINT(5)	UNSIGNED	FOREIGN KEY,
site		VARCHAR(200)
) ;

CREATE TABLE commentaire(
id		SERIAL 		PRIMARY KEY,
auteur 		VACHAR(40)	NOT NULL,
description	TEXT,
type_objet	VARCHAR(30)	NOT NULL,
nom_objet	VARCHAR(30)	NOT NULL,
id_objet	SMALLINT(5) 	UNSIGNED	NOT NULL
) ;

CREATE TABLE demande(
id		SERIAL 		PRIMARY KEY,
auteur		VARCHAR(30)	NOT NULL,
destinatire	VARCAHR(30)	NOT NULL ,
topo		VARCHAR(30),
reponse	VARCHAR(30)
) ;

CREATE TABLE topo(
id		SERIAL 		 PRIMARY KEY,
nom		VARCHAR(30)	 NOT NULL,
auteur		VARCHAR(30)	NOT NULL,
description	TEXT,
prêt		VARCHAR(30),
emprunteur	VARCHAR(30),
site		VARCHAR(30)
) ;

CREATE TABLE voie(
id		SERIAL		PRIMARY KEY,
nom		VARCHAR(30)	NOT NULL ,
cotation	VARCHAR(30),
longueur	DECIMAL,
secteur		VARCHAR(30),
secteur_id	SMALLINT(5)	UNSIGNED	NOT NULL	FOREIGN KEY
) ;
