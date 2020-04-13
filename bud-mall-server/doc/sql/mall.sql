
--
-- 表的结构 `goods`
--

DROP TABLE IF EXISTS `goods`;
CREATE TABLE IF NOT EXISTS `goods` (
       `goods_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品id(SKU)',
       `goods_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商品名称',
       `category_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品分类id',
       `category_id_1` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '一级分类id',
       `category_id_2` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '二级分类id',
       `category_id_3` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '三级分类id',
       `price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '商品原价格',
       `promotion_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '商品促销价格',
       `stock` int(10) NOT NULL DEFAULT 0 COMMENT '商品库存',
       `sales` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售数量',
       `collects` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '收藏数量',
       `positive_rating` smallint(5) UNSIGNED NOT NULL DEFAULT 10000 COMMENT '好评率',
       `evaluates` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '评价数',
       `shares` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '分享数',
       `picture` varchar(1000) NOT NULL DEFAULT '' COMMENT '商品主图',
       `keywords` varchar(255) NOT NULL DEFAULT '' COMMENT '商品关键词',
       `introduction` varchar(255) NOT NULL DEFAULT '' COMMENT '商品简介，促销语',
       `description` text NOT NULL COMMENT '商品详情',
       `attributes` text NOT NULL COMMENT '商品属性',
       `is_hot` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否热销商品',
       `is_recommend` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否推荐',
       `is_new` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否新品',
       `state` tinyint(3) NOT NULL DEFAULT 1 COMMENT '商品状态 0下架，1正常，10违规（禁售）',
       `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
       `img_array` varchar(1000) DEFAULT NULL COMMENT '商品图片序列',
       `sku_img_array` varchar(1000) DEFAULT NULL COMMENT '商品sku应用图片列表  属性,属性值，图片ID',
       `create_time` int(11) NOT NULL DEFAULT 0 COMMENT '商品添加时间',
       `update_time` int(11) NOT NULL DEFAULT 0 COMMENT '商品编辑时间',
       `origin_id` bigint(20) NOT NULL COMMENT '商品产地',
       `service_commitments` varchar(64) NOT NULL COMMENT '商品服务',
       `shipping_template_id` int(10) UNSIGNED NOT NULL COMMENT '运费模板',
       `shipping_weight` decimal(10,2) UNSIGNED NOT NULL COMMENT '运输重量',
       `shipping_volume` decimal(10,2) UNSIGNED NOT NULL COMMENT '运输体积',
       PRIMARY KEY (`goods_id`),
       KEY `category_id` (`category_id`),
       KEY `category_id_1` (`category_id_1`),
       KEY `category_id_2` (`category_id_2`),
       KEY `category_id_3` (`category_id_3`),
       KEY `origin_id` (`origin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 AVG_ROW_LENGTH=16554 DEFAULT CHARSET=utf8 COMMENT='商品表';

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`goods_id`, `goods_name`, `category_id`, `category_id_1`, `category_id_2`, `category_id_3`, `price`, `promotion_price`, `stock`, `sales`, `collects`, `positive_rating`, `evaluates`, `shares`, `picture`, `keywords`, `introduction`, `description`, `attributes`, `is_hot`, `is_recommend`, `is_new`, `state`, `sort`, `img_array`, `sku_img_array`, `create_time`, `update_time`, `origin_id`, `service_commitments`, `shipping_template_id`) VALUES
(57, '黄一琳2017夏季新款韩版性感遮肚子百褶裙 吊带连衣裙女中长款潮', 0, 0, 0, 0, '259.00', '159.00', 98, 3, 0, 6667, 3, 0, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods1_1.jpg', '', '', '<p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_1_1.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_1_2.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_1_3.png\"/></p><p><br/></p>', '[{\"title\":\"颜色\",\"value\":\"黑色条\"},{\"title\":\"尺码\",\"value\":\"S M L\"},{\"title\":\"流行元素\",\"value\":\"显瘦显高挑\"},{\"title\":\"面料\",\"value\":\"棉\"},{\"title\":\"袖长\",\"value\":\"无袖\"},{\"title\":\"面料\",\"value\":\"棉\"},{\"title\":\"袖长\",\"value\":\"无袖\"},{\"title\":\"适用季节\",\"value\":\"夏季\"},{\"title\":\"上市时间\",\"value\":\"2017.4.2\"}]', 0, 0, 0, 1, 0, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods1_1.jpg,https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods1_2.jpg,https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods1_3.jpg', NULL, 1523600687, 0, 1, '1,2', 0),
(58, '黄一琳定制2017夏季新品韩版百搭圆领字母T时尚学生装上衣短袖T恤', 0, 0, 0, 0, '189.00', '89.00', 97, 6, 0, 10000, 0, 0, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods2_1.jpg', '', '', '<p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_2_1.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_2_2.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_2_3.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_2_4.png\"/></p><p><br/></p>', '[{\"title\":\"颜色\",\"value\":\"白色\"},{\"title\":\"尺码\",\"value\":\"S M L\"},{\"title\":\"流行元素\",\"value\":\"字母logo印花\"},{\"title\":\"面料\",\"value\":\"棉\"},{\"title\":\"袖长\",\"value\":\"无袖\"},{\"title\":\"面料\",\"value\":\"棉\"},{\"title\":\"袖长\",\"value\":\"短袖\"},{\"title\":\"适用季节\",\"value\":\"夏季\"},{\"title\":\"上市时间\",\"value\":\"2017.4.7\"}]', 0, 0, 0, 1, 0, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods2_1.jpg,https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods2_2.jpg,https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods2_3.jpg', NULL, 1523603182, 0, 2, '1,3', 0),
(59, '牛仔短裤女夏韩版黄一琳2017新款热裤宽松毛边中腰字母刺绣超短裤', 1, 0, 0, 1, '209.00', '109.00', 206, 11, 0, 7778, 9, 0, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods3_1.jpg', '111', '', '<p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_3_1.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_3_2.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_3_3.png\"/></p><p style=\"text-align: center;\"><img src=\"https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods_des_3_4.png\"/></p><p><br/></p>', '', 0, 0, 0, 1, 0, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods3_1.jpg,https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods3_2.jpg,https://test-1256313035.cos.ap-guangzhou.myqcloud.com/goods3_3.jpg', NULL, 1523604487, 1524906570, 3, '2,4', 0);

-- --------------------------------------------------------

--
-- 表的结构 `goods_attribute`
--

DROP TABLE IF EXISTS `goods_attribute`;
CREATE TABLE IF NOT EXISTS `goods_attribute` (
     `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `goods_type_id` int(11) UNSIGNED NOT NULL COMMENT '商品分类id',
     `type` tinyint(2) UNSIGNED NOT NULL COMMENT '属性类别，1输入，2单选，3多选',
     `values` varchar(1000) NOT NULL COMMENT '属性类别值，在type为2和3的时候使用',
     `name` varchar(50) NOT NULL COMMENT '属性名称',
     `sort` int(11) NOT NULL COMMENT '排序',
     PRIMARY KEY (`id`),
     KEY `idx_goods_type_id` (`goods_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- --------------------------------------------------------

--
-- 表的结构 `goods_attribute_value`
--

DROP TABLE IF EXISTS `goods_attribute_value`;
CREATE TABLE IF NOT EXISTS `goods_attribute_value` (
       `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
       `goods_id` int(11) UNSIGNED NOT NULL COMMENT '商品id',
       `goods_attribute_id` int(11) UNSIGNED NOT NULL COMMENT '商品属性id',
       `goods_attribute_name` varchar(50) NOT NULL DEFAULT '商品属性名称',
       `value` varchar(100) NOT NULL DEFAULT '商品属性值',
       `sort` int(11) NOT NULL COMMENT '排序',
       PRIMARY KEY (`id`),
       KEY `idx_goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性值表';

-- --------------------------------------------------------

--
-- 表的结构 `goods_category`
--

DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE IF NOT EXISTS `goods_category` (
    `category_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    `category_name` varchar(50) NOT NULL DEFAULT '',
    `short_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商品分类简称 ',
    `pid` int(11) NOT NULL DEFAULT 0,
    `level` tinyint(4) NOT NULL DEFAULT 0,
    `is_visible` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否显示  1 显示 0 不显示',
    `attr_id` int(11) NOT NULL DEFAULT 0 COMMENT '关联商品类型ID',
    `attr_name` varchar(255) NOT NULL DEFAULT '' COMMENT '关联类型名称',
    `keywords` varchar(255) NOT NULL DEFAULT '',
    `description` varchar(255) NOT NULL DEFAULT '',
    `sort` int(11) NOT NULL DEFAULT 0,
    `category_pic` varchar(255) NOT NULL DEFAULT '' COMMENT '商品分类图片',
    PRIMARY KEY (`category_id`),
    KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=132 AVG_ROW_LENGTH=244 DEFAULT CHARSET=utf8 COMMENT='商品分类表';

--
-- 转存表中的数据 `goods_category`
--

INSERT INTO `goods_category` (`category_id`, `category_name`, `short_name`, `pid`, `level`, `is_visible`, `attr_id`, `attr_name`, `keywords`, `description`, `sort`, `category_pic`) VALUES
(1, '家用电器', '家电', 0, 1, 1, 0, '', '家电', '家电', 1, ''),
(2, '手机/运营商/数码', '通讯', 0, 1, 1, 0, '', '通讯', '通讯', 2, ''),
(3, '电脑/办公', '电脑', 0, 1, 1, 0, '', '电脑', '电脑', 3, ''),
(4, '家居/家具/家装/厨具', '家居', 0, 1, 1, 0, '', '家居', '家居', 4, ''),
(5, '男装/女装/童装/内衣', '衣服', 0, 1, 1, 0, '', '衣服', '衣服', 5, ''),
(6, '美妆个护/宠物', '美妆', 0, 1, 1, 0, '', '美妆', '美妆', 6, ''),
(7, '女鞋/箱包/钟表/珠宝', '配饰', 0, 1, 1, 0, '', '配饰', '配饰', 7, ''),
(8, '男鞋/运动/户外', '运动', 0, 1, 1, 0, '', '运动', '运动', 8, ''),
(9, '汽车/汽车用品', '汽车', 0, 1, 1, 0, '', '汽车', '汽车', 9, ''),
(10, '母婴/玩具用品', '母婴', 0, 1, 1, 0, '', '母婴', '母婴', 10, ''),
(11, '食品/酒类/生鲜/特产', '食品生鲜', 0, 1, 1, 0, '', '食品生鲜', '食品生鲜', 11, ''),
(12, '礼品鲜花/农资绿植', '礼品农资', 0, 1, 1, 0, '', '礼品', '礼品', 12, ''),
(13, '机票/酒店/旅游/生活', '旅游', 0, 1, 1, 0, '', '旅游', '旅游', 13, ''),
(14, '电视', '电视', 1, 2, 1, 0, '', '电视', '电视', 1, '132'),
(15, '空调', '空调', 1, 2, 1, 0, '', '空调', '空调', 2, '138'),
(16, '洗衣机', '洗衣机', 1, 2, 1, 0, '', '洗衣机', '洗衣机', 3, '139'),
(17, '手机通讯', '手机', 2, 2, 1, 0, '', '手机', '手机', 1, ''),
(18, '运营商', '运营商', 2, 2, 1, 0, '', '运营商', '运营商', 2, ''),
(20, '手机配件', '手机配件', 2, 2, 1, 0, '', '手机配件', '手机配件', 3, ''),
(21, '电脑整机', '电脑整机', 3, 2, 1, 0, '', '电脑整机', '电脑整机', 1, ''),
(22, '电脑配件', '电脑配件', 3, 2, 1, 0, '', '电脑配件', '电脑配件', 2, ''),
(23, '外设产品', '外设产品', 3, 2, 1, 0, '', '外设产品', '外设产品', 3, ''),
(24, '厨具', '厨具', 4, 2, 1, 0, '', '厨具', '厨具', 1, ''),
(25, '家纺', '家纺', 4, 2, 1, 0, '', '家纺', '家纺', 2, ''),
(26, '生活用品', '生活用品', 4, 2, 1, 0, '', '生活用品', '生活用品', 3, ''),
(27, '女装', '女装', 5, 2, 1, 0, '', '女装', '女装', 1, ''),
(28, '男装', '男装', 5, 2, 1, 0, '', '男装', '男装', 2, ''),
(29, '内衣', '内衣', 5, 2, 1, 0, '', '内衣', '内衣', 3, ''),
(30, '面部护肤', '面部护肤', 6, 2, 1, 0, '', '面部护肤', '面部护肤', 1, ''),
(31, '洗发护发', '洗发护发', 6, 2, 1, 0, '', '洗发护发', '洗发护发', 2, ''),
(32, '身体护理', '身体护理', 6, 2, 1, 0, '', '身体护理', '身体护理', 3, ''),
(33, '时尚女鞋', '女鞋', 7, 2, 1, 0, '', '女鞋', '女鞋', 1, ''),
(35, '潮流女包', '女包', 7, 2, 1, 0, '', '女包', '女包', 2, ''),
(36, '精品男包', '男包', 7, 2, 1, 0, '', '男包', '男包', 3, ''),
(37, '流行男鞋', '男鞋', 8, 2, 1, 0, '', '男鞋', '男鞋', 1, ''),
(38, '运动鞋包', '鞋包', 8, 2, 1, 0, '', '鞋包', '鞋包', 2, ''),
(39, '运动服饰', '服饰', 8, 2, 1, 0, '', '服饰', '服饰', 3, ''),
(40, '汽车车型', '车型', 9, 2, 1, 0, '', '车型', '车型', 1, ''),
(41, '汽车价格', '车价', 9, 2, 1, 0, '', '车价', '车价', 2, ''),
(42, '汽车品牌', '品牌', 9, 2, 1, 0, '', '品牌', '品牌', 3, ''),
(43, '奶粉', '奶粉', 10, 2, 1, 0, '', '奶粉', '奶粉', 1, ''),
(44, '营养辅食', '营养辅食', 10, 2, 1, 0, '', '营养辅食', '营养辅食', 2, ''),
(45, '尿裤湿巾', '尿裤', 10, 2, 1, 0, '', '尿裤', '尿裤', 3, ''),
(46, '新鲜水果', '水果', 11, 2, 1, 0, '', '水果', '水果', 1, ''),
(47, '蔬菜蛋品', '蔬菜', 11, 2, 1, 0, '', '蔬菜', '蔬菜', 2, ''),
(48, '精选蔬菜', '蔬菜', 11, 2, 1, 0, '', '蔬菜', '蔬菜', 3, ''),
(49, '礼品', '礼品', 12, 2, 1, 0, '', '礼品', '礼品', 1, ''),
(50, '绿植园艺', '园艺', 12, 2, 1, 0, '', '园艺', '园艺', 2, ''),
(51, '种子', '种子', 12, 2, 1, 0, '', '种子', '种子', 3, ''),
(52, '交通出行', '交通', 13, 2, 1, 0, '', '交通', '交通', 1, ''),
(53, '酒店预订', '酒店预订', 13, 2, 1, 0, '', '酒店预订', '酒店预订', 2, ''),
(54, '旅游度假', '旅游', 13, 2, 1, 0, '', '旅游', '旅游', 3, ''),
(55, '曲面电视', '曲面电视', 14, 3, 1, 0, '', '曲面电视', '曲面电视', 1, ''),
(56, '超薄电视', '超薄电视', 14, 3, 1, 0, '', '超薄电视', '超薄电视', 2, ''),
(57, 'HDR电视', 'HDR电视', 14, 3, 1, 0, '', 'HDR电视', 'HDR电视', 3, ''),
(58, '壁挂式空调', '壁挂式', 15, 3, 1, 0, '', '壁挂式', '壁挂式', 1, ''),
(59, '柜式空调', '柜式', 15, 3, 1, 0, '', '柜式', '柜式', 2, ''),
(60, '中央空调', '中央', 15, 3, 1, 0, '', '中央', '中央', 3, ''),
(61, '滚筒洗衣机', '滚筒', 16, 3, 1, 0, '', '滚筒', '滚筒', 1, ''),
(62, '洗烘一体机', '洗烘一体机', 16, 3, 1, 0, '', '洗烘一体机', '洗烘一体机', 3, ''),
(63, '波轮洗衣机', '波轮', 16, 3, 1, 0, '', '波轮', '波轮', 3, ''),
(64, '手机', '手机', 17, 3, 1, 0, '', '手机', '手机', 1, ''),
(65, '对讲机', '对讲机', 17, 3, 1, 0, '', '对讲机', '对讲机', 2, ''),
(66, '以旧换新', '以旧换新', 17, 3, 1, 0, '', '以旧换新', '以旧换新', 3, ''),
(67, '合约机', '合约机', 18, 3, 1, 0, '', '合约机', '合约机', 1, ''),
(68, '选号码', '选号码', 18, 3, 1, 0, '', '选号码', '选号码', 2, ''),
(69, '固定宽带', '固定宽带', 18, 3, 1, 0, '', '固定宽带', '固定宽带', 3, ''),
(70, '手机壳', '手机壳', 20, 3, 1, 0, '', '手机壳', '手机壳', 1, ''),
(71, '贴膜', '贴膜', 20, 3, 1, 0, '', '贴膜', '贴膜', 2, ''),
(72, '手机存储卡', '存储卡', 20, 3, 1, 0, '', '存储卡', '存储卡', 3, ''),
(73, '笔记本', '笔记本', 21, 3, 1, 0, '', '笔记本', '笔记本', 1, ''),
(74, '游戏本', '游戏本', 21, 3, 1, 0, '', '游戏本', '游戏本', 2, ''),
(75, '平板电脑', '平板电脑', 21, 3, 1, 0, '', '平板电脑', '平板电脑', 3, ''),
(76, '显示器', '显示器', 22, 3, 1, 0, '', '显示器', '显示器', 1, ''),
(77, 'CPU', 'CPU', 22, 3, 1, 0, '', 'CPU', 'CPU', 2, ''),
(78, '主板', '主板', 22, 3, 1, 0, '', '主板', '主板', 3, ''),
(79, '鼠标', '鼠标', 23, 3, 1, 0, '', '鼠标', '鼠标', 1, ''),
(80, '键盘', '键盘', 23, 3, 1, 0, '', '键盘', '键盘', 2, ''),
(81, '键鼠套装', '键鼠套装', 23, 3, 1, 0, '', '键鼠套装', '键鼠套装', 3, ''),
(82, '烹饪锅具', '烹饪锅具', 24, 3, 1, 0, '', '烹饪锅具', '烹饪锅具', 1, ''),
(83, '刀剪菜板', '刀剪菜板', 24, 3, 1, 0, '', '刀剪菜板', '刀剪菜板', 2, ''),
(84, '厨房配件', '厨房配件', 24, 3, 1, 0, '', '厨房配件', '厨房配件', 3, ''),
(85, '床品套件', '床品套件', 25, 3, 1, 0, '', '床品套件', '床品套件', 1, ''),
(86, '被子', '被子', 25, 3, 1, 0, '', '被子', '被子', 2, ''),
(87, '枕芯', '枕芯', 25, 3, 1, 0, '', '枕芯', '枕芯', 3, ''),
(88, '收纳用品', '收纳用品', 26, 3, 1, 0, '', '收纳用品', '收纳用品', 1, ''),
(89, '雨伞雨具', '雨伞雨具', 26, 3, 1, 0, '', '雨伞雨具', '雨伞雨具', 2, ''),
(90, '净化除味', '净化除味', 26, 3, 1, 0, '', '净化除味', '净化除味', 3, ''),
(91, '商场同款', '商场同款', 27, 3, 1, 0, '', '商场同款', '商场同款', 1, ''),
(92, '当季热卖', '当季热卖', 27, 3, 1, 0, '', '当季热卖', '当季热卖', 2, ''),
(93, '2017新品', '2017新品', 27, 3, 1, 0, '', '2017新品', '2017新品', 3, ''),
(94, '商场同款', '商场同款', 28, 3, 1, 0, '', '商场同款', '商场同款', 1, ''),
(95, '当季热卖', '当季热卖', 28, 3, 1, 0, '', '当季热卖', '当季热卖', 2, ''),
(96, '2017新品', '2017新品', 28, 3, 1, 0, '', '2017新品', '2017新品', 3, ''),
(97, '文胸', '文胸', 29, 3, 1, 0, '', '文胸', '文胸', 1, ''),
(98, '睡衣/家居服', '睡衣/家居服', 29, 3, 1, 0, '', '睡衣/家居服', '睡衣/家居服', 3, ''),
(99, '男士内裤', '男士内裤', 29, 3, 1, 0, '', '男士内裤', '男士内裤', 3, ''),
(100, '补水保湿', '补水保湿', 30, 3, 1, 0, '', '补水保湿', '补水保湿', 1, ''),
(101, '卸妆', '卸妆', 30, 3, 1, 0, '', '卸妆', '卸妆', 2, ''),
(102, '洁面', '洁面', 30, 3, 1, 0, '', '洁面', '洁面', 3, ''),
(103, '洗发', '洗发', 31, 3, 1, 0, '', '洗发', '洗发', 1, ''),
(104, '护发', '护发', 31, 3, 1, 0, '', '护发', '护发', 2, ''),
(105, '染发', '染发', 31, 3, 1, 0, '', '染发', '染发', 3, ''),
(106, '补水保湿', '补水保湿', 32, 3, 1, 0, '', '补水保湿', '补水保湿', 1, ''),
(107, '沐浴', '沐浴', 32, 3, 1, 0, '', '沐浴', '沐浴', 2, ''),
(108, '润肤', '润肤', 32, 3, 1, 0, '', '润肤', '润肤', 3, ''),
(109, '2017新品', '2017新品', 33, 3, 1, 0, '', '2017新品', '2017新品', 1, ''),
(110, '单鞋', '单鞋', 33, 3, 1, 0, '', '单鞋', '单鞋', 2, ''),
(111, '休闲鞋', '休闲鞋', 33, 3, 1, 0, '', '休闲鞋', '休闲鞋', 3, ''),
(112, '真皮包', '真皮包', 35, 3, 1, 0, '', '真皮包', '真皮包', 1, ''),
(113, '水桶包', '水桶包', 35, 3, 1, 0, '', '水桶包', '水桶包', 2, ''),
(114, '单肩包', '单肩包', 35, 3, 1, 0, '', '单肩包', '单肩包', 3, ''),
(115, '男士钱包', '男士钱包', 36, 3, 1, 0, '', '男士钱包', '男士钱包', 1, ''),
(116, '双肩包', '双肩包', 36, 3, 1, 0, '', '双肩包', '双肩包', 2, ''),
(117, '单肩/斜挎包', '单肩/斜挎包', 36, 3, 1, 0, '', '单肩/斜挎包', '单肩/斜挎包', 3, ''),
(118, '2017新品', '2017新品', 37, 3, 1, 0, '', '2017新品', '2017新品', 1, ''),
(119, '休闲鞋', '休闲鞋', 37, 3, 1, 0, '', '休闲鞋', '休闲鞋', 2, ''),
(120, '商务休闲鞋', '商务休闲鞋', 37, 3, 1, 0, '', '商务休闲鞋', '商务休闲鞋', 3, ''),
(121, '跑步鞋', '跑步鞋', 38, 3, 1, 0, '', '跑步鞋', '跑步鞋', 1, ''),
(122, '休闲鞋', '休闲鞋', 38, 3, 1, 0, '', '休闲鞋', '休闲鞋', 2, ''),
(123, '篮球鞋', '篮球鞋', 38, 3, 1, 0, '', '篮球鞋', '篮球鞋', 3, ''),
(124, 'T桖', 'T桖', 39, 3, 1, 0, '', 'T桖', 'T桖', 1, ''),
(125, '运动裤', '运动裤', 39, 3, 1, 0, '', '运动裤', '运动裤', 2, ''),
(126, '紧身衣', '紧身衣', 39, 3, 1, 0, '', '紧身衣', '紧身衣', 3, ''),
(127, '苹果', '苹果', 46, 3, 1, 0, '', '苹果', '苹果', 1, ''),
(128, '国产水果', '国产水果', 46, 3, 1, 0, '', '国产水果', '国产水果', 2, ''),
(129, '进口水果', '进口水果', 46, 3, 1, 0, '', '进口水果', '进口水果', 3, ''),
(130, '智能家居', '智能家居', 1, 2, 1, 0, '', '智能家居', '智能家居', 4, '142'),
(131, '家居智能', '家居智能', 130, 3, 1, 0, '', '家居智能', '家居智能', 1, '');

-- --------------------------------------------------------

--
-- 表的结构 `goods_collect`
--

DROP TABLE IF EXISTS `goods_collect`;
CREATE TABLE IF NOT EXISTS `goods_collect` (
       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品收藏iid',
       `uid` int(20) NOT NULL COMMENT '用户id',
       `goods_id` int(20) NOT NULL COMMENT '商品id',
       `create_time` int(11) NOT NULL COMMENT '收藏时间',
       PRIMARY KEY (`id`),
       UNIQUE KEY `uid` (`uid`,`goods_id`),
       KEY `uid_index` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='商品收藏';

--
-- 转存表中的数据 `goods_collect`
--

INSERT INTO `goods_collect` (`id`, `uid`, `goods_id`, `create_time`) VALUES
(16, 2, 59, 1524912152),
(17, 2, 57, 1524912157),
(18, 2, 58, 1524912161);

-- --------------------------------------------------------

--
-- 表的结构 `goods_evaluation`
--

DROP TABLE IF EXISTS `goods_evaluation`;
CREATE TABLE IF NOT EXISTS `goods_evaluation` (
      `evaluation_id` bigint(20) NOT NULL AUTO_INCREMENT,
      `uid` bigint(20) DEFAULT NULL,
      `user_name` varchar(64) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户名称',
      `order_id` bigint(20) DEFAULT NULL COMMENT '订单号',
      `sku_id` bigint(20) DEFAULT NULL,
      `sku_name` varchar(64) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT 'sku名称',
      `goods_id` bigint(20) DEFAULT NULL,
      `order_goods_id` bigint(20) DEFAULT NULL COMMENT '订单物品id',
      `create_time` int(11) DEFAULT NULL COMMENT '创建时间',
      `content` text CHARACTER SET utf8 DEFAULT NULL COMMENT '评论内容',
      `stars` int(11) NOT NULL,
      `pics` varchar(1000) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '评论图片',
      PRIMARY KEY (`evaluation_id`),
      UNIQUE KEY `uid` (`uid`,`order_id`,`order_goods_id`),
      KEY `goods_id_index` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1247 DEFAULT CHARSET=latin1 COMMENT='商品评论';

--
-- 转存表中的数据 `goods_evaluation`
--

INSERT INTO `goods_evaluation` (`evaluation_id`, `uid`, `user_name`, `order_id`, `sku_id`, `sku_name`, `goods_id`, `order_goods_id`, `create_time`, `content`, `stars`, `pics`) VALUES
(1234, 2, 'rinao', 36, 111, 'S', 59, 13, 1524017663, '这个产品不错', 3, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/qcode.jpg'),
(1235, 2, 'rinao', 36, 112, 'M', 59, 14, 1524017663, '这个产品不错', 4, 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/qcode.jpg'),
(1236, 2, 'rinao', 42, 111, 'S', 59, 20, 1524045126, '111111', 3, ''),
(1237, 2, 'rinao', 41, 111, 'S', 59, 19, 1524046868, '111111', 1, ''),
(1238, 2, 'rinao', 40, 105, 'S', 57, 18, 1524046759, '11111111', 1, ''),
(1239, 2, 'rinao', 28, 111, 'S', 59, 4, 1524027005, '11111', 3, ''),
(1240, 2, 'rinao', 28, 108, 'S', 58, 5, 1524027005, '11111', 3, ''),
(1241, 2, 'rinao', 39, 105, 'S', 57, 17, 1524046966, '1111111', 3, ''),
(1242, 2, 'rinao', 37, 111, 'S', 59, 15, 1524047099, '122211122', 3, ''),
(1243, 2, 'rinao', 38, 105, 'S', 57, 16, 1524047461, '111111', 3, ''),
(1244, 2, 'rinao', 35, 111, 'S', 59, 12, 1524193816, '111111', 2, 'https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180420/71e1e2134dc2bf7f2611bcdeb510de0cfd326672.png,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180420/a365d9ca3d34df21630ac7cbcb1d85a9464d17e3.png'),
(1245, 2, 'rinao', 27, 111, 'S', 59, 3, 1524194033, '111111', 5, 'https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180420/af7cae59f7971f6d6e00e7fd9f6aed66ce0f2754.jpg,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180420/a365d9ca3d34df21630ac7cbcb1d85a9464d17e3.png,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180420/5e921e898686de07f737fcb7a3d2bcf73d744016.png,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180420/a919b886303c524e6e22ba55b2faeb5d04318a98.jpg'),
(1246, 2, 'rinao', 9, 111, 'S', 59, 4, 1524639468, '32个赞！', 5, 'https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180425/5e921e898686de07f737fcb7a3d2bcf73d744016.png,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180425/a80ef6382b8881d6c84e51965798ba5fe768c59c.png,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180425/a365d9ca3d34df21630ac7cbcb1d85a9464d17e3.png,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180425/af7cae59f7971f6d6e00e7fd9f6aed66ce0f2754.jpg,https://user-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180425/a919b886303c524e6e22ba55b2faeb5d04318a98.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `goods_origin`
--

DROP TABLE IF EXISTS `goods_origin`;
CREATE TABLE IF NOT EXISTS `goods_origin` (
          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产地ID',
          `origin` varchar(64) NOT NULL DEFAULT '' COMMENT '产地名称',
          `origin_logo` varchar(255) NOT NULL DEFAULT '' COMMENT '产地图标',
          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品产地标';

--
-- 转存表中的数据 `goods_origin`
--

INSERT INTO `goods_origin` (`id`, `origin`, `origin_logo`) VALUES
(1, '中国品牌', 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/%E4%B8%AD%E5%9B%BD.png'),
(2, '美国品牌', 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/%E7%BE%8E%E5%9B%BD.png'),
(3, '日本品牌', 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/%E6%97%A5%E6%9C%AC.png'),
(4, '韩国品牌', 'https://test-1256313035.cos.ap-guangzhou.myqcloud.com/%E9%9F%A9%E5%9B%BD.png');

-- --------------------------------------------------------

--
-- 表的结构 `goods_sku`
--

DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE IF NOT EXISTS `goods_sku` (
       `sku_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表序号',
       `goods_id` int(11) NOT NULL DEFAULT 0 COMMENT '商品编号',
       `sku_name` varchar(500) NOT NULL DEFAULT '' COMMENT 'SKU名称',
       `attr_value_items` varchar(255) NOT NULL DEFAULT '' COMMENT '属性和属性值 id串 attribute + attribute value 表ID分号分隔',
       `price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '价格',
       `promote_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '促销价格',
       `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存',
       `picture` varchar(255) NOT NULL DEFAULT '0' COMMENT '如果是第一个sku编码, 可以加图片',
       PRIMARY KEY (`sku_id`),
       KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 AVG_ROW_LENGTH=481 DEFAULT CHARSET=utf8 COMMENT='商品skui规格价格库存信息表';

--
-- 转存表中的数据 `goods_sku`
--

INSERT INTO `goods_sku` (`sku_id`, `goods_id`, `sku_name`, `attr_value_items`, `price`, `promote_price`, `stock`, `picture`) VALUES
(105, 57, 'S', '10:18', '259.00', '159.00', 95, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/59495958b3e94071d83f00928a6deb2d45b2cca3.jpg'),
(106, 57, 'M', '10:19', '259.00', '159.00', 89, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/05c9a7153a84f6b7fed057cb978eac6bf318a799.jpg'),
(107, 57, 'L', '10:20', '259.00', '159.00', 97, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/88978bac048bdf835f0c03ac322caad5e1055b86.jpg'),
(108, 58, 'S', '10:18', '189.00', '89.00', 98, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/25115c1e2ba90708949e9adba470736e7982f69c.jpg'),
(109, 58, 'M', '10:19', '189.00', '89.00', 99, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/1eabe5a36a92434b733f3b5c76e2898e2c4be984.jpg'),
(110, 58, 'L', '10:20', '189.00', '89.00', 91, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/1aa89043d77fa2559bbf4d74dceb5a0000714fc0.jpg'),
(111, 59, 'S', '10:18', '109.00', '109.00', 4, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/c8847bf2a5b16cf9b4692b2c6e7076769bc937c8.jpg'),
(112, 59, 'M', '10:19', '109.00', '109.00', 103, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/4d264fc5f3a3f13cd322bab0f4ac30fe4b2db8b6.jpg'),
(113, 59, 'L', '10:20', '109.00', '109.00', 99, 'https://admin-uploads-1256313035.cos.ap-guangzhou.myqcloud.com/20180428/29cdb0c2133a4b876648f21714aabe1a47e8ca68.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `goods_sku_template`
--

DROP TABLE IF EXISTS `goods_sku_template`;
CREATE TABLE IF NOT EXISTS `goods_sku_template` (
        `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `goods_type_id` int(11) UNSIGNED NOT NULL COMMENT '商品类别id',
        `spec_id` int(11) UNSIGNED NOT NULL COMMENT '商品规格id',
        `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
        PRIMARY KEY (`id`),
        KEY `idx_goods_type_id` (`goods_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品sku模板表';

-- --------------------------------------------------------

--
-- 表的结构 `goods_spec`
--

DROP TABLE IF EXISTS `goods_spec`;
CREATE TABLE IF NOT EXISTS `goods_spec` (
        `spec_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '规格ID',
        `spec_name` varchar(255) NOT NULL DEFAULT '' COMMENT '规格名称',
        `is_visible` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否可视',
        `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
        PRIMARY KEY (`spec_id`),
        KEY `sort` (`sort`)
) ENGINE=InnoDB AUTO_INCREMENT=13 AVG_ROW_LENGTH=3276 DEFAULT CHARSET=utf8 COMMENT='商品属性（规格）表';

--
-- 转存表中的数据 `goods_spec`
--

INSERT INTO `goods_spec` (`spec_id`, `spec_name`, `is_visible`, `sort`) VALUES
(6, '手机尺寸', 1, 1),
(7, '颜色', 1, 2),
(8, '颜色', 1, 3),
(10, '尺码', 1, 5),
(11, '衣服颜色', 1, 6),
(12, '大小', 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `goods_spec_value`
--

DROP TABLE IF EXISTS `goods_spec_value`;
CREATE TABLE IF NOT EXISTS `goods_spec_value` (
      `spec_value_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品规格值ID',
      `spec_id` int(11) UNSIGNED NOT NULL COMMENT '商品规格ID',
      `spec_value_name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品规格值名称',
      `is_visible` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否可视',
      `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
      PRIMARY KEY (`spec_value_id`),
      KEY `spec_id` (`spec_id`),
      KEY `sort` (`sort`)
) ENGINE=InnoDB AUTO_INCREMENT=29 AVG_ROW_LENGTH=1092 DEFAULT CHARSET=utf8 COMMENT='商品规格值模版表';

--
-- 转存表中的数据 `goods_spec_value`
--

INSERT INTO `goods_spec_value` (`spec_value_id`, `spec_id`, `spec_value_name`, `is_visible`, `sort`) VALUES
(8, 6, '4.5寸', 1, 0),
(9, 6, '4.7寸', 1, 0),
(10, 6, '5.0寸', 1, 0),
(11, 7, '玫瑰金', 1, 0),
(12, 7, '黑色', 1, 0),
(13, 7, '土豪金', 1, 0),
(14, 8, '粉色', 1, 0),
(15, 8, '白色', 1, 0),
(16, 8, '土豪金', 1, 0),
(18, 10, 'S', 1, 0),
(19, 10, 'M', 1, 0),
(20, 10, 'L', 1, 0),
(21, 10, 'xl', 1, 0),
(22, 10, '2xl', 1, 0),
(23, 11, '粉色', 1, 0),
(24, 11, '红色', 1, 0),
(25, 11, '白色', 1, 0),
(26, 12, '大', 1, 0),
(27, 12, '中', 1, 0),
(28, 12, '小', 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `goods_type`
--

DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE IF NOT EXISTS `goods_type` (
        `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
        `pid` int(11) UNSIGNED NOT NULL COMMENT '上级id',
        `name` varchar(50) NOT NULL DEFAULT '类别名称',
        `sort` int(11) NOT NULL COMMENT '排序',
        PRIMARY KEY (`id`),
        KEY `idx_pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- --------------------------------------------------------
