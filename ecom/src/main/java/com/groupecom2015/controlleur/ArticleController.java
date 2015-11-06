/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.Article;
import com.groupecom2015.services.ArticleFacadeLocal;
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
public class ArticleController {
    @EJB
    private Article article = new Article();
    private ArrayList<Article> articles = new ArrayList<>();
    private ArticleFacadeLocal articleFacadeLocal;

    public Article getArticle() {
        article = articleFacadeLocal.findAll().get(0);
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ArrayList<Article> getArticles() {        
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArticleFacadeLocal getArticleFacadeLocal() {
        return articleFacadeLocal;
    }

    public void setArticleFacadeLocal(ArticleFacadeLocal articleFacadeLocal) {
        this.articleFacadeLocal = articleFacadeLocal;
    }
    
    
    /**
     * Creates a new instance of ArticleControlleur
     */
    public ArticleController() {
    }
    
}
