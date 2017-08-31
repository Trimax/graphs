-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.19-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры для таблица graphs.edges
CREATE TABLE IF NOT EXISTS `edges` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `graphid` int(10) unsigned NOT NULL,
  `sourcevertexid` int(10) unsigned NOT NULL,
  `destinationvertexid` int(10) unsigned NOT NULL,
  `cost` double unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_EDGES_GRAPHID` (`graphid`),
  KEY `IDX_EDGES_SOURCEVERTEXID` (`sourcevertexid`),
  KEY `IDX_EDGES_DESTINATIONVERTEXID` (`destinationvertexid`),
  KEY `IDX_EDGES_COST` (`cost`),
  CONSTRAINT `FK_EDGES_DESTINATIONVERTEXID` FOREIGN KEY (`destinationvertexid`) REFERENCES `vertices` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EDGES_GRAPHID` FOREIGN KEY (`graphid`) REFERENCES `graphs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EDGES_SOURCEVERTEXID` FOREIGN KEY (`sourcevertexid`) REFERENCES `vertices` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица graphs.graphs
CREATE TABLE IF NOT EXISTS `graphs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_GRAPHS_USERID` (`userid`),
  FULLTEXT KEY `IDX_GRAPHS_NAME` (`name`),
  CONSTRAINT `FK_GRAPHS_USERID` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица graphs.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `passwordhash` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_USERS_EMAIL` (`email`),
  KEY `IDX_USERS_PASSWORDHASH` (`passwordhash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица graphs.vertices
CREATE TABLE IF NOT EXISTS `vertices` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `graphid` int(10) unsigned NOT NULL,
  `data` blob NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_VERTICES_GRAPHID` (`graphid`),
  CONSTRAINT `FK_VERTICES_GRAPHID` FOREIGN KEY (`graphid`) REFERENCES `graphs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
