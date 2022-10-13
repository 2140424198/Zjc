/*
 Navicat Premium Data Transfer

 Source Server         : user
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : vared

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 13/10/2022 22:13:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_line
-- ----------------------------
DROP TABLE IF EXISTS `t_line`;
CREATE TABLE `t_line`  (
  `id` bigint NOT NULL COMMENT '主键(雪花算法)',
  `line_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '线路名称',
  `line_category` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '线路分类',
  `sort` int NULL DEFAULT NULL COMMENT '线路分类排序',
  `line_amount` decimal(10, 2) NOT NULL COMMENT '线路价格',
  `img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '线路图片',
  `remark` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '线路备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '景点线路表（初始化数据）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_line
-- ----------------------------
INSERT INTO `t_line` VALUES (1, '八达岭长城', '一日游', 1, 200.00, '长城.webp', '一日游');
INSERT INTO `t_line` VALUES (2, '颐和园', '一日游', 1, 220.00, '颐和园.jpg', '一日游');
INSERT INTO `t_line` VALUES (3, '四面山', '一日游', 1, 300.00, '四面山.webp', '一日游');
INSERT INTO `t_line` VALUES (4, '张家界', '两日游', 2, 350.00, '张家界.jpg', '两日游');
INSERT INTO `t_line` VALUES (5, '兵马俑', '两日游', 2, 400.00, '兵马俑.webp', '两日游');
INSERT INTO `t_line` VALUES (6, '苏州园林', '两日游', 2, 370.00, '苏州园林.webp', '两日游');
INSERT INTO `t_line` VALUES (7, '布达拉宫', '三日游', 3, 450.00, '布达拉宫.webp', '三日游');
INSERT INTO `t_line` VALUES (8, '上海迪士尼', '三日游', 3, 500.00, '上海迪士尼.webp', '三日游');
INSERT INTO `t_line` VALUES (9, '故宫', '四日游', 4, 550.00, '故宫.webp', '四日游');

-- ----------------------------
-- Table structure for t_line_scenic
-- ----------------------------
DROP TABLE IF EXISTS `t_line_scenic`;
CREATE TABLE `t_line_scenic`  (
  `id` bigint NOT NULL COMMENT '主键(雪花算法)',
  `line_id` bigint NOT NULL COMMENT '线路id',
  `scenic_id` bigint NOT NULL COMMENT '景点id',
  `sort` int NULL DEFAULT NULL COMMENT '景点次序',
  `go_time` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '前往时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `un_line_rule`(`line_id` ASC, `scenic_id` ASC, `sort` ASC) USING BTREE COMMENT '线路规则唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '线路景点关系表（初始化数据）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_line_scenic
-- ----------------------------
INSERT INTO `t_line_scenic` VALUES (1, 1, 1, 1, '2');
INSERT INTO `t_line_scenic` VALUES (2, 2, 2, 2, '2');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint NOT NULL COMMENT '主键(雪花算法)',
  `amount` decimal(10, 0) NOT NULL COMMENT '订单金额',
  `together_number` int NOT NULL COMMENT '同行人数',
  `reservation_time` datetime NOT NULL COMMENT '预定时间',
  `status` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '订单状态(未支付，已支付，已完成)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '订单表（业务数据）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_payment
-- ----------------------------
DROP TABLE IF EXISTS `t_payment`;
CREATE TABLE `t_payment`  (
  `id` bigint NOT NULL COMMENT '主键(雪花算法)',
  `order_id` bigint NOT NULL COMMENT '订单id',
  `pay_amount` decimal(10, 2) NOT NULL COMMENT '支付金额',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '支付表（业务数据）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_payment
-- ----------------------------

-- ----------------------------
-- Table structure for t_scenic_spot
-- ----------------------------
DROP TABLE IF EXISTS `t_scenic_spot`;
CREATE TABLE `t_scenic_spot`  (
  `id` bigint NOT NULL COMMENT '主键(雪花算法)',
  `scenic_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '景点名称',
  `scenic_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '景点详细地址',
  `scenic_describe` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '景点描述',
  `scenic_image` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '景点图片名称',
  `longitude` decimal(10, 7) NOT NULL COMMENT '地理经度',
  `latitude` decimal(10, 7) NOT NULL COMMENT '地理纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '景点表（初始化数据）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_scenic_spot
-- ----------------------------
INSERT INTO `t_scenic_spot` VALUES (1, '八达岭长城', '位于北京市延庆区军都山关沟古道北口', '八达岭长城是中国古代伟大的防御工程万里长城的重要组成部分，是明长城的一个隘口。八达岭长城为居庸关的重要前哨，古称“居庸之险不在关而在八达岭”。\r\n明长城的八达岭段被称作“玉关天堑”，为明代居庸关八景之一。八达岭长城是明长城向游人开放最早的地段，八达岭景区以八达岭长城为主，兴建了八达岭饭店和由江泽民主席亲笔题名的中国长城博物馆等功能齐全的现代化旅游服务设施。\r\n八达岭景区是全国文明风景旅游区示范点，以其宏伟的景观、完善的设施和深厚的文化历史内涵而著称于世，是举世闻名的旅游胜地。', '长城.webp', 116.0200000, 40.2400000);
INSERT INTO `t_scenic_spot` VALUES (2, '颐和园', '坐落在北京西郊', '颐和园鼎盛时期，规模宏大，占地面积2.97平方公里，主要由万寿山和昆明湖两部分组成，其中水面占四分之三（大约220公顷）。园内建筑以佛香阁为中心，园中有景点建筑物百余座、大小院落20余处，3555古建筑，面积70000多平方米，共有亭、台、楼、阁、廊、榭等不同形式的建筑3000多间。其中佛香阁、长廊、石舫、苏州街、十七孔桥、谐趣园、大戏台为代表性建筑。古树名木1600余株。', '颐和园.jpg', 116.2739490, 39.9990920);
INSERT INTO `t_scenic_spot` VALUES (3, '四面山', '位于重庆市江津区四面山镇', '四面山处于渝川黔旅游金三角核心地带，集山、水、林、瀑、石于一身，融幽、险、雄、奇、秀为一体，自然景观独特、生态环境优美、旅游资源丰富，是休闲度假的旅游目的地 。', '四面山.webp', 105.1628200, 28.8098500);
INSERT INTO `t_scenic_spot` VALUES (4, '张家界', '位于湖南西北部', '1982年9月，张家界国家森林公园成为中国第一个国家森林公园。1988年8月，张家界武陵源风景名胜区被列入国家重点风景名胜区；1992年，由张家界国家森林公园等三大景区构成的武陵源风景名胜区被联合国教科文组织列入《世界自然遗产名录》；2004年2月，被列入全球首批《世界地质公园》；2007年，被列入中国首批国家5A级旅游景区。 2017年，被授予“国家森林城市”荣誉称号。', '张家界.jpg', 110.4700000, 29.1300000);
INSERT INTO `t_scenic_spot` VALUES (5, '兵马俑', '位于陕西省西安市临潼区', '1961年3月4日，秦始皇陵被国务院公布为第一批全国重点文物保护单位  。1974年3月，兵马俑被发现。1987年，秦始皇陵及兵马俑坑被联合国教科文组织批准列入《世界遗产名录》，被誉为“世界第八大奇迹” ，先后有200多位外国元首和政府首脑参观访问，成为中国古代辉煌文明的一张金字名片，又被誉为世界十大古墓稀世珍宝之一。', '兵马俑.webp', 109.1624280, 34.2307690);
INSERT INTO `t_scenic_spot` VALUES (6, '苏州园林', '位于江苏省苏州市', '苏州古典园林宅园合一，可赏，可游，可居。这种建筑形态的形成，是在人口密集和缺乏自然风光的城市中，人类依恋自然、追求与自然和谐相处、美化和完善自身居住环境的一种创造。苏州古典园林所蕴涵的中华哲学、历史、人文习俗是江南人文历史传统、地方风俗的一种象征和浓缩，展现了中国文化的精华，在世界造园史上具有独特的历史地位和重大的艺术价值。以拙政园、留园为代表的苏州古典园林被誉为“咫尺之内再造乾坤”，是中华园林文化的翘楚和骄傲。', '苏州园林.webp', 120.6299650, 31.3242490);
INSERT INTO `t_scenic_spot` VALUES (7, '布达拉宫', '位于中国西藏自治区首府拉萨市区西北的玛布日山上', '布达拉宫是一座宫堡式建筑群，最初是吐蕃王朝赞普松赞干布为迎娶尺尊公主和文成公主而兴建 。于17世纪重建后，成为历代达赖喇嘛的冬宫居所，为西藏政教合一的统治中心。1961年，布达拉宫成为了中华人民共和国国务院第一批全国重点文物保护单位之一。1994年，布达拉宫被列为世界文化遗产。', '布达拉宫.webp', 91.1252300, 29.6603480);
INSERT INTO `t_scenic_spot` VALUES (8, '上海迪士尼', '位于上海市浦东新区川沙镇黄赵路310号', '上海迪士尼乐园于2016年6月16日正式开园，是中国内地首座迪士尼主题乐园，也是中国规模最大的现代服务业中外合作项目之一，是一座具有纯正迪士尼风格并融汇了中国风的主题乐园。', '上海迪士尼.webp', 121.4053400, 31.2113290);
INSERT INTO `t_scenic_spot` VALUES (9, '故宫', '位于北京中轴线的中心', '北京故宫于明成祖永乐四年（1406年）开始建设，以南京故宫为蓝本营建，到永乐十八年（1420年）建成，成为明清两朝二十四位皇帝的皇宫。民国十四年国庆节（1925年10月10日）故宫博物院正式成立开幕。北京故宫南北长961米，东西宽753米，四面围有高10米的城墙，城外有宽52米的护城河。紫禁城有四座城门，南面为午门，北面为神武门，东面为东华门，西面为西华门。城墙的四角，各有一座风姿绰约的角楼，民间有九梁十八柱七十二条脊之说，形容其结构的复杂。', '故宫.webp', 116.2326930, 39.5456920);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint NOT NULL COMMENT '主键(雪花算法)',
  `nick_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '昵称',
  `openid` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '微信openid',
  `head_portrait` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '头像url',
  `gender` bit(1) NULL DEFAULT NULL COMMENT '性别',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表（业务数据）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (95441036616138752, 'ㅤㅤㅤㅤㅤㅤㅤㅤ', 'op_di5Hgk7V5MEO0gXVLQwEm_YVE', 'https://thirdwx.qlogo.cn/mmopen/vi_32/gVosEHqCWOEpp5nJwZXH1OkrLYMmr4cZwJOXiaiaPCGAXicibavwlibe0p1TvCsRT89icKbTKt9Vn5arpGWQYmSqgF9g/132', b'0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (95441494499917824, '冰@~', 'ouF6D5cX-OZd1ElBM-IWdl8DzUE0', 'https://thirdwx.qlogo.cn/mmopen/vi_32/z65lnygfJyouOJgWRecnZdttnLeibwdPd1aYmicRET4JEdZxlPTBE4LsXapy4vibW4qSbvYMVlhBv7I8IElvibVUBw/132', b'0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (95455608341266432, 'Host-梦琪', 'o8uZC5LtTaQQV-BnWyJywmgXAF7k', 'https://thirdwx.qlogo.cn/mmopen/vi_32/fib7RWUDhp6Dpz92KXemBxNjpFKYWuf6SMbzy0gcuHrQTibIjVqwj4pXa1j8jeD5W2mDmOgzVmibk6CfG1RsGWgdA/132', b'0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (95459073129971712, '雪橙', 'oud3r5BjyB6oO9MYZBPyGi0n6I2Q', 'https://thirdwx.qlogo.cn/mmopen/vi_32/uGOeNuw7ln6TM6lCYrhme1DocB6Wvv0usPEVlpM2MSXk4NlPj9vUVA0TzGSFVdYAmYh4hGCibibQo1eDGja8Pbsw/132', b'0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (95472430830583808, '不念', 'o2PS95BuWQKmIJudEzntrKvHrh78', 'https://thirdwx.qlogo.cn/mmopen/vi_32/hd4ribEql1tVibZ9Crib2IMgRtibaAnictKISDU18OED28O2ot3AiakmxW0shLicuIHpgDtZYnkVRu466Yf00lqEg60SA/132', b'0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (100008477425926144, '嗯哼', 'oMUf-5X4xzMmxHuRE6ISe2Bh9Dgs', '', b'0', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
