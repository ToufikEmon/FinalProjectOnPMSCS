-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2015 at 02:38 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `final_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `insert_data`
--

CREATE TABLE IF NOT EXISTS `insert_data` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `applicant_name` varchar(100) NOT NULL,
  `father_name` varchar(100) NOT NULL,
  `mother_name` varchar(100) NOT NULL,
  `nationality` varchar(100) NOT NULL,
  `permanent_address` varchar(100) NOT NULL,
  `present_address` varchar(100) NOT NULL,
  `contact_number` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `date_of_birth` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `blood_group` varchar(100) NOT NULL,
  `degree1` varchar(100) NOT NULL,
  `degree2` varchar(100) NOT NULL,
  `degree3` varchar(100) NOT NULL,
  `degree4` varchar(100) NOT NULL,
  `group1` varchar(100) NOT NULL,
  `group2` varchar(100) NOT NULL,
  `group3` varchar(100) NOT NULL,
  `group4` varchar(100) NOT NULL,
  `board1` varchar(100) NOT NULL,
  `board2` varchar(100) NOT NULL,
  `board3` varchar(100) NOT NULL,
  `board4` varchar(100) NOT NULL,
  `ssc_cgpa` varchar(100) NOT NULL,
  `hsc_cgpa` varchar(100) NOT NULL,
  `hons_cgpa` varchar(100) NOT NULL,
  `others_cgpa` varchar(100) NOT NULL,
  `passing_year1` varchar(100) NOT NULL,
  `passing_year2` varchar(100) NOT NULL,
  `passing_year3` varchar(100) NOT NULL,
  `passing_year4` varchar(100) NOT NULL,
  `organization` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `applicant_roll` varchar(11) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `insert_data`
--

INSERT INTO `insert_data` (`sid`, `applicant_name`, `father_name`, `mother_name`, `nationality`, `permanent_address`, `present_address`, `contact_number`, `email`, `date_of_birth`, `sex`, `blood_group`, `degree1`, `degree2`, `degree3`, `degree4`, `group1`, `group2`, `group3`, `group4`, `board1`, `board2`, `board3`, `board4`, `ssc_cgpa`, `hsc_cgpa`, `hons_cgpa`, `others_cgpa`, `passing_year1`, `passing_year2`, `passing_year3`, `passing_year4`, `organization`, `status`, `applicant_roll`) VALUES
(1, 'Sabrina Khan', 'Md.Billal uddin khan', 'Anwara Khanam', 'bangladesh', 'adad,dhaka', '32/a dhaka', '9146327856', 'fjhdjfgh@gmail.com', '23.23.1995', 'Female', 'A+', 'SSC', 'HSC', 'Honors', '', 'Sciece', 'Sciece', 'Sciece', '', 'Dhaka', 'Dhaka', 'Dhaka', '', '5', '5', '3', '', '2007', '2009', '2014', '', 'faculty', 'cse,ju', '1531001');

-- --------------------------------------------------------

--
-- Table structure for table `payment_clearence`
--

CREATE TABLE IF NOT EXISTS `payment_clearence` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile_number` int(14) NOT NULL,
  `pin` int(14) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `payment_clearence`
--

INSERT INTO `payment_clearence` (`payment_id`, `mobile_number`, `pin`) VALUES
(1, 1760568639, 123456);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
