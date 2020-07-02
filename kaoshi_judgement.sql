-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 02, 2020 at 02:51 PM
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
-- Table structure for table `kaoshi_judgement`
--

CREATE TABLE `kaoshi_judgement` (
  `judgementid` int(50) NOT NULL,
  `specialid` varchar(50) DEFAULT NULL,
  `jtitle` varchar(500) DEFAULT NULL,
  `janswer` varchar(20) DEFAULT NULL,
  `jmark` int(3) DEFAULT NULL,
  `kcbianhao` varchar(30) NOT NULL,
  `gonghao` varchar(30) NOT NULL,
  `gongxiang` varchar(5) NOT NULL DEFAULT 'n',
  `difficulty` int(11) DEFAULT NULL,
  `chapter` varchar(20) DEFAULT NULL,
  `useage` text,
  `explain` text,
  `Knowledgepoint` text,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kaoshi_judgement`
--

INSERT INTO `kaoshi_judgement` (`judgementid`, `specialid`, `jtitle`, `janswer`, `jmark`, `kcbianhao`, `gonghao`, `gongxiang`, `difficulty`, `chapter`, `useage`, `explain`, `Knowledgepoint`, `addtime`) VALUES
(16, NULL, '视图是一张虚表，所有的视图中不存储数据。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:26:49'),
(17, NULL, '用户不允许使用视图修改表数据。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:27:01'),
(18, NULL, '数据库中的视图只能使用所属数据库的表，不能访问其它数据库的表。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:27:14'),
(19, NULL, '视图既可以通过表得到，也可以通过其它视图得到。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:27:25'),
(20, NULL, '规则在创建后，并不能直接使用，必须绑定到表中某一列或者用户定义的数据类型上。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:27:34'),
(21, NULL, '创建规则对象后，必须把它绑定到一个列或用户定义的数据类型上才能起作用。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:27:43'),
(22, NULL, '现实世界的对象在数据库中用实体描述。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:28:10'),
(23, NULL, '游标是系统为用户的查询结果开辟的数据缓冲区，存放SELECT语句的查询结果。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:28:29'),
(24, NULL, '在数据库系统中，核心的部分是应用程序。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:28:45'),
(25, NULL, '候选码可以选作主码,但一个主码不总是候选码。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:28:58'),
(26, NULL, '存储过程是存放在服务器上的预先定义与编译好的SQL语句的命名集合。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:29:12'),
(27, NULL, '视图、表是一样的,都可以进行更新操作的。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:29:28'),
(28, NULL, '触发器操作与约束有冲突时，触发器仍会执行。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:29:47'),
(29, NULL, '删除触发表时，触发器被随之删除。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:30:06'),
(30, NULL, 'Order by子句仅对检索数据的显示有影响，并不改变表中行的内部顺序。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:30:39'),
(31, NULL, '从一个表中删除元组时，delete和drop table命令可以起到同样的效果。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:30:47'),
(32, NULL, '与主键不同，惟一性可以是null值。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:32:06'),
(33, NULL, '使用having子句是为了限制group by子句返回的行的个数。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:32:21'),
(34, NULL, '在数据表定义时设置Primary key是数据库的实体完整性控制。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:32:33'),
(35, NULL, '在数据表定义时设置主键(Primary key)则不允许插入全为空的记录。', 'true', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:32:50'),
(36, NULL, '数据库一旦建立，就没有办法重命名了，所以命名数据库要慎重。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-18 01:33:05'),
(37, NULL, '数据仓库与数据库的本质区别在于底层的数据模型。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 14:32:54'),
(38, NULL, 'PCA方法可以有效地减少特征维数。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 14:33:03'),
(39, NULL, ' FP增长树算法需要反复多次地扫描原始事物数据库。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 14:33:14'),
(40, NULL, '数据挖掘的主要任务是从数据中发现潜在的规则，从而能更好的完成描述数据、预测数据等任务', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:13:40'),
(41, NULL, '数据挖掘的目标不在于数据采集策略，而在于对于已经存在的数据进行模式的发掘', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:13:57'),
(42, NULL, '图挖掘技术在社会网络分析中扮演了重要的角色。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:14:04'),
(43, NULL, '寻找模式和规则主要是对数据进行干扰，使其符合某种规则以及模式。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:14:39'),
(44, NULL, '离群点可以是合法的数据对象或者值。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:15:07'),
(45, NULL, '离散属性总是具有有限个值。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:15:21'),
(46, NULL, '噪声和伪像是数据错误这一相同表述的两种叫法。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:15:36'),
(47, NULL, '用于分类的离散化方法之间的根本区别在于是否使用类信息', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:15:44'),
(48, NULL, '特征提取技术并不依赖于特定的领域。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:15:53'),
(49, NULL, '定量属性可以是整数值或者是连续值。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:16:05'),
(50, NULL, 'DSS主要是基于数据仓库.联机数据分析和数据挖掘技术的应用。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:16:19'),
(51, NULL, '数据仓库中间层OLAP服务器只能采用关系型OLAP', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:16:48'),
(52, NULL, '数据仓库系统的组成部分包括数据仓库，仓库管理，数据抽取，分析工具等四个部分. ', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:17:03'),
(53, NULL, '关联规则挖掘过程是发现满足最小支持度的所有项集代表的规则。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:17:23'),
(54, NULL, ' 如果规则 不满足置信度阈值，则形如 的规则一定也不满足置信度阈值，其中 是X的子集。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:17:34'),
(55, NULL, '具有较高的支持度的项集具有较高的置信度。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:17:49'),
(56, NULL, '分类和回归都可用于预测，分类的输出是离散的类别值，而回归的输出是连续数值。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:19:17'),
(58, NULL, '分类和回归都可用于预测，分类的输出是离散的类别值，而回归的输出是连续数值。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 04:23:44'),
(59, NULL, '数据挖掘的主要任务是从数据中发现潜在的规则，从而能更好的完成描述数据、预测数据等任务。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:15:58'),
(60, NULL, '数据挖掘的目标不在于数据采集策略，而在于对于已经存在的数据进行模式的发掘。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:16:32'),
(61, NULL, '图挖掘技术在社会网络分析中扮演了重要的角色。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:16:50'),
(62, NULL, '寻找模式和规则主要是对数据进行干扰，使其符合某种规则以及模式。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:17:21'),
(63, NULL, '离群点可以是合法的数据对象或者值。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:17:39'),
(64, NULL, '离散属性总是具有有限个值。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:17:57'),
(65, NULL, '噪声和伪像是数据错误这一相同表述的两种叫法。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:18:43'),
(66, NULL, '用于分类的离散化方法之间的根本区别在于是否使用类信息。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:18:53'),
(67, NULL, '特征提取技术并不依赖于特定的领域。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:19:08'),
(68, NULL, '序列数据没有时间戳。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:19:25'),
(69, NULL, '定量属性可以是整数值或者是连续值。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:19:36'),
(70, NULL, '可视化技术对于分析的数据类型通常不是专用性的', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:19:47'),
(71, NULL, ' DSS主要是基于数据仓库.联机数据分析和数据挖掘技术的应用。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:20:11'),
(72, NULL, '数据仓库中间层OLAP服务器只能采用关系型OLAP', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:20:53'),
(73, NULL, '数据仓库系统的组成部分包括数据仓库，仓库管理，数据抽取，分析工具等四个部分', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:21:03'),
(74, NULL, '关联规则挖掘过程是发现满足最小支持度的所有项集代表的规则。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:21:44'),
(75, NULL, '利用先验原理可以帮助减少频繁项集产生时需要探查的候选项个数', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:21:59'),
(76, NULL, '先验原理可以表述为：如果一个项集是频繁的，那包含它的所有项集也是频繁的。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:22:25'),
(77, NULL, '如果规则 不满足置信度阈值，则形如 的规则一定也不满足置信度阈值，其中 是X的子集。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:22:38'),
(78, NULL, '具有较高的支持度的项集具有较高的置信度。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:22:59'),
(79, NULL, '分类和回归都可用于预测，分类的输出是离散的类别值，而回归的输出是连续数值。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:24:01'),
(80, NULL, '对于SVM分类算法，待分样本集中的大部分样本不是支持向量，移去或者减少这些样本对分类结果没有影响。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-23 05:24:27'),
(82, NULL, '在聚类分析当中，簇内的相似性越大，簇间的差别越大，聚类的效果就越差。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:02:41'),
(83, NULL, '聚类分析可以看作是一种非监督的分类。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:03:08'),
(84, NULL, ' K均值是一种产生划分聚类的基于密度的聚类算法，簇的个数由算法自动地确定。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:03:19'),
(85, NULL, '给定由两次运行K均值产生的两个不同的簇集，误差的平方和最大的那个应该被视为较优。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:03:29'),
(86, NULL, '基于邻近度的离群点检测方法不能处理具有不同密度区域的数据集。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:03:36'),
(87, NULL, '如果一个对象不强属于任何簇，那么该对象是基于聚类的离群点。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:03:44'),
(88, NULL, '从点作为个体簇开始，每一步合并两个最接近的簇，这是一种分裂的层次聚类方法', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:26:23'),
(89, NULL, '数据挖掘的目标不在于数据采集策略，而在于对已经存在的数据进行模式的发掘。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:26:31'),
(90, NULL, '在聚类分析当中，簇内的相似性越大，簇间的差别越大，聚类的效果就越差。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:27:47'),
(91, NULL, '当两个点之间的邻近度取它们之间距离的平方时，Ward方法与组平均非常相似。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:27:57'),
(92, NULL, 'DBSCAN是相对抗噪声的，并且能够处理任意形状和大小的簇。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:28:06'),
(93, NULL, '属性的性质不必与用来度量他的值的性质相同。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:28:16'),
(94, NULL, '全链对噪声点和离群点很敏感。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:28:24'),
(95, NULL, '对于非对称的属性，只有非零值才是重要的。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:28:36'),
(96, NULL, 'K均值可以很好的处理不同密度的数据。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:28:44'),
(97, NULL, '单链技术擅长处理椭圆形状的簇。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-27 14:28:53'),
(98, NULL, '在关系数据模型中，实体与实体之间的联系只能用一个单独的关系表表示。', 'false', 2, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-08 11:01:57'),
(99, NULL, 'MongoDB的集合是动态模式的，同一个集合里面的文档可以是各式各样的。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:15:29'),
(100, NULL, 'MongoDB在更新文档的时候，会造成文档的移动，同时会修改集合的填充因子。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:15:40'),
(101, NULL, 'MongoDB在更新文档的时候，会造成文档的移动，同时会修改集合的填充因子。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:15:45'),
(102, NULL, '在MongoDB数据库应用中，对于集合较大，文档较大，选择性的查询通常是需要建立索引。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:16:05'),
(103, NULL, '对于较大集合的索引创建，通常采用后台方式，在创建过程中，数据库仍然能够有效处理所有的读写请求。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:16:17'),
(104, NULL, 'MongoDB数据库目前仅提供普通的聚合函数分析、基于管道的聚合运算。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:16:30'),
(105, NULL, '目前，最新MongoDB数据库不支持事务操作。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:16:43'),
(106, NULL, '在MongoDB数据库中，用户在自定义角色时一定要切换到admin数据库下。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:17:39'),
(107, NULL, 'MongoDB数据库中副本集可以有效实现负载均衡。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:17:50'),
(108, NULL, 'MongoDB采用分片进行数据库的高可用。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:18:02'),
(109, NULL, 'MongoDB采用副本集提供数据库的扩缩容能力。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:18:14'),
(110, NULL, 'MongoDB基于管道的聚合运算分析时候，其内存使用可以最大化的利用机器可用内存。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:18:26'),
(111, NULL, 'MongoDB分片节点中两两相邻的节点中不存在同样的快节点数据。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:18:36'),
(112, NULL, 'MongoDB写入策略中，journaled是数据安全级别最高的策略。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:18:48'),
(113, NULL, 'MongoDB暂不支持二级索引。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:19:01'),
(114, NULL, '云计算真正实现了按需计算，从而有效地提高了对软硬件资源的利用效率。', 'true', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:50:03'),
(115, NULL, 'Raid1是备份量极高的Raid策略，相应的他的保护能力也很强', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:51:57'),
(116, NULL, '云计算可以把普通的服务器或者PC连接起来以获得超级计算机计算机的计算和存储等功能，但是成本更低。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:52:06'),
(117, NULL, '虚拟交换机可以连多块物理网卡，所以同一块物理网卡可以连多个虚拟交换机。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:52:17'),
(118, NULL, '相比各种网路存储的设置技术来讲，本地硬盘还是最快的', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:52:30'),
(119, NULL, 'Secondary namenode就是namenode出现问题时的备用节点 ', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:46:07'),
(120, NULL, 'Ganglia 不仅可以进行监控，也可以进行告警。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:00:07'),
(121, NULL, 'Block Size 是不可以修改的。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:00:18'),
(122, NULL, 'Nagios 不可以监控 Hadoop 集群，因为它不提供 Hadoop 支持。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:00:26'),
(123, NULL, '如果 NameNode 意外终止，SecondaryNameNode 会接替它使集群继续工作。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:00:35'),
(124, NULL, 'Cloudera CDH 是需要付费使用的。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:00:48'),
(125, NULL, ' Hadoop 是 Java 开发的，所以 MapReduce 只支持 Java 语言编写。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:00:57'),
(126, NULL, ' Hadoop 支持数据的随机读写。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:01:05'),
(127, NULL, 'Hadoop 自身具有严格的权限管理和安全措施保障集群正常运行。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:01:35'),
(128, NULL, ' Slave 节点要存储数据，所以它的磁盘越大越好。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:01:44'),
(129, NULL, ' hadoop dfsadmin –report 命令用于检测 HDFS 损坏块。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:01:55'),
(130, NULL, 'Hadoop 默认调度器策略为 FIFO', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:02:06'),
(131, NULL, ' 集群内每个节点都应该配 RAID，这样避免单磁盘损坏，影响整个节点运行。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:02:19'),
(132, NULL, '因为 HDFS 有多个副本，所以 NameNode 是不存在单点问题的。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:02:30'),
(133, NULL, '每个 map 槽就是一个线程。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:02:41'),
(134, NULL, ' Mapreduce 的 input split 就是一个 block。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:02:54'),
(135, NULL, 'NameNode 的 Web UI 端口是 50030，它通过 jetty 启动的 Web 服务。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:03:14'),
(136, NULL, '函数eval()用于数值表达式求值,例如eval(2*3+1)。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:22:10'),
(137, NULL, '执行了importmath之后即可执行语句printsin(pi/2)。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:22:19'),
(138, NULL, 'Python可以不加声明就使用变量。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:22:26'),
(139, NULL, 'Python可以不对变量如a初始化就可在表达式如b=a+1中使用该变量。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:22:41'),
(140, NULL, '选择排序算法是一个时间复杂度为nlogn nlogn算法。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:22:49'),
(141, NULL, 'Hanoi塔的解法体现了分而治之(divide-and-conquer)方法的典型用途。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:22:58'),
(142, NULL, '一个函数中只允许有一条return语句。', 'false', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:23:06'),
(143, NULL, '可用open(“file1”,”r”）方式打开文件并进行修改。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:23:20'),
(144, NULL, 'Python语言是面向对象的。', 'true', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:23:28'),
(145, NULL, '存在一个程序判别一个Python程序的运行是否可以停止。', 'false', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 10:23:36'),
(151, NULL, '存在很多个人', 'true', 1, 'K02', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2020-03-19 03:41:22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kaoshi_judgement`
--
ALTER TABLE `kaoshi_judgement`
  ADD PRIMARY KEY (`judgementid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kaoshi_judgement`
--
ALTER TABLE `kaoshi_judgement`
  MODIFY `judgementid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
