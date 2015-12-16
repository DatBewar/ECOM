
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entities.Article;
import com.groupecom2015.entities.Commentaire;
import com.groupecom2015.managerBean.util.JsfUtil;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

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
    private int auxStock, auxIdArticle;
    private List<Article> articleFiltre;
    
    public ArticleManager() {
        article = new Article();
        this.articleList = null;
    }

    public int getAuxIdArticle() {
        return auxIdArticle;
    }

    public void setAuxIdArticle(int auxIdArticle) {
        this.auxIdArticle = auxIdArticle;
    }
    
    public int getAuxStock() {
        return auxStock;
    }

    public void setAuxStock(int auxStock) {
        this.auxStock = auxStock;
    }

    public List<Article> getArticleList() {
        if (articleList == null) {
            articleList = articleFacade.getAllArticle();
        }
        return articleList;
    }
    
    /*public List<Article> getArticleList(int db, int fin) {
        return articleFacade.getArticleFrom(db, fin);
    }*/

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public ArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }
   
    public String addArticle() {
        articleFacade.create(article);
        return "messageArticleAjouter";
    }

    public Article getArticle() {
        return article;
    }

    public void setArticleById(int id){
        article = articleFacade.find(id);        
    }

    public List<Article> searchArticleById(int id) {
        return articleFacade.searchArticleById(id);
    }

    //Fiston, une recherche avancée par les mots clés
    public String getArticlesByKeyWords() {
        articleList = articleFacade.findByKeyWords(article.getNomArticle());        
        return "searchResult";
    }

    public String modifierQuantite(Article aux) {
        article = aux;
        auxIdArticle = aux.getIdArticle();
        return "modifierQuantite";
    }

    public String updateArticle(int idArticle){           
        Article aux = articleFacade.find(idArticle);
        int updatedStock = aux.getStockArticle() + auxStock;
        aux.setStockArticle(updatedStock);
        articleFacade.edit(aux);
        return "displayAllArticles";
    }
    
   public void surprimer(int idArticle){
      Article aux = articleFacade.find(idArticle);
      articleFacade.remove(aux);

    }
     public void setFiltreArticle(List<Article> filtreArticle) {
        this.articleFiltre = filtreArticle;
    }
    
     public List<Article> getArticleFiltre(){
         return articleFiltre;
     }
     public String getArticleByID(int idArticle){
         article = articleFacade.find(idArticle);
         return "displayCommentaires_1";
     }
     
     public void getRate(int idArticle){
         Article a = articleFacade.find(idArticle);
         List<Commentaire> c = a.getCommentaireCollection();
         int rate = 0, count = 0;        
     }
     
     public void onRowEdit(RowEditEvent event) {
       
        Article ac = (Article)event.getObject();
        articleFacade.edit(ac);
        
    }
     
      public void onRowCancel(RowEditEvent event) {
       
    }
}