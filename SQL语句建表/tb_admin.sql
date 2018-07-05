/*
MySQL Data Transfer
Source Host: localhost
Source Database: studb
Target Host: localhost
Target Database: studb
Date: 2018/7/4 19:58:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `pwd` varchar(255) NOT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('123456', 'liming');
INSERT INTO `tb_admin` VALUES ('123', 'tina');
