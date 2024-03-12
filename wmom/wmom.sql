/*
 Navicat Premium Data Transfer

 Source Server         : 117.78.10.32
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 117.78.10.32:3306
 Source Schema         : wmom

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 15/12/2020 23:02:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created` datetime(6) NULL DEFAULT NULL,
  `deleted` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('26ddeacd2d2f4c9b9dc83643a5e4c358', '29f3be4f836b43a6aa1efee0aefb8e7d', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-26 00:00:00.000000', '2020-10-27 21:35:52.000000');
INSERT INTO `cart` VALUES ('2dc9c121a24f42a1b86501ed25a1d4b3', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-22 00:00:00.000000', '2020-10-30 01:30:28.000000');
INSERT INTO `cart` VALUES ('396ebe3c8264447aaa47f52fc9db3a0e', 'aba976db50e341798c9fc815fcdcf8eb', 'a98260bc50834d63920922ced61333a9', '2020-11-19 00:00:00.000000', '2020-11-19 17:41:22.000000');
INSERT INTO `cart` VALUES ('448ea69384124d64afbc2f8badb82a95', '2d3d4d7521b545f7a196e18e5a53ff74', 'a98260bc50834d63920922ced61333a9', '2020-10-25 00:00:00.000000', '2020-11-19 12:08:31.000000');
INSERT INTO `cart` VALUES ('463781973c5b4725a3b5890fb42911d6', '2d3d4d7521b545f7a196e18e5a53ff74', 'a98260bc50834d63920922ced61333a9', '2020-11-19 00:00:00.000000', '2020-11-19 12:08:31.000000');
INSERT INTO `cart` VALUES ('60257093c65849d78c9be30d619fe282', 'b7405893f1a048a0b60982b0fbb6e207', 'a98260bc50834d63920922ced61333a9', '2020-10-30 00:00:00.000000', '2020-11-19 17:41:22.000000');
INSERT INTO `cart` VALUES ('742c97b960dd47c98c52d154f164ef20', 'd51db31e414045ad982f088b6f5f11fd', 'a98260bc50834d63920922ced61333a9', '2020-10-20 00:00:00.000000', '2020-10-20 12:00:40.000000');
INSERT INTO `cart` VALUES ('7488ab8f6847413683ed8f207a277554', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-20 00:00:00.000000', '2020-10-25 16:48:06.000000');
INSERT INTO `cart` VALUES ('7562df5b5586495698e33425676e350a', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-20 00:00:00.000000', '2020-10-25 16:48:06.000000');
INSERT INTO `cart` VALUES ('7953a4116a1e4403a835de13eafb3540', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-21 00:00:00.000000', '2020-10-25 16:48:06.000000');
INSERT INTO `cart` VALUES ('7c03895b09cb4d9980416a1ee9fdd607', '16588169bcde4c9fbc7a109619f87e4c', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-21 00:00:00.000000', '2020-10-24 20:27:07.000000');
INSERT INTO `cart` VALUES ('7e9853393f794fc7a146f72633f97a23', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-30 00:00:00.000000', '2020-10-30 01:30:28.000000');
INSERT INTO `cart` VALUES ('8092709ff25d47b4ae14deb5e5e04776', 'd51db31e414045ad982f088b6f5f11fd', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-21 01:24:29.000000');
INSERT INTO `cart` VALUES ('822e3b89e21347118bd5d1806ff7c6c2', 'd51db31e414045ad982f088b6f5f11fd', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-21 01:24:29.000000');
INSERT INTO `cart` VALUES ('89087bab1e1a4c779ad7ce417b4b6739', '2d3d4d7521b545f7a196e18e5a53ff74', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-20 17:43:40.000000');
INSERT INTO `cart` VALUES ('98beb5ed2cc04a54b661849101adae7e', 'c563dc5a7f194c48b76da3bb6e0a0ad3', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-27 00:00:00.000000', '2020-10-27 21:35:57.000000');
INSERT INTO `cart` VALUES ('9aab7afe98d449f2b18ee88cff7bb8b5', 'f83f49994cdd4364abbcccaa4bff2c9d', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-20 00:00:00.000000', '2020-10-20 17:47:46.000000');
INSERT INTO `cart` VALUES ('a1acc08581d94445be7ba500412a29d3', 'e8360ffbecd049a8b7d43ec8016cfebb', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-19 18:24:33.000000');
INSERT INTO `cart` VALUES ('a69b6c569a5e45fa8768891571405da8', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-21 00:00:00.000000', '2020-10-30 01:30:28.000000');
INSERT INTO `cart` VALUES ('a8d4ca6a48044d378ef722b82790d2d7', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-25 16:48:06.000000');
INSERT INTO `cart` VALUES ('aa9d88cd048b4b29ad8666b87e40f5fd', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-21 00:00:00.000000', '2020-10-25 16:48:06.000000');
INSERT INTO `cart` VALUES ('adbd8f8a6f814057a72040316b3af139', '15bfd9e0b70b410981e46cea056e89ac', 'a98260bc50834d63920922ced61333a9', '2020-11-29 00:00:00.000000', '2020-11-29 14:53:13.000000');
INSERT INTO `cart` VALUES ('b324189af1aa4137b6e853198f451d22', '15bfd9e0b70b410981e46cea056e89ac', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-25 00:00:00.000000', '2020-10-25 18:03:12.000000');
INSERT INTO `cart` VALUES ('b621b88650054d88b313e5bfbb16facc', '2d3d4d7521b545f7a196e18e5a53ff74', 'a98260bc50834d63920922ced61333a9', '2020-10-20 00:00:00.000000', '2020-11-19 12:08:31.000000');
INSERT INTO `cart` VALUES ('ba4462656a3440e782a7180d8efebdd1', 'd51db31e414045ad982f088b6f5f11fd', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-21 00:00:00.000000', '2020-10-21 01:24:29.000000');
INSERT INTO `cart` VALUES ('bb848aa9614d4ab692e74dfc1317d320', 'f83f49994cdd4364abbcccaa4bff2c9d', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-20 17:47:46.000000');
INSERT INTO `cart` VALUES ('c63ce72813724e5aab883021c71262b5', '15bfd9e0b70b410981e46cea056e89ac', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-20 00:00:00.000000', '2020-10-25 18:03:12.000000');
INSERT INTO `cart` VALUES ('c92f96cde41846d29e4ec69a6dab25ff', 'b7405893f1a048a0b60982b0fbb6e207', 'a98260bc50834d63920922ced61333a9', '2020-11-19 00:00:00.000000', '2020-11-19 17:41:22.000000');
INSERT INTO `cart` VALUES ('cbfd61f60bef4d0ab80e24272b44050c', '15bfd9e0b70b410981e46cea056e89ac', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-25 18:03:12.000000');
INSERT INTO `cart` VALUES ('cf3e1afd1ba34f6ca50f9ee8e2e010ec', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-25 16:48:06.000000');
INSERT INTO `cart` VALUES ('d6891a19d8104c7d8aeb081679971760', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-30 01:30:28.000000');
INSERT INTO `cart` VALUES ('dbb7093e24094b0498699720bc5ce483', '2d3d4d7521b545f7a196e18e5a53ff74', 'a98260bc50834d63920922ced61333a9', '2020-10-20 00:00:00.000000', '2020-11-19 12:08:31.000000');
INSERT INTO `cart` VALUES ('ec7b90650d90486eaa75a27c5cf4deb5', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', '2020-11-04 00:00:00.000000', NULL);
INSERT INTO `cart` VALUES ('edd18c847edb4a708c1c1faa83dd13b3', 'e8360ffbecd049a8b7d43ec8016cfebb', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-19 18:24:33.000000');
INSERT INTO `cart` VALUES ('f20b9c0ea0a54d90bcfc820a75f294bc', '2d3d4d7521b545f7a196e18e5a53ff74', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-20 00:00:00.000000', '2020-10-20 17:43:40.000000');
INSERT INTO `cart` VALUES ('f36081f7c341495489b5ec9a355b3aa4', 'd51db31e414045ad982f088b6f5f11fd', '05546b24af2f4d45a6f9c3570534de0f', '2020-10-19 00:00:00.000000', '2020-10-21 01:24:29.000000');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created` datetime(6) NULL DEFAULT NULL,
  `deleted` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('17a1cb46108142618ad8df521eeae642', '8362a1f331174058895508c70d4be59f', 'xueyuan', '这个辣条好辣！', '2020-10-30 00:00:00.000000', NULL);
INSERT INTO `comment` VALUES ('20f7549307fe4dfbb72d5e8da3442fe7', '2d3d4d7521b545f7a196e18e5a53ff74', 'xbt', '可以', '2020-11-20 00:00:00.000000', NULL);
INSERT INTO `comment` VALUES ('6ed55a5c7f154628b17ffcb0274f9481', 'b7405893f1a048a0b60982b0fbb6e207', 'xueyuan', '这个mysql非常的nice', '2020-10-30 00:00:00.000000', NULL);
INSERT INTO `comment` VALUES ('ba4784a27422488e83c324f91d9cb527', '29f3be4f836b43a6aa1efee0aefb8e7d', 'xueyuan', '123456', '2020-10-30 00:00:00.000000', NULL);
INSERT INTO `comment` VALUES ('c4bda9ccb09d4c0d9a8be58c29481279', '2d3d4d7521b545f7a196e18e5a53ff74', 'xbt', '1215\n', '2020-12-15 00:00:00.000000', NULL);
INSERT INTO `comment` VALUES ('c9a7f34d1615447ba5ceac793e7f1fee', '2d3d4d7521b545f7a196e18e5a53ff74', 'xbt', '小裙子真好看！！！', '2020-11-19 00:00:00.000000', NULL);
INSERT INTO `comment` VALUES ('ddf3dad33e5a431bb7e5285b17660987', 'b7405893f1a048a0b60982b0fbb6e207', 'xueyuan', '这个mysql不错，讲的不错！敲代码起来没问题！', '2020-10-30 00:00:00.000000', NULL);
INSERT INTO `comment` VALUES ('defa27d68f344d2a991e6de3c8b855ac', 'b7405893f1a048a0b60982b0fbb6e207', 'xueyuan', '用了几天 发现这个书非常好！', '2020-10-30 00:00:00.000000', NULL);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created` datetime(6) NULL DEFAULT NULL,
  `deleted` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('4931d94bd2ad4b359abfdc75538cb030', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '王建林', '2020-10-14 17:04:14.000000', NULL);
INSERT INTO `manager` VALUES ('6da21bcb19054021b22da27b754d1b9c', 'tom', 'e10adc3949ba59abbe56e057f20f883e', '汤姆猫', '2020-10-14 21:44:51.000000', NULL);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` int(10) NULL DEFAULT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `created` datetime(6) NULL DEFAULT NULL,
  `deleted` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('0d600186cb054d28a295b9211ba35921', 'da05b2dda48042dd8e5e44aa41a59619', 'a98260bc50834d63920922ced61333a9', 5, '小白兔的家', 0, '2020-11-28 00:00:00.000000', '2020-11-28 10:51:37.000000');
INSERT INTO `order` VALUES ('10b285e3165e4ea1b92ce29260fdb398', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 0, '2020-11-04 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('1289957cfd784ead92745513fb97c894', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-24 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('1e0d054470df4b81ab89f680fdf3f562', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 7, '四川省广安市广安区滨江东路98号', 0, '2020-11-04 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('216c2bfa83924a86995e90b48a840cd1', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 0, '2020-11-04 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('24c69d956d5640d2ab55379577381454', 'd426ee2de2214947b2149daa61b7aef0', '05546b24af2f4d45a6f9c3570534de0f', 6, '四川省广安市广安区滨江东路98号', 1, '2020-10-25 00:00:00.000000', '2020-10-26 20:32:22.000000');
INSERT INTO `order` VALUES ('25386dcef0d144cba4496dd6661986ab', '16588169bcde4c9fbc7a109619f87e4c', '05546b24af2f4d45a6f9c3570534de0f', 6, '四川省广安市广安区滨江东路98号', 2, '2020-10-24 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('2dcaecf1e1424d87954189beace39d48', 'b7405893f1a048a0b60982b0fbb6e207', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-19 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('345bdff794a4407eb1d4cc8c2e6a45b3', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-22 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('3627d39602614a6fb3b63d754f099d33', 'b489f8f16ee148a384fe32a7a035d389', '05546b24af2f4d45a6f9c3570534de0f', 5, '四川省广安市广安区滨江东路98号', 2, '2020-10-20 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('3f494035a5cc4ed29af69fc0c1e99f54', 'b7405893f1a048a0b60982b0fbb6e207', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-19 00:00:00.000000', '2020-11-19 17:41:53.000000');
INSERT INTO `order` VALUES ('41a6a413226b4b40bcf2d94554ae7107', '20dde4e8872543a48c17f0e4903e6ed6', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 1, '2020-11-04 00:00:00.000000', '2020-11-04 00:59:17.000000');
INSERT INTO `order` VALUES ('486fceba108d44a0ac27c58e95098543', 'c563dc5a7f194c48b76da3bb6e0a0ad3', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 1, '2020-10-27 00:00:00.000000', '2020-10-27 21:36:26.000000');
INSERT INTO `order` VALUES ('5b60c19f1e10435991ae707519ce1121', 'd51db31e414045ad982f088b6f5f11fd', '05546b24af2f4d45a6f9c3570534de0f', 20, '四川省广安市广安区滨江东路98号', 2, '2020-10-21 00:00:00.000000', '2020-10-21 13:04:31.000000');
INSERT INTO `order` VALUES ('6366324ba36b4113b373d3d261fa91ae', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 0, '2020-10-20 00:00:00.000000', '2020-10-26 20:34:14.000000');
INSERT INTO `order` VALUES ('645672a942b5404989f8439a60bf0d30', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 1, '2020-10-21 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('647d0db9d01140dc8da52eacd096e79f', 'f83f49994cdd4364abbcccaa4bff2c9d', 'a98260bc50834d63920922ced61333a9', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-25 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('66be87252bfa43dcbf5ae918ddaa9124', 'f68a70de7cc046fea26b847e8adad836', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 1, '2020-10-21 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('6714ea76d5b94edb862b51f238fef6b4', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 4, '四川省广安市广安区滨江东路98号', 2, '2020-10-21 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('6a6cc06c67b448c08163c917fc1a919b', 'b7405893f1a048a0b60982b0fbb6e207', 'a98260bc50834d63920922ced61333a9', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-25 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('83c0f0f698564b93aaa183e863b56d62', '7f5945cf4c094b6b89fccff8cb5f379a', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-22 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('85abd723bd7c4598a7da7f6e0e85b9d8', '5160faa8a49a424aa134052267f0b0f9', 'a98260bc50834d63920922ced61333a9', 5, '小白兔的家', 0, '2020-11-20 00:00:00.000000', '2020-11-22 21:28:12.000000');
INSERT INTO `order` VALUES ('88a3fe21513e4b88acb9e47517d09959', '5160faa8a49a424aa134052267f0b0f9', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-20 00:00:00.000000', '2020-11-20 11:34:44.000000');
INSERT INTO `order` VALUES ('90772aac9f1f4ea08b1bf2772133f482', '2d3d4d7521b545f7a196e18e5a53ff74', 'a98260bc50834d63920922ced61333a9', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-25 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('96fe3b4587b647e38749f91c62704286', '2d3d4d7521b545f7a196e18e5a53ff74', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 1, '2020-10-25 00:00:00.000000', '2020-10-26 20:33:43.000000');
INSERT INTO `order` VALUES ('9e0219bb9cfb407ca9fdb1f0db9445d8', '7f5945cf4c094b6b89fccff8cb5f379a', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-27 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('9eb9fa70d7214a04b61eb27947ab0bb5', 'e8360ffbecd049a8b7d43ec8016cfebb', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 2, '2020-10-25 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('9f9bdc82016d438098137840095b43fe', '15bfd9e0b70b410981e46cea056e89ac', '05546b24af2f4d45a6f9c3570534de0f', 10, '四川省广安市广安区滨江东路98号', 2, '2020-10-20 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('9fca24cbf26d4ae2875025d8409098fe', 'b7405893f1a048a0b60982b0fbb6e207', 'a98260bc50834d63920922ced61333a9', 10, '小白兔的家', 0, '2020-11-04 00:00:00.000000', '2020-11-19 12:05:18.000000');
INSERT INTO `order` VALUES ('a1fa4baa506a4b13abf8114c306bc3a2', 'e8360ffbecd049a8b7d43ec8016cfebb', 'a98260bc50834d63920922ced61333a9', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-20 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('a9b300c4b31248db8fc627d7b672c159', 'b7405893f1a048a0b60982b0fbb6e207', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-19 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('ad3911bb13a34f8ab025531e3c53e413', '0d8c538655004e27b5069f707c97059f', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 1, '2020-10-26 00:00:00.000000', '2020-10-26 20:30:21.000000');
INSERT INTO `order` VALUES ('becd7f8a649b4d32a4823de89ba0c759', 'e8360ffbecd049a8b7d43ec8016cfebb', '05546b24af2f4d45a6f9c3570534de0f', 6, '四川省广安市广安区滨江东路98号', 0, '2020-10-20 00:00:00.000000', '2020-10-26 20:33:51.000000');
INSERT INTO `order` VALUES ('cab5ecbf606b4179bab23ccbea77e322', 'aba976db50e341798c9fc815fcdcf8eb', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-19 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('cfa599f254a64b7f8bb31886ab910088', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-30 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('e1d6721b6ac14078b7282aed9e3b28f2', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 0, '2020-11-04 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('e31c7e4606e7440199b9e7c5adcb489e', '2d3d4d7521b545f7a196e18e5a53ff74', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 2, '2020-11-19 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('e844c65949ce4357949fe63d613343cd', 'b7405893f1a048a0b60982b0fbb6e207', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-30 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('eb3d87879850431589950915a46e66b6', '15bfd9e0b70b410981e46cea056e89ac', '05546b24af2f4d45a6f9c3570534de0f', 8, '四川省广安市广安区滨江东路98号', 1, '2020-10-25 00:00:00.000000', '2020-10-26 20:33:01.000000');
INSERT INTO `order` VALUES ('eda4fdde5dc64916a1fdd8981b41673c', 'e8360ffbecd049a8b7d43ec8016cfebb', '05546b24af2f4d45a6f9c3570534de0f', 1, '四川省广安市广安区滨江东路98号', 2, '2020-10-21 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('eeb8ccfe47cf410aa8994c12ec775723', '8362a1f331174058895508c70d4be59f', '05546b24af2f4d45a6f9c3570534de0f', 4, '四川省广安市广安区滨江东路98号', 2, '2020-10-22 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('f07f9ae976224dd69a5564330612390d', '15bfd9e0b70b410981e46cea056e89ac', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 1, '2020-11-29 00:00:00.000000', NULL);
INSERT INTO `order` VALUES ('f2dc7c73ba8e4d48b361522d54d6e5a4', '15bfd9e0b70b410981e46cea056e89ac', 'a98260bc50834d63920922ced61333a9', 1, '小白兔的家', 0, '2020-11-29 00:00:00.000000', '2020-11-29 14:52:34.000000');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double(50, 2) NOT NULL,
  `stock` int(50) NOT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created` datetime(0) NULL DEFAULT NULL,
  `deleted` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('0d8c538655004e27b5069f707c97059f', '大刀肉辣条儿时辣味小吃怀旧小零食麻辣素肉休闲老式吃的食品整箱 ', '品牌: 乡气 系列: 大刀肉 口味: 大刀肉250g*2包 大刀肉250g*4包 大刀肉250g*1包（约38） 大刀肉250g*3包（约114） 大刀肉250g*5包（约190） 产地: 中国大陆 省份: 安徽省 重量(g): 250 包装方式: 包装', 15.00, 100, 'fb844d4b1cda4859a6a621e55a457644.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('15bfd9e0b70b410981e46cea056e89ac', '微黑JK正版原创jk制服裙百褶裙短裙学生格裙半身裙校供', '产品参数： 品牌: 微黑 适用年龄: 18-24周岁 尺码: 【同格小物】可到店铺宝贝列表购买 XS S M L XL 图案: 格子 风格: 甜美 甜美: 学院 腰型: 高腰，jk，JK，女装，裙子', 248.00, 98, '83ec9715c77b497d9ed8dc1ab923e9d2.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('16588169bcde4c9fbc7a109619f87e4c', 'JK制服裙正版现货格裙掉落水手服女套装全套学生装学院风秋冬长袖 ', '品牌名称：BAILIPHIL/佰俪菲尔 产品参数： 品牌: BAILIPHIL/佰俪菲尔 适用年龄: 18-25周岁 尺码: S M L XL XXL 风格: 日系 款式: 裙子 颜色分类: 短袖上衣（送金鱼结） ，jk，JK，女装', 299.00, 8888, 'e96a986e6f034334814174318a828153.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('20dde4e8872543a48c17f0e4903e6ed6', '【双11预售 12期免息 直降1000】Samsung/三星Galaxy S20 Ultra SM-G9880 120Hz全面屏拍照5G双模手机 ', 'TA800 输出 :(PD0) 5.0Vdc 3.0A 或9.0... 产品名称：Samsung/三星 Galaxy S20... 三星型号: Galaxy S20 Ultra SM-G9880 5G 机身颜色: 幻游黑 遐想灰 意象白 运行内存RAM: 16GB 12GB 存储容量: 12+256GB 16+512GB', 8900.00, 265, '681a241d95014891805e95ecc59f1eba.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('29f3be4f836b43a6aa1efee0aefb8e7d', 'ROGER DUBUIS/罗杰杜彼官方正品男士钛金属机械腕表 ', '成色: 全新 保修: 全球联保 品牌产地: 瑞士 机芯类型: 机械机芯-自动机械机芯 表带材质: 其他 颜色分类: 银色表壳 表壳材质: 其他 手表种类: 男', 355500.00, 326, 'bdfa3c0b74e14b41835f9ae976ecbc3e.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('2d3d4d7521b545f7a196e18e5a53ff74', '日系原创jk制服裙正版一全套学生学院风长袖衬衫秋装沙华红格套装 ', 'jk，JK，女装，裙子，风格: 日系', 268.00, 187, '7020ae11e3f946e2aae196d3789d7106.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('391796e78c764fa995e8bbc782b9e44f', '格子半身裙秋冬女2020新款高腰a字伞裙百褶学院风小个子毛呢短裙', '优雅小俏皮，荷叶边短裙', 500.00, 6000, '8f1422a9cc2b4fcf97aa9e613e13ddfb.webp', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('479450e22c7e46c58539c76f692f3c38', '青蜂商显广告机壁挂超薄高清吊挂电梯网络液晶显示屏电视竖屏播放器19/22/27/32/43/49/55/65/70/80/86/100寸', '高清视界，智享未来', 5999.00, 3000, '555b7796fad544b5a3749934b0710c67.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('5123a67b784449f2ae281814132e2ba6', '2020全新款笔记本电脑办公用商务轻薄便携女生学生游戏本15.6英寸送华为荣耀华硕联想小米戴尔惠普鼠标摆渡者', '轻于时代，薄于未来', 6999.00, 1000, 'ac235df070cb477f95fd561e8e65d222.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('5160faa8a49a424aa134052267f0b0f9', '【现货速发/12分期】xiaomi/小米10至尊纪念版手机官方旗舰5G手机小米10pro尊享骁龙865红米k30pro直降k30i', '配器：MDY-11-EF 输出：5VDC,3A / 9V... 产品名称：Xiaomi/小米 小米10 至尊... 型号: 小米10 至尊纪念版 机身颜色: 透明版 陶瓷黑 运行内存RAM: 8GB 12GB 存储容量: 8+128GB 8+256GB 12+256GB 网络模式: 双卡双待 CPU型号: CPU型号', 5899.00, 348, 'dbd40233882b484f9da92d76e8fa962d.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('51d1c932995d463ea0f0282238153ed3', '【新品抢先预定】Redmi Note 9红米note9天玑800U千元拍照智能机手机全面屏学生小米官方旗舰店官网xiaomi', '高性能长续航5g手机', 1999.00, 9878, 'e646dcfb43904644939b9d33b177c3f0.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('53c671907a414fb7b5f0250b4d6e701c', 'Boolibyoo 好面料！欧美大码弹力修身包臀裙性感抽绳连衣裙', '自制欧美抽绳连衣裙', 456.00, 654, '58ca5b3ba5a04fef9f522b72d56dc3d9.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('5b274ade091b45499be0b4247f0ba7dd', '比比赞魔芋爽素毛肚网红辣条宿舍辣条小零食小吃麻辣休闲食品儿时', '辣条又叫大面筋、素牛筋等，它是以小麦粉或其他谷物、豆类为主要原料做成的一种食品。', 29.00, 200, '65f93c9b54ae4c1c8a7f1ff5cd1c87e1.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('7a9bf350987e49bba715aca1fee7740a', '连帽毛绒羽绒服', '优雅/时尚/轻奢', 899.00, 1200, '08a86b5d573548e0afb85803fa762427.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('7e44014151984eb3ad2fb12868bdd79b', '钱夫人黑色宫廷风打揽连衣裙女2020新款时尚收腰显瘦法式复古裙', '柔软/光滑/透气/舒适', 744.00, 500, 'b909c9fc3edf4f6fa4766579bf68240a.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('7f5945cf4c094b6b89fccff8cb5f379a', 'Xiaomi/小米 红米6 pro 5A 3S 4X全网通4G支持人脸解锁智能手机 ', '全网通4G5.5屏幕 红米8A全网通4G 红米note5全网通4G指纹解锁5.5屏 红米6Pro全网通4G全面屏5.84屏幕 红米2A移动2G网络白色  小米', 2899.00, 119, '96d8df92b8f44e6e996e0813e4495a90.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('8362a1f331174058895508c70d4be59f', '君仔面筋卷25g*10袋装烧烤面筋卷串辣条儿时怀旧零食小吃休闲食品', '君仔面筋卷25g*10袋装烧烤面筋卷串辣条儿时怀旧零食小吃休闲食品', 99.80, 500, '45acfc7602af48bb932cb90f2a2ff7a0.png', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('87a77c495edb442aaa7498bc4a9e548f', '飞旺辣条大礼包麻辣零食', '辣条', 29.00, 200, '96cd96fadb964a64a5179cbd0033943d.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('96cdb174fd8e471cba1aa0b6f0e62f42', '新品抢先预定】Redmi Note 9红米note9天玑800U千元拍照智能机手机全面屏学生小米官方旗舰店官网xiaomi', '超强续航5g手机', 899.00, 1200, 'e2dc3f7635f44fc8a4db441e4889dcad.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('aba976db50e341798c9fc815fcdcf8eb', 'ROG玩家国度 枪神4 Plus十代酷睿i7-RTX2070Super/i9-RTX2080Super 17.3英寸300hz 3ms电竞游戏本笔记本电脑', '3xyyyyyyyyyyyyyyyyy, R20... 产品名称：ROG/玩家国度 枪神 枪神4... 品牌: ROG/玩家国度 型号: 枪神4 Plus 内存容量: 16G 32GB 硬盘容量: 1TB 固态硬盘 2TB 固态硬盘 CPU: 英特尔 酷睿 i7-10875H 屏幕尺寸: 17.3英寸', 28900.00, 323, 'a3c3a2e71a0e4a919441c0379359d873.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('af4f0ac766fb4b8dabc08f52b609ae74', '帛卡琪2020新款夏季荷叶边白衬衫短袖女泡泡袖刺绣polo领衬衣上衣', '少女/经典双重领/碎花刺绣/韩范', 656.00, 600, '903f67c633554065b13c83f96839507c.jpg', '2020-11-28 00:00:00', NULL);
INSERT INTO `product` VALUES ('b489f8f16ee148a384fe32a7a035d389', 'jk制服裙正版日常学生毛衣jk套装基础款正版日系水手服套装中间服 ', '品牌名称：hvht 产品参数： 品牌: hvht 适用年龄: 18-25周岁 尺码: S M L 均码 风格: 日系 款式: 裙子 颜色分类: 米白色毛衣+白衬衫，jk，JK，女装', 299.00, 165, 'f37739fd58a546b286c6a0814faf289c.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('b7405893f1a048a0b60982b0fbb6e207', '正版 高性能MySQL 第3版 SQL优化数据库管理 mysql从入门到精通必知必会 MySQL领域的经典之作 数据挖掘数据库原理及应用教程书籍', '关系型数据库，MySQL，编程，电脑，IT，信息技术', 45.50, 496, 'b0ab1478b6824ed28f00c7ddc1eeb5e2.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('c0521363974a48878a782a01d51fb608', '【6期免息]Huawei/华为 P40 5G全网通手机官方nowa8旗舰店mate40pro官网6se新品nova8直降nova7正品p30荣耀10', '产品名称：Huawei/华为 P40 华为型号: P40 机身颜色: 深海蓝 晨曦金 零度白 冰霜银 【P40Pro】亮黑色 【P40Pro】深海蓝 【P40Pro】晨曦金 【P40Pro】零度白 【P40Pro】冰霜银 亮黑色 运行内存RAM: 8GB', 2900.00, 165, '782f989afdb54b6a9c3406b4b983f26d.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('c2cc4f76ff3a47c8af5225de6085be39', 'qweqwe', 'qweqwe', 123.00, 11111, '6b4df90685b44925931426b19d7cd835.jpg', '2020-11-01 00:00:00', '2020-11-04 01:01:03');
INSERT INTO `product` VALUES ('c563dc5a7f194c48b76da3bb6e0a0ad3', 'ThinkPad P1隐士 20QTA00DCD 英特尔九代标压酷睿i7设计电脑15.6英寸商务办公笔记本电脑移动图形工作站', 'xx, ThinkPad X1 Extreme... 产品名称：ThinkPad P1 工作站 品牌: ThinkPad 型号: 工作站 内存容量: 16G 硬盘容量: 1T固态硬盘 CPU: 英特尔 酷睿 i7-9750H 屏幕尺寸: 15.6英寸 显存容量: 4G 显卡类型: 核芯显卡 操作系统: windows 10', 19499.00, 125, 'f1c95d5d34904e08b2c4c43fea7127b8.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('d426ee2de2214947b2149daa61b7aef0', 'Apple/苹果 iPhone X国行iphonexsmax全新苹果x 256g手机xr全网通 ', ' iPhone XR 6.1英寸【黑色】 iPhone XR 6.1英寸【白色】 iPhone XR 6.1英寸【黄色】 iPhone XR 6.1英寸【红色】 iPhone XR 6.1英寸【蓝色】 iPhone XR 6.1英寸【珊瑚色】 iPhone XS MAX 6.5英寸【黑色】 iPhone XS MAX 6.5英寸【白色】 iPhone XS MAX 6.5英寸【金色】 套餐类型: 官方标配 套餐一 售后服务: 全国联保 版本类型: 美国 中国大陆', 4900.00, 600, '82c20adc6ccf4cb1b7b3f741e736a142.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('d51db31e414045ad982f088b6f5f11fd', 'JK制服裙正版学院风西服日系校服秋冬软妹萝莉套装学生可爱三件套 ', '品牌名称：间佰 产品参数： 品牌: 间佰 适用年龄: 18-25周岁 尺码: S M 风格: 日系 款式: 裙子 颜色分类: 短裙+衬衫+领带 短裙+衬衫，jk，JK，女装', 399.00, 150, '59331a7a93aa4c2b9a0266f698684894.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('da05b2dda48042dd8e5e44aa41a59619', '网红辣条麻辣片休闲零食大礼包儿时辣味小吃抖音同款好吃的排行榜 ', '储藏方法: 置阴凉、干燥处，避免阳光直射 保质期: 90 食品添加剂: 详情见包装 产地: 中国大陆 口味: 组合8包（收藏加购赠送2包） 网红辣块4包 网红辣丝4包 网红辣条4包 网红小面筋4包 组合装4包 组合装4包（共500g）爆辣 重量: 500g 包装方式: 包装', 9.90, 155, 'fb0fa591f4424d0dba6b9226d99959c9.jpg', '2020-10-25 00:00:00', NULL);
INSERT INTO `product` VALUES ('e8360ffbecd049a8b7d43ec8016cfebb', 'jk制服裙正版套装全套班服温柔一刀星野长袖衬衫校服百褶裙格裙秋 ', '品牌名称：歌奈妮 产品参数： 品牌: 歌奈妮 适用年龄: 18-25周岁 尺码: XS S M L XL XXL 风格: 日系 款式: 裙子，jk，JK，女装', 258.00, 120, '37499f0d59da483c99c329f4e8127454.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('f68a70de7cc046fea26b847e8adad836', 'jk制服裙正版套装全套学生格裙学院风秋冬装长袖衬衫中牌馆兔缝缝 ', '品牌名称：艺菲草 产品参数： 品牌: 艺菲草 适用年龄: 18-25周岁 尺码: XS S M L XL 风格: 日系 款式: 裙子 颜色分类: 风琴白色长袖，jk,JK，女装', 299.00, 234, '3629f78bbb9a43c5bf865cae5c14072e.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('f83f49994cdd4364abbcccaa4bff2c9d', '长袖jk制服裙正版套装全套秋装温柔一刀校园中牌兔缝缝制服馆女冬', 'jk，JK，女装，裙子', 399.00, 530, '7f7edd49c7a0439b839851cbdce7d8ee.jpg', '2020-10-19 00:00:00', NULL);
INSERT INTO `product` VALUES ('fdc942105c4345a6890ded536c495881', 'a', 'a', 999.00, 500, '5576197d07004cae822d555eb3a7a1be.jpg', '2020-11-28 00:00:00', '2020-11-28 11:09:23');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `created` datetime(6) NULL DEFAULT NULL,
  `deleted` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('a187a0f8a9e644549ae59694685fddb4', '147258369', 'god', 'e10adc3949ba59abbe56e057f20f883e', NULL, '/static/img/user.jpg', NULL, 1, '2020-11-28 00:00:00.000000', NULL);
INSERT INTO `user` VALUES ('c1c416613e77481d85bb8e344703acaa', '8467502433', '金泉大佬', '47b6ed0b6b6824c8dc892e2e48b462f9', NULL, '/static/img/user.jpg', NULL, 1, '2020-11-27 00:00:00.000000', NULL);
INSERT INTO `user` VALUES ('a98260bc50834d63920922ced61333a9', 'xbt', '小白兔爱吃胡萝卜', 'e10adc3949ba59abbe56e057f20f883e', '826365699', '/upload/720142058d39427f8ca8c7f701213420.jpg', '小白兔的家', 1, '2020-10-19 00:00:00.000000', NULL);
INSERT INTO `user` VALUES ('05546b24af2f4d45a6f9c3570534de0f', 'xueyuan', '广安职业技术学院', 'e10adc3949ba59abbe56e057f20f883e', '0826365655', '/upload/43977774e97b456eaae76e16ff11f897.jpg', '四川省广安市广安区滨江东路98号', 1, '2020-10-18 00:00:00.000000', NULL);

SET FOREIGN_KEY_CHECKS = 1;
