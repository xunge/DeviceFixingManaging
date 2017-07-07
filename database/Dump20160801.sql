-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: equipment_system
-- ------------------------------------------------------
-- Server version	5.5.50

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_idno` varchar(18) NOT NULL DEFAULT '',
  `customer_visittime` date DEFAULT NULL,
  `customer_character` varchar(20) DEFAULT NULL,
  `customer_companyname` varchar(20) DEFAULT NULL,
  `customer_housephone` varchar(11) DEFAULT NULL,
  `customer_mobilephone` varchar(11) NOT NULL,
  `customer_address` varchar(50) NOT NULL,
  `customer_postcode` varchar(6) DEFAULT NULL,
  `customer_linkman` varchar(20) NOT NULL,
  `customer_email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`customer_idno`),
  UNIQUE KEY `customer_mobilephone` (`customer_mobilephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('111111111111111111','1111-12-12','家庭用户','','','77888888888','fuck','','man',''),('123456789012345091','2016-07-29','家庭用户','caccc','82345608','13344556499','111','10001','11111111','123@qq.com'),('123456789012345112','2016-08-01','单位用户','caccc','82345608','13344556683','dddddddddddddd','10001','women','123@qq.com'),('123456789012345115','2016-07-29','代理商','caccc','82345608','13344556605','dddddddddddddd','10001','11111111','123@qq.com'),('123456789012345622','2016-07-29','家庭用户',NULL,'82345608','13344556633','dddddddddddddd','10001','11111111','123@qq.com'),('123456789012345666','2016-07-29','代理商',NULL,'82345608','13344556622','dddddddddddddd','10001','11111111','123@qq.com'),('123456789012345677','2016-07-29','单位用户','caccc','82345608','13344556671','111','10001','11111111','123@qq.com'),('123456789012345678','2016-07-06','家庭用户',NULL,NULL,'13344556689','dddddddddddddd',NULL,'women',NULL),('123456789012345679','2016-07-09','',NULL,NULL,'13344556688','',NULL,'',NULL),('123456789012345688','2016-07-29','家庭用户',NULL,'82345608','13344556686','dddddddddddddd','10001','women','123@qq.com'),('132123199899071234','2016-07-29','代理商','caccc','82345608','18812340000','dddddddddddddd','10001','women','123@qq.com'),('230103199608311111','2016-08-01','家庭用户','哈工程','88069381','13654505791','哈工程','150000','姜训智','1063563941@qq.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part` (
  `part_no` int(20) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(20) NOT NULL,
  `part_size` varchar(20) DEFAULT NULL,
  `part_price` double(10,2) NOT NULL,
  `part_num` int(10) NOT NULL,
  `part_warn_num` int(10) NOT NULL,
  `part_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`part_no`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (0,'S','1L',23.30,1,2,'警示'),(2,'L','2L',1.00,24,2,'正常'),(3,'关键轴','3L',33.33,59,5,'正常'),(4,'关键轴','3L',33.33,50,5,'正常'),(5,'关键轴','3L',33.33,62,5,'正常'),(6,'关键轴','3L',33.33,55,5,'正常'),(7,'关键轴','3L',33.33,55,5,'正常'),(8,'关键轴','3L',33.33,55,5,'正常'),(9,'关键轴','3L',33.33,55,5,'正常'),(10,'关键轴','3L',33.33,55,5,'正常'),(11,'关键轴','3L',33.33,59,5,'正常'),(12,'关键轴','3L',33.33,55,5,'正常'),(13,'关键轴','3L',33.33,55,5,'正常'),(14,'关键轴','3L',33.33,55,5,'正常');
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_detail`
--

DROP TABLE IF EXISTS `part_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_detail` (
  `part_detail_no` int(20) NOT NULL AUTO_INCREMENT,
  `repair_record_no` int(6) DEFAULT NULL,
  `part_no` int(20) DEFAULT NULL,
  `part_detail_num` int(20) NOT NULL,
  `part_detail_status` varchar(20) NOT NULL,
  PRIMARY KEY (`part_detail_no`),
  KEY `fk_part_no` (`part_no`),
  KEY `fk_repair_record_no` (`repair_record_no`),
  CONSTRAINT `fk_part_no` FOREIGN KEY (`part_no`) REFERENCES `part` (`part_no`),
  CONSTRAINT `fk_repair_record_no` FOREIGN KEY (`repair_record_no`) REFERENCES `repair_record` (`repair_record_no`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_detail`
--

LOCK TABLES `part_detail` WRITE;
/*!40000 ALTER TABLE `part_detail` DISABLE KEYS */;
INSERT INTO `part_detail` VALUES (1,1,0,3,'未入库'),(2,1,0,2,'已出库'),(5,1,2,10,'已出库'),(8,1,2,4,''),(9,1,2,4,''),(10,1,2,4,''),(11,1,2,4,'已出库'),(12,1,2,4,'已出库'),(13,1,0,3,'已出库'),(14,4,3,4,'已出库'),(15,4,4,5,'已出库'),(16,1,4,5,'已出库'),(21,4,0,4,'已出库'),(22,1,2,4,''),(23,1,2,4,''),(24,1,2,4,''),(26,4,0,4,'已出库'),(27,1,2,4,''),(28,1,2,4,''),(29,1,2,4,''),(30,1,2,4,''),(32,1,2,4,''),(33,1,2,4,''),(34,1,2,4,''),(35,1,2,4,''),(36,1,2,4,''),(37,1,2,4,''),(38,1,2,4,''),(39,1,2,4,''),(40,1,2,4,''),(41,1,2,4,''),(42,4,0,4,'未出库'),(43,4,0,4,'已出库'),(44,4,0,5,'已出库'),(47,4,0,5,'已出库'),(48,1,2,4,''),(50,1,2,4,''),(52,35,5,3,'已出库'),(53,1,2,4,''),(54,4,0,4,'未出库'),(55,4,4,6,'未出库'),(56,25,0,11,'已出库'),(57,1,2,4,''),(58,1,2,4,''),(59,1,2,4,'');
/*!40000 ALTER TABLE `part_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `price_no` int(6) NOT NULL AUTO_INCREMENT,
  `price_time` date DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`price_no`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,'1111-01-11',22.22),(2,'1111-01-11',22.22),(3,'1111-01-11',22.22),(4,'1111-01-11',22.22),(5,'1111-01-11',22.22),(6,'1111-01-11',22.22),(7,'1111-01-11',22.22),(8,'1111-01-11',22.22),(9,'2016-07-27',0.00),(10,'2016-07-27',0.00),(11,'2016-07-27',0.00),(12,'2016-07-27',0.00),(13,'2016-07-27',0.00),(14,'2016-07-27',0.00),(15,'2016-07-27',0.00),(16,'2016-07-27',0.00),(17,'2016-07-27',1.00),(18,'2016-07-27',56.60),(19,'2016-07-27',57.60),(20,'2016-07-27',12.00),(21,'2016-07-27',0.00),(22,'2016-07-27',1.00),(23,'2016-07-27',2.00),(24,'2016-07-29',291.60),(25,'2016-07-29',1.00),(26,'2016-07-29',0.00),(27,'2016-07-29',12.00),(28,'2016-07-29',12.00),(29,'2016-07-29',12.00),(30,'2016-07-29',12.00),(31,'2016-07-29',12.00),(32,'2016-07-29',12.00),(33,'2016-07-29',12.00),(34,'2016-07-29',12.00),(35,'2016-07-29',280.60),(36,'2016-07-29',1.00),(37,'2016-08-01',1.00),(38,'2016-08-01',651.40);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repair_record`
--

DROP TABLE IF EXISTS `repair_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repair_record` (
  `repair_record_no` int(6) NOT NULL AUTO_INCREMENT,
  `report_record_no` int(6) DEFAULT NULL,
  `repair_person_no` int(6) DEFAULT NULL,
  `repair_time` date DEFAULT NULL,
  `test_record` varchar(50) DEFAULT NULL,
  `repair_record` varchar(50) DEFAULT NULL,
  `repair_test_time` date DEFAULT NULL,
  `work_amount` varchar(50) DEFAULT NULL,
  `person_price` double(10,2) DEFAULT NULL,
  `material_price` double(10,2) DEFAULT NULL,
  `repair_promise` varchar(50) DEFAULT NULL,
  `attention` varchar(50) DEFAULT NULL,
  `repair_status` varchar(30) DEFAULT NULL,
  `repair_delay` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`repair_record_no`),
  KEY `fk_repair_person_no` (`repair_person_no`),
  KEY `fk_report_record_no` (`report_record_no`),
  CONSTRAINT `fk_repair_person_no` FOREIGN KEY (`repair_person_no`) REFERENCES `staff` (`staff_no`),
  CONSTRAINT `fk_report_record_no` FOREIGN KEY (`report_record_no`) REFERENCES `report_record` (`report_record_no`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair_record`
--

LOCK TABLES `repair_record` WRITE;
/*!40000 ALTER TABLE `repair_record` DISABLE KEYS */;
INSERT INTO `repair_record` VALUES (1,2,1,'2016-07-26','111','111','2016-07-26','2min',2.33,2.34,'Noi!','Noi!','撤销','一般'),(4,2,1,'2016-07-26','主机爆炸。','劝导客户更换主机。','2016-07-26','1min',2.33,6.66,'不作任何保证。','增加警卫，防止客户发飙。','已维修','一般'),(5,2,1,'2016-07-26','主机爆炸。','劝导客户更换主机。','2016-07-26','1min',2.33,6.66,'不作任何保证。','增加警卫，防止客户发飙。','已维修','一般'),(11,2,1,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','已维修',''),(12,2,1,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','已维修',''),(13,2,1,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','撤销',''),(14,2,1,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','撤销',''),(15,2,1,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','撤销',''),(16,2,1,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','撤销',''),(17,2,1,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','撤销',''),(18,40,NULL,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','',''),(19,41,NULL,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','',''),(20,42,NULL,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','',''),(21,43,NULL,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','',''),(22,44,NULL,'2016-07-02','','','2016-07-02','',-1.00,-1.00,'','','',''),(23,45,7,'2016-07-09','','','2016-07-09','',-1.00,-1.00,'','','已分配',''),(24,2,5,'2016-07-31',NULL,NULL,'2016-08-01','caonima',NULL,NULL,NULL,NULL,'已维修','严重'),(25,NULL,5,NULL,NULL,NULL,'2016-08-01',NULL,NULL,NULL,NULL,NULL,'已分配','比较严重'),(26,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'未分配',NULL),(27,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'未分配',NULL),(28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'未分配',NULL),(29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'未分配',NULL),(30,46,NULL,'2016-07-28','','','2016-07-28','',-1.00,-1.00,'','','',''),(31,47,NULL,'2016-07-28','','','2016-07-28','',-1.00,-1.00,'','','',''),(32,48,NULL,'2016-07-28','','','2016-07-28','',-1.00,-1.00,'','','',''),(33,49,NULL,'2016-07-28','','','2016-07-28','',-1.00,-1.00,'','','',''),(34,50,NULL,'2016-07-28','','','2016-07-28','',-1.00,-1.00,'','','',''),(35,50,5,'2016-07-31',NULL,NULL,'2016-08-11',NULL,NULL,NULL,NULL,NULL,'撤销','一般'),(36,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'已分配','严重'),(37,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'已分配',NULL),(38,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'已分配',NULL),(39,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'已分配',NULL),(40,51,NULL,'2016-07-31','','','2016-07-31','',-1.00,-1.00,'','','',''),(41,52,NULL,'2016-07-31','','','2016-07-31','',-1.00,-1.00,'','','',''),(42,53,NULL,'2016-07-31','','','2016-07-31','',-1.00,-1.00,'','','',''),(43,54,NULL,'2016-07-31','','','2016-07-31','',-1.00,-1.00,'','','',''),(44,55,NULL,'2016-07-31','','','2016-07-31','',-1.00,-1.00,'','','',''),(45,56,5,'2016-07-31','','','2016-07-31','',-1.00,-1.00,'','','已维修',''),(46,56,NULL,'2016-08-01','','','2016-08-01','',-1.00,-1.00,'','','',''),(47,58,NULL,'2016-08-01','','','2016-08-01','',-1.00,-1.00,'','','未分配',''),(48,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'已分配',NULL),(49,59,NULL,'2016-08-01','','','2016-08-01','',-1.00,-1.00,'','','未分配',''),(50,59,NULL,'2016-08-01','','','2016-08-01','',-1.00,-1.00,'','','',''),(51,61,NULL,'2016-08-01','','','2016-08-01','',-1.00,-1.00,'','','未分配',''),(52,62,NULL,'2016-08-01','','','2016-08-01','',-1.00,-1.00,'','','未分配',''),(53,63,NULL,'2016-08-01','','','2016-08-01','',-1.00,-1.00,'','','未分配','');
/*!40000 ALTER TABLE `repair_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_equipment`
--

DROP TABLE IF EXISTS `report_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_equipment` (
  `report_equip_no` int(20) NOT NULL AUTO_INCREMENT,
  `product_type` varchar(20) DEFAULT NULL,
  `report_equip_brand` varchar(20) DEFAULT NULL,
  `report_equip_series` varchar(20) DEFAULT NULL,
  `report_equip_absent` varchar(20) DEFAULT NULL,
  `report_equip_problem` varchar(50) NOT NULL,
  `report_equip_problem_type` varchar(20) NOT NULL,
  `report_equip_appearance` varchar(20) DEFAULT NULL,
  `report_equip_password` varchar(20) DEFAULT NULL,
  `report_equip_data` varchar(20) DEFAULT NULL,
  `report_equip_hdd` varchar(20) DEFAULT NULL,
  `report_equip_memory` varchar(20) DEFAULT NULL,
  `report_equip_pc` varchar(20) DEFAULT NULL,
  `report_equip_ac` varchar(20) DEFAULT NULL,
  `report_equip_battery` varchar(20) DEFAULT NULL,
  `report_equip_cd` varchar(20) DEFAULT NULL,
  `report_equip_model` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`report_equip_no`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_equipment`
--

LOCK TABLES `report_equipment` WRITE;
/*!40000 ALTER TABLE `report_equipment` DISABLE KEYS */;
INSERT INTO `report_equipment` VALUES (1,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'','','','','','','','','','','','','','','',NULL),(4,'打印机','xiaomi1000','asdf','fdas','adf','固定性故障','','','','','','','','','','XXIX'),(5,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(9,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(10,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(11,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(12,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(14,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(15,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(16,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(17,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(18,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(19,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(20,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(21,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(22,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(23,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(24,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(25,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(26,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(27,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(28,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(29,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(30,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(31,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(32,'台式机','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(33,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(34,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(35,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(36,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(37,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(38,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(39,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(40,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(42,'台式机','123','','123','固定性故障','固定性故障','','','','','','','','','',NULL),(43,'笔记本','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(44,'笔记本','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(45,'笔记本','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(46,'笔记本','123','1','123','固定性故障','固定性故障','','','','','','','','','',NULL),(47,'笔记本','123','1','11','固定性故障','固定性故障','','','','','','','','','',NULL),(48,'笔记本','123','1','11','固定性故障','固定性故障','','','','','','','','','',NULL),(49,'笔记本','123','1','11','固定性故障','固定性故障','','','','','','','','','',NULL),(50,'笔记本','123','1','11','固定性故障','固定性故障','','','','','','','','','',NULL),(51,'笔记本','123','1','11','固定性故障','固定性故障','','','','','','','','','',NULL),(52,'笔记本','123','1','11','固定性故障','固定性故障','','','','','','','','','',NULL),(53,'笔记本','11','1','123','固定性故障','固定性故障','','','','','','','','','',NULL),(54,'笔记本','123','11','123','固定性故障','固定性故障','','','','','','','','','',NULL),(55,'投影仪',NULL,NULL,NULL,'p','固定性故障',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,'台式机','123','123','123','固定性故障','固定性故障','','','','','','','','','',NULL),(57,'台式机','123','123','123','固定性故障','固定性故障','','','','','','','','','',NULL),(58,'台式机','3123','12312','12321','固定性故障','固定性故障','','','','','','','','','',NULL),(59,'台式机','3123','12312','12321','固定性故障','固定性故障','','','','','','','','','',NULL),(60,'台式机','mi','mi-pro','124332141234123','间隙性故障','间隙性故障','','','','','','','','','',NULL),(61,'台式机','123','11','','固定性故障','固定性故障','','','','','','','','','',NULL),(62,'台式机','123','11','','固定性故障','固定性故障','','','','','','','','','',NULL),(63,'台式机','','','','固定性故障','固定性故障','','','','','','','','','',NULL),(64,'台式机','123','11','','固定性故障','固定性故障','','','','','','','','','',NULL),(65,'台式机','11','11','','固定性故障','固定性故障','','','','','','','','','',NULL),(66,'台式机','11','11','','固定性故障','固定性故障','','','','','','','','','',NULL),(67,'台式机','123','11','','固定性故障','固定性故障','','','','','','','','','',NULL),(68,'笔记本','联想','123456','','间隙性故障','间隙性故障','','','','','','','','','',NULL),(69,'笔记本','联想','123456','q','间隙性故障','间隙性故障','','','','','','','','','',NULL),(70,'台式机','','','','固定性故障','固定性故障','','','','','','','','','',NULL),(71,'笔记本','HP','1234556','11','间隙性故障','间隙性故障','','','','','','','','','',NULL),(72,'笔记本','MacBookPro','11111','4','固定性故障','固定性故障','','','','','','','','','',NULL),(73,'笔记本','MacBookPro','aaaa','444','固定性故障','固定性故障','','','','','','','','','',NULL),(74,'台式机','123','11','','固定性故障','固定性故障','','','','','','','','','',NULL),(75,'台式机','我操','432','','固定性故障','固定性故障','','','','','','','','','',NULL);
/*!40000 ALTER TABLE `report_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_record`
--

DROP TABLE IF EXISTS `report_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_record` (
  `report_record_no` int(6) NOT NULL AUTO_INCREMENT,
  `customer_idno` varchar(18) DEFAULT NULL,
  `report_equip_no` int(20) DEFAULT NULL,
  `report_time` date DEFAULT NULL,
  `predict_complete_time` date DEFAULT NULL,
  `report_status` varchar(20) DEFAULT NULL,
  `predict_price` int(20) DEFAULT NULL,
  PRIMARY KEY (`report_record_no`),
  KEY `fk_customer_idno` (`customer_idno`),
  KEY `fk_report_equip_no` (`report_equip_no`),
  CONSTRAINT `fk_customer_idno` FOREIGN KEY (`customer_idno`) REFERENCES `customer` (`customer_idno`),
  CONSTRAINT `fk_report_equip_no` FOREIGN KEY (`report_equip_no`) REFERENCES `report_equipment` (`report_equip_no`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_record`
--

LOCK TABLES `report_record` WRITE;
/*!40000 ALTER TABLE `report_record` DISABLE KEYS */;
INSERT INTO `report_record` VALUES (2,'111111111111111111',4,'1111-12-12','1111-12-12','结束',NULL),(3,'123456789012345678',3,'2016-07-02','2016-07-09','',NULL),(4,'123456789012345678',4,'2016-07-02','2016-07-09','',NULL),(5,'123456789012345678',4,'2016-07-02','2016-07-09','',NULL),(6,'123456789012345678',4,'2016-07-02','2016-07-09','',NULL),(10,'123456789012345678',7,'2016-07-02','2016-07-09','',NULL),(11,'123456789012345678',11,'2016-07-02','2016-07-09','',NULL),(12,'123456789012345678',12,'2016-07-02','2016-07-09','',NULL),(13,'123456789012345678',13,'2016-07-02','2016-07-09','',NULL),(15,'123456789012345678',23,'2016-07-02','2016-07-09','',NULL),(16,'123456789012345678',24,'2016-07-02','2016-07-09','',NULL),(17,'123456789012345678',25,'2016-07-02','2016-07-09','',NULL),(18,'123456789012345678',26,'2016-07-02','2016-07-09','',NULL),(19,'123456789012345678',27,'2016-07-02','2016-07-09','',NULL),(20,'123456789012345678',28,'2016-07-02','2016-07-09','',NULL),(21,'123456789012345678',29,'2016-07-02','2016-07-09','',NULL),(22,'123456789012345678',30,'2016-07-02','2016-07-09','',NULL),(23,'123456789012345678',31,'2016-07-02','2016-07-09','',NULL),(24,'123456789012345678',32,'2016-07-02','2016-07-09','',NULL),(25,'123456789012345679',33,'2016-07-09','2016-07-16','',NULL),(26,'123456789012345679',34,'2016-07-02','2016-07-09','',NULL),(27,'123456789012345679',35,'2016-07-02','2016-07-09','',NULL),(28,'123456789012345679',36,'2016-07-02','2016-07-09','',NULL),(29,'123456789012345679',37,'2016-07-02','2016-07-09','',NULL),(30,'123456789012345679',38,'2016-07-02','2016-07-09','',NULL),(31,'123456789012345679',39,'2016-07-02','2016-07-09','',NULL),(32,'123456789012345679',41,'2016-07-02','2016-07-09','',NULL),(33,'123456789012345679',42,'2016-07-02','2016-07-09','',NULL),(34,'123456789012345678',43,'2016-07-02','2016-07-09','',NULL),(35,'123456789012345678',44,'2016-07-02','2016-07-09','',NULL),(36,'123456789012345678',45,'2016-07-02','2016-07-09','',NULL),(37,'123456789012345678',46,'2016-07-02','2016-07-09','',NULL),(38,'123456789012345678',47,'2016-07-02','2016-07-09','',NULL),(39,'123456789012345678',48,'2016-07-02','2016-07-09','',NULL),(40,'123456789012345678',49,'2016-07-02','2016-07-09','',NULL),(41,'123456789012345678',50,'2016-07-02','2016-07-09','',NULL),(42,'123456789012345678',51,'2016-07-02','2016-07-09','',NULL),(43,'123456789012345678',52,'2016-07-02','2016-07-09','',NULL),(44,'123456789012345678',53,'2016-07-02','2016-07-09','',NULL),(45,'123456789012345679',54,'2016-07-09','2016-07-09','',NULL),(46,'123456789012345679',56,'2016-07-28','2016-07-28','',NULL),(47,'123456789012345679',57,'2016-07-28','2016-07-28','',NULL),(48,'123456789012345678',58,'2016-07-28','2016-07-28','',NULL),(49,'123456789012345678',59,'2016-07-28','2016-07-28','',NULL),(50,'123456789012345679',60,'2016-07-28','2016-07-28','',NULL),(51,'123456789012345678',61,'2016-07-31','2016-07-31','',NULL),(52,'123456789012345678',62,'2016-07-31','2016-07-31','',NULL),(53,'123456789012345679',64,'2016-07-31','2016-07-31','',NULL),(54,'123456789012345679',65,'2016-07-31','2016-07-31','',NULL),(55,'123456789012345679',66,'2016-07-31','2016-07-31','',NULL),(56,'123456789012345679',67,'2016-07-31','2016-07-31','',NULL),(58,'111111111111111111',69,'2016-08-01','2016-08-01','',NULL),(59,'111111111111111111',71,'2016-08-01','2016-08-01','',NULL),(61,'230103199608311111',73,'2016-08-01','2016-08-01','',NULL),(62,'123456789012345679',74,'2016-08-01','2016-08-01','',NULL),(63,'123456789012345678',75,'2016-08-01','2016-08-01','',NULL);
/*!40000 ALTER TABLE `report_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `staff_no` int(6) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(20) NOT NULL,
  `staff_password` varchar(12) NOT NULL,
  `staff_character` varchar(20) NOT NULL,
  PRIMARY KEY (`staff_no`),
  UNIQUE KEY `uq_staff_name` (`staff_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'kefu1','5555','客服'),(2,'kefu2','55552','客服'),(3,'kefu3','55552','客服'),(4,'kefu4','55552','客服'),(5,'jishugongchengshi1','55552','技术工程师'),(6,'jishugongchengshi2','55552','技术工程师'),(7,'jishugongchengshi3','55552','技术工程师'),(8,'jishugongchengshi4','55552','技术工程师'),(9,'jishugongchengshi5','55552','技术工程师'),(10,'kuguan1','55552','库管'),(11,'kuguan2','55552','库管'),(12,'kuguan3','55552','库管'),(13,'kuguan4','55552','库管'),(14,'kuguan5','55552','库管'),(15,'caster1','55553','任务调度'),(16,'engineer1','55553','技术工程师'),(17,'admin','admin','运营监督');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-01 19:16:08
