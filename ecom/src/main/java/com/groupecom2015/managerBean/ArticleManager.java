/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entities.Article;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BXDN
 */
@ManagedBean
@RequestScoped
public class ArticleManager {
    @EJB
    private ArticleFacade articleFacade;
    private List<Article> articles = new ArrayList<>();
    private Article article = new Article();
    
    public ArticleManager() {
    }

    public ArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

    public List<Article> getArticles() {
        articles = articleFacade.findAll();
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }   

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    public List<Article> getAllArticles(){
        if(articles == null){
            articles = articleFacade.getAllArticle();
        }
        return articles;
    }
    
    //Fiston, je cherche un article par son ID
    public String getArticleById(int _articleId){
        article = articleFacade.find(_articleId);
        return null;
    }
    //Fiston, une recherche avancée par les mots clés
    public String getArticlesByKeyWords(String keyWord){        
        articles = articleFacade.findByKeyWords(keyWord);
        return "";
    }
    //Fiston, recherche par categories
    public String getArticlesByCategory(int idCategorie){        
        return "";
    }
    public String addArticle(){
        articleFacade.create(article);
        return "index";
    }
}
