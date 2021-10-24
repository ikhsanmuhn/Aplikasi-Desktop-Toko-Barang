-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Bulan Mei 2020 pada 08.11
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_toko_oop`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `Kode_Barang` varchar(20) NOT NULL,
  `Nama_Barang` varchar(30) NOT NULL,
  `Harga_Jual` int(10) NOT NULL,
  `Harga_Beli` int(10) NOT NULL,
  `Gambar` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`Kode_Barang`, `Nama_Barang`, `Harga_Jual`, `Harga_Beli`, `Gambar`) VALUES
('B01', 'Supreme Oreo', 500000, 3000, 'oreo.jpg'),
('B02', 'Supreme Cap', 200000, 2000000, 'cap.jpg'),
('B03', 'Supreme Axe', 300000, 580000, 'axe.jpg'),
('B04', 'Supreme Horn', 70000, 120000, 'horn.jpg'),
('B05', 'Supreme Hydrant', 30000, 1200000, 'hydrant.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_barang`
--

CREATE TABLE `detail_barang` (
  `Kode_Barang` varchar(20) NOT NULL,
  `Stok` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_barang`
--

INSERT INTO `detail_barang` (`Kode_Barang`, `Stok`) VALUES
('B01', '90'),
('B02', '20'),
('B03', '80'),
('B04', '5'),
('B05', '2');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `ID_Transaksi` varchar(20) NOT NULL,
  `Kode_Pelanggan` varchar(20) NOT NULL,
  `Kode_Barang` varchar(20) NOT NULL,
  `Jumlah` int(10) NOT NULL,
  `Total` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `Kode_Karyawan` varchar(20) NOT NULL,
  `Nama_Karyawan` varchar(30) NOT NULL,
  `Alamat` text NOT NULL,
  `JK` varchar(15) NOT NULL,
  `No_HP` varchar(20) NOT NULL,
  `Gambar` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`Kode_Karyawan`, `Nama_Karyawan`, `Alamat`, `JK`, `No_HP`, `Gambar`) VALUES
('ADM01', 'koswari', 'Kebon Kawung', 'Pria', '089564634', 'admin.jpg'),
('PG01', 'Ajeng Azmi', 'Kebon Kopi', 'Pria', '0895326236590', 'jesica.jpg'),
('PT01', 'Babang Supreme', 'New York', 'Pria', '0893482412', 'asep.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `Kode_Karyawan` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `hak` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`Kode_Karyawan`, `username`, `password`, `hak`) VALUES
('PG01', 'ajeng', '123', 'Karyawan'),
('ADM01', 'admin', 'admin', 'Admin'),
('PT01', 'babang', '123', 'Pemilik Toko');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `Kode_Pelanggan` varchar(20) NOT NULL,
  `Nama_Pelanggan` varchar(30) NOT NULL,
  `Alamat` text NOT NULL,
  `No_HP` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`Kode_Pelanggan`, `Nama_Pelanggan`, `Alamat`, `No_HP`) VALUES
('P01', 'Aceng Fikri', 'Kebon Sejarah 2', '089543232473'),
('P02', 'Romlah', 'Situ', '4093845345'),
('P03', 'ashira', 'buah batu', '089034294234'),
('P04', 'ashanti', 'buah bangus', '234234234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `p_toko`
--

CREATE TABLE `p_toko` (
  `Kode` varchar(20) NOT NULL,
  `Nama_Pemilik` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `p_toko`
--

INSERT INTO `p_toko` (`Kode`, `Nama_Pemilik`) VALUES
('PT01', 'Babang Supreme');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_Transaksi` varchar(20) NOT NULL,
  `Kode_Karyawan` varchar(20) NOT NULL,
  `Tanggal` date NOT NULL,
  `Total` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`Kode_Barang`);

--
-- Indeks untuk tabel `detail_barang`
--
ALTER TABLE `detail_barang`
  ADD KEY `Kode_Barang` (`Kode_Barang`);

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `ID_Transaksi` (`ID_Transaksi`),
  ADD KEY `Kode_Barang` (`Kode_Barang`),
  ADD KEY `Kode_Pelanggan` (`Kode_Pelanggan`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`Kode_Karyawan`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD KEY `Kode_Karyawan` (`Kode_Karyawan`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`Kode_Pelanggan`);

--
-- Indeks untuk tabel `p_toko`
--
ALTER TABLE `p_toko`
  ADD PRIMARY KEY (`Kode`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_Transaksi`),
  ADD KEY `Kode_Karyawan` (`Kode_Karyawan`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_barang`
--
ALTER TABLE `detail_barang`
  ADD CONSTRAINT `detail_barang_ibfk_1` FOREIGN KEY (`Kode_Barang`) REFERENCES `barang` (`Kode_Barang`);

--
-- Ketidakleluasaan untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`ID_Transaksi`) REFERENCES `transaksi` (`ID_Transaksi`),
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`Kode_Barang`) REFERENCES `barang` (`Kode_Barang`),
  ADD CONSTRAINT `detail_transaksi_ibfk_3` FOREIGN KEY (`Kode_Pelanggan`) REFERENCES `pelanggan` (`Kode_Pelanggan`);

--
-- Ketidakleluasaan untuk tabel `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`Kode_Karyawan`) REFERENCES `karyawan` (`Kode_Karyawan`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`Kode_Karyawan`) REFERENCES `karyawan` (`Kode_Karyawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
