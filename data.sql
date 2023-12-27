-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_gendara
CREATE DATABASE IF NOT EXISTS `db_gendara` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_gendara`;

-- Dumping structure for table db_gendara.beladiri
CREATE TABLE IF NOT EXISTS `beladiri` (
  `idNumber` varchar(5) NOT NULL,
  `materi` varchar(500) DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idNumber`),
  KEY `FK_beladiri_user` (`username`),
  CONSTRAINT `FK_beladiri_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_gendara.beladiri: ~10 rows (approximately)
INSERT INTO `beladiri` (`idNumber`, `materi`, `username`) VALUES
	('1', 'Perlunya meningkatkan kesadaran diri:  \r\n- Tetap waspada terhadap situasi sekitar dan percayai insting. Tingkatkan kesadaran diri terhadap lingkungan dan orang-orang di sekitar.\r\n', 'Admin'),
	('10', 'Lapor kejadian dengan segera:\r\n - Jika terlibat menjadi korban kekerasan seksual atau menyaksikan kejadian semacam itu, segera laporkan kejadian tersebut kepada pihak berwenang dan dapatkan bantuan profesional.\r\n', 'Admin'),
	('2', 'Pahami tanda-tanda peringatan:\r\n - Pahami tanda-tanda peringatan kekerasan seksual dan situasi yang berisiko. Hal ini dapat membantu untuk menghindari situasi yang dapat membahayakan.\r\n ', 'Admin'),
	('3', 'Pelajari ilmu Self-Defense:\r\n - Mengikuti kursus self-defense dapat memberikan pengetahuan yang mendalam dan keterampilan fisik yang dapat membantu untuk melindungi diri dalam situasi darurat.\r\n', 'Admin'),
	('4', 'Hindari minum minuman yang tidak diketahui asalnya:\r\n - Selalu awasi minuman dan hindari menerima minuman dari seseorang yang tidak dikenal. Kebanyakan kasus penyerangan seksual terjadi setelah korban diberi obat dalam minuman.\r\n', 'Admin'),
	('5', 'Berperilaku bijak di media sosial:\r\n - Batasi informasi pribadi yang dibagikan di media sosial. Berhati-hatilah terhadap siapa yang terlibat  dan ditambahkan sebagai teman dan hindari memberikan informasi terlalu rinci tentang keberadaan atau rutinitas harian.\r\n', 'Admin'),
	('6', 'Hindari situasi berisiko:\r\n - Berpikirlah dua kali sebelum memasuki situasi yang berisiko, seperti tempat yang sepi atau gelap, terutama pada malam hari.\r\n', 'Admin'),
	('7', 'Berkendara dengan aman:\r\n - Jika mengemudi sendirian, pastikan pintu mobil terkunci dan hindari berhenti di tempat yang terpencil. Pastikan mobil dalam kondisi baik dan bawa ponsel yang terisi daya.\r\n', 'Admin'),
	('8', 'Percaya pada insting:\r\n - Jika sesuatu terasa tidak benar atau merasa tidak aman, segera pergi dari situasi tersebut dan minta pertolongan jika diperlukan.\r\n', 'Admin'),
	('9', 'Bangun jaringan dukungan dan keamanan:\r\n - Bangun hubungan dengan teman, keluarga, atau rekan kerja yang dapat memberikan dukungan dan membantu jika sedang menghadapi situasi sulit.\r\n', 'Admin');

-- Dumping structure for table db_gendara.beladiri1
CREATE TABLE IF NOT EXISTS `beladiri1` (
  `idNumber` varchar(50) NOT NULL,
  `materi` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idNumber`),
  KEY `FK_beladiri1_user` (`username`),
  CONSTRAINT `FK_beladiri1_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_gendara.beladiri1: ~10 rows (approximately)
INSERT INTO `beladiri1` (`idNumber`, `materi`, `username`) VALUES
	('1', 'Lakukam pemeriksaan rutin:\r\n - Rutin melakukan pemeriksaan kesehatan reproduksi dengan profesional medis seperti ginekolog atau dokter spesialis urologi. Hal ini melibatkan pemeriksaan fisik dan tes kesehatan yang diperlukan.\r\n', 'Admin'),
	('10', 'Komunikasi secara terbuka:\r\n - Berkomunikasi terbuka dengan pasangan tentang kebutuhan dan keinginan seksual, serta mendiskusikan metode kontrasepsi atau perencanaan keluarga dengan baik.\r\n', 'Admin'),
	('2', 'Praktik seks aman:\r\n - Gunakan kondom atau metode kontrasepsi lainnya untuk melindungi diri dari infeksi menular seksual (IMS) dan mencegah kehamilan yang tidak diinginkan.\r\n', 'Admin'),
	('3', 'Perlunya pendidikan seksual:\r\n - Pahami pendidikan seksual dan memiliki pemahaman yang baik tentang anatomi, fungsi, dan perubahan yang terjadi dalam tubuh. Hal Ini membantu dalam pengambilan keputusan yang bijak terkait seksualitas.\r\n', 'Admin'),
	('4', 'Melakukan vaksinasi:\r\n - Terlibat dalam vaksinasi yang dianjurkan untuk melindungi diri dari penyakit menular seksual tertentu, seperti HPV (Human Papillomavirus).\r\n', 'Admin'),
	('5', 'Jaga kebersihan pribadi:\r\n - Pertahankan kebersihan pribadi dengan membersihkan organ genital secara teratur. Hindari penggunaan sabun atau produk kimia yang dapat menyebabkan iritasi dan infeksi.\r\n', 'Admin'),
	('6', 'Pertahankan kesehatan mental:\r\n - Kesehatan mental yang baik berkontribusi pada kesehatan reproduksi. Atasi stres, kecemasan, dan depresi dengan mencari dukungan profesional jika diperlukan seperti psikolog. \r\n', 'Admin'),
	('7', 'Terapkan pola makan sehat:\r\n - Makan makanan sehat yang kaya nutrisi seperti buah-buahan, sayuran, biji-bijian, dan protein sehat. Gizi yang baik mendukung kesehatan reproduksi.\r\n', 'Admin'),
	('8', 'Olahraga secara teratur:\r\n - Lakukan olahraga secara teratur untuk menjaga berat badan yang sehat, meningkatkan sirkulasi darah, dan mendukung kesehatan secara keseluruhan.\r\n', 'Admin'),
	('9', 'Batasi konsumsi alkohol dan hindari merokok:\r\n - Batasi konsumsi alkohol dan hindari merokok. Kedua kebiasaan ini dapat berdampak negatif pada kesehatan reproduksi.\r\n', 'Admin');

-- Dumping structure for table db_gendara.genara
CREATE TABLE IF NOT EXISTS `genara` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `chat` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_genara_user` (`username`),
  CONSTRAINT `FK_genara_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_gendara.genara: ~13 rows (approximately)
INSERT INTO `genara` (`ID`, `username`, `chat`) VALUES
	(1, 'Ozan', 'Hey bro'),
	(2, 'kuc', 'Apa?'),
	(3, 'Oman', 'Main yu'),
	(4, 'fikri', 'kemana'),
	(5, 'admin', 'ikut dong'),
	(6, 'Oman', 'bruh'),
	(7, 'Oman', 'haloo'),
	(8, 'Oman', 'tes'),
	(9, 'Oman', 'apakah bisa scroll'),
	(10, 'Oman', 'bismillah'),
	(11, 'Oman', 'dan '),
	(12, 'Oman', 'hasilnya'),
	(13, 'Oman', 'tidak bisa');

-- Dumping structure for table db_gendara.laporan
CREATE TABLE IF NOT EXISTS `laporan` (
  `idNumber` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `waktu` date DEFAULT NULL,
  `kronologis` varchar(500) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `username_member` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username_admin` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idNumber`),
  KEY `FK_laporan_user` (`username_member`),
  KEY `FK_laporan_user_2` (`username_admin`),
  CONSTRAINT `FK_laporan_user` FOREIGN KEY (`username_member`) REFERENCES `user` (`username`),
  CONSTRAINT `FK_laporan_user_2` FOREIGN KEY (`username_admin`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_gendara.laporan: ~7 rows (approximately)
INSERT INTO `laporan` (`idNumber`, `username`, `nama`, `waktu`, `kronologis`, `status`, `username_member`, `username_admin`) VALUES
	('2cvYF', 'Oman', 'Rochman', '2023-11-29', 'tes date picker', 'Unverified', 'Oman', 'Admin'),
	('INE7d', 'Oman', 'Rochman', '2024-04-23', 'Ketika sedang bersepeda', 'Unverified', 'Oman', 'Admin'),
	('j7mEZ', 'Oman', 'Rochman', '2024-03-21', 'Ketika sedang tidur', 'verified', 'Oman', 'Admin'),
	('jVHyz', 'Ozan', 'Fauzan', '2023-12-15', 'Saya sedang jalan di desa, tiba-tiba ada mobil hitam datang.', 'Unverified', 'Oman', 'Admin'),
	('pLJsv', 'kuc', 'koceng', '2022-02-11', 'Tengah malam di hutan', 'Unverified', 'Oman', 'Admin'),
	('Tnbvf', 'erlangga', 'Erlangga', '2023-12-27', 'Saat saya sedang membeli minyak goreng di warung', 'Unverified', 'Oman', 'Admin'),
	('yQaAw', 'Oman', 'Rochman', '2023-12-01', 'tes date', 'Unverified', 'Oman', 'Admin');

-- Dumping structure for table db_gendara.perempi
CREATE TABLE IF NOT EXISTS `perempi` (
  `idNumber` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `img` varchar(500) DEFAULT NULL,
  `tokoh` varchar(50) DEFAULT NULL,
  `materi` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idNumber`),
  KEY `FK_perempi_user` (`username`),
  CONSTRAINT `FK_perempi_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_gendara.perempi: ~4 rows (approximately)
INSERT INTO `perempi` (`idNumber`, `img`, `tokoh`, `materi`, `username`) VALUES
	('1', 'foto_maudy-ayunda.png', 'Maudy Ayunda', 'Maudy Ayunda, seorang seniman multitalenta yang menginspirasi, telah membangun reputasi yang kuat sebagai penyanyi, aktris, penulis, dan aktivis sosial. Kelahiran 19 Desember 1994 di Jakarta, Indonesia, Maudy telah mengukir prestasi yang menginspirasi banyak orang melalui karyanya di dunia hiburan dan juga upayanya dalam meningkatkan kesadaran akan isu-isu sosial. Selain kiprahnya dalam bidang seni, Maudy juga dikenal sebagai aktivis yang peduli terhadap berbagai isu sosial. Ia aktif berbicara tentang pendidikan, lingkungan, dan isu-isu perempuan melalui media sosial dan kegiatan amal.', 'Oman'),
	('2', 'foto_najwa-shihab.png', 'Najwa Shihab', 'Tokoh perempuan Indonesia yang sering kali muncul di televisi yakni Najwa Shihab. Ia merupakan seorang aktivis media yang aktif menyuarakan berbagai isu yang sedang hangat di kalangan masyarakat. Atas keberaniannya, ia juga aktif dalam mewakili suara rakyat serta menyampaikannya kepada para pejabat publik. Selain dikenal karena keberaniannya, ia juga dikenal sebagai wanita tangguh yang berani menyampaikan kebenaran dan pendapatnya di hadapan publik. Beliau juga aktif untuk meningkatkan kualitas jurnalisme di Indonesia serta tak heran banyak sekali mendapatkan penghargaan atas karya-karya nya di bidang jurnalisme.', 'Oman'),
	('3', 'foto_dian-sastro.png', 'Dian Sastro', 'Dian Sastro merupakan tokoh perempuan masa kini yang berasal dari kalangan aktris dan model.  Ia memulai karirnya menjadi model hingga melesat menjadi bintang film di berbagai film box office. Selain paras dan kemampuan akting nya yang mumpuni, Dian Sastro juga dikenal melalui karya nya dalam bidang filantropi. Ia aktif dalam berbagai lembaga kemanusiaan serta memberikan dampak positif bagi lingkungannya. Bakat, kerja keras serta kegigihannya menjadi contoh bagi muda-mudi masa kini.', 'Oman'),
	('4', 'foto_angkie.png', 'Angkie Yudistia', 'Kekurangan tak harus menghalangi dalam menggapai mimpi. Hal tersebut berlaku dari salah satu tokoh perempuan Indonesia inspiratif ini. Pasalnya, ia berhasil mengalahkan kekurangannya tersebut. Saat berusia 10 tahun, Angkie Yudistia divonis menjadi tunarungu. Ia pun menjadi tidak percaya diri sejak kecil. Namun, dorongan semangat dan tekadnya kuat membuatnya meraih berbagi prestasi. Berkat prestasi yang ia telah dapat, Angkie menjadi sosok yang menginspirasi bagi para penyandang disabilitas. Kekurangan tak boleh jadi batu sandungan untuk meraih sebuah kesuksesan.', 'Oman');

-- Dumping structure for table db_gendara.user
CREATE TABLE IF NOT EXISTS `user` (
  `nama` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` enum('Admin','Member') DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_gendara.user: ~5 rows (approximately)
INSERT INTO `user` (`nama`, `email`, `username`, `password`, `role`) VALUES
	('Admin', 'admin@gmail.com', 'admin', 'admin', 'Admin'),
	('Erlangga', 'erlangga@gmail.com', 'erlangga', 'erlangga123', 'Member'),
	('Fikri', 'fikri@gmail.com', 'fikri', 'fikri123', 'Member'),
	('koceng', 'koceng@example.com', 'kuc', 'password', 'Member'),
	('Rochman', 'Oman@gmail.com', 'Oman', 'Oman123', 'Member'),
	('Fauzan', 'fauzan@gmail.com', 'Ozan', 'Ozan123', 'Member');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
