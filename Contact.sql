-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-05-31 09:48:15
-- 服务器版本： 5.7.22-0ubuntu0.17.10.1
-- PHP Version: 7.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Contact`
--

-- --------------------------------------------------------

--
-- 表的结构 `contact`
--

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL,
  `contact_name` varchar(30) NOT NULL,
  `user_id` int(11) NOT NULL,
  `contact_status` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `contact`
--

INSERT INTO `contact` (`contact_id`, `contact_name`, `user_id`, `contact_status`) VALUES
(1, '同学', 2, 1),
(2, '嘻哈', 1, 1),
(4, '同学', 2, 1),
(6, '室友', 2, 1),
(7, '嘻哈', 1, 1),
(8, '红色嘻哈', 1, 1),
(9, '红色de嘻哈', 1, 1),
(10, 'zuqiu', 1, 1),
(12, '', 1, 1),
(13, '', 1, 1),
(14, '长辈ss', 1, 1),
(15, '嘻哈', 6, 1);

-- --------------------------------------------------------

--
-- 表的结构 `contact_info`
--

CREATE TABLE `contact_info` (
  `contact_info_id` int(11) NOT NULL,
  `contact_user_tel` varchar(30) NOT NULL,
  `contact_user_name` varchar(30) NOT NULL,
  `contact_id` int(11) NOT NULL,
  `contact_info_status` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `contact_info`
--

INSERT INTO `contact_info` (`contact_info_id`, `contact_user_tel`, `contact_user_name`, `contact_id`, `contact_info_status`) VALUES
(1, '13388335879', 'nic', 1, 1),
(2, '2222222222222222', '111111111111111111', 1, 1),
(3, '8833283', 'dsdsa', 2, 1),
(5, '88332833312', 'dsdsass', 6, 1),
(6, '110', '嘻嘻嘻', 6, 1),
(7, '8833283', 'dsdsa', 8, 1),
(8, '8833283', 'dsdsa', 9, 1),
(9, '8833283', '。。。。。。', 9, 1),
(10, '8833283的撒的撒', 'd四大的撒sdsa', 12, 1),
(11, '8833283的撒的撒', 'd四大的撒sdsa', 13, 1),
(12, '8833283的撒的撒', 'd四大的撒sdsa', 2, 1),
(14, '8833283的撒的撒', 'd四大的撒sdsa', 4, 1),
(15, '8833283', 'bbbbbbb', 14, 1),
(16, '8833283', 'aaaaaaa', 14, 1);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`user_id`, `user_name`) VALUES
(1, 'Nicolas'),
(2, 'nicolas'),
(3, 'dsadsa'),
(4, 'dasdsadasdsads'),
(5, 'TANXIN'),
(6, 'TANXIN01'),
(7, 'asdsadsads'),
(8, '1'),
(9, '1'),
(10, '2'),
(11, '3'),
(12, '444'),
(13, '444'),
(14, '555');

-- --------------------------------------------------------

--
-- 表的结构 `user_info`
--

CREATE TABLE `user_info` (
  `user_info_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_status` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_info`
--

INSERT INTO `user_info` (`user_info_id`, `user_id`, `user_email`, `user_status`) VALUES
(1, 1, '364758461@qq.com', 1),
(2, 2, 'nicxia001@qq.com', 1),
(3, 5, '666666666666@gmail.com', 1),
(4, 6, '66666666SS6666@gmail.com', 1),
(5, 7, 'sadsadsdasda', 1),
(6, 8, '1', 1),
(7, 9, '1', 1),
(8, 10, '2', 1),
(9, 11, '333333', 1),
(10, 12, '444545', 1),
(11, 13, '444545', 1),
(12, 14, '5555555555555', 1);

-- --------------------------------------------------------

--
-- 表的结构 `user_pwd`
--

CREATE TABLE `user_pwd` (
  `user_pwd_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_pwd`
--

INSERT INTO `user_pwd` (`user_pwd_id`, `user_id`, `password`) VALUES
(1, 1, '59488332832'),
(2, 2, '59488332832'),
(3, 4, '8833283'),
(4, 5, '12345678'),
(5, 6, '1244345678'),
(6, 7, 'dsadsadasdsa'),
(7, 8, '111111'),
(8, 9, '111111'),
(9, 10, '2111111'),
(10, 11, '33'),
(11, 12, '654646546'),
(12, 13, '654646546'),
(13, 14, '55555555555');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contact_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `contact_info`
--
ALTER TABLE `contact_info`
  ADD PRIMARY KEY (`contact_info_id`),
  ADD KEY `contact_id` (`contact_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`user_info_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user_pwd`
--
ALTER TABLE `user_pwd`
  ADD PRIMARY KEY (`user_pwd_id`),
  ADD KEY `user_id` (`user_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `contact`
--
ALTER TABLE `contact`
  MODIFY `contact_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- 使用表AUTO_INCREMENT `contact_info`
--
ALTER TABLE `contact_info`
  MODIFY `contact_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- 使用表AUTO_INCREMENT `user_info`
--
ALTER TABLE `user_info`
  MODIFY `user_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- 使用表AUTO_INCREMENT `user_pwd`
--
ALTER TABLE `user_pwd`
  MODIFY `user_pwd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- 限制导出的表
--

--
-- 限制表 `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- 限制表 `contact_info`
--
ALTER TABLE `contact_info`
  ADD CONSTRAINT `contact_info_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`);

--
-- 限制表 `user_info`
--
ALTER TABLE `user_info`
  ADD CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- 限制表 `user_pwd`
--
ALTER TABLE `user_pwd`
  ADD CONSTRAINT `user_pwd_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
