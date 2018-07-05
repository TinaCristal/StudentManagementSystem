/*
MySQL Data Transfer
Source Host: localhost
Source Database: studb
Target Host: localhost
Target Database: studb
Date: 2018/7/4 19:58:15
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `id` varchar(20) NOT NULL,
  `cno` varchar(255) NOT NULL DEFAULT '',
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`cno`),
  KEY `cno` (`cno`),
  CONSTRAINT `cno` FOREIGN KEY (`cno`) REFERENCES `course` (`cno`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sc` VALUES ('1', '01', '67');
INSERT INTO `sc` VALUES ('1', '02', '50');
INSERT INTO `sc` VALUES ('1', '03', '62');
INSERT INTO `sc` VALUES ('2', '02', '30');
INSERT INTO `sc` VALUES ('3', '01', '4');
INSERT INTO `sc` VALUES ('3', '02', '89');
INSERT INTO `sc` VALUES ('3', '03', '60');
INSERT INTO `sc` VALUES ('4', '01', '80');
INSERT INTO `sc` VALUES ('5', '01', '97');
INSERT INTO `sc` VALUES ('6', '01', '100');
