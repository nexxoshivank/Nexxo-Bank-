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
-- Table structure for table `transaction_history`
--

DROP TABLE IF EXISTS `transaction_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_history` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `user_id_transaction_table` int DEFAULT NULL,
  `amount` int NOT NULL,
  `ifsc` varchar(45) NOT NULL,
  `date_time` datetime NOT NULL,
  `merchant_account_number` varchar(20) NOT NULL,
  `t_id` int DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `t_id` (`t_id`),
  KEY `transaction_history_ibfk_2_idx` (`user_id_transaction_table`),
  CONSTRAINT `transaction_history_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `transaction_type` (`trans_id`),
  CONSTRAINT `transaction_history_ibfk_2` FOREIGN KEY (`user_id_transaction_table`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10580 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_history`
--

LOCK TABLES `transaction_history` WRITE;
/*!40000 ALTER TABLE `transaction_history` DISABLE KEYS */;
INSERT INTO `transaction_history` VALUES (10564,100,400,'SBI0987','2021-10-01 00:00:00','54637895',2),(10565,102,500,'IDS675S','2021-10-04 12:51:20','2345678',2),(10566,101,100,'FDS677Y','2021-10-04 12:52:53','20985678',2),(10567,103,10000,'ICICIS677Y','2021-10-04 12:59:45','678985678',2),(10568,100,655,'SBI6543TY','2021-10-05 08:45:34','65487687',2),(10569,105,100000,'ICICIS677Y','2021-10-07 22:11:40','678985678',2),(10570,100,99,'SDG543S','2021-10-08 15:15:19','65456',2),(10571,102,50,'SDF53','2021-10-08 15:23:37','4567890',2),(10572,107,800,'DFT567RFT','2021-10-11 12:44:55','78765487',2),(10573,100,300,'SEW543STY','2021-10-11 17:09:09','12345678',2),(10574,100,-987,'STF765TRF','2021-10-11 17:40:08','67654567',2),(10575,100,76,'SFT786GTH','2021-10-13 12:14:55','87654587',2),(10576,100,76,'YFT786GTH','2021-10-13 12:16:19','76545878',2),(10577,100,-76,'YFT786GTH','2021-10-13 12:16:58','76545878',2),(10578,100,-76,'YFT786GTH','2021-10-13 12:18:08','76545878',2),(10579,100,-76,'YFT786GTH','2021-10-13 12:20:12','76545878',2);
/*!40000 ALTER TABLE `transaction_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-13 15:08:00
