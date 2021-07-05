/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : ssmbuild

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 08/12/2020 13:01:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `bookID` int(0) NOT NULL AUTO_INCREMENT COMMENT '书ID',
  `bookName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `bookCounts` int(0) NOT NULL COMMENT '数量',
  `detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  INDEX `bookID`(`bookID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, 'Java', 1, '从入门到放弃');
INSERT INTO `books` VALUES (2, 'python', 10, '从入门到入土');
INSERT INTO `books` VALUES (3, 'MySQL', 5, '从入门到跑路');

SET FOREIGN_KEY_CHECKS = 1;
