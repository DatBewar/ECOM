/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  umar
 * Created: Nov 13, 2015
 */
DELETE FROM ecomBd.Commentaire;
DELETE FROM ecomBd.Article;
DELETE FROM ecomBd.Categorie;
DELETE FROM ecomBd.CompteUser;
DELETE FROM ecomBd.LigneDeCommande;
DELETE FROM ecomBd.Caracteristique;
DELETE FROM ecomBd.Commande;

INSERT INTO ecomBd.Categorie (idCategorie, nomCategorie) 
	VALUES (1001, "Ecran");
INSERT INTO ecomBd.Categorie (idCategorie, nomCategorie) 
	VALUES (1002, "Clavier");
INSERT INTO ecomBd.Categorie (idCategorie, nomCategorie) 
	VALUES (1003, "Souris");
INSERT INTO ecomBd.Categorie (idCategorie, nomCategorie) 
	VALUES (1004, "Cable USB");

INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5001, "Ecran 15p PC portable", "Ecran 15p ASUS" , 150, 300, 40, 1001);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (50020, "Clavier externe pour PC", "Clavier externe" , 50, 100, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5003, "Souris avec cable USB", "Souris hp" , 15, 30, 200, 1003);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5004, "Souris sans fil bluetooth", "Souris hp h33" , 50, 90, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5005, "Souris sans fil bluetooth", "Souris hp h22" , 50, 40, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5006, "Souris sans fil bluetooth", "Souris hp h44" , 50, 50, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5007, "Souris sans fil bluetooth", "Souris hp h55" , 50, 60, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5008, "Souris sans fil bluetooth", "Souris hp h66" , 50, 23, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5009, "Souris sans fil bluetooth", "Souris hp h77" , 50, 12, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5025, "Souris sans fil bluetooth", "Souris hp h88" , 50, 34, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5019, "Souris sans fil bluetooth", "Souris hp h99" , 50, 45, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5039, "Souris sans fil bluetooth", "Souris hp h10" , 50, 45, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5049, "Souris sans fil bluetooth", "Souris hp h23" , 50, 45, 20, 1002);
INSERT INTO ecomBd.Article (idArticle, descripArticle, nomArticle, prixAchatArticle, prixVenteArticle, stockArticle, categorieId) 
	VALUES (5059, "Souris sans fil bluetooth", "Souris hp h34" , 50, 45, 20, 1002);

INSERT INTO ecomBd.CompteUser (NOM, PRENOM, email, adresse, idCompte, motDePasse, telephone, typeCompte) 
	VALUES ("tom", "smith", "tom.smith@yahoo.com", "New York", 91000, "tom.smith", "0612345678","client");
INSERT INTO ecomBd.CompteUser (NOM, PRENOM, email, adresse, idCompte, motDePasse, telephone, typeCompte) 
	VALUES ("azerty", "azerty","azerty@gmail.com", "Paris", 92000, "azerty", "0612345678","client");
INSERT INTO ecomBd.CompteUser (NOM, PRENOM, email, adresse, idCompte, motDePasse, telephone, typeCompte) 
	VALUES ("qwerty","qwerty","qwerty@hotmail.com", "Grenoble", 93000, "qwerty", "0612345678","client");

INSERT INTO ecomBd.CompteUser (NOM, PRENOM, email, adresse, idCompte, motDePasse, telephone, typeCompte) 
	VALUES ("ADMIN","AdminPrenom","admin@admin.com", "Grenoble", 38400, "admin", "0612345678","admin");

INSERT INTO ecomBd.Commande (idCommande, dateCommande) 
	VALUES (45000, '2015-11-13');

INSERT INTO ecomBd.LigneDeCommande(prixVente, quantite, idArticle, idCommande)
	VALUES(300, 1, 5001, 45000);

INSERT INTO ecomBd.Commentaire (idCommentaire, noteCommentaire, idCompte, idArticle, LIBELLE) 
	VALUES (121, 1, 91000, 5001, "pas satisfait !");
INSERT INTO ecomBd.Commentaire (idCommentaire, noteCommentaire, idCompte, idArticle, LIBELLE) 
	VALUES (122, 2, 91000, 50020, "plutot satisfait");
INSERT INTO ecomBd.Commentaire (idCommentaire, noteCommentaire, idCompte, idArticle, LIBELLE) 
	VALUES (123, 3, 92000, 5003, "tres satisfait");

INSERT INTO ecomBd.Caracteristique (idCaracteristique, libelleCaracteristique, uniteCaracteristique, valeurCaracteristique) 
	VALUES (501, "libelle de la Caracteristique", 5, 1);
INSERT INTO ecomBd.Caracteristique (idCaracteristique, libelleCaracteristique, uniteCaracteristique, valeurCaracteristique) 
	VALUES (502, "libelle de la Caracteristique", 4, 2);
INSERT INTO ecomBd.Caracteristique (idCaracteristique, libelleCaracteristique, uniteCaracteristique, valeurCaracteristique) 
	VALUES (503, "libelle de la Caracteristique", 3, 3);


