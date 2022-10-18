-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- 생성 시간: 22-10-18 03:57
-- 서버 버전: 10.4.21-MariaDB
-- PHP 버전: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `yydh`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `users`
--

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `id` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `users`
--

INSERT INTO `users` (`uid`, `id`, `pw`, `name`) VALUES
(1, 'felicia213', 'Hi123', 'Felicia');

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `id` (`id`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `users`
--
ALTER TABLE `users`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
