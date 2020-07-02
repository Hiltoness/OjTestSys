-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 02, 2020 at 02:50 PM
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
-- Table structure for table `kaoshi_multi`
--

CREATE TABLE `kaoshi_multi` (
  `multiid` int(50) NOT NULL,
  `specialid` varchar(50) DEFAULT NULL,
  `msubject` varchar(200) DEFAULT NULL,
  `moptionA` varchar(500) DEFAULT NULL,
  `moptionB` varchar(500) DEFAULT NULL,
  `moptionC` varchar(500) DEFAULT NULL,
  `moptionD` varchar(500) DEFAULT NULL,
  `manswer` varchar(500) DEFAULT NULL,
  `mmark` int(3) DEFAULT NULL,
  `kcbianhao` varchar(30) NOT NULL,
  `gonghao` varchar(30) NOT NULL,
  `gongxiang` varchar(5) NOT NULL DEFAULT 'n',
  `difficulty` int(11) DEFAULT NULL,
  `chapter` varchar(10) DEFAULT NULL,
  `useage` varchar(5) DEFAULT NULL,
  `explain` text,
  `Knowledgepoint` text,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kaoshi_multi`
--

INSERT INTO `kaoshi_multi` (`multiid`, `specialid`, `msubject`, `moptionA`, `moptionB`, `moptionC`, `moptionD`, `manswer`, `mmark`, `kcbianhao`, `gonghao`, `gongxiang`, `difficulty`, `chapter`, `useage`, `explain`, `Knowledgepoint`, `addtime`) VALUES
(14, NULL, '通过数据挖掘过程所推倒出的关系和摘要经常被称为：', '模型    ', '模式', '模范', '模具', 'ab', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:01:27'),
(15, NULL, '寻找数据集中的关系是为了寻找精确、方便并且有价值地总结了数据的某一特征的表示，这个过程包括了以下哪些步骤？', '决定要使用的表示的特征和结构', '决定如何量化和比较不同表示拟合数据的好坏', '选择一个算法过程使评分函数最优', '决定用什么样的数据管理原则以高效地实现算法。', 'abcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:02:21'),
(16, NULL, '数据挖掘算法的组件包括', '模型或模型结构', '评分函数', '优化和搜索方法', '数据管理策略', 'abcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:03:20'),
(17, NULL, '以下哪些学科和数据挖掘有密切联系？', '统计', '计算机组成原理', '矿产挖掘', '人工智能', 'ad', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:03:54'),
(18, NULL, '在现实世界的数据中，元组在某些属性上缺少值是常有的。描述处理该问题的各种方法有', '忽略元组;使用一个全局常量填充空缺值', '使用属性的平均值填充空缺值', '使用与给定元组属同一类的所有样本的平均值', '使用最可能的值填充空缺值 ', 'abcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:05:02'),
(19, NULL, '对于数据挖掘中的原始数据，存在的问题有：', '不一致;重复  ', '不完整', '含噪声', '维度高', 'abcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:06:00'),
(20, NULL, '下面列出的条目中，哪些是数据仓库的基本特征', '数据仓库是面向主题的', '数据仓库的数据是集成的 ', '数据仓库的数据是相对稳定的', '数据仓库的数据是反映历史变化的', 'acd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:06:44'),
(21, NULL, '以下各项均是针对数据仓库的不同说法，你认为正确的有', '数据仓库的主要目标就是帮助分析，做长期性的战略制定', '数据仓库是一切商业智能系统的基础', '数据仓库是面向业务的，支持联机事务处理（OLTP）', '数据仓库支持决策而非事务处理', 'abcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:07:31'),
(22, NULL, '数据仓库在技术上的工作过程是：', '数据的抽取', '存储和管理', '数据的表现', '数据仓库设计', 'abcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:08:48'),
(23, NULL, '联机分析处理包括以下哪些基本分析功能？', '聚类 ', '切片', '转轴', '切块', 'bcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:09:30'),
(24, NULL, '利用Apriori算法计算频繁项集可以有效降低计算频繁集的时间复杂度。在以下的购物篮中产生支持度不小于3的候选3-项集，在候选2-项集中需要剪枝的是   ID项集 .1 面包、牛奶 2 面包、尿布、啤酒、鸡蛋 3 牛奶、尿布、啤酒、可乐 4 面包、牛奶、尿布、啤酒 5 面包、牛奶、尿布、可乐 ', '啤酒、尿布', '啤酒、面包', '面包、尿布', '啤酒、牛奶', 'bd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:11:04'),
(25, NULL, 'Apriori算法的计算复杂度受__ 影响', '支持度阀值', '项数（维度）', '事务数', '事务平均宽度', 'abcd', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:12:16'),
(26, NULL, '贝叶斯信念网络(BBN)有如下哪些特点', '构造网络费时费力', '对模型的过分问题非常鲁棒', '贝叶斯网络不适合处理不完整的数据', '网络结构确定后，添加变量相当麻烦', 'ab', 1, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-10-22 15:13:18'),
(27, NULL, '下面哪几种类型是MongoDB支持的类型？', '字符串', '日期', '正则表达式', '数组', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:08:34'),
(28, NULL, 'MongoDB地理空间查询支持的方式？', '交集', '差额', '包含', '接近', 'acd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:09:12'),
(29, NULL, 'MongoDB数据库find返回游标，基于此游标，可以有更多的查询选型，其中包括？', 'limit', 'group', 'sort', 'skip', 'acd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:09:58'),
(30, NULL, 'MongoDB数据库提供多种索引分析与优化的手段，包括？', 'explain', 'hint', 'move', 'profiler', 'abd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:10:38'),
(31, NULL, '下面哪些命令是MongoDB数据库备份时使用的？', 'mongodump', 'mongorestore', 'mongostat', 'mongooplog', 'abd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:11:21'),
(32, NULL, '以下哪些是MongoDB的可视化工具？', 'Robomongo', 'MongoHub', 'rockmongo', 'MongoVUE ', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:12:03'),
(33, NULL, 'MongoDB的可支持哪些分片方式？', '哈希分片', '范围分片', '区域分片', '预分片', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:12:52'),
(34, NULL, 'MongoDB有哪些是副本集成员？', 'Primary', 'Slave', 'Secondary', 'arbiter', 'acd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:13:35'),
(35, NULL, 'MongoDB数据删除后产生碎片可采用何种手段修复？', 'compact', 'monodump', 'move', 'restore', 'ab', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:14:16'),
(36, NULL, 'MongoDB写入策略包括？', 'Unacknowledged', 'Acknowledged', 'Journaled', 'Replica Acknowledged', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:14:57'),
(37, NULL, '可伸缩性包括（  ）', '功能的伸缩', '容量的扩展', '性能的扩展', '系统的伸缩', 'abc', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:47:42'),
(38, NULL, '云平台层的功能有哪些？（  ）', '开发环境', '运行时环境', '运营环境', '测试环境', 'ab', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:48:17'),
(39, NULL, '云架构包含以下哪些？', '基础设施层', '服务层', '应用层', '平台层', 'acd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:48:45'),
(40, NULL, '基于平台服务，这种“云”计算形式把开发环境或者运行平台也作为一种服务给用户提供。用户可以把自己的应用运行在提供者的基础设施中，例如（  ）等公司提供这种形式的服务。', 'Sun', 'Amazon.com', 'YahooPipes', 'Salesforce.com', 'cd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:49:16'),
(41, NULL, '云计算的特点是（  ）', '大规模', '平滑扩展', '资源共享', '动态分配', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 08:49:46'),
(42, NULL, 'MapReduce与HBase的关系，哪些描述是正确的？', '两者不可或缺，MapReduce是HBase可以正常运行的保证', '两者不是强关联关系，没有MapReduce，HBase可以正常运行', ' MapReduce可以直接访问HBase', '它们之间没有任何关系', 'bc', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:06:49'),
(43, NULL, '下面哪些选项正确描述了HBase的特性？', '高可靠性', '高性能', '面向列', '可伸缩', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:07:16'),
(44, NULL, '下面哪些概念是HBase框架中使用的？', 'HDFS', ' GridFS', 'Zookeeper', ' EXT3', 'ac', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:08:38'),
(45, NULL, ' 下面对LSM结构描述正确的是？', '顺序存储', '直接写硬盘', '需要将数据Flush到磁盘', '是一种搜索平衡树', 'ac', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:10:58'),
(46, NULL, 'HFile数据格式中的KeyValue数据格式，下列选项描述正确的是（）', '是byte[]数组', '没有固定的结构', '数据的大小是定长的', '有固定的结构', 'ad', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:15:22'),
(47, NULL, ' HBase性能优化包含下面的哪些选项？', '读优化', '写优化', '配置优化', 'JVM优化', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:17:52'),
(48, NULL, 'Rowkey设计的原则，下列哪些选项的描述是正确的？', '尽量保证越短越好', '可以使用汉字', '可以使用字符串', '本身是无序的', 'abc', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:18:23'),
(49, NULL, 'HBase构建二级索引的实现方式有哪些？ ', ' MapReduce', 'Coprocessor', 'Bloom Filter', 'Filter', 'ab', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:18:51'),
(50, NULL, '关于HBase二级索引的描述，哪些是正确的？', '核心是倒排表', '二级索引概念是对应Rowkey这个“一级”索引', '二级索引使用平衡二叉树', '二级索引使用LSM结构', 'ab', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:19:20'),
(51, NULL, '下列关于Bloom Filter的描述正确的是？', '是一个很长的二进制向量和一系列随机映射函数', '没有误算率', '有一定的误算率', '可以在Bloom Filter中删除元素', 'ac', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:19:49'),
(52, NULL, 'HBase官方版本可以安装在什么操作系统上？', 'CentOS', 'Ubuntu', 'RedHat', 'Windows', 'abc', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:20:22'),
(53, NULL, '下列哪项可以作为集群的管理？', 'Puppet', 'Pdsh', 'Cloudera Manager', 'Zookeeper', 'abd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:57:31'),
(54, NULL, '配置机架感知的下面哪项正确：', '如果一个机架出问题，不会影响数据读写', 'MapReduce 会根据机架获取离自己比较近的网络数据', '写入数据的时候会写到不同机架的 DataNode 中', ' ', 'abc', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:58:05'),
(55, NULL, '下列哪个是 Hadoop 运行的模式：', '单机版', '伪分布式', '分布式', ' ', 'abc', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:59:17'),
(56, NULL, 'Cloudera 提供哪几种安装 CDH 的方法？', 'Cloudera manager', 'Tarball', 'Yum', 'Rpm', 'abcd', 2, 'K01', '30003499', 'n', NULL, NULL, NULL, NULL, NULL, '2019-12-13 09:59:51');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kaoshi_multi`
--
ALTER TABLE `kaoshi_multi`
  ADD PRIMARY KEY (`multiid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kaoshi_multi`
--
ALTER TABLE `kaoshi_multi`
  MODIFY `multiid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
