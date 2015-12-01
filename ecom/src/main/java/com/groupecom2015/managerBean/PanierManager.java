/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entitieManager.CommandeFacade;
import com.groupecom2015.entitieManager.LigneDeCommandeFacade;
import com.groupecom2015.entities.Article;
import com.groupecom2015.entities.ArticlePanier;
import com.groupecom2015.entities.Commande;
import com.groupecom2015.entities.LigneDeCommande;
import com.groupecom2015.entities.LigneDeCommandePK;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Erwan
 */
@Named(value = "panierManager")
@SessionScoped
@Stateful
public class PanierManager {

    @EJB
    private LigneDeCommandeFacade ligneDeCommandeFacade;

    @EJB
    private CommandeFacade commandeFacade;

    @EJB
    private ArticleFacade articleFacade;

    private List<ArticlePanier> listArt;


    public PanierManager() {
        
        commandeFacade = new CommandeFacade();
        ligneDeCommandeFacade = new LigneDeCommandeFacade();
        listArt = new ArrayList<ArticlePanier>();
    }

    public List<ArticlePanier> getListArt() {
        return listArt;
    }

    public void setListArt(List<ArticlePanier> listArt) {
        this.listArt = listArt;
    }

    public float getPrixTotal() {
        float prixTotal = 0;
        for (ArticlePanier l : listArt) {
            prixTotal += (l.getArticle().getPrixVenteArticle() * l.getQuantite());
        }
        return prixTotal;
    }

    public String addArticle(Article article) {
        ArticlePanier ap;

        for (ArticlePanier l : listArt) {
            if (l.getArticle().getIdArticle() == article.getIdArticle()) {
                l.incrQuantite();
                return "panier";
            }
        }
        ap = new ArticlePanier(1, article);
        this.listArt.add(ap);

        return "panier";
    }

    public String deleteArticle(Article article) {
        for (ArticlePanier l : listArt) {
            if (l.getArticle().getIdArticle() == article.getIdArticle()) {
                listArt.remove(l);
                return "panier";
            }
        }
        return "panier";
    }

    public String viderPanier() {
        this.listArt.clear();
        return "panier";
    }

    public String continuerAchat() {
        return "displayAllArticles";
    }

    public String validerPanier() {
        
        Date date = new Date(System.currentTimeMillis());
        Article article;
        Commande c = new Commande();
        LigneDeCommande lc = new LigneDeCommande();
       // LigneDeCommandePK pk;
        // inserer d'abord dans la table commande
        c.setIdCommande(0);
        c.setDateCommande(date);
        commandeFacade.create(c);
        
        // Recuperer l'id de la commande qu'on viens d'inserer
        c = commandeFacade.getCommandeByDate(date);

        for (ArticlePanier l : listArt) {
         article = l.getArticle();
         lc.setLigneDeCommandePK( new LigneDeCommandePK(article.getIdArticle(), c.getIdCommande()));
         lc.setPrixVente(article.getPrixVenteArticle());
         lc.setQuantite(l.getQuantite());
         ligneDeCommandeFacade.create(lc);
         
         //Décrementer le stock de chaque article
         article.setStockArticle(article.getStockArticle() - l.getQuantite());
         articleFacade.edit(article);
         
        }        
         listArt.clear();
        
        return "index";
    }

    /*
     public List<ArticlePanierAffichage> getPanier(){
     List<ArticlePanierAffichage> newList = new ArrayList<ArticlePanierAffichage>();
        
     for(int cpt = 0 ; cpt < this.listArt.size() ; cpt++)
     {
     List<Article> l = articleFacade.searchArticleById(this.listArt.get(cpt).getArticle());
     ArticlePanierAffichage apa = new ArticlePanierAffichage(this.listArt.get(cpt).getQuantArticle(),l.get(0));
     newList.add(apa);
     }
        
     return newList;
     }
    
     */
}
