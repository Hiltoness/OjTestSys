-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 02, 2020 at 02:52 PM
-- Server version: 5.7.26
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fx`
--

-- --------------------------------------------------------

--
-- Table structure for table `kaoshi_blank`
--

CREATE TABLE `kaoshi_blank` (
  `blankid` int(50) NOT NULL,
  `specialid` varchar(50) DEFAULT NULL,
  `bfronttitle` varchar(200) DEFAULT NULL,
  `bbacktitle` varchar(200) DEFAULT NULL,
  `banswer` varchar(400) DEFAULT NULL,
  `bmark` int(11) DEFAULT NULL,
  `kcbianhao` varchar(30) NOT NULL,
  `gonghao` varchar(30) NOT NULL,
  `gongxiang` varchar(5) NOT NULL DEFAULT 'n',
  `difficulty` int(11) DEFAULT NULL,
  `chapter` varchar(20) DEFAULT NULL,
  `useage` varchar(200) DEFAULT NULL,
  `explain` varchar(200) DEFAULT NULL,
  `Knowledgepoint` varchar(200) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kaoshi_blank`
--

INSERT INTO `kaoshi_blank` (`blankid`, `specialid`, `bfronttitle`, `bbacktitle`, `banswer`, `bmark`, `kcbianhao`, `gonghao`, `gongxiang`, `difficulty`, `chapter`, `useage`, `explain`, `Knowledgepoint`, `addtime`) VALUES
(16, NULL, '在SQL查询语句中，用于测试子查询是否为空的谓词是', '', 'EXISTS', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-17 13:42:52'),
(17, NULL, '在查询操作结果中不出现重复元组，应在Select子句中使用', '保留字。', 'DISTINCT', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:17:40'),
(18, NULL, 'SQL的SELECT语句在未使用分组子句但在SELECT子句中使用了聚合函数。此时SELECT子句的语句就不是投影的意思了，而是', '', '对查询结果执行聚合操作', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:18:02'),
(19, NULL, '数据库系统的权限控制方法分为', '两种', '自主存取控制和强制存取控制方法', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:18:50'),
(20, NULL, '在SQL Server 中，数据库的文件分为', '三大类', '主数据文件、辅助数据文件和事务日志文件', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:19:28'),
(21, NULL, 'SQL的数据操纵功能主要包括', '三个语句。', 'INSERT、UPDATE和DELETE', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:20:07'),
(22, NULL, '在字符匹配查询中，通配符“%”和“_”分别代表', '', '任意多个字符；任意单个字符', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:21:09'),
(23, NULL, '触发器是一种特殊的存储过程，它可以在对一个表上进行', '操作中的任一种或几种操作时被自动调用执行。', '插入、删除和修改', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:21:52'),
(24, NULL, '视图是一个虚表，它是（  ）中导出的表。在数据库中，只存放视图的（  ），不存放视图的（  ）', '', '从一个或几个基本表；结构定义；对应数据', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:24:12'),
(25, NULL, '关系模型的数据操纵即是建立在关系上的数据操纵，一般有', '、增加、删除和修改四种操作。', '查询', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:47:18'),
(26, NULL, '2．在SQL语言中，如果要为一个基本表增加列和完整性的约束条件，应该使用SQL语句', '', 'Alter table<表名> ADD [COLUNMN]<表名><数据类型>[完整性约束]', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:47:35'),
(27, NULL, '如果要计算表中数据的平均值，可以使用的集函数是', '函数。', 'AVG', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:47:53'),
(28, NULL, '在数据库的三级模式体系结构中，外模式与模式之间的映像（外模式／模式），实现了数据库的', '独立性。', '数据与程序之间的', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:48:20'),
(29, NULL, '在数据库技术中，数据分为概念数据模型和结构数据模型，常用的实体联系模型（E-R模型）属于', '数据模型。', '关系', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:48:40'),
(30, NULL, '数据库恢复通常基于数据备份和', '文件。', '日志', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:48:57'),
(31, NULL, '在Transact-SQL语法中，用来插入数据的命令是', '，用于更新的命令是（  ）', 'Insert；update', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:49:35'),
(32, NULL, '在Transact-SQL语法中，SELECT语句的完整语法较复杂，但至少包括的部分（  ），使用关键字（  ）可以把重复行屏蔽，将多个查询结果返回一个结果集合的运算符是（  ），如果要将查询结果分组，一定要使用（  ）子句。', '', 'select...from...；distinct；union；group by', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:51:21'),
(33, NULL, 'SQL Server主数据文件、辅数据文件和事务日志文件默认的扩展名分别为', '', '.mdf、.ndf和.ldf', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:51:51'),
(34, NULL, '完整性规则是为了保证关系（表）中数据的正确、一致、有效而确定的规则。实体完整性规则是表中任意一行的主键值不能为（  ）；参照完整性规则是一个表的', '可以为空值，若不为空值，则必须等于另一个表中主键的某个值。', '空值；外键值', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 00:52:37'),
(35, NULL, '事务具有', '四个特性。', '原子性 ，一致性，隔离性，持久性(持续性)', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 07:43:43'),
(36, NULL, '在关系A（S，SN，D）和B（D，CN，NM）中，A的主码是S，B的主码是D，则D在A中称为', '', '外码', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 07:44:06'),
(37, NULL, '在SQL Server2000中,某数据库用户User具有对表数据的查询和更改权限.现要回收该用户对T表的数据更改权,下述是实现该功能的语句,请补全该语句', 'UPDATE ON T FROM User;', 'REVOKE', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 07:44:28'),
(38, NULL, '在一个ER图中，如果共有20个不同实体类型，在这些实体类型之间存在着9个不同的二元联系(二元联系是指两个实体之间的联系)其中3个是1:N联系，6个是M:N联系，还存在1个M:N的三元联系，那么根据ER模型转换成关系模型的规则，这个ER结构转换成的关系模式个数至少为', '个。', '27', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-19 07:45:28'),
(39, NULL, '1.	多层神经网络是指至少包含一个', '', '隐层', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 14:31:39'),
(40, NULL, '2.	使用垂直数据格式挖掘频繁项集主要是通过', '运算来生成K项集。', '交', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 14:32:03'),
(41, NULL, '', '通过沿一个维的概念分层向上攀升', '上卷', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 14:32:24'),
(42, NULL, '属性包括的四种类型：', '', '标称、序数、区间、比率', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:14:36'),
(43, NULL, '', '是两个簇的邻近度定义为不同簇的所有点对邻近度的平均值', '组平均', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:14:53'),
(44, NULL, '基本凝聚层次聚类算法空间复杂度     时间复杂度', '如果某个簇到其他所有簇的距离存放在一个有序表或堆中，层次聚类所需要的时间复杂度将为     ', 'O(m^2),O(m^3),O(m^2logm)', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:16:22'),
(45, NULL, '聚类中，定义簇间的相似度的方法有（写出四个）：', '', 'MIN（单链）、MAX（全链）、组平均、Ward方法', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:16:38'),
(46, NULL, '层次聚类技术是第二类重要的聚类方法。两种层次聚类的基本方法：', '', '凝聚层次聚类、分裂层次聚类', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:17:01'),
(47, NULL, '组平均是一种界于     和', '之间的折中方法', '单链，全链', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:17:37'),
(48, NULL, '相似度矩阵可以用相识度表示还可以用', '表示', '距离', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:23:27'),
(49, NULL, '全链在处理大小不同的簇时，可能使    ', '破裂，并且偏好   ', '大的簇;球形', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:24:02'),
(50, NULL, '单链技术擅长于处理    ,但对      和', '很敏感', '非椭圆形状的簇；噪声点；离群点', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:24:52'),
(51, NULL, '聚类分析可以看做是一种', '的分类。（有监督、无监督）', '无监督', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:25:15'),
(52, NULL, '缩写RDBMS的含义是', '', '关系数据库系统', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-09 10:39:22'),
(53, NULL, '缩写DBA 的含义是', '', '数据库管理员', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-09 10:39:39'),
(54, NULL, '在关系A（S，SN，D）和B（D，CN，NM）中，A的主码是S，B的主码是D，则D在S中称为', '', '外码', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-09 10:39:57'),
(55, NULL, '数据库恢复的基本原理十分简单，可以用一个词来概括即：（', '', '冗余', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-09 10:40:17'),
(56, NULL, '有两个不同的实体集，它们之间存在着一个1：1和一个M：N的联系，根据E-R图转换成关系模型后，得到的关系模式个数为', '个', '3', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-09 10:40:40'),
(57, NULL, '事务具有', '四个特性', '原子性 ， 一致性 ， 隔离性,持久性(持续性)', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-11 07:06:48'),
(58, NULL, '在关系A（S，SN，D）和B（D，CN，NM）中，A的主码是S，B的主码是D，则D在A中称为', '', '外码', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-11 07:07:05'),
(59, NULL, '在SQL Server2000中,某数据库用户User具有对表数据的查询和更改权限.现要回收该用户对T表的数据更改权,下述是实现该功能的语句,请补全该语句', 'UPDATE ON T FROM User', 'REVOKE', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-11 07:07:24'),
(60, NULL, '在一个ER图中，如果共有20个不同实体类型，在这些实体类型之间存在着9个不同的二元联系(二元联系是指两个实体之间的联系)其中3个是1:N联系，6个是M:N联系，还存在1个M:N的三元联系，那么根据ER模型转换成关系模型的规则，这个ER结构转换成的关系模式个数至少为', '个', '27', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-11-11 07:07:41'),
(61, NULL, '关系数据模型由关系数据结构、关系操作和', '三部分组成。', '关系完整性约束', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-08 11:03:35'),
(62, NULL, 'Python中调用open函数打开文件，调用close函数关闭文件，调用', '函数可实现对文件内容的读取。', 'read()orreadline()orreadlines()', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:20:00'),
(63, NULL, '表达式1/4+2.75的值是。', '', '2.75', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:20:16'),
(64, NULL, '高级程序设计语言必须由', '翻译成低级语言。', '编译器或者解释器', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:20:49'),
(65, NULL, '给出range(1,10,3)的值:', '', '[1,4,7]', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:21:08'),
(66, NULL, '请给出计算2^31−1的Python表达式:。', '', '2**31-1', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:21:49');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kaoshi_blank`
--
ALTER TABLE `kaoshi_blank`
  ADD PRIMARY KEY (`blankid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kaoshi_blank`
--
ALTER TABLE `kaoshi_blank`
  MODIFY `blankid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
