/*
MySQL Data Transfer
Source Host: localhost
Source Database: studb
Target Host: localhost
Target Database: studb
Date: 2018/7/4 19:58:04
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cno` varchar(255) NOT NULL DEFAULT '',
  `cname` varchar(255) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `cname` (`cname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `course` VALUES ('01', 'JAVA', '3');
INSERT INTO `course` VALUES ('02', '数据库', '4');
INSERT INTO `course` VALUES ('03', '操作系统', '3');
