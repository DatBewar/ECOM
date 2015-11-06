/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.ArticleCommande;
import com.groupecom2015.services.ArticleCommandeFacadeLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BXDN
 */
@ManagedBean
@RequestScoped
public class ArticleCommandeController {
    @EJB
    private ArticleCommande articleCommande = new ArticleCommande();
    private ArrayList<ArticleCommande> articleCommandes = new ArrayList<ArticleCommande>();
    private ArticleCommandeFacadeLocal articleCommandeFacadeLocal;

    public ArticleCommande getArticleCommande() {
        return articleCommande;
    }

    public void setArticleCommande(ArticleCommande articleCommande) {
        this.articleCommande = articleCommande;
    }

    public ArrayList<ArticleCommande> getArticleCommandes() {
        return articleCommandes;
    }

    public void setArticleCommandes(ArrayList<ArticleCommande> articleCommandes) {
        this.articleCommandes = articleCommandes;
    }

    public ArticleCommandeFacadeLocal getArticleCommandeFacadeLocal() {
        return articleCommandeFacadeLocal;
    }

    public void setArticleCommandeFacadeLocal(ArticleCommandeFacadeLocal articleCommandeFacadeLocal) {
        this.articleCommandeFacadeLocal = articleCommandeFacadeLocal;
    }    
    /**
     * Creates a new instance of ArticleCommandeArticleControlleur
     */
    public ArticleCommandeController() {
    }
    
}
