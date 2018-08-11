/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : adshow

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 17/07/2018 17:29:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad_music
-- ----------------------------
DROP TABLE IF EXISTS `ad_music`;
CREATE TABLE `ad_music` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(128) DEFAULT NULL COMMENT '存储名称',
  `alias_name` varchar(128) DEFAULT NULL COMMENT '实际名称',
  `physical_path` varchar(128) DEFAULT NULL COMMENT '本地路径',
  `size` bigint(20) DEFAULT NULL COMMENT '视频大小',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `type` varchar(10) DEFAULT NULL COMMENT '音乐播放类型（*.mp3）',
  `time_length` int(11) DEFAULT NULL COMMENT '时长',
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ad_picture
-- ----------------------------
DROP TABLE IF EXISTS `ad_picture`;
CREATE TABLE `ad_picture` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(128) DEFAULT NULL COMMENT '存储名称',
  `alias_name` varchar(128) DEFAULT NULL COMMENT '实际名称',
  `physical_path` varchar(128) DEFAULT NULL COMMENT '本地路径',
  `size` bigint(20) DEFAULT NULL COMMENT '视频大小',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `pixel_size` varchar(20) DEFAULT NULL COMMENT '像素大小',
  `type` varchar(10) DEFAULT NULL COMMENT '图片类型（*.mp3）',
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ad_player_program
-- ----------------------------
DROP TABLE IF EXISTS `ad_player_program`;
CREATE TABLE `ad_player_program` (
  `id` int(11) NOT NULL COMMENT 'ID自增',
  `player_id` varchar(36) DEFAULT NULL COMMENT '播放端ID',
  `player_name` varchar(64) DEFAULT NULL COMMENT '播放端名称',
  `program_id` varchar(36) DEFAULT NULL COMMENT '节目ID',
  `program_name` varchar(64) DEFAULT NULL COMMENT '节目名称',
  `resolution` varchar(36) DEFAULT NULL COMMENT '节目分辨率',
  `status` tinyint(4) DEFAULT NULL COMMENT '终端的节目状态 0-未下载 1-正在下载 2-下载完成 3-节目删除',
  `program_duration` int(11) DEFAULT NULL COMMENT '节目时长',
  `start_date` datetime DEFAULT NULL COMMENT '过期时间',
  `end_date` datetime DEFAULT NULL COMMENT '创建时间',
  `start_time` datetime DEFAULT NULL COMMENT '开始时段（0~24）',
  `end_time` datetime DEFAULT NULL COMMENT '结束时段（0~24）',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `size` bigint(20) DEFAULT NULL COMMENT '节目大小',
  `download_size` bigint(20) DEFAULT '0' COMMENT '节目当前下载的大小',
	`create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ad_program
-- ----------------------------
DROP TABLE IF EXISTS `ad_program`;
CREATE TABLE `ad_program` (
  `id` varchar(255) NOT NULL COMMENT 'ID自增',
  `name` varchar(64) DEFAULT NULL COMMENT '节目名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '节目类型 1-普通节目 2-直播节目',
  `program_duration` int(11) DEFAULT NULL COMMENT '节目时长',
  `resolution` varchar(36) DEFAULT NULL COMMENT '节目分辨率',
  `program_description` varchar(1024) DEFAULT NULL COMMENT '节目描述',
  `video_ids` varchar(512) DEFAULT NULL COMMENT '视频ids',
  `music_ids` varchar(512) DEFAULT NULL COMMENT '背景音乐ids',
  `text_ids` varchar(512) DEFAULT NULL COMMENT '字幕ids',
  `weather` varchar(512) DEFAULT NULL COMMENT '天气是否显示',
  `date_show` varchar(512) DEFAULT NULL COMMENT '日期是否显示',
  `previewImage` varchar(256) DEFAULT NULL COMMENT '节目预览图',
  `template_image` varchar(256) DEFAULT NULL COMMENT '模板图片',
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ad_program_material
-- ----------------------------
DROP TABLE IF EXISTS `ad_program_material`;
CREATE TABLE `ad_program_material` (
  `id` varchar(255) NOT NULL COMMENT 'ID自增',
  `program_id` varchar(36) DEFAULT NULL COMMENT '节目ID',
  `material_id` varchar(64) DEFAULT NULL COMMENT '节目对应的素材ID',
  `material_position` varchar(36) DEFAULT NULL COMMENT '素材在节目中的位置（x*y）',
  `material_size` varchar(36) DEFAULT NULL COMMENT '素材在节目中的显示大小（w*l）',
  `material_interval` varchar(256) DEFAULT NULL COMMENT '素材在节目中显示的时间（数组）',
  `material_oder` varchar(256) DEFAULT NULL COMMENT '素材在节目中的图层顺序',
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  `type` varchar(10) DEFAULT NULL COMMENT '节目类型 0-视频 1-音乐 2-图片 3-字幕',
  `material_name` varchar(255) DEFAULT NULL COMMENT '素材名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `IDX_PK` (`program_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ad_subtitle
-- ----------------------------
DROP TABLE IF EXISTS `ad_subtitle`;
CREATE TABLE `ad_subtitle` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(128) DEFAULT NULL COMMENT '存储名称',
  `alias_name` varchar(128) DEFAULT NULL COMMENT '实际名称',
  `physical_path` varchar(128) DEFAULT NULL COMMENT '本地路径',
  `size` bigint(20) DEFAULT NULL COMMENT '视频大小',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `content` varchar(1024) DEFAULT NULL COMMENT '字幕内容',
  `type` int(10) DEFAULT NULL COMMENT '字幕类型（1.静态字幕 2.滚动字幕）',
  `font` varchar(64) DEFAULT NULL COMMENT '字体',
  `font_size` int(10) DEFAULT NULL COMMENT '字体大小',
  `font_color` varchar(32) DEFAULT NULL COMMENT '字体颜色',
  `back_color` varchar(32) DEFAULT NULL COMMENT '字体背景颜色',
  `back_transparency` varchar(32) DEFAULT NULL COMMENT '字体背景透明度',
  `scroll_speed` int(10) DEFAULT NULL COMMENT '滚动速度和类型（1.快 2.适中  3.慢）',
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ad_video
-- ----------------------------
DROP TABLE IF EXISTS `ad_video`;
CREATE TABLE `ad_video` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(128) DEFAULT NULL COMMENT '存储名称',
  `alias_name` varchar(128) DEFAULT NULL COMMENT '实际名称',
  `physical_path` varchar(128) DEFAULT NULL COMMENT '本地路径',
  `size` bigint(20) DEFAULT NULL COMMENT '大小',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `resolution` varchar(20) DEFAULT NULL COMMENT '视频分辨率',
  `type` varchar(10) DEFAULT NULL COMMENT '播放类型（*.mp4）',
  `time_length` int(11) DEFAULT NULL COMMENT '视频时长',
  `finish_size` bigint(20) DEFAULT NULL COMMENT '断点续传',
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(255) NOT NULL COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(255) NOT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `cost_time` int(11) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `ip_info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `request_param` varchar(255) DEFAULT NULL,
  `request_type` varchar(255) DEFAULT NULL,
  `request_url` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` varchar(255) NOT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `sort_order` decimal(10,2) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `button_type` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `default_role` bit(1) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(255) NOT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `permission_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatar` varchar(1000) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(255) NOT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ad_player 终端信息表
-- ----------------------------
drop table if EXISTS `ad_player`;
CREATE TABLE `ad_player` (
  `id` varchar(64) NOT NULL COMMENT '终端ID',
  `name` varchar(64) DEFAULT NULL COMMENT '终端名称',
  `subnet_mask` varchar(64) DEFAULT NULL COMMENT '子网掩码',
  `default_ipgateway` varchar(64) DEFAULT NULL COMMENT '默认网关',
  `dns_server` varchar(64) DEFAULT NULL COMMENT 'DNS服务器',
  `is_register` int(11) DEFAULT NULL COMMENT '是否注册',
  `group_id` varchar(64) DEFAULT NULL COMMENT '所属公司',
  `machine_id` varchar(64) DEFAULT NULL COMMENT '机器码',
  `security_id` varchar(64) DEFAULT NULL COMMENT '安全码',
  `statue` varchar(64) DEFAULT NULL COMMENT '终端状态',
  `statue_change_time` datetime DEFAULT NULL COMMENT '状态改变时间',
  `online_time` int(11) DEFAULT NULL COMMENT '在线时长',
  `width` int(11) DEFAULT NULL COMMENT '屏幕宽度',
  `height` int(11) DEFAULT NULL COMMENT '屏幕高度',
  `resolution` varchar(64) DEFAULT NULL COMMENT '分辨率',
  `note` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` varchar(64) DEFAULT NULL COMMENT '创建者ID',
  `update_user` varchar(64) DEFAULT NULL COMMENT '更新者ID',
  `mac_ip` varchar(256) DEFAULT NULL COMMENT 'MAC地址',
  `diskspace` bigint(20) DEFAULT NULL COMMENT '磁盘空间',
  `city_id` varchar(512) DEFAULT NULL COMMENT '终端对应城市ID',
  `city_name` varchar(512) DEFAULT NULL COMMENT '终端对应城市名称',
  `soft_version` varchar(64) DEFAULT NULL COMMENT '终端版本',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `latitude` double DEFAULT NULL COMMENT '纬度',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `debice_type` varchar(64) DEFAULT NULL COMMENT '设备类型',
  `device_brand` varchar(64) DEFAULT NULL COMMENT '品牌',
  `os_version` varchar(64) DEFAULT NULL COMMENT '系统版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS = 1;
