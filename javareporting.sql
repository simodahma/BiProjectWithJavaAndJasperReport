-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Sam 28 Avril 2018 à 23:59
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `javareporting`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Cne` varchar(20) NOT NULL,
  `MoyG` float NOT NULL,
  `MoyN` float NOT NULL,
  `Filiere` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`Nom`, `Prenom`, `Cne`, `MoyG`, `MoyN`, `Filiere`) VALUES
('ELMoughir', 'Rihab', '1498321221', 15.1, 15.95, 'Big Data'),
('Moutafatin', 'Khalil', '152321345', 14.7, 15.6, 'Big Data'),
('DAHMAMOU', 'MOHAMED', '1311941880', 16.02, 16.22, 'Big Data'),
('Alouane', 'Reda', '154342321', 14.5, 15.34, 'Big Data'),
('Hanini', 'Mohamed', '129838878', 16.22, 16.45, 'Big Data'),
('Asmae', 'Lannani', '142323432', 14.34, 14.32, 'BCG'),
('Mhila', 'Fatimzahra', '14983234', 15.3, 13.43, 'BCG'),
('Alaoui', 'Sarah', '134332444', 13.25, 14.32, 'BCG'),
('Lachachi', 'Mohamed', '13984332', 14.23, 15.34, 'BCG'),
('Alami', 'Salma', '143443423', 12.45, 13.45, 'BCG'),
('Dalmi', 'Ahmed', '14344323', 12.23, 14.34, 'MA'),
('Mellali', 'Ikram', '13232434', 13.45, 14.56, 'MA'),
('ELkhouakhi', 'Mounir', '143354672', 14.34, 14.9, 'MA'),
('Ait Belarbi', 'Basma', '149887878', 15.34, 15.01, 'MA'),
('Belmekhtar', 'Soufiane', '143243232', 16.03, 15.54, 'MA'),
('Omri', 'Imane', '1423324323', 12.34, 11.23, 'GE'),
('Bouarich', 'Zineb', '14321223', 14.22, 14.9, 'GE'),
('Ighza', 'Abderahim', '14342312', 11.87, 11.34, 'GE'),
('Elfarsi', 'Rajae', '154343443', 14.34, 15.23, 'Big Data'),
('Ahmadii', 'Ali', '132434879', 16.1, 11.13, 'Big Data');

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `nom` varchar(30) NOT NULL,
  `dep` varchar(30) NOT NULL,
  `nbre` int(3) NOT NULL,
  `chef_f` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `filiere`
--

INSERT INTO `filiere` (`nom`, `dep`, `nbre`, `chef_f`) VALUES
('Big Data', 'Informatique', 30, 'Abdellah Ezzati'),
('GC', 'Mécanique', 28, 'Abdelaoui'),
('GI', 'Informatique', 33, 'Hamdaoui'),
('MA', 'Informatique', 25, 'Salami'),
('GE', 'Electrique', 40, 'Ibriz'),
('BCG', 'Biologie', 40, 'Khouakhi'),
('Reseaux', 'Informatique', 20, 'Elkant');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
