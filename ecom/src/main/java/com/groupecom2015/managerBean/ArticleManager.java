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
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author umar
 */
@Named(value = "articleManager")
@ManagedBean
public class ArticleManager {
    
    private List<Article> articleList;
    @EJB
    private ArticleFacade articleFacade;

    
    
    public ArticleManager() {
    }
    
    public List<Article> getAllArticles(){
        if(articleList == null){
            articleList = articleFacade.getAllArticle();
        }
        return articleList;
    }
    
    public Article getArticleById(){
        return null;
    }
}
