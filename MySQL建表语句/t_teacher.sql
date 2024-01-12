DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` varchar(32) NOT NULL COMMENT '辅导员工号',
  `username` varchar(32) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别：0男，1女',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月日',
  `telephone` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮件地址',
  `profession` varchar(32) DEFAULT NULL COMMENT '管理班级',
  `create_time` datetime DEFAULT NULL COMMENT '账号添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '账号更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='辅导员表';

