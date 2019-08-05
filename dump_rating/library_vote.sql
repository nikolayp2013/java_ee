CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.6.10-log

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
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(5) DEFAULT '0',
  `book_id` bigint(20) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_book_id_idx` (`book_id`),
  KEY `fk_user_id_idx` (`username`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=372 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` (`id`, `value`, `book_id`, `username`) VALUES (291,4,7,'user'),(292,5,7,'user'),(293,4,21,'user'),(294,5,14,'user'),(297,3,7,'admin'),(298,3,21,'admin'),(299,1,21,'admin'),(300,5,21,'admin'),(301,3,14,'admin'),(311,4,20,'admin'),(312,5,20,'admin'),(313,4,18,'admin'),(314,5,18,'admin'),(315,4,18,'admin'),(316,5,9,'admin'),(317,4,9,'admin'),(318,2,9,'admin'),(319,4,9,'admin'),(320,5,9,'admin'),(321,5,8,'admin'),(322,4,8,'admin'),(323,5,8,'admin'),(324,5,8,'admin'),(325,4,8,'admin'),(326,5,8,'admin'),(327,5,22,'admin'),(328,4,22,'admin'),(329,5,22,'admin'),(330,4,22,'admin'),(331,5,6,'admin'),(332,4,6,'admin'),(333,3,6,'admin'),(334,1,6,'admin'),(335,5,6,'admin'),(336,5,12,'admin'),(337,5,12,'admin'),(338,5,12,'admin'),(339,4,12,'admin'),(340,2,12,'admin'),(341,5,12,'admin'),(348,5,7,'admin'),(349,1,6,'admin'),(350,5,12,'admin'),(351,5,12,'admin'),(352,1,20,'admin'),(353,4,20,'admin'),(354,5,6,'admin'),(355,5,7,'admin'),(356,5,21,'admin'),(357,5,20,'admin'),(358,5,6,'admin'),(359,3,12,'admin'),(360,3,22,'admin'),(361,1,12,'admin'),(362,1,12,'admin'),(363,2,14,'admin'),(364,5,14,'admin'),(365,1,14,'admin'),(366,1,14,'admin'),(367,1,14,'admin'),(368,1,14,'admin'),(369,1,12,'admin'),(370,2,22,'admin'),(371,5,20,'user');
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-11 23:28:48
