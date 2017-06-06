-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: taxi
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `bkg_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `bkg_start_datetime` datetime DEFAULT NULL,
  `bkg_finish_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`bkg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,1,'2017-04-14 00:50:09','2017-04-14 00:50:09'),(2,2,2,'2017-04-14 00:50:09','2017-04-14 00:50:09'),(3,3,3,'2017-04-14 00:50:09','2017-04-14 00:50:09'),(4,4,4,'2017-04-14 00:50:09','2017-04-14 00:50:09'),(5,5,5,'2017-04-14 00:50:09','2017-04-14 00:50:09'),(6,6,6,'2017-04-14 00:50:09','2017-04-14 00:50:09'),(7,7,7,'2017-04-14 00:50:09','2017-04-14 00:50:09'),(8,8,8,'2017-04-14 00:50:09','2017-04-14 00:50:09');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_phonenumber` varchar(100) NOT NULL,
  `driver_name` varchar(100) NOT NULL,
  `car_type` varchar(100) NOT NULL,
  `car_name` varchar(100) NOT NULL,
  `car_number` varchar(200) NOT NULL,
  `car_color` varchar(200) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `cars___fk` (`group_id`),
  CONSTRAINT `cars___fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (7,'+79287898989','Svetlanafbsdhjfb','passengercar','Lada Priora','345','green',NULL),(10,'35545','test','1','2','455','0',NULL),(11,'7777777777','alex','passengercar','Lada Priora','345','1',NULL),(12,'5555555','Yog','passengercar','Lada Priora','788','green',NULL),(13,'88888','Григорий','passengercar','Porsche 911','333','0',NULL),(14,'444444444','Петр','passengercar','Porsche 911','543','green',NULL),(15,'6766767','Alex','passengercar','Lada Priora','345','green',NULL),(16,'7777777777','alex','passengercar','Lada Priora','345','Выберите цвет автомобиля',NULL),(18,'james bond car','alex','passengercar','Lada Priora','345','green',NULL),(19,'465656','fgfrgf','passengercar','Lada 2115','456','violet',NULL);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'passenger cars'),(2,'trucks');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `loc_id` int(11) NOT NULL AUTO_INCREMENT,
  `loc_latitude` varchar(100) NOT NULL,
  `loc_longitude` varchar(100) NOT NULL,
  `loc_address` varchar(100) NOT NULL,
  PRIMARY KEY (`loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'45.56565656','67.565656656','Lenina Street'),(2,'45.56565656','67.565656656','Pushkina Street'),(3,'45.56565656','67.565656656','Pushkina Street'),(4,'45.56565656','67.565656656','Pushkina Street'),(5,'45.56565656','67.565656656','Pushkina Street'),(6,'45.56565656','67.565656656','Pushkina Street'),(7,'45.56565656','67.565656656','Pushkina Street'),(8,'45.56565656','67.565656656','Pushkina Street');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'test','ROLE_ADMIN'),(2,'hh','ROLE_USER'),(3,'login','ROLE_USER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_phonenumber` varchar(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_address` varchar(200) NOT NULL,
  `call_datetime` datetime DEFAULT NULL,
  `login` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `is_blocked` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'+79287898989','Ivan','Lenina Street','2017-04-14 00:31:03','test','test',0),(2,'+79287898988','Petr','Bunina Street','2017-04-14 00:31:03','hh','hh',0),(3,'+79287898987','Grigory','Stalina Street','2017-04-14 00:31:03','gg','gg',0),(4,'+79287898986','Svetlana','Petra1 Street','2017-04-14 00:31:03',NULL,NULL,NULL),(5,'+79287898985','Inessa','Pushkina Street','2017-04-14 00:31:03',NULL,NULL,NULL),(6,'+79287898984','Vladimir','Lermontova Street','2017-04-14 00:31:03',NULL,NULL,NULL),(7,'+79287898983','Svatoslav','Esenina Street','2017-04-14 00:31:03',NULL,NULL,NULL),(8,'+79287898983','Victor','Tutcheva Street','2017-04-14 00:31:03',NULL,NULL,NULL),(9,'34345','gg','fgrgg',NULL,'ggg','ggg',0),(10,'wdwd','wdwd','wd',NULL,'ef','ef',0),(11,'efrgrg','efr','rgrg',NULL,'rg','rg',0),(12,'45556656','Ð¼Ð°Ð³Ð¾Ð¼ÐµÐ´','Ð¼Ð°ÑÐ°ÑÐºÐ°Ð»',NULL,'mag','mag',0),(13,'4343545','testttt','tttttteeeeessstttt',NULL,'ttt','ttt',0),(14,'454545','Ð°Ð¿ÐºÑÐµÑÐµÑÐµÑÐµ','ÑÐºÐ°Ð¿ÐºÐ¿ÐµÐµ',NULL,'ggg','ggg',0),(15,'72346t672357','sdyfjgsdf','jdgfyusdgfyu',NULL,'login','login',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-06 23:26:53
