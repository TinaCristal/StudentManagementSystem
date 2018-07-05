/*
MySQL Data Transfer
Source Host: localhost
Source Database: studb
Target Host: localhost
Target Database: studb
Date: 2018/7/4 19:58:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(20) NOT NULL DEFAULT '',
  `age` int(5) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `year` int(5) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  `political` varchar(20) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `record` varchar(20) DEFAULT NULL,
  `flag` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `student` VALUES ('1', '22', 'Tina', '女', '4', '江苏', 'CS', '团员', '汉族', '无', '无');
INSERT INTO `student` VALUES ('2', '21', '周八', '男', '3', '湖北', 'English', '无', '回族', '奖励', '无');
INSERT INTO `student` VALUES ('3', '20', '张三', '男', '4', '内蒙古', 'CS', '团员', '汉族', '无', '无');
INSERT INTO `student` VALUES ('4', '21', '李四', '男', '4', '江苏', 'CS', '党员', '回族', '记过', '转学');
INSERT INTO `student` VALUES ('5', '19', '王五', '5', '5', '江苏', 'English', '团员', '汉族', '无', '无');
INSERT INTO `student` VALUES ('6', '20', '赵七', '女', '3', '湖北', 'Chinese', '无', '汉族', '奖励', '无');
