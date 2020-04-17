set names utf8mb4;
CREATE SCHEMA IF NOT EXISTS bud_mall default character set utf8mb4 collate utf8mb4_unicode_ci;
use bud_mall;

/* 系统权限表 */
CREATE TABLE `sys_permission`
(
    `id`              int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `parent_id`       int(10)          NOT NULL default 0 COMMENT '父权限ID，一级菜单为0',
    `permission_name` varchar(30)      NOT NULL default '' COMMENT '权限名称',
    `key_name`        varchar(30)      NOT NULL default '' COMMENT '标识名',
    `component`       varchar(30)      NOT NULL default '' COMMENT '组件名',
    `permission_type` tinyint(2)       NOT NULL default 1 COMMENT '类别，1目录，2菜单，3权限',
    `permits`         varchar(500)     NOT NULL default '' COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
    `url`             varchar(200)     NOT NULL default '' COMMENT '权限URL，菜单用',
    `icon`            varchar(50)      NOT NULL default '' COMMENT '权限图标，菜单用',
    `sort`            smallint(4)      NOT NULL default 0 COMMENT '排序权重',
    `hidden`          tinyint(2)       NOT NULL default 1 COMMENT '是否隐藏,1显示,2隐藏',
    `data_status`     tinyint(2)       NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='权限';

/* 系统角色表 */
CREATE TABLE `sys_role`
(
    `id`          int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `role_name`   varchar(20)      NOT NULL default '' COMMENT '角色名称',
    `remark`      varchar(100)     NOT NULL default '' COMMENT '备注',
    `permissions` varchar(500)     NOT NULL default '' COMMENT '权限id，多个以逗号分隔',
    `create_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `data_status` tinyint(2)       NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色';

/**管理员信息表**/
CREATE TABLE `admin_user`
(
    `id`          int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `account`     varchar(20)      NOT NULL COMMENT '账号',
    `login_pwd`   varchar(64)      NOT NULL COMMENT '登陆密码',
    `avatar`      varchar(255)     NOT NULL COMMENT '头像图片url地址',
    `nickname`    varchar(20)      NOT NULL DEFAULT '' COMMENT '昵称',
    `role_id`     int(10) UNSIGNED NOT NULL COMMENT '角色id',
    `data_status` tinyint(2)       NOT NULL DEFAULT 2 COMMENT '通用状态,2正常,3删除,4禁用',
    `create_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `account` (`account`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='管理员信息';

/**用户信息表**/
CREATE TABLE `user_info`
(
    `id`          int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `mobile`      varchar(11)      NOT NULL COMMENT '手机号',
    `email`       varchar(50)      NOT NULL DEFAULT '' COMMENT '邮箱',
    `password`    varchar(64)      NOT NULL COMMENT '密码',
    `avatar`      varchar(255)     NOT NULL COMMENT '头像图片url地址',
    `nickname`    varchar(20)      NOT NULL DEFAULT '' COMMENT '昵称',
    `gender`      tinyint(1)       NOT NULL DEFAULT '0' COMMENT '0:保密 1:男 2:女',
    `birthday`    date             NOT NULL DEFAULT '1990-01-01' COMMENT '生日',
    `data_status` tinyint(2)       NOT NULL DEFAULT 2 COMMENT '通用状态,2正常,3删除,4禁用',
    `create_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `mobile` (`mobile`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户信息';


/* 商品分类表 */
CREATE TABLE `product_category`
(
    `category_id`   int(10) UNSIGNED NOT NULL COMMENT '分类id',
    `parent_id`     int(10)          NOT NULL default 0 COMMENT '上级分类ID，一级为0',
    `category_name` varchar(32)      NOT NULL default '' COMMENT '分类名称',
    `product_num`   int(10)                   DEFAULT NULL default 0 COMMENT '分类下的商品数量',
    `icon`          varchar(50)      NOT NULL default '' COMMENT '分类图标',
    `sort`          smallint(4)      NOT NULL default 0 COMMENT '排序权重',
    `create_time`   timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `data_status`   tinyint(2)       NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
    PRIMARY KEY (`category_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品分类';

/* 商品品牌表 */
CREATE TABLE `product_brand`
(
    `id`           int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `brand_name`   varchar(32)      NOT NULL default '' COMMENT '品牌名称',
    `category_id`  int(10)          NOT NULL default 0 COMMENT '分类ID',
    `first_letter` char(1)                   DEFAULT '' COMMENT '首字母',
    `brand_logo`   varchar(128)              DEFAULT '' COMMENT '品牌logo',
    `brand_img`    varchar(128)              DEFAULT '' COMMENT '专区大图',
    `intro`        varchar(500)              DEFAULT '' COMMENT '简单介绍',
    `product_num`  int(10)                   DEFAULT NULL default 0 COMMENT '品牌下商品数量',
    `sort`         smallint(4)      NOT NULL default 0 COMMENT '排序权重',
    `create_time`  timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `data_status`  tinyint(2)       NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品品牌';

/**店铺，初期可能只有一个自营店铺*/
CREATE TABLE `shop`
(
    `id`          int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `shop_name`   varchar(100)     NOT NULL DEFAULT '' COMMENT '店铺名称',
    `product_num` int(10)          NOT NULL DEFAULT 0 COMMENT '店铺商品数量',
    `create_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `data_status` tinyint(2)       NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='店铺详情';

/**商品服务表**/
CREATE TABLE IF NOT EXISTS `product_service`
(
    `id`           bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '服务id',
    `service_name` varchar(64)         NOT NULL COMMENT '服务名称',
    `description`  text                NOT NULL COMMENT '服务描述',
    `logo`         varchar(255)        NOT NULL COMMENT 'logo',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT = '商品服务表';

/**商品信息表**/
CREATE TABLE `product_info`
(
    `id`           int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `category_id`  int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品分类id',
    `brand_id`     int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品品牌id',
    `shop_id`      int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '店铺id',
    `product_name` varchar(500)     NOT NULL COMMENT '商品名称',
    `product_img`  varchar(2000)    NOT NULL DEFAULT '' COMMENT '商品图片,多个图片逗号隔开，第一个作为封面图',
    `price`        decimal(10, 2)   NOT NULL DEFAULT 0.00 COMMENT '商品价格',
    `origin_price` decimal(10, 2)   NOT NULL DEFAULT 0.00 COMMENT '原价',
    `stock`        int(10)          NOT NULL DEFAULT 0 COMMENT '库存数量',
    `sales`        int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售数量',
    `sort`         smallint(4)      NOT NULL default 0 COMMENT '排序权重',
    `intro`        VARCHAR(2000)    NOT NULL DEFAULT '' COMMENT '商品介绍',
    `services`     varchar(200)     NOT NULL DEFAULT '' COMMENT '商品服务，逗号隔开',
    `create_time`  timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `data_status`  tinyint(2)       NOT NULL default 2 COMMENT '通用状态,2正常,3删除',
    PRIMARY KEY (`id`),
    KEY `idx_category_id` (`category_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品详情';

/**商品sku表**/
CREATE TABLE IF NOT EXISTS `product_sku`
(
    `id`           int(11)        NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `product_id`   int(11)        NOT NULL DEFAULT 0 COMMENT '商品编号',
    `sku_name`     varchar(500)   NOT NULL DEFAULT '' COMMENT 'SKU名称',
    `price`        decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
    `origin_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '原价',
    `stock`        int(11)        NOT NULL DEFAULT 0 COMMENT '库存',
    `picture`      varchar(255)   NOT NULL DEFAULT '0' COMMENT '如果是第一个sku编码, 可以加图片',
    PRIMARY KEY (`id`),
    KEY `idx_product_id` (`product_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品sku表';

/****/