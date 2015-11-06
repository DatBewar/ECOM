/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.ArticleVendu;
import com.groupecom2015.services.ArticleVenduFacadeLocal;
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
public class ArticleVenduController {
    @EJB
    private ArticleVendu article = new ArticleVendu();
    private ArrayList<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
    private ArticleVenduFacadeLocal articleVenduFacadeLocal;

    public ArticleVendu getArticle() {
        return article;
    }

    public void setArticle(ArticleVendu article) {
        this.article = article;
    }

    public ArrayList<ArticleVendu> getArticleVendus() {
        return articleVendus;
    }

    public void setArticleVendus(ArrayList<ArticleVendu> articleVendus) {
        this.articleVendus = articleVendus;
    }

    public ArticleVenduFacadeLocal getArticleVenduFacadeLocal() {
        return articleVenduFacadeLocal;
    }

    public void setArticleVenduFacadeLocal(ArticleVenduFacadeLocal articleVenduFacadeLocal) {
        this.articleVenduFacadeLocal = articleVenduFacadeLocal;
    }
    
    
    /**
     * Creates a new instance of ArticleVenduArticleControlleur
     */
    public ArticleVenduController() {
    }
    
}