-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2018 at 12:39 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kiriman_materai`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_jenis_produk`
--

CREATE TABLE `tb_jenis_produk` (
  `id_jenis_produk` varchar(5) NOT NULL,
  `nama_jenis_produk` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jenis_produk`
--

INSERT INTO `tb_jenis_produk` (`id_jenis_produk`, `nama_jenis_produk`) VALUES
('MTR', 'Materai'),
('SMP', 'Sampul');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kiriman`
--

CREATE TABLE `tb_kiriman` (
  `g14` varchar(5) NOT NULL,
  `tanggal` date NOT NULL,
  `no_seal` varchar(15) NOT NULL,
  `jumlah_ktg` int(11) NOT NULL,
  `no_dus` varchar(15) NOT NULL,
  `id_kantor` varchar(30) NOT NULL,
  `id_produk` varchar(6) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `besar_uang` bigint(20) NOT NULL,
  `no_ktg` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kiriman`
--

INSERT INTO `tb_kiriman` (`g14`, `tanggal`, `no_seal`, `jumlah_ktg`, `no_dus`, `id_kantor`, `id_produk`, `jumlah`, `besar_uang`, `no_ktg`) VALUES
('2', '2018-04-16', '2', 2, '2', '4', 'MTR001', 5, 15000, '6'),
('7', '2018-04-16', '7', 7, '7', '7', 'MTR001', 7, 21000, '7');

-- --------------------------------------------------------

--
-- Table structure for table `tb_produk`
--

CREATE TABLE `tb_produk` (
  `id_produk` varchar(6) NOT NULL,
  `nama_produk` varchar(25) NOT NULL,
  `harga_produk` bigint(20) NOT NULL,
  `id_jenis_produk` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_produk`
--

INSERT INTO `tb_produk` (`id_produk`, `nama_produk`, `harga_produk`, `id_jenis_produk`) VALUES
('MTR001', 'Materai Rp.3000', 3000, 'MTR'),
('MTR002', 'Materai Rp.6000', 6000, 'MTR'),
('SMP001', 'KARTUPOS REMAJA', 200, 'SMP'),
('SMP002', 'Sampul Kecil', 200, 'SMP'),
('SMP003', 'Sampul Besar', 250, 'SMP'),
('SMP004', 'Sampul L311', 5000, 'SMP');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_user` varchar(30) NOT NULL,
  `penyimpanan` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jenis_produk`
--
ALTER TABLE `tb_jenis_produk`
  ADD PRIMARY KEY (`id_jenis_produk`);

--
-- Indexes for table `tb_kiriman`
--
ALTER TABLE `tb_kiriman`
  ADD PRIMARY KEY (`g14`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD PRIMARY KEY (`id_produk`),
  ADD KEY `FK_id_jenis_produk` (`id_jenis_produk`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_kiriman`
--
ALTER TABLE `tb_kiriman`
  ADD CONSTRAINT `id_produk` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD CONSTRAINT `FK_id_jenis_produk` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
