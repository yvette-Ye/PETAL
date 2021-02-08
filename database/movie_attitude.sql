/*
Navicat MySQL Data Transfer

Source Server         : Valar
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : petal2

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-12-07 16:40:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for movie_attitude
-- ----------------------------
DROP TABLE IF EXISTS `movie_attitude`;
CREATE TABLE `movie_attitude` (
  `id` varchar(255) NOT NULL COMMENT 'id 主键自增',
  `userid` varchar(255) NOT NULL,
  `movieid` varchar(255) NOT NULL,
  `wanna` int NOT NULL DEFAULT '0' COMMENT '是否想看 默认为0，1代表想看',
  `seen` int NOT NULL DEFAULT '0' COMMENT '是否看过 0代表没看过 1代表看过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie_attitude
-- ----------------------------
INSERT INTO `movie_attitude` VALUES ('24eeebf9-fd55-4d74-bd1f-417efb1c6f46', '1', '3169043', '0', '1');
INSERT INTO `movie_attitude` VALUES ('39a875ab-57af-4039-928e-19184663c002', '1', '1293460', '1', '0');
INSERT INTO `movie_attitude` VALUES ('3b01ee12-26ca-49c1-bd8a-df6c35ef6f01', '1', '1299204', '1', '0');
INSERT INTO `movie_attitude` VALUES ('4686b66e-2ded-4f99-acab-e2d310451c96', '7ba95cde-90b1-4cee-a447-a3fc9c61191a', '1308046', '1', '0');
INSERT INTO `movie_attitude` VALUES ('4b1b36cf-2f62-48ac-95f2-bff187d27ba7', '1', '2240587', '1', '0');
INSERT INTO `movie_attitude` VALUES ('4f69fb6b-abc7-4e26-8649-f126c2446739', '1', '1302022', '1', '0');
INSERT INTO `movie_attitude` VALUES ('63e261cc-833e-427a-80d3-ab1527503345', '7ba95cde-90b1-4cee-a447-a3fc9c61191a', '1297756', '1', '0');
INSERT INTO `movie_attitude` VALUES ('803f865d-0193-438d-bb5b-1a8530c2fd31', '1', '1419958', '1', '0');
INSERT INTO `movie_attitude` VALUES ('9003a534-c60a-474e-87c0-6c0fa487350c', '1', '2067505', '0', '1');
INSERT INTO `movie_attitude` VALUES ('b40c3654-9609-4e14-a629-be518922e796', '1', '3169043', '1', '0');
INSERT INTO `movie_attitude` VALUES ('c188ea6b-6565-4da0-9ce9-247e475bed86', '7ba95cde-90b1-4cee-a447-a3fc9c61191a', '1945337', '1', '0');
INSERT INTO `movie_attitude` VALUES ('db07495f-4c20-4d79-a6e8-862748d45914', '7ba95cde-90b1-4cee-a447-a3fc9c61191a', '1293798', '1', '0');
INSERT INTO `movie_attitude` VALUES ('f937f3c4-2041-4576-8283-e23f473c8a48', '7ba95cde-90b1-4cee-a447-a3fc9c61191a', '1310179', '1', '0');
