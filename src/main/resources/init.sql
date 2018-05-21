use test_00;

DROP TABLE IF EXISTS `t_user_0000`;
CREATE TABLE `t_user_0000` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

use test_01;

DROP TABLE IF EXISTS `t_user_0001`;
CREATE TABLE `t_user_0001` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
