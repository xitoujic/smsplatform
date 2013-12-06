/*
Navicat MySQL Data Transfer

Source Server         : hanphon
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : smsplatform

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2013-12-06 10:15:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_bd_log
-- ----------------------------
DROP TABLE IF EXISTS `t_bd_log`;
CREATE TABLE `t_bd_log` (
  `F_logID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `F_userID` bigint(20) NOT NULL,
  `F_befor` varchar(50) DEFAULT NULL,
  `F_operate` varchar(50) DEFAULT NULL,
  `F_after` varchar(50) DEFAULT NULL,
  `F_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`F_logID`),
  KEY `User_Log` (`F_userID`) USING BTREE,
  KEY `FK60613FF2140B6C42` (`F_userID`),
  CONSTRAINT `FK60613FF2140B6C42` FOREIGN KEY (`F_userID`) REFERENCES `t_bd_user` (`F_UserID`),
  CONSTRAINT `t_bd_log_ibfk_1` FOREIGN KEY (`F_userID`) REFERENCES `t_bd_user` (`F_UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_bd_log
-- ----------------------------
INSERT INTO `t_bd_log` VALUES ('00000000000000000001', '1', null, null, null, '2013-12-05 09:03:07');
INSERT INTO `t_bd_log` VALUES ('00000000000000000002', '2', null, null, null, '2013-12-05 09:05:01');

-- ----------------------------
-- Table structure for t_bd_messagesend
-- ----------------------------
DROP TABLE IF EXISTS `t_bd_messagesend`;
CREATE TABLE `t_bd_messagesend` (
  `F_MessageID` bigint(20) NOT NULL,
  `F_SendGroupID` bigint(20) NOT NULL,
  `F_SendNumber` varchar(20) NOT NULL,
  `F_SendStatus` varchar(4) DEFAULT NULL,
  `F_SendCostStatus` varchar(4) DEFAULT NULL,
  `F_MessageStatus` varchar(4) DEFAULT NULL,
  `F_Operator` varchar(20) DEFAULT NULL,
  `F_NumberArea` varchar(20) DEFAULT NULL,
  `F_SendTime` datetime NOT NULL,
  PRIMARY KEY (`F_MessageID`),
  KEY `FKD78A82BDA813DD21` (`F_SendGroupID`),
  CONSTRAINT `FKD78A82BDA813DD21` FOREIGN KEY (`F_SendGroupID`) REFERENCES `t_bd_messagesendgroup` (`F_SendGroupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bd_messagesend
-- ----------------------------

-- ----------------------------
-- Table structure for t_bd_messagesendgroup
-- ----------------------------
DROP TABLE IF EXISTS `t_bd_messagesendgroup`;
CREATE TABLE `t_bd_messagesendgroup` (
  `F_SendGroupID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_UserID` bigint(20) NOT NULL,
  `F_GroupType` varchar(10) NOT NULL,
  `F_SubmitType` varchar(20) DEFAULT NULL,
  `F_GroupSendStatus` varchar(20) DEFAULT NULL,
  `F_GroupPhoneNum` bigint(20) DEFAULT NULL,
  `F_GroupContent` varchar(200) DEFAULT NULL,
  `F_GroupSendTime` datetime DEFAULT NULL,
  `F_GroupPhones` text,
  PRIMARY KEY (`F_SendGroupID`),
  KEY `FK6D1BA1E2140B6C42` (`F_UserID`),
  CONSTRAINT `FK6D1BA1E2140B6C42` FOREIGN KEY (`F_UserID`) REFERENCES `t_bd_user` (`F_UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bd_messagesendgroup
-- ----------------------------
INSERT INTO `t_bd_messagesendgroup` VALUES ('1', '1', '1', '1', null, null, null, null, null);
INSERT INTO `t_bd_messagesendgroup` VALUES ('2', '1', '1', '2', null, null, null, null, null);
INSERT INTO `t_bd_messagesendgroup` VALUES ('3', '1', '2', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_bd_rechargeandconsumption
-- ----------------------------
DROP TABLE IF EXISTS `t_bd_rechargeandconsumption`;
CREATE TABLE `t_bd_rechargeandconsumption` (
  `F_RcgAndCuptID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_UserID` bigint(20) NOT NULL,
  `F_BeforeRechargeMoney` double DEFAULT '0',
  `F_RechargeMoney` double DEFAULT '0',
  `F_AfterRechargeMoney` double DEFAULT '0',
  `F_BeforeRechargeNum` bigint(20) DEFAULT '0',
  `F_RechargeNum` bigint(20) DEFAULT '0',
  `F_AfterRechargeNum` bigint(20) DEFAULT '0',
  `F_BeforeConsumpteMoney` double DEFAULT '0',
  `F_ConsumpteMoney` double DEFAULT '0',
  `F_AfterConsumpteMoney` double DEFAULT '0',
  `F_BeforeConsumpteNum` bigint(20) DEFAULT '0',
  `F_ConsumpteNum` bigint(20) DEFAULT '0',
  `F_AfterConsumpteNum` bigint(20) DEFAULT '0',
  `F_OperateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `F_OperateType` varchar(4) DEFAULT '--',
  PRIMARY KEY (`F_RcgAndCuptID`),
  KEY `FKB8EFA45D140B6C42` (`F_UserID`),
  CONSTRAINT `FKB8EFA45D140B6C42` FOREIGN KEY (`F_UserID`) REFERENCES `t_bd_user` (`F_UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bd_rechargeandconsumption
-- ----------------------------
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('1', '1', null, null, null, null, null, null, null, null, null, null, null, null, '2013-11-28 14:20:40', '1');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('2', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2013-12-04 19:52:37', '--');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('3', '2', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2013-12-04 20:09:57', '--');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('5', '28', null, null, null, null, null, null, null, null, null, null, null, null, '2013-12-04 20:34:08', '消费');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('6', '29', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2013-12-04 20:37:39', '消费');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('7', '1', '0', '0', '200', '0', '0', '500', '0', '0', '0', '0', '0', '0', '2013-12-04 21:32:21', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('8', '1', '0', '0', '200', '0', '0', '500', '0', '0', '0', '0', '0', '0', '2013-12-04 21:38:09', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('9', '1', '100', '0', '300', '250', '0', '750', '0', '0', '0', '0', '0', '0', '2013-12-04 21:38:20', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('10', '2', '0', '100', '100', '0', '0', '250', '0', '0', '0', '0', '0', '0', '2013-12-04 21:46:53', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('11', '2', '0', '100', '100', '0', '0', '250', '0', '0', '0', '0', '0', '0', '2013-12-04 21:49:43', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('12', '2', '100', '100', '200', '250', '0', '500', '0', '0', '0', '0', '0', '0', '2013-12-04 21:51:39', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('13', '2', '200', '500', '300', '500', '0', '750', '0', '0', '0', '0', '0', '0', '2013-12-04 21:52:28', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('14', '2', '300', '0', '800', '750', '0', '2000', '0', '0', '0', '0', '0', '0', '2013-12-04 21:53:27', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('15', '2', '800', '500', '1300', '2000', '0', '3250', '0', '0', '0', '0', '0', '0', '2013-12-04 21:54:59', '充值');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('16', '46', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2013-12-05 16:38:54', '--');
INSERT INTO `t_bd_rechargeandconsumption` VALUES ('17', '47', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2013-12-05 16:50:50', '--');

-- ----------------------------
-- Table structure for t_bd_user
-- ----------------------------
DROP TABLE IF EXISTS `t_bd_user`;
CREATE TABLE `t_bd_user` (
  `F_UserID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_UserName` varchar(50) NOT NULL,
  `F_UserFullName` varchar(50) DEFAULT NULL,
  `F_Password` varchar(50) NOT NULL,
  `F_PhoneNumber` varchar(20) DEFAULT NULL,
  `F_Sex` varchar(4) DEFAULT '男',
  `F_Role` varchar(20) NOT NULL,
  `F_CompanyType` varchar(50) DEFAULT NULL,
  `F_CheckType` varchar(1) DEFAULT NULL COMMENT '1是 2 否',
  `F_Signature` varchar(100) DEFAULT NULL,
  `F_SignatureFlag` varchar(20) DEFAULT NULL,
  `F_Urgent` varchar(4) DEFAULT '正常' COMMENT '1 加急  2 正常',
  `F_UpdateStatus` varchar(4) DEFAULT '未修改' COMMENT '1 已修改 2 未修改',
  `F_Right` varchar(4) DEFAULT '合法' COMMENT '1  合法  2  黑名单',
  `F_DeductScale` int(11) DEFAULT '100',
  `F_Email` varchar(50) DEFAULT NULL,
  `F_MessageNumber` bigint(20) DEFAULT '0',
  `F_Money` decimal(8,2) DEFAULT '0.00',
  `F_UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`F_UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bd_user
-- ----------------------------
INSERT INTO `t_bd_user` VALUES ('1', 'yes', 'nice', '111', '18952478547', null, '1', 'ysdf', null, null, null, null, null, null, null, '4255871115@qq.com', '0', '0.00', '2013-12-06 08:41:52');
INSERT INTO `t_bd_user` VALUES ('2', 'ni', 'ni', 'ni', null, null, '3', null, null, null, null, null, null, null, null, null, '3250', '1300.00', null);
INSERT INTO `t_bd_user` VALUES ('3', 'FUserName', 'FUserFullName', 'FPassword', null, '1', 'FRole', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('28', 'd', null, 'd', null, null, '普通用户', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('29', 'd', null, 'd', null, null, '普通用户', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('30', 'sdf', null, 'ddfd', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('31', 'sdf', null, 'ddfd', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('32', 'cx', null, 'sds', null, null, '普通用户', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('33', 'wq', null, 'wq', null, null, '管理员', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('34', 'ad', null, 'ad', null, null, '管理员', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('35', 'as', null, 'sds', null, '男', '普通用户', null, null, null, null, '正常', '已修改', null, null, null, null, null, '2013-12-05 17:16:10');
INSERT INTO `t_bd_user` VALUES ('36', 'nice', null, 'nice', null, '男', '普通用户', null, null, null, null, '正常', '已修改', '合法', null, null, null, null, '2013-12-05 17:17:21');
INSERT INTO `t_bd_user` VALUES ('37', 'nice1', null, 'nice', null, '男', '管理员', null, null, null, null, '正常', '未修改', '合法', null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('38', 'nice1', null, 'nice', null, '男', '管理员', null, null, null, null, '正常', '未修改', '合法', null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('39', 'nice3', null, 'nice', null, '男', '管理员', null, null, null, null, '正常', '未修改', '合法', null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('40', 'nice3', null, 'nice', null, '男', '管理员', null, null, null, null, '正常', '未修改', '合法', null, null, null, null, null);
INSERT INTO `t_bd_user` VALUES ('41', 'dfd', null, 'df', null, '男', '普通用户', null, null, null, null, '正常', '未修改', '合法', null, null, '0', '0.00', '2013-12-05 09:11:03');
INSERT INTO `t_bd_user` VALUES ('42', 'hah', null, 'uu', null, '男', '普通用户', null, null, null, null, '正常', '未修改', '合法', null, null, '0', '0.00', '2013-12-05 16:31:16');
INSERT INTO `t_bd_user` VALUES ('43', 'hah', null, 'uu', null, '男', '普通用户', null, null, null, null, '正常', '未修改', '合法', null, null, '0', '0.00', '2013-12-05 16:34:57');
INSERT INTO `t_bd_user` VALUES ('44', 'hah', null, 'uu', null, '男', '普通用户', null, null, null, null, '正常', '未修改', '合法', null, null, '0', '0.00', '2013-12-05 16:35:30');
INSERT INTO `t_bd_user` VALUES ('45', 'hah', null, 'uu', null, '男', '普通用户', null, null, null, null, '正常', '未修改', '合法', null, null, '0', '0.00', '2013-12-05 16:37:21');
INSERT INTO `t_bd_user` VALUES ('46', 'hah', null, 'uu', null, '男', '普通用户', null, null, null, null, '正常', '未修改', '合法', null, null, '0', '0.00', '2013-12-05 16:38:54');
INSERT INTO `t_bd_user` VALUES ('47', 'hah', null, 'uu', null, '男', '普通用户', null, null, null, null, '正常', '未修改', '合法', null, null, '0', '0.00', '2013-12-05 16:50:50');
