
CREATE TABLE `sys_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(32),
  `label` varchar(128),
  weight float,
  parent_id int(11),
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

CREATE TABLE `sys_role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `type` varchar(32),
  role_id int(11),
  authority_id int(11),
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

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  app_id varchar(32),
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