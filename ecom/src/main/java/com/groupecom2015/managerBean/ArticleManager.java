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
    private List<Article> articles_ = new ArrayList<>();
    private Article article = new Article();
    private String keyWord = new String();
    
    public ArticleManager() {
    }

    public List<Article> getArticles_() {
        return articles_;
    }

    public void setArticles_(List<Article> articles_) {
        this.articles_ = articles_;
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
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    
    //Fiston, je cherche un article par son ID
    public String getArticleById(int _articleId){
        article = articleFacade.find(_articleId);
        return null;
    }
    //Fiston, une recherche avancée par les mots clés
    public String getArticlesByKeyWords(){
        articles_ = articleFacade.findByKeyWords(keyWord);
        return "searchResult";
    }
    //Fiston, recherche par categories
    public String getArticlesByCategory(int idCategorie){        
        return "searchResult";
    }
    public String addArticle(){
        articleFacade.create(article);
        return "index";
    }
}
