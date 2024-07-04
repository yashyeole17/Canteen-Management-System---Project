-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: canteenmg
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`canteenmg` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `canteenmg`;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userId` bigint DEFAULT NULL,
  `productname` varchar(45) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `typename` varchar(45) DEFAULT NULL,
  `companyname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,2,'Sandwich.',600,1,'Dairy Foods','Archer Company'),(2,2,'Chilli Paneer',550,1,'Grains, Beans','PepsiCo, Inc.'),(3,2,'Salad.',490,1,'Vegetables','PepsiCo, Inc.'),(4,2,'Momos',370,1,'Fruits','PepsiCo, Inc.');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `orderId` varchar(45) DEFAULT NULL,
  `productName` varchar(45) DEFAULT NULL,
  `useremail` varchar(45) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `accountNo` varchar(45) DEFAULT NULL,
  `bankname` varchar(45) DEFAULT NULL,
  `cardName` varchar(45) DEFAULT NULL,
  `totalprice` bigint DEFAULT NULL,
  `totalCharge` bigint DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'orderID221','Sandwich.','User1@123gmail.com','User1',NULL,NULL,NULL,600,0,'Paid'),(2,'orderID712','Chilli Paneer','User1@123gmail.com','User1','Sint lorem suscipit','Merrill Lester','Autem mollit consequ',550,1150,'Paid'),(3,'orderID715','Sandwich.','User1@123gmail.com','User1',NULL,NULL,NULL,600,0,'Paid'),(4,'orderID634','Chilli Paneer','User1@123gmail.com','User1',NULL,NULL,NULL,550,0,'Paid'),(5,'orderID444','Salad.','User1@123gmail.com','User1',NULL,NULL,NULL,490,0,'Paid'),(6,'orderID98','Momos','User1@123gmail.com','User1','Quasi ut aut commodi','Honorato Burnett','Incididunt rerum qui',370,2010,'Paid'),(7,'orderID829','Sandwich.','User1@123gmail.com','User1',NULL,NULL,NULL,600,0,'Paid'),(8,'orderID555','Chilli Paneer','User1@123gmail.com','User1',NULL,NULL,NULL,550,0,'Paid'),(9,'orderID928','Salad.','User1@123gmail.com','User1',NULL,NULL,NULL,490,0,'Paid'),(10,'orderID825','Momos','User1@123gmail.com','User1','Quasi ut aut commodi','Honorato Burnett','Incididunt rerum qui',370,2010,'Paid'),(11,'orderID919','Sandwich.','User1@123gmail.com','User1',NULL,NULL,NULL,600,0,'Paid'),(12,'orderID536','Chilli Paneer','User1@123gmail.com','User1',NULL,NULL,NULL,550,0,'Paid'),(13,'orderID198','Salad.','User1@123gmail.com','User1',NULL,NULL,NULL,490,0,'Paid'),(14,'orderID694','Momos','User1@123gmail.com','User1','Molestiae veniam do','Virginia Sandoval','Qui et totam dolores',370,2010,'Paid');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcompany`
--

DROP TABLE IF EXISTS `productcompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productcompany` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `companyName` varchar(455) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcompany`
--

LOCK TABLES `productcompany` WRITE;
/*!40000 ALTER TABLE `productcompany` DISABLE KEYS */;
INSERT INTO `productcompany` VALUES (1,'Nestle'),(2,'PepsiCo, Inc.'),(3,'Tyson Foods'),(4,'Archer Company'),(5,'Estrada LLC');
/*!40000 ALTER TABLE `productcompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdetails`
--

DROP TABLE IF EXISTS `productdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productdetails` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `image` longblob,
  `typeid` bigint DEFAULT NULL,
  `typename` varchar(45) DEFAULT NULL,
  `companyId` bigint DEFAULT NULL,
  `companyName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetails`
--

LOCK TABLES `productdetails` WRITE;
/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producttype`
--

DROP TABLE IF EXISTS `producttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producttype` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `productid` varchar(455) DEFAULT NULL,
  `productName` varchar(455) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttype`
--

LOCK TABLES `producttype` WRITE;
/*!40000 ALTER TABLE `producttype` DISABLE KEYS */;
INSERT INTO `producttype` VALUES (1,'1001A','Vegetables'),(2,'2001B','Fruits'),(3,'3001C','Grains, Beans'),(4,'1001D','Dairy Foods');
/*!40000 ALTER TABLE `producttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `roleid` bigint DEFAULT NULL,
  `roleName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','Admin@123gmail.com','Admin@1234',1,'Admin'),(2,'User1','User1@123gmail.com','User1@1234',2,'Student'),(3,'User2','User2@123gmail.com','User2@1234',2,'Student');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-09 19:41:01
