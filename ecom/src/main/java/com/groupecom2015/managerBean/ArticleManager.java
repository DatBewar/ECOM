
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entities.Article;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author umar
 */
@Named(value = "articleManager")
@ManagedBean
@RequestScoped
public class ArticleManager {
    private Article article;
    private List<Article> articleList;
    @EJB
    private ArticleFacade articleFacade;

    
    
    public ArticleManager() {
        article = new Article();
        this.articleList = null;
    }

    public List<Article> getArticleList() {
        if(articleList == null){
            articleList = articleFacade.getAllArticle();
        }
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public ArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }
    
    /*public List<Article> getAllArticles(){
        if(articleList == null){
            articleList = articleFacade.getAllArticle();
        }
        return articleList;
    }*/
    
    public String addArticle(){
        articleFacade.create(article);
        return "messageArticleAjouter";
    } 

    public Article getArticle() {
        return article;
    }
    
    
    public Article getArticleById(){
        return null;
    }
    
    public List<Article> searchArticleById(int id){
       return articleFacade.searchArticleById(id);
    }
    /*
    public String getArticleById(){
        articleList.add(articleFacade.findById(article.getIdArticle()));
        return "searchResult";
    }*/
}
