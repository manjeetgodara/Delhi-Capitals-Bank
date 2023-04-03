-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: sb_101_b24_dcbank
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `customerlogin`
--

DROP TABLE IF EXISTS `customerlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerlogin` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `Cname` varchar(25) NOT NULL,
  `Cmobile` varchar(20) DEFAULT NULL,
  `Caddress` varchar(40) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerlogin`
--

LOCK TABLES `customerlogin` WRITE;
/*!40000 ALTER TABLE `customerlogin` DISABLE KEYS */;
INSERT INTO `customerlogin` VALUES (1000,'Manjeet','9953462784','Dwarka-NewDelhi','manjeet123','123',0),(1001,'sandeep','8448817875','Dwarka-Delhi','sandeep123','123',0);
/*!40000 ALTER TABLE `customerlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customersignup`
--

DROP TABLE IF EXISTS `customersignup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customersignup` (
  `customer_id` int DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `martial` varchar(10) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `income` int DEFAULT NULL,
  `type` varchar(10) NOT NULL,
  `services` varchar(30) DEFAULT NULL,
  `is_delete` tinyint DEFAULT '0',
  `accountNumber` bigint NOT NULL,
  `pinNumber` int NOT NULL,
  `status` varchar(20) DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customersignup`
--

LOCK TABLES `customersignup` WRITE;
/*!40000 ALTER TABLE `customersignup` DISABLE KEYS */;
INSERT INTO `customersignup` VALUES (1000,'manjeet','JaswantSingh','1999-05-01','M','godaramanjeet293@gmail.com','unmarried','Dwarka-NewDelhi',15000,'saving','chequeBook,ATMcard',0,5040936746986598,9090,'active'),(1001,'sandeep','JaipalSingh','1999-05-10','M','sandeepgodara@gmail.com','unmarried','Dwarka-Delhi',19000,'saving','chequebook,InternetBanking',0,5040936742013163,2477,'active');
/*!40000 ALTER TABLE `customersignup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `accountNumber` bigint NOT NULL,
  `pinNumber` int NOT NULL,
  `balance` bigint DEFAULT '2000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (5040936746986598,9090,4000),(5040936742013163,2477,4500);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `customer_id` int DEFAULT NULL,
  `Tdate` date DEFAULT NULL,
  `Ttime` time DEFAULT NULL,
  `transaction_type` varchar(20) NOT NULL,
  `amount` bigint NOT NULL,
  `pinNumber` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1000,'2023-03-31','08:44:45','Deposit',3000,9090),(1000,'2023-03-31','08:44:54','Withdraw',1500,9090),(1001,'2023-03-31','09:06:38','Deposit',2000,2477),(1001,'2023-03-31','09:07:15','Withdraw',1000,2477),(1000,'2023-03-31','10:03:27','Transfer',1000,9090),(1000,'2023-03-31','10:06:55','Transfer',500,9090);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 16:49:49
