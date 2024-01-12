DROP TABLE IF EXISTS `t_scholarship`;
CREATE TABLE `t_scholarship` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '奖学金序号',
  `scholarshipName` varchar(32) DEFAULT NULL COMMENT '奖学金名称',
  `scholarshipType` varchar(32) default null COMMENT '奖学金的类型：
      0校内入学资助，1勤工俭学补贴，2中西部新生入学资助项目
      3师范生公费补贴，4基层就业学费补偿，5服兵役高等学校学生补偿
      6国家教育资助补贴，7国家助学金
      8国家励志奖学金
      9研究生国家助学金
      10创新创业激励金
      11五好学生奖励金
      12校内励志奖学金',
  `bonusAmount` varchar(32) default NULL COMMENT '奖学金金额',
  `scholarshipRequirements` TEXT DEFAULT NULL COMMENT '奖学金申请条件',
  `scholarshipIntroductions` TEXT DEFAULT NULL COMMENT '奖学金介绍',
  `scholarshipGrade` int default null comment '申请奖学金需要达到的总分数',
  `create_time` datetime DEFAULT NULL COMMENT '奖学金添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '奖学金更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='奖学金表';