/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : wechat

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 09/05/2019 11:09:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `car_num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_school_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time8_max` int(10) DEFAULT NULL,
  `time8_left` int(10) DEFAULT NULL,
  `time9_max` int(10) DEFAULT NULL,
  `time9_left` int(10) DEFAULT NULL,
  `time10_max` int(10) DEFAULT NULL,
  `time10_left` int(10) DEFAULT NULL,
  `time11_max` int(10) DEFAULT NULL,
  `time11_left` int(10) DEFAULT NULL,
  `time14_max` int(10) DEFAULT NULL,
  `time14_left` int(10) DEFAULT NULL,
  `time15_max` int(10) DEFAULT NULL,
  `time15_left` int(10) DEFAULT NULL,
  `time16_max` int(10) DEFAULT NULL,
  `time16_left` int(10) DEFAULT NULL,
  `time17_max` int(10) DEFAULT NULL,
  `time17_left` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (3, '3', '4', '黄色', '兰博基尼', '开放', 3, 2, 3, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
INSERT INTO `car` VALUES (4, '4', '4', '白色', '帕加尼', '开放', 3, 0, 3, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
INSERT INTO `car` VALUES (6, '6', '5', '黄色', '兰博基尼', '未开放', 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `car` VALUES (7, '7', '6', '红色', '保时捷911', '开放', 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `car` VALUES (8, '8', '6', '红色', '玛莎拉蒂', '开放', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `news` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `school_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `news_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '今日开始练车', '12345678', '发布');
INSERT INTO `news` VALUES (2, '今日开始练车', '4', '未发布');
INSERT INTO `news` VALUES (3, '今日停止练车', '5', '发布');
INSERT INTO `news` VALUES (4, '大家好', '5', '未发布');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `car_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` int(24) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES (2, '2', '王旭', '3', '已预订', 9);

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `school_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `school_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `school_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES (1, '12345678', '湖大驾校', '湖北大学');
INSERT INTO `school` VALUES (4, '7', '学子驾校', '湖北大学忠诚学生公寓');
INSERT INTO `school` VALUES (5, '57', '驾校5', '5号地址');
INSERT INTO `school` VALUES (6, '6', '驾校6', '6号地址');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_school_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', '杨睿', '4');
INSERT INTO `user` VALUES (2, '2', '王旭', '4');
INSERT INTO `user` VALUES (3, '3', '毛逸青', '5');
INSERT INTO `user` VALUES (4, '4', '吴大城', '5');

SET FOREIGN_KEY_CHECKS = 1;
