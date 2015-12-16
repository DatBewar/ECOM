-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 16 Décembre 2015 à 16:05
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `ecombd`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `idArticle` int(11) NOT NULL AUTO_INCREMENT,
  `descripArticle` longtext,
  `nomArticle` varchar(255) DEFAULT NULL,
  `prixAchatArticle` float DEFAULT NULL,
  `prixVenteArticle` float DEFAULT NULL,
  `stockArticle` int(11) DEFAULT NULL,
  `categorieId` int(11) DEFAULT NULL,
  PRIMARY KEY (`idArticle`),
  KEY `FK_Article_categorieId` (`categorieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3006 ;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`idArticle`, `descripArticle`, `nomArticle`, `prixAchatArticle`, `prixVenteArticle`, `stockArticle`, `categorieId`) VALUES
(1, 'HP Pavilion 23-q112nf Ordinateur Tout-en-un 23" Full HD Blanc (Intel Core i5, 4 Go de RAM, Disque dur 1 To, Windows 10)', 'HP Pavilion 23-q112nf', 723.19, 783.19, 100, 1),
(2, 'Lenovo C260 Ordinateur Tout-en-Un 19" Blanc (Intel Celeron, 4 Go de RAM, Disque dur 500 Go, Intel HD Graphics, Windows 10)', 'Lenovo C260 Blanc', 369, 399, 100, 1),
(3, 'Acer Aspire Z1-622 Ordinateur Tout-en-Un Full HD 21" Noir (Intel Pentium, 4 Go de RAM, Disque Dur 1 To, Windows 10)', 'Acer Aspire Z1-622', 499, 499, 100, 1),
(4, 'Lenovo Ideapad 100-15IBY Ordinateur Portable 15" Noir (Intel Celeron, 4 Go de RAM, Disque dur 500 Go, Intel HD Graphics, Windows 10)', 'Lenovo Ideapad 100-15IBY Noir', 299, 299, 90, 1),
(5, 'Asus Premium K751LX-TY077T PC Portable 17,3" (Intel Core i5, 6 Go de RAM, Disque dur 1 To, Nvidia GeForce GTX950M, Windows 10)', 'Asus Premium i5, Nvidia GeForce GTX950M, ', 669.9, 669.9, 90, 1),
(6, 'Apple MacBook Air 13" Argent (2015) (Intel Core i5, 4 Go de RAM, SSD 128 Go, Intel HD Graphics 6000, OS X El Capitan)', 'Apple MacBook Air 13" Argent', 964.99, 964.99, 90, 1),
(7, 'Asus Chromebook C200MA-KX017 PC Portable 11,6" Noir (Intel Celeron, 2 Go de RAM, SSD 16 Go, Chrome OS)', 'Asus Chromebook C200MA-KX017', 169.9, 199.9, 90, 1),
(8, 'Apple MacBook Pro 13" MD101F/A (Core i5 2,5 GHz, 500 Go, 4 Go de RAM, Intel HD graphics 4000)', 'Apple MacBook Pro 13" MD101F/A', 1045, 1045, 90, 1),
(9, 'Lenovo Yoga 3 14 Ordinateur portable Hybride Tactile 14" Orange (Intel Core i5, 8 Go de RAM, SSD 256 Go, Intel HD Graphics, Windo', 'Lenovo Yoga Hybride et tactile', 749, 749, 90, 1),
(10, 'Apple MacBook Pro 13" Retina Argent (2015) (Intel Core i5, 8 Go de RAM, SSD 512 Go, Intel Iris Graphics 6100, Mac OS Yosemite)', 'Apple MacBook Pro 13" Retina Argent', 1729.99, 1729.99, 90, 1),
(11, 'Les Sims 4 : vivre ensemble de Electronic Arts sur les plate-forme : Windows 7, Windows 8, Windows XP', 'Les Sims 4 : vivre ensemble', 43.99, 50.99, 100, 4),
(12, '', 'Call of Duty : Black Ops III', 0, 0, 100, 4),
(13, 'La Nouvelle Maison du Style 2 : les reines de la mode, par Nintendo, Plate-forme : Nintendo 3DS, Nintendo 2DS', 'La Nouvelle Maison du Style 2 ', 60.99, 90.14, 100, 4),
(14, 'De Electronic Arts, Plate-forme : PlayStation 4', 'Fifa 16', 49.99, 59, 100, 4),
(15, 'Plate-forme : PlayStation 4', 'Star Wars : Battlefront', 54.19, 54.19, 100, 4),
(16, 'Plate-forme : Nintendo 3DS', 'Top Model', 19.99, 19.99, 100, 4),
(2001, 'Value Edition Smartphone débloqué 4G Android 5.1 Lollipop Or', 'Samsung Galaxy Grand Prime', 75, 150, 10, 3),
(2002, 'Smartphone débloqué 3G Double SIM - Windows Phone 8.1 Noir', 'Microsoft Lumia 435 ', 75, 350, 10, 3),
(2003, 'Téléphone portable Radio FM gris (Import Allemagne)', 'Nokia 1800 ', 20, 50, 10, 3),
(2004, 'Téléphone 3ème génération Smartphone débloqué 4G, Simple Micro-SIM - Android 5.1 Lollipop Noir', 'Motorola Moto G', 100, 299.99, 5, 3),
(2005, 'Smartphone débloqué 4G  Android 5.1 Lollipop Or Nano-SIM', 'Samsung Galaxy S6 Edge Plus', 400, 699.99, 15, 3),
(2006, 'Smartphone débloqué H+ Double SIM-Micro - Android 5.1 Lollipop', 'Wiko Lenny 2', 50, 71.78, 15, 3),
(2007, 'Smartphone débloqué 4G Simple SIM - Android 4.4 KitKat Noir [Classe énergétique A+]', 'Samsung Galaxy Note 4', 350, 485, 15, 3),
(2008, 'Téléphone 2 pouces Noir (import Allemagne)', 'Samsung GT-B2710KRADBT B2710', 100, 153, 15, 3),
(2009, 'Smartphone débloqué 4G Simple Micro-SIM - Android 5.1 Lollipop Bleu', 'LG Wine Smart H410', 100, 160, 15, 3),
(2010, 'Smartphone débloqué 4G Android 4.2.2 Jelly Bean) Noir', 'LG G2', 200, 299, 15, 3),
(3001, 'SHC8535 Casque Hifi sans fil', 'Casque Philips', 50, 62.9, 10, 2),
(3002, ' Ecouteurs intra auriculaires Noir', 'Ecouteur Panasonic', 5, 9.99, 10, 2),
(3003, 'HS Appareil photo numérique Compact', 'Canon Powershot SX610', 20, 50, 10, 2),
(3004, 'Appareil photo Reflex numérique 10,2 Mpix Ecran 2,7&quot; Stabilisé Objectif 18 55 mm Noir', 'Sony DSLR-A230L', 100, 299.99, 5, 2),
(3005, 'Caméra d''action sportive avec montre de pilotage GPS intégré 4K Full HD Wifi/NFC Blanc', 'Camescope Sony FDRX1000VR', 400, 499.99, 15, 2);

-- --------------------------------------------------------

--
-- Structure de la table `article_caracteristique`
--

CREATE TABLE IF NOT EXISTS `article_caracteristique` (
  `caracteristiques_idCaracteristique` int(11) NOT NULL,
  `articles_idArticle` int(11) NOT NULL,
  PRIMARY KEY (`caracteristiques_idCaracteristique`,`articles_idArticle`),
  KEY `FK_Article_Caracteristique_articles_idArticle` (`articles_idArticle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `article_caracteristique`
--

INSERT INTO `article_caracteristique` (`caracteristiques_idCaracteristique`, `articles_idArticle`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(1, 7),
(2, 7),
(3, 7),
(4, 7),
(5, 7),
(1, 8),
(2, 8),
(3, 8),
(4, 8),
(5, 8),
(1, 9),
(2, 9),
(3, 9),
(4, 9),
(5, 9),
(1, 501),
(2, 501),
(3, 501),
(4, 501),
(5, 501),
(1, 510),
(2, 510),
(3, 510),
(4, 510),
(5, 510),
(1, 524),
(2, 524),
(3, 524),
(4, 524),
(5, 524);

-- --------------------------------------------------------

--
-- Structure de la table `caracteristique`
--

CREATE TABLE IF NOT EXISTS `caracteristique` (
  `idCaracteristique` int(11) NOT NULL AUTO_INCREMENT,
  `libelleCaracteristique` varchar(255) DEFAULT NULL,
  `uniteCaracteristique` varchar(255) DEFAULT NULL,
  `valeurCaracteristique` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCaracteristique`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=525 ;

--
-- Contenu de la table `caracteristique`
--

INSERT INTO `caracteristique` (`idCaracteristique`, `libelleCaracteristique`, `uniteCaracteristique`, `valeurCaracteristique`) VALUES
(1, 'Stockage', 'Go', 1000),
(2, 'Memoire RAM', 'Go', 4),
(3, 'Système d''exploitation', 'Windows', 10),
(4, 'Taille de l''écran', 'pouces', 23),
(5, 'Stockage', 'Go', 500),
(6, 'Memoire RAM', 'Go', 8),
(7, 'Carte Graphique', 'Intel HD Graphics', 0),
(8, 'Memoire RAM', 'Go', 6),
(9, 'Carte Graphique', 'Nvidia GeForce GTX950M', 0),
(501, 'Ecran', 'pouce', 4),
(502, 'Ecran', 'pouce', 5),
(503, 'Ecran', 'pouce', 5),
(504, 'Ecran', 'pouce', 6),
(505, 'Camera Front', 'MP', 10),
(506, 'Camera Front', 'MP', 8),
(507, 'Camera Front', 'MP', 14),
(508, 'Camera Front', 'MP', 12),
(509, 'Camera Front', 'MP', 11),
(510, 'Camera Back', 'MP', 4),
(511, 'Camera Back', 'MP', 4),
(512, 'Camera Back', 'MP', 5),
(513, 'Camera Back', 'MP', 6),
(514, 'Capacité', 'Go', 6),
(515, 'Capacité', 'Go', 8),
(516, 'Capacité', 'Go', 16),
(517, 'Capacité', 'Go', 32),
(518, 'Capacité', 'Go', 64),
(519, 'Système d''exloitation', 'Android', 5),
(520, 'Système d''exloitation', 'Android', 4),
(521, 'Système d''exloitation', 'Windows Phone', 8),
(522, 'Système d''exloitation', 'Android', 4),
(523, 'Zoom Optique', 'x', 18),
(524, 'Objectif', 'mm', 55);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `idCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `nomCategorie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `nomCategorie`) VALUES
(1, 'Informatique'),
(2, 'Image & Son'),
(3, 'Téléphone'),
(4, 'Jeux & Console');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `dateCommande` datetime DEFAULT NULL,
  `idCompteUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE IF NOT EXISTS `commentaire` (
  `idCommentaire` int(11) NOT NULL AUTO_INCREMENT,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `noteCommentaire` int(11) DEFAULT NULL,
  `idArticle` int(11) DEFAULT NULL,
  `idCompte` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCommentaire`),
  KEY `FK_Commentaire_idArticle` (`idArticle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=138 ;

--
-- Contenu de la table `commentaire`
--

INSERT INTO `commentaire` (`idCommentaire`, `LIBELLE`, `noteCommentaire`, `idArticle`, `idCompte`) VALUES
(1, 'Satisfait de ma commande. Je vous conseille.', 5, 1, 2),
(2, 'Ne vaut pas plus cher , et encore je trouve le prix élevé pour ce que c''est. Le pavé tactile est vraiment mais vraiment médiocre , autonomie correct. finition horrible (il fait jouet). La prochaine fois j’investis un peu plus.', 4, 1, 3),
(3, 'Y a t''il un OS de fournis avec l''ordinateur ?', 3, 1, 4),
(4, 'Très bon produit. Beaucoup de plaisir à utiliser Windows 10, ordinateur très performant en ce qui me concerne pour une utilisation internet, bureautique et photos.', 5, 2, 2),
(5, 'Excellent pc, visuellement très réussi, léger et performant.', 4, 2, 3),
(6, 'cet ordi est tout simplement génial, autonomie très grande, simple d''utilisation, beau design, leger. j''ai vite adopter Windows 10, et pourtant j''en était encore avec le vista. c''est un grand changement mais facile. je recommande ce produit.', 3, 2, 4),
(7, 'Un bon pc avec des performances appréciables pour un usage standard (bureautique, jeux de base, photo, etc) Pour l''autonomie, à voir dans le temps si la batterie tient le coup.', 5, 8, 2),
(8, 'Produit fiable Meilleur rapport qualite prix trouve sur le net...', 4, 8, 3),
(9, 'Très bonne ergonomie du clavier . Témoins lumineux de clavier numérique et majuscules. Pc très mince,beau désigne très moderne . mémoire et performances intéressants.', 3, 8, 4),
(10, 'Pas cher du tout la livraison etait parfaite avant la date préciser rien a dire merci', 5, 12, 2),
(11, 'Très satisfait de ecomBay, j''ai recu le jeux la date de sa sorti et j''avais recu un t shirt en cadeaux.', 4, 12, 3),
(12, 'Satisfait de ma commande. Je vous conseille.', 3, 12, 4),
(13, 'Graphisme au top. Différente campagne en solo, ou en ligne avec ses amis Le mode zombie je n''ai pas tester. Le multi comme dans tous les cod sa campent au max', 5, 14, 2),
(14, 'Excellent comment jeux', 4, 14, 3),
(15, 'Satisfait de ma commande. Je vous conseille.', 3, 14, 4),
(121, 'J''ai acheté ce portable il y a quelques mois et j''en suis très satisfait : très belle image en photo et surtout en video', 4, 2001, 2),
(122, 'plutot satisfait', 3, 2001, 3),
(123, 'tres satisfait', 4, 2001, 4),
(124, 'Un très bel object, une autonomie admirable', 5, 2002, 2),
(125, 'Ecran HD superbe', 5, 2002, 2),
(126, 'Très pratique !', 4, 2003, 4),
(127, 'Très bon achat !', 4, 2003, 4),
(128, 'Le rapport qualité/prix/puissance', 3, 2004, 3),
(129, 'Vibreur peut être un peu faible', 2, 2005, 2),
(130, 'Rapport qualité/prix imbattable.', 4, 2005, 3),
(131, 'j''ai des problèmes avec les microphones.', 1, 2006, 4),
(132, 'Ecran tactile très fluide', 4, 2007, 2),
(133, 'Super téléphone acheté il y a 6 mois et il continue de m''épater.', 5, 2008, 3),
(134, 'Pas satisfait, la batterie est nul', 1, 2010, 3),
(135, 'Son extra ! très bon', 4, 2, 92000),
(136, 'Je l''utilise depuis bientot 3 mois, super son', 5, 3, 92000),
(137, 'Difficile a manipuler mais prend des super photo si on s''y connais', 5, 4, 92000);

-- --------------------------------------------------------

--
-- Structure de la table `compteuser`
--

CREATE TABLE IF NOT EXISTS `compteuser` (
  `email` varchar(255) NOT NULL,
  `adresse` longtext,
  `idCompte` int(11) DEFAULT NULL,
  `motDePasse` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `TYPECOMPTE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compteuser`
--

INSERT INTO `compteuser` (`email`, `adresse`, `idCompte`, `motDePasse`, `NOM`, `PRENOM`, `telephone`, `TYPECOMPTE`) VALUES
('ecomgroup2015@gmail.com', 'Grenoble', 1, 'ecomgroup2015', 'EcomBay', 'EcomBay', '0412345678', 'admin'),
('erwancroze@gmail.com', 'New York', 4, 'erwancroze', 'CROZE', 'Erwan', '0612345678', 'client'),
('milkzodiagne@yahoo.fr', 'Paris', 2, 'milkzodiagne', 'DIAGNE', 'Malik', '0412345678', 'client'),
('rukundofiston@yahoo.com', 'Grenoble', 3, 'rukundofiston', 'RUKUNDO', 'Fiston', '0642345678', 'client');

-- --------------------------------------------------------

--
-- Structure de la table `lignedecommande`
--

CREATE TABLE IF NOT EXISTS `lignedecommande` (
  `prixVente` float DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `idArticle` int(11) NOT NULL,
  `idCommande` int(11) NOT NULL,
  PRIMARY KEY (`idArticle`,`idCommande`),
  KEY `FK_LigneDeCommande_idCommande` (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `ID` bigint(20) NOT NULL,
  `MESSAGE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

CREATE TABLE IF NOT EXISTS `photo` (
  `idPhoto` int(11) NOT NULL AUTO_INCREMENT,
  `pathPhoto` varchar(255) DEFAULT NULL,
  `idArticle` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPhoto`),
  KEY `FK_Photo_idArticle` (`idArticle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=851 ;

--
-- Contenu de la table `photo`
--

INSERT INTO `photo` (`idPhoto`, `pathPhoto`, `idArticle`) VALUES
(1, '/uploads/5001/hp_pavillon_all_in_one.jpg', 1),
(2, '/uploads/5001/hp_pavillon_all_in_one1.jpg', 1),
(3, '/uploads/5001/hp_pavillon_all_in_one2.jpg', 1),
(4, '/uploads/5001/Lenovo_C260_Q4.jpg', 2),
(5, '/uploads/5001/Lenovo_C260_Q4_1.jpg', 2),
(6, '/uploads/5001/Lenovo_C260_Q4_2.jpg', 2),
(7, '/uploads/5001/Acer_Aspire_ Z1-622.jpg', 3),
(8, '/uploads/5001/Acer_Aspire_ Z1-622_1.jpg', 3),
(9, '/uploads/5001/Acer_Aspire_ Z1-622_2.jpg', 3),
(10, '/uploads/5001/Acer_Aspire_ Z1-622_3.jpg', 3),
(11, '/uploads/5001/lenovo_Ideapad_0.jpg', 4),
(12, '/uploads/5001/lenovo_Ideapad_1.jpg', 4),
(13, '/uploads/5001/lenovo_Ideapad_2.jpg', 4),
(14, '/uploads/5001/lenovo_Ideapad_3.jpg', 4),
(15, '/uploads/5001/Asus_Premium_K751LX_0.jpg', 5),
(16, '/uploads/5001/Asus_Premium_K751LX_1.jpg', 5),
(17, '/uploads/5001/Asus_Premium_K751LX_2.jpg', 5),
(18, '/uploads/5001/Asus_Premium_K751LX_3.jpg', 5),
(19, '/uploads/5001/Apple_MacBook_Air_1.jpg', 6),
(20, '/uploads/5001/Apple_MacBook_Air_2.jpg', 6),
(21, '/uploads/5001/Apple_MacBook_Air_3.jpg', 6),
(22, '/uploads/5001/Asus_Chromebook_C300MA_0.jpg', 7),
(23, '/uploads/5001/Asus_Chromebook_C300MA_1.jpg', 7),
(24, '/uploads/5001/Asus_Chromebook_C300MA_2.jpg', 7),
(25, '/uploads/5001/Asus_Chromebook_C300MA_3.jpg', 7),
(26, '/uploads/5001/Apple_MacBook_Pro_0.jpg', 8),
(27, '/uploads/5001/Apple_MacBook_Pro_1.jpg', 8),
(28, '/uploads/5001/Apple_MacBook_Pro_2.jpg', 8),
(29, '/uploads/5001/Apple_MacBook_Pro_3.jpg', 8),
(30, '/uploads/5001/Lenovo_Yoga_0.jpg', 9),
(31, '/uploads/5001/Lenovo_Yoga_1.jpg', 9),
(32, '/uploads/5001/Lenovo_Yoga_2.jpg', 9),
(33, '/uploads/5001/Lenovo_Yoga_3.jpg', 9),
(34, '/uploads/5001/Apple_MacBook_Pro_Retina_0.jpg', 10),
(35, '/uploads/5001/Apple_MacBook_Pro_Retina_1.jpg', 10),
(36, '/uploads/5001/Apple_MacBook_Pro_Retina_2.jpg', 10),
(37, '/uploads/5001/Apple_MacBook_Pro_Retina_3.jpg', 10),
(38, '/uploads/5001/sims_4_0.jpg', 11),
(39, '/uploads/5001/sims_4_1.jpg', 11),
(40, '/uploads/5001/sims_4_2.jpg', 11),
(41, '/uploads/5001/sims_4_3.jpg', 11),
(42, '/uploads/5001/Call_Duty_0.jpg', 12),
(43, '/uploads/5001/Call_Duty_1.jpg', 12),
(44, '/uploads/5001/Call_Duty_2.jpg', 12),
(45, '/uploads/5001/Call_Duty_3.jpg', 12),
(46, '/uploads/5001/NouvelleMaison_tyle_0.jpg', 13),
(47, '/uploads/5001/NouvelleMaison_tyle_1.jpg', 13),
(48, '/uploads/5001/NouvelleMaison_tyle_2.jpg', 13),
(49, '/uploads/5001/NouvelleMaison_tyle_3.jpg', 13),
(50, '/uploads/5001/fifa_16_0.jpg', 14),
(51, '/uploads/5001/fifa_16_1.jpg', 14),
(52, '/uploads/5001/fifa_16_2.jpg', 14),
(53, '/uploads/5001/fifa_16_3.jpg', 14),
(54, '/uploads/5001/Star_Wars_Battlefront_0.jpg', 15),
(55, '/uploads/5001/Star_Wars_Battlefront_1.jpg', 15),
(56, '/uploads/5001/Star_Wars_Battlefront_2.jpg', 15),
(57, '/uploads/5001/Star_Wars_Battlefront_3.jpg', 15),
(58, '/uploads/5001/Top_Model_0.jpg', 16),
(59, '/uploads/5001/Top_Model_1.jpg', 16),
(60, '/uploads/5001/Top_Model_2.jpg', 16),
(61, '/uploads/5001/Top_Model_3.jpg', 16),
(801, '/uploads/2001/801.JPG', 2001),
(802, '/uploads/2001/801.JPG', 2001),
(803, '/uploads/2001/801.JPG', 2001),
(804, '/uploads/2002/801.JPG', 2002),
(805, '/uploads/2002/801.JPG', 2002),
(806, '/uploads/2002/801.JPG', 2002),
(807, '/uploads/2002/801.JPG', 2002),
(808, '/uploads/2003/801.JPG', 2003),
(809, '/uploads/2003/801.JPG', 2003),
(810, '/uploads/2003/801.JPG', 2003),
(811, '/uploads/2003/801.JPG', 2003),
(812, '/uploads/2004/801.JPG', 2004),
(813, '/uploads/2004/801.JPG', 2004),
(814, '/uploads/2004/801.JPG', 2004),
(815, '/uploads/2004/801.JPG', 2004),
(816, '/uploads/2005/801.JPG', 2005),
(817, '/uploads/2005/801.JPG', 2005),
(818, '/uploads/2005/801.JPG', 2005),
(819, '/uploads/2005/801.JPG', 2005),
(820, '/uploads/2005/801.JPG', 2005),
(821, '/uploads/2006/801.JPG', 2006),
(822, '/uploads/2006/801.JPG', 2006),
(823, '/uploads/2007/801.JPG', 2007),
(824, '/uploads/2007/801.JPG', 2007),
(825, '/uploads/2007/801.JPG', 2007),
(826, '/uploads/2007/801.JPG', 2007),
(827, '/uploads/2008/801.JPG', 2008),
(828, '/uploads/2008/801.JPG', 2008),
(829, '/uploads/2008/801.JPG', 2008),
(830, '/uploads/2009/801.JPG', 2009),
(831, '/uploads/2010/801.JPG', 2010),
(832, '/uploads/2010/801.JPG', 2010),
(833, '/uploads/2010/801.JPG', 2010),
(834, '/uploads/3001/801.JPG', 3001),
(835, '/uploads/3001/801.JPG', 3001),
(836, '/uploads/3002/801.JPG', 3002),
(837, '/uploads/3002/801.JPG', 3002),
(838, '/uploads/3002/801.JPG', 3002),
(839, '/uploads/3003/801.JPG', 3003),
(840, '/uploads/3003/801.JPG', 3003),
(841, '/uploads/3003/801.JPG', 3003),
(842, '/uploads/3004/801.JPG', 3004),
(843, '/uploads/3004/801.JPG', 3004),
(844, '/uploads/3004/801.JPG', 3004),
(845, '/uploads/3004/801.JPG', 3004),
(850, '/uploads/3002/801.JPG', 3002);

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(255) NOT NULL,
  `SEQ_COUNT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK_Article_categorieId` FOREIGN KEY (`categorieId`) REFERENCES `categorie` (`idCategorie`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `FK_Commentaire_idArticle` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`);

--
-- Contraintes pour la table `lignedecommande`
--
ALTER TABLE `lignedecommande`
  ADD CONSTRAINT `FK_LigneDeCommande_idArticle` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`),
  ADD CONSTRAINT `FK_LigneDeCommande_idCommande` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`);

--
-- Contraintes pour la table `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `FK_Photo_idArticle` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
