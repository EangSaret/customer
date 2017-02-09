/*
SQLyog Ultimate v8.3 
MySQL - 5.6.20-log : Database - customer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`customer` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `customer`;

/*Table structure for table `tb_customer` */

DROP TABLE IF EXISTS `tb_customer`;

CREATE TABLE `tb_customer` (
  `cus_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cus_first_name` varchar(100) DEFAULT NULL,
  `cus_last_name` varchar(100) DEFAULT NULL,
  `cus_sex` varchar(10) DEFAULT NULL,
  `cus_email_address` varchar(255) DEFAULT NULL,
  `cus_dob` date DEFAULT NULL,
  `cus_address` varchar(255) DEFAULT NULL,
  `cus_phone_number` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `date_updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `tb_customer` */

insert  into `tb_customer`(`cus_id`,`cus_first_name`,`cus_last_name`,`cus_sex`,`cus_email_address`,`cus_dob`,`cus_address`,`cus_phone_number`,`date_created`,`date_updated`) values (4,'Phinath','Heng','Male','phinath63@gmail.com','1991-08-01','Phnom Penh','070361121','2017-02-04 20:47:53','2017-02-04 20:47:53'),(5,'Thay','Mardy','Female','mardy@gmail.com','1991-08-01','Phnom Penh','012730816',NULL,NULL),(10,'Chandara','Chhun','Male','chandara@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(11,'Chandara','Chhun','Male','chandara@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(12,'Phinath','Heng','Male','phinath@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(13,'Phinath','Heng','Male','phinath@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(14,'Phinath','Heng','Male','phinath@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(15,'Phinath','Heng','Male','phinath@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(16,'Phinath','Heng','Male','phinath@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(17,'Phinath','Heng','Male','phinath@gmail.com','1991-08-01','Phnom Penh','098262716',NULL,NULL),(19,'Auth','Phnath','Male','da@gmail.com','2016-11-15','Svay Reing','089362637','2017-02-06 10:31:24','2017-02-06 10:31:24'),(20,'Phearom','Phann','Male','phearom@gmail.com','1991-02-27','Soung','012987523',NULL,NULL);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`username`,`password`) values ('admin','admin'),('user','user');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
