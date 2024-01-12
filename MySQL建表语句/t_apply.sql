DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '奖学金申请这个事件的id(自增的）',
  `userId` varchar(32) default null COMMENT '申请人学号',
  `applyNickName`  varchar(32) default null comment '申请人姓名',
  `applyClass` varchar(11) default null comment '申请人班级',
  `scholarshipId` int default null comment '申请的奖学金id',
  `scholarshipName` varchar(32) default null COMMENT '申请的奖学金的名称',
  `reason` TEXT DEFAULT NULL COMMENT '申请奖学金的理由',
  `teacherId` varchar(11) default null comment '审核辅导员工号',
  `teacherState` varchar(11) DEFAULT NULL COMMENT '辅导员审核状态：yes或者no',
  `adminId` varchar(11) default null comment '审核管理员id',
  `adminState`  varchar(11) DEFAULT NULL COMMENT '管理员审核状态：yes或者no',
  `create_time` datetime DEFAULT NULL COMMENT '申请创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '申请更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='奖学金申请表';