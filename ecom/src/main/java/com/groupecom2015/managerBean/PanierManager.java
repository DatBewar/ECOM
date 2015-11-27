/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entities.Article;
import com.groupecom2015.entities.ArticlePanier;
import com.groupecom2015.entities.Commande;
import com.groupecom2015.entities.LigneDeCommande;
import java.util.ArrayList;
import java.util.Calendar;
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

    private List<ArticlePanier> listArt;
    @EJB
    private ArticleFacade articleFacade;

    private CommandeManager commandeManager;

    private LigneDeCommandeManager ligneCommandeManager;

    private ArticleManager articleManager;

    public PanierManager() {
        listArt = new ArrayList<ArticlePanier>();
        commandeManager = new CommandeManager();
        ligneCommandeManager = new LigneDeCommandeManager();
        articleManager = new ArticleManager();
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

    public String  viderPanier() {
        this.listArt.clear();
        return "panier";
    }

    public String continuerAchat() {
        return "displayAllArticles";
    }
/*
    public String validerPanier() {
  
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Commande c = new Commande();
        LigneDeCommande lc = new LigneDeCommande();

        c.setDateCommande(date);
        commandeManager.addCommande(c);

        for (ArticlePanier l : listArt) {
            
            lc.setArticle(l.getArticle());
            lc.setCommande(c);
            lc.setPrixVente(l.getArticle().getPrixVenteArticle());
            lc.setQuantite(l.getQuantite());
            ligneCommandeManager.addLigneCommande(lc);
            
            //Décrementer le stock de chaque article
           // l.getArticle().setStockArticle(l.getArticle().getStockArticle() - l.getQuantite());
        } 
        listArt.clear();
        
        return "index";
    }
*/
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
