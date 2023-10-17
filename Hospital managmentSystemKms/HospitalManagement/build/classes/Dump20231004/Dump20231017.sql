-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: login
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `user nme` varchar(45) DEFAULT NULL,
  `password` int DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `duplicate` int NOT NULL AUTO_INCREMENT,
  `pasant_id` int NOT NULL,
  `pasantname` varchar(45) DEFAULT NULL,
  `contactno` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `doctorid` int DEFAULT NULL,
  `doctorname` varchar(45) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `Visitingtime` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`duplicate`,`pasant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,3,'limon','foridpur','fsdfsd',4,'Dr. Tonmoy Hosain','Urology','12:00pm  to  03:00pm','2023-10-05'),(3,3,'limon','foridpur','fsdfsd',4,'Dr. Tonmoy Hosain','Urology','12:00pm  to  03:00pm','2023-10-13'),(4,3,'limon','fsdfsd','foridpur',3,'Dr. Tonmoy Hosain','Urology','05:00pm to 10:00pm','2023-10-12'),(5,4,'Tonmoy','Rajbari','017100000',5,'Dr. Hasan','Internal medicine','12:00pm  to  03:00pm','2023-10-04');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctorinformation`
--

DROP TABLE IF EXISTS `doctorinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctorinformation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `qualifications` varchar(45) DEFAULT NULL,
  `joiningDate` date DEFAULT NULL,
  `contactNo` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `blodgroup` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctorinformation`
--

LOCK TABLES `doctorinformation` WRITE;
/*!40000 ALTER TABLE `doctorinformation` DISABLE KEYS */;
INSERT INTO `doctorinformation` VALUES (1,'Dr. Sabit Hasan','1236','General surgery','2023-10-13','0171********','Male','O+'),(2,'Dr. limon','6789',' Cardiology ','2023-10-13','0171**4******','Male','B+'),(4,'Dr. Tonmoy Hosain','tonmoy','Urology','2019-04-15','0187688888**','Male','A+'),(5,'Dr. Hasan','12345','Internal medicine','2017-04-14','08978643','Male','A-'),(6,'Dr. Rajib Dooto','1234','Physical medicine and rehabilitation','2023-10-05','0123456789','Male','B+');
/*!40000 ALTER TABLE `doctorinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employes`
--

DROP TABLE IF EXISTS `employes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employes`
--

LOCK TABLES `employes` WRITE;
/*!40000 ALTER TABLE `employes` DISABLE KEYS */;
INSERT INTO `employes` VALUES (1,'kms','gm',500000),(2,'sayfullah','student  attendent',20000),(4,'sabit hasan','student',1000);
/*!40000 ALTER TABLE `employes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospitaladmition`
--

DROP TABLE IF EXISTS `hospitaladmition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospitaladmition` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pasantid` int NOT NULL,
  `panantname` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `blodgroup` varchar(45) DEFAULT NULL,
  `disease` varchar(45) DEFAULT NULL,
  `roomid` varchar(45) DEFAULT NULL,
  `roomtype` varchar(45) DEFAULT NULL,
  `doctorid` int NOT NULL,
  `doctorname` varchar(45) DEFAULT NULL,
  `admitdate` date DEFAULT NULL,
  PRIMARY KEY (`id`,`pasantid`,`doctorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospitaladmition`
--

LOCK TABLES `hospitaladmition` WRITE;
/*!40000 ALTER TABLE `hospitaladmition` DISABLE KEYS */;
/*!40000 ALTER TABLE `hospitaladmition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginlist`
--

DROP TABLE IF EXISTS `loginlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loginlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usarname` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginlist`
--

LOCK TABLES `loginlist` WRITE;
/*!40000 ALTER TABLE `loginlist` DISABLE KEYS */;
INSERT INTO `loginlist` VALUES (1,'sldkfjsdalkj','gggggg','2023-09-04'),(2,'limon','1234','2023-09-06');
/*!40000 ALTER TABLE `loginlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasantinformation`
--

DROP TABLE IF EXISTS `pasantinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasantinformation` (
  `pasantid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `blodgroup` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `Phathologist` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `disease` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pasantid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasantinformation`
--

LOCK TABLES `pasantinformation` WRITE;
/*!40000 ALTER TABLE `pasantinformation` DISABLE KEYS */;
INSERT INTO `pasantinformation` VALUES (1,'sabit','pabna','01723539359','26','O+','Male','Dr. Md. Amer Wahed','2023-10-13','Orthopedics'),(3,'limon','foridpur','fsdfsd','32','B+','Male','Dr. Abdul Khaleq Akond','2023-10-13','Neurology'),(4,'Tonmoy','Rajbari','017100000','29','B+','Male','Professor Dr. M. Shawkat Hasan','2013-10-02','Neurology'),(5,'Hasan','Borisal','0152342323','27','A+','Male','Professor Dr. M. Shawkat Hasan','2023-10-19','Urology'),(6,'Jahid Ahmed','Cumilla','018131154423','28','O+','Male','Dr. Md. Mahmudul Huda (Himel) Assistant',NULL,' Cardiology ');
/*!40000 ALTER TABLE `pasantinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomid` varchar(45) DEFAULT NULL,
  `roomType` varchar(45) DEFAULT NULL,
  `roomPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'1','AC CABIN',3500);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stucentinfoin`
--

DROP TABLE IF EXISTS `stucentinfoin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stucentinfoin` (
  `idstucentinfoin` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idstucentinfoin`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stucentinfoin`
--

LOCK TABLES `stucentinfoin` WRITE;
/*!40000 ALTER TABLE `stucentinfoin` DISABLE KEYS */;
INSERT INTO `stucentinfoin` VALUES (1,'sabit','25','Male','2023-09-07'),(4,'kms','28','Male','2023-10-05');
/*!40000 ALTER TABLE `stucentinfoin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `role` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentinfo`
--

DROP TABLE IF EXISTS `studentinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentinfo` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `rolenumber` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentinfo`
--

LOCK TABLES `studentinfo` WRITE;
/*!40000 ALTER TABLE `studentinfo` DISABLE KEYS */;
INSERT INTO `studentinfo` VALUES (1,'6tg5tf','f5trf5','Male','CSS','2023-09-07'),(2,'Tonmoy','10500','Male','JEE','2023-09-05'),(3,'jamil','520','Male','CSS','2023-09-02'),(4,'kakoli','256','Femal','--Sub--','2023-10-04');
/*!40000 ALTER TABLE `studentinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-17  5:09:56
