-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 15, 2014 at 11:26 PM
-- Server version: 5.1.44
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `shoppingcart`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cart`
--

CREATE TABLE IF NOT EXISTS `Cart` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `userID` int(3) NOT NULL,
  `contents` text NOT NULL,
  `couponID` int(3) NOT NULL DEFAULT '0',
  `checkedOut` tinyint(1) NOT NULL DEFAULT '0',
  `invoice` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=171 ;

--
-- Dumping data for table `Cart`
--

INSERT INTO `Cart` (`id`, `userID`, `contents`, `couponID`, `checkedOut`, `invoice`) VALUES
(153, 2, '1:5, 3:1, 5:20, ', 1, 1, '-----------------------------------------------------------------\n| INVOICE:							|\n| Purchaser: John						|\n| Shipping Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Items Ordered: 						|\n\n| 								|\n| Applied Coupon: DISCOUNT20					|\n| Total Amount: $1106.00  (WOW! You Just Saved: $276.50!)	|\n| 								|\n| Billing Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Card Used: 							|\n| 1234567887654321						|\n-----------------------------------------------------------------\n'),
(154, 2, '1:5, 3:1, 5:20, ', 1, 1, '-----------------------------------------------------------------\n| INVOICE:							|\n| Purchaser: John						|\n| Shipping Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Items Ordered: 						|\n| Item: Pen, Quantity: 5, Price: $8.50				|\n| Item: Keyboard, Quantity: 1, Price: $40.00			|\n| Item: USB Drive, Quantity: 20, Price: $65.00			|\n| 								|\n| Applied Coupon: DISCOUNT20					|\n| Total Amount: $1106.00  (WOW! You Just Saved: $276.50!)	|\n| 								|\n| Billing Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Card Used: 							|\n| 1234567887654321						|\n-----------------------------------------------------------------\n'),
(155, 2, '1:5, 3:1, 5:20, ', 1, 1, '-----------------------------------------------------------------\n| INVOICE:							|\n\n| 								|\n| Purchaser: John						|\n| Shipping Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Items Ordered: 						|\n| Item: Pen, Quantity: 5, Price: $8.50				|\n| Item: Keyboard, Quantity: 1, Price: $40.00			|\n| Item: USB Drive, Quantity: 20, Price: $65.00			|\n| 								|\n| Applied Coupon: DISCOUNT20					|\n| Total Amount: $1106.00  (WOW! You Just Saved: $276.50!)	|\n| 								|\n| Billing Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Card Used: 							|\n| 1234567887654321						|\n-----------------------------------------------------------------\n'),
(156, 2, '1:5, 3:1, 5:20, ', 1, 1, '-----------------------------------------------------------------\n| INVOICE:							|\n| 								|\n| Purchaser: John						|\n| Shipping Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Items Ordered: 						|\n| Item: Pen, Quantity: 5, Price: $8.50				|\n| Item: Keyboard, Quantity: 1, Price: $40.00			|\n| Item: USB Drive, Quantity: 20, Price: $65.00			|\n| 								|\n| Applied Coupon: DISCOUNT20					|\n| Total Amount: $1106.00  (WOW! You Just Saved: $276.50!)	|\n| 								|\n| Billing Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Card Used: 							|\n| 1234567887654321						|\n-----------------------------------------------------------------\n'),
(157, 2, '1:5, 5:100, ', 0, 0, ''),
(158, 2, '', 0, 0, ''),
(159, 2, '', 0, 0, ''),
(160, 2, '', 0, 0, ''),
(161, 2, '', 0, 0, ''),
(162, 2, '', 0, 0, ''),
(163, 2, '', 0, 0, ''),
(164, 2, '', 0, 0, ''),
(165, 2, '', 0, 0, ''),
(166, 2, '1:5, 5:10, ', 0, 0, ''),
(167, 2, '1:5, 5:10, ', 0, 0, ''),
(168, 2, '1:5, 3:1, 4:1, 5:20, ', 1, 1, '-----------------------------------------------------------------\n| INVOICE:							|\n| 								|\n| Purchaser: John						|\n| Shipping Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Items Ordered: 						|\n| Item: Pen, Quantity: 5, Price: $8.50				|\n| Item: Keyboard, Quantity: 1, Price: $40.00			|\n| Item: Snowboard, Quantity: 1, Price: $349.99			|\n| Item: USB Drive, Quantity: 20, Price: $65.00			|\n| 								|\n| Applied Coupon: DISCOUNT20					|\n| Total Amount: $1385.99  (WOW! You Just Saved: $346.50!)	|\n| 								|\n| Billing Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Card Used: 							|\n| 1234567887654321						|\n-----------------------------------------------------------------\n'),
(169, 2, '1:5, 3:1, 4:1, 5:20, ', 1, 1, '-----------------------------------------------------------------\n| INVOICE:							|\n| 								|\n| Purchaser: John						|\n| Shipping Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Items Ordered: 						|\n| Item: Pen, Quantity: 5, Price: $8.50				|\n| Item: Keyboard, Quantity: 1, Price: $40.00			|\n| Item: Snowboard, Quantity: 1, Price: $349.99			|\n| Item: USB Drive, Quantity: 20, Price: $65.00			|\n| 								|\n| Applied Coupon: DISCOUNT20					|\n| Total Amount: $1385.99  (WOW! You Just Saved: $346.50!)	|\n| 								|\n| Billing Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Card Used: 							|\n| 1234567887654321						|\n-----------------------------------------------------------------\n'),
(170, 2, '1:5, 3:1, 4:1, 5:20, ', 1, 1, '-----------------------------------------------------------------\n| INVOICE:							|\n| 								|\n| Purchaser: John						|\n| Shipping Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Items Ordered: 						|\n| Item: Pen, Quantity: 5, Price: $8.50				|\n| Item: Keyboard, Quantity: 1, Price: $40.00			|\n| Item: Snowboard, Quantity: 1, Price: $349.99			|\n| Item: USB Drive, Quantity: 20, Price: $65.00			|\n| 								|\n| Applied Coupon: DISCOUNT20					|\n| Total Amount: $1385.99  (WOW! You Just Saved: $346.50!)	|\n| 								|\n| Billing Address: 						|\n| XYZ company, 123 W RD,New York, NY, 12345			|\n| 								|\n| Card Used: 							|\n| 1234567887654321						|\n-----------------------------------------------------------------\n');

-- --------------------------------------------------------

--
-- Table structure for table `Coupon`
--

CREATE TABLE IF NOT EXISTS `Coupon` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Coupon`
--

INSERT INTO `Coupon` (`id`, `code`, `discount`) VALUES
(1, 'DISCOUNT20', 0.8),
(2, 'HALFDAY', 0.5);

-- --------------------------------------------------------

--
-- Table structure for table `Item`
--

CREATE TABLE IF NOT EXISTS `Item` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `description` text NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `Item`
--

INSERT INTO `Item` (`id`, `name`, `description`, `price`) VALUES
(1, 'Pen', 'Used in writing', 8.5),
(2, 'Kindle', 'Amazon tablet', 90),
(3, 'Keyboard', 'Wireless keyboard with a touch pad.', 40),
(4, 'Snowboard', 'Winter is coming! Prepare yourself.', 349.99),
(5, 'USB Drive', '128GB', 65),
(6, 'Notebook', 'This is a macbook', 1399);

-- --------------------------------------------------------

--
-- Table structure for table `Orders`
--

CREATE TABLE IF NOT EXISTS `Orders` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `cartID` int(32) NOT NULL,
  `trackingNum` varchar(20) NOT NULL,
  `orderstamp` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=50 ;

--
-- Dumping data for table `Orders`
--

INSERT INTO `Orders` (`id`, `cartID`, `trackingNum`, `orderstamp`) VALUES
(1, 23, 'KLTDHGNVSV', '2014-05-11 16:38:27.57'),
(3, 24, '1JVDXFPYR2', '2014-05-11 16:39:28.686'),
(4, 25, 'MF0QTEFRLAX4GJDY2YPH', '2014-05-11 16:40:54.313'),
(5, 60, '3E4Q6GVURITNA9F00SK1', '2014-05-12 21:27:18.506'),
(6, 96, 'GOQN0V50KQTMPYRQ8B6T', '2014-05-12 22:27:55.775'),
(7, 97, '5NGIILQFVNQFVYGURXRD', '2014-05-12 22:29:16.616'),
(8, 98, '5RVTYBD10J6S3FQ8A5CE', '2014-05-12 22:29:43.201'),
(9, 99, 'JJ05JAJRZG59JPGOQO3B', '2014-05-12 22:30:08.121'),
(10, 100, 'KGUL4452RVZ2QJI5R6AK', '2014-05-12 22:30:48.359'),
(11, 101, '09BHL0OHILK3HKM9LEJZ', '2014-05-12 22:31:09.539'),
(12, 102, 'Y0S8QBZ7IOJGHMJRC1GO', '2014-05-12 22:31:54.779'),
(13, 103, 'F4BN54HDUVKRQMTPO8O1', '2014-05-12 22:32:38.041'),
(14, 123, 'MXKIE5F8V0CE0JKX64UB', '2014-05-12 23:38:03.982'),
(15, 124, 'MMJY7QBK801XMFD3X6YN', '2014-05-12 23:40:38.422'),
(16, 125, 'X36BKPENZQYKQ6KQQCQG', '2014-05-12 23:41:10.29'),
(17, 126, 'NFLPFAS3EEYNP8N7J3JK', '2014-05-12 23:42:06.792'),
(18, 127, 'URXYF8CBSD4QV5AMVGGB', '2014-05-12 23:43:45.392'),
(19, 129, '2RZ5QQCNDB9M1R2T2NOB', '2014-05-12 23:46:11.772'),
(20, 130, 'HYKIPX2AKZ74JI4CO7MK', '2014-05-12 23:47:22.315'),
(21, 131, '00HCSLEL081RMZ1ZIGKG', '2014-05-12 23:48:59.663'),
(22, 132, 'MKCS0ZE5TDL9CLSLYSK0', '2014-05-12 23:49:52.478'),
(23, 133, 'QY5UUZEPQATDQ7B5YC1P', '2014-05-12 23:50:58.413'),
(24, 134, 'BN2DPUNIX70RVV7Q2QOD', '2014-05-12 23:51:39.589'),
(25, 135, '3AJVB1Q1QF7LKBQVPS4K', '2014-05-12 23:52:54.76'),
(26, 136, 'LBQBT7DQDXYN39A6DHQ1', '2014-05-12 23:54:51.272'),
(27, 137, 'NSQJD3API8ERM68GR2FC', '2014-05-12 23:55:58.161'),
(28, 138, 'TDI5E3QFRHT899FF66KT', '2014-05-13 00:00:56.719'),
(29, 139, 'HFMQQIL8TS0J24N8RATI', '2014-05-13 00:01:34.117'),
(30, 140, '09QR0RVXUUN3HY34UTRM', '2014-05-13 00:03:11.066'),
(31, 141, '1ID2H1PE7DQ886JDURCN', '2014-05-13 00:10:33.733'),
(32, 142, '2SC4KQXVRJUQO0VL20T3', '2014-05-13 00:11:07.754'),
(33, 143, 'TMN1MM3GZHG4NH91X3QV', '2014-05-13 00:13:24.428'),
(34, 144, 'QGXB5MVHQBO62NJ5GMO3', '2014-05-13 00:15:14.14'),
(35, 145, '2URIO8GUO0548EKPZAXI', '2014-05-13 00:16:25.836'),
(36, 146, 'VIS6MT3HUQ8G0G73GFF8', '2014-05-13 00:18:32.281'),
(37, 147, '4Z9KZXMUX4DQ2QZ7USU6', '2014-05-13 00:19:04.974'),
(38, 148, 'MVUYDFYA2Y6K4DIEY3SO', '2014-05-13 00:19:52.001'),
(39, 149, '5DSAJKEGNLJPQFF8LSD7', '2014-05-13 00:21:26.45'),
(40, 150, 'ZJC2JSGE28RQOVPGXGM3', '2014-05-13 00:22:17.001'),
(41, 151, 'OQ15AJDU5ESCEHV5PG00', '2014-05-13 00:22:46.354'),
(42, 152, 'MXLT7R9DSZX8V8T8HCP5', '2014-05-13 00:23:48.817'),
(43, 153, 'U2DSXROZ4GLM1ZJSDJVH', '2014-05-13 00:26:03.581'),
(44, 154, '95NYVR3Q2KF5L4ITOX4F', '2014-05-13 00:33:47.671'),
(45, 155, 'HF8T7J4A4H7HEIEB6M60', '2014-05-13 00:35:11.135'),
(46, 156, 'VHN480FACQJM1ZV4CGX8', '2014-05-13 00:35:27.764'),
(47, 168, '0AHSL0MHFHTB6A7M3EX0', '2014-05-15 17:43:41.736'),
(48, 169, 'FPQ6G4TBAP93XZOYFEXB', '2014-05-15 17:51:35.22'),
(49, 170, 'JN7TAKA1LQE486FF4EPL', '2014-05-15 17:53:35.569');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `emailAdd` varchar(128) NOT NULL,
  `billingAdd` text NOT NULL,
  `shippingAdd` text NOT NULL,
  `creditNum` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`id`, `name`, `emailAdd`, `billingAdd`, `shippingAdd`, `creditNum`) VALUES
(1, 'armsky', 'armsky1988@gmail.com', '7811 45th Ave, Elmhurst,NY ,11373', '7811 45th Ave, Elmhurst,NY ,11373', '1234432112213443'),
(2, 'John', 'johnsmith@gmail.com', 'XYZ company, 123 W RD,New York, NY, 12345', 'XYZ company, 123 W RD,New York, NY, 12345', '1234567887654321');
