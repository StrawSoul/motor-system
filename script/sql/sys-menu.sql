CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(32),
   app_id varchar(32),
   link_id  varchar(32),
   page_id  varchar(32),
   auth_code varchar(64),
   description text,
   `version` int(11),
   create_time datetime,
   update_time datetime,
   create_by varchar(32),
   update_by varchar(32),
   deleted int(1)  DEFAULT 0,
   status int(2) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;