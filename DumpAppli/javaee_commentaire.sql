-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: javaee
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentaire` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `auteur` varchar(40) NOT NULL,
  `description` text,
  `type_objet` varchar(30) NOT NULL,
  `nom_objet` varchar(30) NOT NULL,
  `id_objet` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaire`
--

LOCK TABLES `commentaire` WRITE;
/*!40000 ALTER TABLE `commentaire` DISABLE KEYS */;
INSERT INTO `commentaire` VALUES (1,'test','cool','site','la marmotte',8),(2,'test2','truc','site','Le chamois',3),(3,'azer','wouah','site','Le bouquetin',11),(4,'Clement','Ce site est cool','site','Vive l\'escalade',13),(5,'Dja Sprey','Trop bien comme site!','site','La marmotte',8),(6,'Dja Sprey','Site très varié et très belle vue','site','Le chamois',3),(7,'Clement','C\'est le meilleur secteur du site','secteur','Secteur birsois',2),(8,'Dja Sprey','Beaucoup de verdure sur ce secteur, ce qui contraste bien avec le rocher blanc','secteur','Secteur birsois',2),(9,'Clement','Super secteur pour toute la famille','secteur','Secteur birsois',2),(10,'Clement','Agréablement surpris par ce secteur','secteur','Secteur birsois',2),(11,'Clement','J\'aime bien ce site','site','Le bouquetin',11),(12,'test','C\'est cool','voie','Tout droit',3),(13,'test','Vraiment trop trop cool!','voie','Tout droit',3),(14,'Clement','La meilleure des voies du secteur','voie','1ere voie',1),(15,'test','Pas mal...','voie','1ere voie',1),(16,'Clement','Nice!','site','Le chamois',3),(17,'test','pas mal comme voie','voie','Voie oklm',5),(18,'test','plein de trucs a faire la bas','secteur','Cool',4);
/*!40000 ALTER TABLE `commentaire` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-26 11:58:04
