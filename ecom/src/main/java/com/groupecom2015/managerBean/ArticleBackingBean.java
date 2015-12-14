/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entities.Article;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author umar
 */
@Named(value = "articleBackingBean")
@ManagedBean
@SessionScoped
public class ArticleBackingBean implements Serializable {
    @EJB
    private ArticleFacade articleFacade;

    private int idArticle;
    private String nomArticle;
    private Article article;
    private List<Article> list;
    public String getNomArticle() {
        return nomArticle;
    }

    public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }
    /**
     * Creates a new instance of ArticleBackingBean
     */
    public ArticleBackingBean() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    public int getIdArticle(){
        return idArticle;
    }
    
    public void setIdArticle(int id){
        idArticle = id;
    }
    
    public void print(){
        System.out.println(idArticle);
    }
    
    public String getArticleByID(Article article){
         this.article = article;
         return "displayCommentaires";
     }
    
     public String getArticlesByKeyWords() {
        list = articleFacade.findByKeyWords(this.nomArticle);        
        return "searchResult";
    }
}
