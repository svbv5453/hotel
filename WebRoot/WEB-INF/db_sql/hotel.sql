/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.36 : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotel`;

/*Table structure for table `dinnertable` */

DROP TABLE IF EXISTS `dinnertable`;

CREATE TABLE `dinnertable` (
  `tId` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` varchar(20) DEFAULT NULL,
  `tableStatus` int(11) DEFAULT '0',
  `reservationTime` datetime DEFAULT NULL,
  PRIMARY KEY (`tId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dinnertable` */

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `foodName` varchar(20) DEFAULT NULL,
  `ftId` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `vPrice` double DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`fId`),
  KEY `food_foodType_id` (`ftId`),
  CONSTRAINT `food_foodType_id` FOREIGN KEY (`ftId`) REFERENCES `foodtype` (`ftId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`fId`,`foodName`,`ftId`,`price`,`vPrice`,`remark`,`img`) values (1,'回锅肉',1,25,22,'好吃不贵','回锅肉.jpg'),(2,'水煮肉片',1,35,22,'好辣呀','水煮肉片.jpg'),(6,'水煮鱼',1,36,33,'川味美食，好吃不贵','水煮鱼1.jpg');

/*Table structure for table `foodtype` */

DROP TABLE IF EXISTS `foodtype`;

CREATE TABLE `foodtype` (
  `ftId` int(11) NOT NULL AUTO_INCREMENT,
  `ftName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ftId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `foodtype` */

insert  into `foodtype`(`ftId`,`ftName`) values (1,'川菜'),(2,'鲁菜'),(3,'粤菜'),(4,'浙菜'),(5,'徽菜'),(6,'苏菜'),(7,'湘菜'),(8,'闽菜');

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `odId` int(11) NOT NULL AUTO_INCREMENT,
  `oId` int(11) DEFAULT NULL,
  `fId` int(11) DEFAULT NULL,
  `foodCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`odId`),
  KEY `orderDetail_orders_id` (`oId`),
  KEY `orderDetail_food_id` (`fId`),
  CONSTRAINT `orderDetail_food_id` FOREIGN KEY (`fId`) REFERENCES `food` (`fId`),
  CONSTRAINT `orderDetail_orders_id` FOREIGN KEY (`oId`) REFERENCES `orders` (`oId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderdetail` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oId` int(11) NOT NULL AUTO_INCREMENT,
  `tId` int(11) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `orderStatus` int(11) DEFAULT '0',
  PRIMARY KEY (`oId`),
  KEY `orders_table_id` (`tId`),
  CONSTRAINT `orders_table_id` FOREIGN KEY (`tId`) REFERENCES `dinnertable` (`tId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
