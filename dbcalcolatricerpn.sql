-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2024 at 10:20 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcalcolatricerpn`
--

-- --------------------------------------------------------

--
-- Table structure for table `cronologia`
--

CREATE TABLE `cronologia` (
  `espressione` varchar(30) NOT NULL,
  `risultato` float NOT NULL,
  `username` varchar(15) NOT NULL,
  `idespressione` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cronologia`
--

INSERT INTO `cronologia` (`espressione`, `risultato`, `username`, `idespressione`) VALUES
('13+2', 15, 'tarasolani', 1),
('13+5', 18, 'tarasolani', 2),
('13+10', 23, 'tarasolani', 3),
('60+8', 68, 'walteragazzi', 5);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('tarasolani', 'dariomoccia'),
('walteragazzi', 'profmaniglio');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cronologia`
--
ALTER TABLE `cronologia`
  ADD PRIMARY KEY (`idespressione`),
  ADD KEY `username_FK_1` (`username`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cronologia`
--
ALTER TABLE `cronologia`
  MODIFY `idespressione` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cronologia`
--
ALTER TABLE `cronologia`
  ADD CONSTRAINT `username_FK_1` FOREIGN KEY (`username`) REFERENCES `login` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
