DROP TABLE IF EXISTS `mediciTool`;
CREATE TABLE `mediciTool`(
`id`        bigint(20)   NOT NULL AUTO_INCREMENT  COMMENT 'ID',
`buyTime`   varchar(32)  NOT NULL COMMENT '购买日期',
`saleUnit`  varchar(32)  NOT NULL COMMENT '销售单位',
`saleCode`  varchar(32)  NOT NULL COMMENT '销售单号',
`name`      varchar(32)  NOT NULL COMMENT '商品名称',
`standard`  varchar(32)  NOT NULL COMMENT '规格',
`unit`      varchar(32)  NOT NULL COMMENT '单位',
`num`       bigint(20)   NOT NULL COMMENT '数量',
`price`     bigint(20)   NOT NULL COMMENT '单价/元',
`factory`   varchar(32)  NOT NULL COMMENT '生产企业',
`registrId` varchar(32)  NOT NULL COMMENT '注册号',
`batchNo`   varchar(32)  NOT NULL COMMENT '生产批号',
`producData` varchar(32) NOT NULL COMMENT '生产日期',
`usefulData`  varchar(32)NOT NULL COMMENT '有效期',
`responsiPerson` varchar(32) NOT NULL COMMENT '责任人',
`remark` varchar(32)     NOT NULL COMMENT '备注',
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tooth`;
CREATE TABLE `tooth`(
`id`        bigint(20)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
`useTime`   varchar(32)    NOT NULL  COMMENT '使用日期',
`name`      varchar(32)    NOT NULL  COMMENT '姓名',
`sex`       varchar(32)    NOT NULL  COMMENT '性别',
`age`       bigint(20)     NOT NULL  COMMENT '年龄',
`address`   varchar(32)    NOT NULL  COMMENT '地址',
`telephone` varchar(32)    NOT NULL  COMMENT '电话',
`type`      varchar(32)    NOT NULL  COMMENT '型号',
`toothSite` varchar(32)    NOT NULL  COMMENT '齿位',
`num`       bigint(20)     NOT NULL  COMMENT '数量',
`batchNo`   varchar(32)    NOT NULL  COMMENT '生产批号',
`factory`   varchar(32)    NOT NULL  COMMENT '生产企业',
`check`     boolean        NOT NULL  COMMENT '验收是否合格',
`handlers`  varchar(32)    NOT NULL  COMMENT '操作者',
`isSuccess` boolean        default true  COMMENT '是否完成',
PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;