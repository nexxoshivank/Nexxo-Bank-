-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: my_bank_app
-- ------------------------------------------------------
-- Server version	8.0.26

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

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `mobile` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `aadhaar_number` varchar(12) NOT NULL,
  `pan_no` varchar(20) NOT NULL,
  `created_on` date NOT NULL,
  `status_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `aadhaar_number_UNIQUE` (`aadhaar_number`),
  UNIQUE KEY `pan_no_UNIQUE` (`pan_no`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `users_ibfk_1` (`status_id`),
  KEY `users_ibfk_2` (`role_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `statuses` (`status_id`),
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (100,'Shivank','Sharma','1999-11-12','9013807652','shivank.sharma@nexxo.com','12345678912','JHWPS6899P','2021-09-29',1,2),(101,'admin',NULL,NULL,'9999999999','admin@nexxo.com','123443211234','JHAP34PP','2021-09-29',1,1),(102,'Jatin','Rawat','1999-10-19','9999966666','jatin@nexxo.com','123443011234','JHWPS98','2021-09-29',1,2),(103,'Arkodeep','Biswas','1997-08-13','9090909090','arkodeep.biswas@nexxo.com','109876543211','KSD98SP','2021-09-30',1,2),(104,'admin','second',NULL,'9999999933','adminsecond@nexxo.com','444333523456','GDFR56T','2021-09-29',2,1),(105,'Puneet','Sharma','1999-02-04','7678334455','puneet@abc.com','543267543278','SD54RST','2021-10-01',1,2),(106,'Shivam','Sharma','2000-08-12','9876567897','shivam@gmail.com','123456789012','JHWP98SP','2021-10-08',2,2),(107,'Rahul','Bisht','1995-08-24','7654326543','rahul@gmail.com','654345678965','SD54RSI','2021-10-08',1,2),(115,'kwefh','bkfjb','1998-03-14','765676','habjh@g.com','456545675','hbarhb','2021-10-11',1,2),(116,'Krishna','Pandey','1998-08-12','639598987','pandey@nexxo.com','567867890876','SUT458DUST','2021-10-11',2,2);
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

-- Dump completed on 2021-10-13 15:08:01
