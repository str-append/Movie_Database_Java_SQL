-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (arm64)
--
-- Host: localhost    Database: dbmsproject
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `action` (
  `m_id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `movie_id` int DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `action_fk` (`movie_id`),
  CONSTRAINT `action_fk` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'Avengers End Game',1),(2,'Extraction',2),(3,'Bahubali',3),(4,'Morbius',5);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `uname` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('yashsharma','1122@@');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comedy`
--

DROP TABLE IF EXISTS `comedy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comedy` (
  `m_id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `movie_id` int DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `comedy_fk` (`movie_id`),
  CONSTRAINT `comedy_fk` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comedy`
--

LOCK TABLES `comedy` WRITE;
/*!40000 ALTER TABLE `comedy` DISABLE KEYS */;
INSERT INTO `comedy` VALUES (1,'Made In China',6),(2,'Entertainment',7);
/*!40000 ALTER TABLE `comedy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language` (
  `movie_id` int NOT NULL,
  `language` varchar(20) NOT NULL,
  PRIMARY KEY (`movie_id`,`language`),
  CONSTRAINT `language_fk` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movieid` int NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `actor` varchar(200) NOT NULL,
  `actress` varchar(200) NOT NULL,
  PRIMARY KEY (`movieid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Spider-Man HomeComing','Tom Holland','Zendaya'),(2,'Morbius','Jared Leto','Adria Arjona'),(3,'Bahubali','Prabhas','pta nahi'),(4,'pushpa','allu','rashmika'),(5,'KGF','Yash','Raveena Tandon');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `movie_id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `release_date` timestamp NOT NULL,
  `actor` varchar(30) NOT NULL,
  `actress` varchar(30) NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Avengers End Game','2019-04-26 06:30:00','Robert_Downey','Brie_Larson'),(2,'Extraction','2020-04-24 06:30:00','Chris_hemsworth','Golshifteh_Farahani'),(3,'Bahubali','2015-07-10 04:30:00','Prabhas','Anushka Shetty'),(4,'Gully_Boy','2019-02-14 22:30:00','Ranveer_Singh','Alia_Bhatt'),(5,'Morbius','2022-04-01 06:30:00','Jared Leto','Adrina Arjona'),(6,'Made In China','2019-10-18 23:30:00','Rajkumar Rao','Mouni Roy'),(7,'Entertainment','2014-08-08 02:30:00','Akshay Kumar','Tamannah'),(8,'Jab_we_met','2007-10-25 20:30:00','Shahid Kapoor','Kareena Kapoor'),(9,'Dhadak','2018-07-20 06:30:00','Ishan Khattar','Jahanvi Kapoor'),(10,'The Vow','2012-03-09 04:30:00','Channing Tatum','Rachel McAdems');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requests` (
  `mname` varchar(50) NOT NULL,
  `language` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES ('KGF 2','Hindi'),('Spider Man ','english'),('Bahubali 2','HIndi'),('Krish','English'),('RRR','HINDI');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `romance`
--

DROP TABLE IF EXISTS `romance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `romance` (
  `m_id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `movie_id` int DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `romance_fk` (`movie_id`),
  CONSTRAINT `romance_fk` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `romance`
--

LOCK TABLES `romance` WRITE;
/*!40000 ALTER TABLE `romance` DISABLE KEYS */;
INSERT INTO `romance` VALUES (1,'Gully Boy',4),(2,'Jab We Met',8),(3,'Dhadak',9),(4,'The Vow',10);
/*!40000 ALTER TABLE `romance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrating`
--

DROP TABLE IF EXISTS `userrating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userrating` (
  `mov_name` varchar(30) NOT NULL,
  `rating` int DEFAULT NULL,
  `review` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrating`
--

LOCK TABLES `userrating` WRITE;
/*!40000 ALTER TABLE `userrating` DISABLE KEYS */;
INSERT INTO `userrating` VALUES ('Extraction',4,'fantastic movie must watch'),('Extraction',4,'Superb Movie nice movie '),('Extraction',3,'Worst movie do not watch time waste'),('Krish',3,'Nice movie'),('Extraction',2,'Worst movie ever do not watch');
/*!40000 ALTER TABLE `userrating` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-06 11:22:16
