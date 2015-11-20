/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entities.Article;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.EJBException;
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
    }
    
    public List<Article> getAllArticles(){
        if(articleList == null){
            articleList = articleFacade.getAllArticle();
        }
        return articleList;
    }
    
    public String addArticle(){
        try{
        articleFacade.create(article);
        }catch(EJBException e){
            try {
                throw e.getCausedByException();
            } catch (Exception ex) {
                Logger.getLogger(ArticleManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "messageArticleAjouter";
    } 

    public Article getArticle() {
        return article;
    }
    
    
    public Article getArticleById(){
        return null;
    }
}
