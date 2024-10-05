DROP DATABASE IF EXISTS photo;
CREATE DATABASE photo;
USE photo;

DROP TABLE IF EXISTS lectures;

CREATE TABLE lectures (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `surname` varchar(100) NOT NULL DEFAULT '',
  `photo` mediumblob DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO lectures values (1,"Mario","Rossi",null);
INSERT INTO lectures values (2,"Antonio","Verdi",null);

