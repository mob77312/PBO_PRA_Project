-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2020 at 04:35 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resto`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(15) NOT NULL,
  `passoword` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `passoword`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `mvc_resto`
--

CREATE TABLE `mvc_resto` (
  `kode` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `harga` int(15) NOT NULL,
  `jenis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mvc_resto`
--

INSERT INTO `mvc_resto` (`kode`, `nama`, `harga`, `jenis`) VALUES
('123', 'Nasi Goreng1', 12000, 'Makanan'),
('1234', 'Alpukat', 10000, 'Minuman');

-- --------------------------------------------------------

--
-- Table structure for table `pesan`
--

CREATE TABLE `pesan` (
  `kode` int(11) NOT NULL,
  `nama` varchar(15) NOT NULL,
  `harga` int(11) NOT NULL,
  `jenis` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesan`
--

INSERT INTO `pesan` (`kode`, `nama`, `harga`, `jenis`) VALUES
(1234, 'Alpukat', 10000, 'Minuman');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mvc_resto`
--
ALTER TABLE `mvc_resto`
  ADD PRIMARY KEY (`kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
