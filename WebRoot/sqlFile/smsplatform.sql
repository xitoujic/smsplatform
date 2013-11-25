/*
Navicat MySQL Data Transfer

Source Server         : hanphon
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : smsplatform

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2013-11-07 16:05:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_domain
-- ----------------------------
DROP TABLE IF EXISTS `user_domain`;
CREATE TABLE `user_domain` (
  `usrID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`usrID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_domain
-- ----------------------------
INSERT INTO `user_domain` VALUES ('1', '1033761115@qq.com', '11', '1', '1');
INSERT INTO `user_domain` VALUES ('8', '1033761115@qq.com', '2', '2', '2');
INSERT INTO `user_domain` VALUES ('9', '1033761115@qq.com', '3', '3', '3');
INSERT INTO `user_domain` VALUES ('11', '4', '4', '4', '4');
