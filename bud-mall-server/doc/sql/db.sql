set names utf8mb4;
CREATE SCHEMA IF NOT EXISTS bud_mall default character set utf8mb4 collate utf8mb4_unicode_ci;
use bud_mall;

/* 系统权限表 */
CREATE TABLE `sys_permission` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `parent_id` int(10) NOT NULL default 0 COMMENT '父权限ID，一级菜单为0',
  `permission_name` varchar(30) NOT NULL default '' COMMENT '权限名称',
  `key_name` varchar(30) NOT NULL default '' COMMENT '标识名',
  `component` varchar(30) NOT NULL default '' COMMENT '组件名',
  `permission_type` tinyint(2) NOT NULL default 1 COMMENT '类别，1目录，2菜单，3权限',
  `permits` varchar(500) NOT NULL default '' COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `url` varchar(200) NOT NULL default '' COMMENT '权限URL，菜单用',
  `icon` varchar(50) NOT NULL default ''  COMMENT '权限图标，菜单用',
  `sort` smallint(4) NOT NULL default 0 COMMENT '排序权重',
  `hidden` tinyint(2) NOT NULL default 1 COMMENT '是否隐藏,1显示,2隐藏',
  `data_status` tinyint(2) NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

/* 系统角色表 */
CREATE TABLE `sys_role` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_name` varchar(20) NOT NULL default '' COMMENT '角色名称',
  `remark` varchar(100) NOT NULL default '' COMMENT '备注',
  `permissions` varchar(500) NOT NULL default '' COMMENT '权限id，多个以逗号分隔',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `data_status` tinyint(2) NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

/* 商品分类表 */
CREATE TABLE `product_category` (
  `category_id` int(10) UNSIGNED NOT NULL COMMENT '分类id',
  `parent_id` int(10) NOT NULL default 0 COMMENT '上级分类ID，一级为0',
  `category_name` varchar(32) NOT NULL default '' COMMENT '分类名称',
  `product_num` int(10) DEFAULT NULL default 0 COMMENT '分类下的商品数量',
  `icon` varchar(50) NOT NULL default ''  COMMENT '分类图标',
  `sort` smallint(4) NOT NULL default 0 COMMENT '排序权重',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `data_status` tinyint(2) NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类';

/* 商品品牌表 */
CREATE TABLE `product_brand` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `brand_name` varchar(32) NOT NULL default '' COMMENT '品牌名称',
  `category_id` int(10) NOT NULL default 0 COMMENT '分类ID',
  `first_letter` char(1) DEFAULT '' COMMENT '首字母',
  `brand_logo` varchar(128) DEFAULT '' COMMENT '品牌logo',
  `brand_img` varchar(128) DEFAULT '' COMMENT '专区大图',
  `intro` varchar(500) DEFAULT '' COMMENT '简单介绍',
  `product_num` int(10) DEFAULT NULL default 0 COMMENT '品牌下商品数量',
  `sort` smallint(4) NOT NULL default 0 COMMENT '排序权重',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `data_status` tinyint(2) NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品品牌';

