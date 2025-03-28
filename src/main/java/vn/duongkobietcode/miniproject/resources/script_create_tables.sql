use miniproject_db;

drop table if exists `students`;
CREATE TABLE `students` (
  `id` int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT null,
  `birth_date` date DEFAULT null,
  `gender` boolean NOT NULL DEFAULT true,
  `phone_number` varchar(12) DEFAULT null,
  `address` varchar(255) DEFAULT null,
  `status` boolean NOT NULL
);

drop table if exists `courses`;
CREATE TABLE `courses` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name_course` varchar(255) DEFAULT null,
  `description` mediumtext DEFAULT null,
  `start_date` date DEFAULT null,
  `end_date` date DEFAULT null,
  `status` boolean NOT NULL
);

drop table if exists `classes`;
CREATE TABLE `classes` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `course_id` int DEFAULT null,
  `student_id` int DEFAULT null,
  `register_date` date DEFAULT null,
  `status` boolean NOT NULL
);

ALTER TABLE `classes` ADD FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);
ALTER TABLE `classes` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

use miniproject_db;
drop table if exists `accounts`;
CREATE TABLE `accounts` (
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` int NOT NULL UNIQUE,
    `password` int NOT NULL,
    `status` boolean NOT NULL
);
