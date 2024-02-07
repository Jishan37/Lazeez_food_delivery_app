-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2024 at 03:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lazeez`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

CREATE TABLE `cart_item` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `food_id` int(11) NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `total_price` float NOT NULL,
  `unit_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart_item`
--

INSERT INTO `cart_item` (`id`, `created_at`, `created_by`, `is_active`, `update_at`, `update_by`, `description`, `food_id`, `image_path`, `name`, `quantity`, `status`, `total_price`, `unit_price`) VALUES
(36, '2024-01-15 22:06:50.000000', 2, b'1', NULL, 0, 'Crisp-fried chicken crowned with rich cheddar cheese sauce for a savory delight. You will be served 2 pieces', 1, 'images/Crispy_Cheddar_Chicken_Tue_09_1_2024_08_00_00_PM.jpeg', 'Crispy Cheddar Chicken', 1, 1, 280, 280),
(37, '2024-01-15 22:06:53.000000', 2, b'1', NULL, 0, 'Savor the essence of our delectable soup, featuring succulent shrimp, earthy mushrooms, and tender chicken in a sweet and tangy broth.', 5, 'images/Thai_Soup_Tue_09_1_2024_08_03_10_PM.jpeg', 'Thai Soup', 1, 1, 180, 180),
(43, '2024-01-17 20:02:36.000000', 1, b'1', NULL, 0, 'Crisp-fried chicken crowned with rich cheddar cheese sauce for a savory delight. You will be served 2 pieces', 1, 'images/Crispy_Cheddar_Chicken_Tue_09_1_2024_08_00_00_PM.jpeg', 'Crispy Cheddar Chicken', 1, 1, 280, 280);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `total_order` bigint(20) NOT NULL,
  `zip_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `created_at`, `created_by`, `is_active`, `update_at`, `update_by`, `address`, `city`, `email`, `name`, `password`, `total_order`, `zip_code`) VALUES
(1, '2024-01-09 20:04:01.000000', 0, b'1', NULL, 0, 'Uttara, Dhaka', 'Dhaka', 'hridoykrisnadas@gmail.com', 'Hridoy Krisna Das ', 'ff6a3766669af4bd616ee81a86b1fd2e', 0, '1230'),
(2, '2024-01-15 21:12:44.000000', 0, b'1', NULL, 0, 'Cumilla', 'Cumilla', 'jisan@lazeez.com', 'Jisan', '4922156cf3b5e6122eeb16caa857b9cc', 0, '3500');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` int(11) NOT NULL,
  `balance` float NOT NULL,
  `date_of_birth` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `designation` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `driving_license_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `home_district` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `image_path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `joining_date` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `last_payment_date` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `mobile_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `nationality` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `nid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `passport_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `salary` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `total_bill` float NOT NULL,
  `total_due_amount` float NOT NULL,
  `total_payment` float NOT NULL,
  `user_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `validity_of_driving_license` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `created_at`, `created_by`, `is_active`, `update_at`, `update_by`, `balance`, `date_of_birth`, `designation`, `driving_license_no`, `email`, `gender`, `home_district`, `image_path`, `joining_date`, `last_payment_date`, `mobile_no`, `name`, `nationality`, `nid`, `passport_no`, `password`, `salary`, `total_bill`, `total_due_amount`, `total_payment`, `user_type`, `validity_of_driving_license`) VALUES
(1, '2023-12-04 20:52:18.000000', 1, NULL, NULL, 0, 0, NULL, 'Super Admin', NULL, 'admin@lazeez.com', NULL, NULL, NULL, NULL, NULL, NULL, 'Super Admin', NULL, NULL, NULL, '21232f297a57a5a743894a0e4a801fc3', NULL, 0, 0, 0, 'ADMIN', NULL),
(3, '2024-01-09 19:57:09.000000', 1, b'1', NULL, 0, 0, '2000-10-17', 'Manager', '', 'hasinsharowar69@gmail.com', 'Male', 'Cumilla', 'images/Hasin_Sarower_Tue_09_1_2024_07_57_09_PM.jpg', '2024-01-01', NULL, '01600000000', 'Hasin Sarower', 'Bangladeshi', '01600000000', '', '58a37d9e0a3f223e2af279a987ffeef8', '35000', 0, 0, 0, 'USER', '');

-- --------------------------------------------------------

--
-- Table structure for table `food_menu`
--

CREATE TABLE `food_menu` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `status` int(11) NOT NULL,
  `total_order` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food_menu`
--

INSERT INTO `food_menu` (`id`, `created_at`, `created_by`, `is_active`, `update_at`, `update_by`, `description`, `image_path`, `name`, `price`, `status`, `total_order`) VALUES
(1, '2024-01-09 20:00:00.000000', 1, b'1', '2024-01-17 20:06:35.000000', 0, 'Crisp-fried chicken crowned with rich cheddar cheese sauce for a savory delight. You will be served 2 pieces', 'images/Crispy_Cheddar_Chicken_Tue_09_1_2024_08_00_00_PM.jpeg', 'Crispy Cheddar Chicken', 280, 1, 0),
(2, '2024-01-09 20:01:06.000000', 1, b'1', NULL, 0, 'Golden Chicken Katsu atop a bed of fried rice . Perfect for one person lunch.', 'images/Chicken_Katsu_Rice_Platter_Tue_09_1_2024_08_01_06_PM.jpeg', 'Chicken Katsu Rice Platter', 250, 1, 0),
(3, '2024-01-09 20:01:40.000000', 1, b'1', '2024-01-17 20:05:56.000000', 0, 'Tender chicken wrapped in thin dough pockets, filled with a blend of aromatic spices.', 'images/Chicken_Momos_Tue_09_1_2024_08_01_40_PM.jpeg', 'Chicken Momos', 250, 1, 0),
(4, '2024-01-09 20:02:31.000000', 1, b'1', '2024-01-17 20:06:42.000000', 0, 'Mixed platter-crispy chicken popcorn, succulent shrimp tempura, flavorful spring rolls, and golden French fries.', 'images/Mixed_Starter_Platter_Tue_09_1_2024_08_02_31_PM.jpeg', 'Mixed Starter Platter', 300, 0, 0),
(5, '2024-01-09 20:03:10.000000', 1, b'1', NULL, 0, 'Savor the essence of our delectable soup, featuring succulent shrimp, earthy mushrooms, and tender chicken in a sweet and tangy broth.', 'images/Thai_Soup_Tue_09_1_2024_08_03_10_PM.jpeg', 'Thai Soup', 180, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `food_order`
--

CREATE TABLE `food_order` (
  `order_id` int(11) NOT NULL,
  `food_menu_list_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food_order`
--

INSERT INTO `food_order` (`order_id`, `food_menu_list_id`) VALUES
(6, 2),
(6, 1),
(7, 2),
(8, 4),
(9, 2),
(9, 1),
(10, 2),
(10, 3),
(10, 4),
(11, 2),
(11, 3),
(12, 3);

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `total_price` float NOT NULL,
  `user_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `payment_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`id`, `created_at`, `created_by`, `is_active`, `update_at`, `update_by`, `quantity`, `status`, `total_price`, `user_id`, `customer_id`, `date`, `payment_status`) VALUES
(6, '2024-01-09 21:08:13.000000', 1, b'1', NULL, 0, 2, 0, 530, 1, 1, '2024-01-09 22:15:24.000000', 0),
(7, '2024-01-09 21:16:57.000000', 1, b'1', '2024-01-09 23:38:04.000000', 0, 1, 0, 250, 1, 1, '2024-01-09 22:15:28.000000', 0),
(8, '2024-01-09 21:30:16.000000', 1, b'1', '2024-01-10 20:29:16.000000', 0, 1, 1, 300, 1, 1, '2024-01-09 22:15:31.000000', 0),
(9, '2024-01-09 21:32:50.000000', 1, b'1', '2024-01-10 20:37:23.000000', 0, 2, 3, 530, 1, 1, '2024-01-09 22:15:35.000000', 1),
(10, '2024-01-15 21:13:46.000000', 0, b'1', '2024-01-15 21:15:49.000000', 0, 3, 3, 800, 2, 2, '2024-01-15 21:13:46.000000', 1),
(11, '2024-01-15 21:18:12.000000', 0, b'1', '2024-01-15 21:18:59.000000', 0, 2, 3, 500, 2, 2, '2024-01-15 21:18:12.000000', 1),
(12, '2024-01-17 19:54:58.000000', 0, b'1', NULL, 0, 1, 0, 250, 1, 1, '2024-01-17 19:54:58.000000', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food_menu`
--
ALTER TABLE `food_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food_order`
--
ALTER TABLE `food_order`
  ADD KEY `FK7sogy1638fvxvlww8d1wa002o` (`food_menu_list_id`),
  ADD KEY `FKqfslu9dxs2ncl88qntmyq0fog` (`order_id`);

--
-- Indexes for table `order_table`
--
ALTER TABLE `order_table`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdit09e676nqbguvt1k1w8mlj2` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart_item`
--
ALTER TABLE `cart_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `food_menu`
--
ALTER TABLE `food_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `order_table`
--
ALTER TABLE `order_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `food_order`
--
ALTER TABLE `food_order`
  ADD CONSTRAINT `FK7sogy1638fvxvlww8d1wa002o` FOREIGN KEY (`food_menu_list_id`) REFERENCES `food_menu` (`id`),
  ADD CONSTRAINT `FKqfslu9dxs2ncl88qntmyq0fog` FOREIGN KEY (`order_id`) REFERENCES `order_table` (`id`);

--
-- Constraints for table `order_table`
--
ALTER TABLE `order_table`
  ADD CONSTRAINT `FKdit09e676nqbguvt1k1w8mlj2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
