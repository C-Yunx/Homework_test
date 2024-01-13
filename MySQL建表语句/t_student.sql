DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` varchar(32) not null COMMENT '学生学号',
  `classNumber` varchar(32) default NULL COMMENT '学生班级',
  `username` varchar(32) DEFAULT NULL unique COMMENT '学生登录账号',
  `password` varchar(32) DEFAULT NULL COMMENT '学生登录密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '学生姓名',
  `sex` int(11) DEFAULT NULL COMMENT '学生性别：0男，1女',
  `birthday` varchar(255) DEFAULT NULL COMMENT '学生出生年月日',
  `telephone` varchar(32) DEFAULT NULL COMMENT '学生电话',
  `email` varchar(32) DEFAULT NULL COMMENT '学生邮箱',
  `profession` varchar(32) DEFAULT NULL COMMENT '学生专业',
  `ifPool` int(11) default NULL COMMENT '学生家庭是否贫困',
  `proClassGrade` int default NULL COMMENT '学生的专业课程成绩',
  `peClassGrade` int default NULL COMMENT '学生的体测成绩',
  `cultureClassGrade` int default NULL COMMENT '学生的思想文化成绩',
  `comprehensiveTestGrade` int default NULL COMMENT '学生的综测成绩',
  `totalClassGrade` int DEFAULT NULL COMMENT '学生的总成绩',
  `ifViolationOfDiscipline` int DEFAULT NULL COMMENT '学生是否有违纪情况',
  `create_time` datetime DEFAULT NULL COMMENT '学生账号添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '学生账号更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='学生表';
