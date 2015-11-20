/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author malick
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article> {
    @PersistenceContext(unitName = "com.groupecom2015_ecom_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    
    public List<Article> getAllArticle(){
       return em.createNamedQuery("Article.findAll").getResultList();
    }
    
    public Article updateArticle(Article article){
        return em.merge(article);
    }
    
    public void persist(Article article){
        em.persist(article);
    }
    
    public List<Article> searchArticleById(int id){
       return em.createNamedQuery("Article.findByIdArticle").setParameter("idArticle", id).getResultList();
    }

     //Fiston, une fonction - requete pour rechercher par les mots clé (dans sa description et son nom-libellé
    public List<Article> findByKeyWords(String keyWords){
        List<Article> articles;
        //String strQuery ="SELECT * FROM Article descripArticle like %"+keyWords+"% or nom like %"+keyWord+"%";
        String strQuery ="SELECT a FROM Article a WHERE a.nomArticle LIKE '%"+keyWords+"%' OR a.descripArticle LIKE '%"+keyWords+"%'";
        Query q = em.createQuery(strQuery);        
        articles = q.getResultList();
        System.out.println(strQuery+"\n"+articles.size()+"\n Notre resultat");
        return articles;
    }
    
    public List<Article> findByCategorie(int idCategorie){
        List<Article> articles;
        String strQuery ="SELECT a FROM Article a WHERE a.idCategorie.idCategorie ="+idCategorie;
        Query q = em.createQuery(strQuery);        
        articles = q.getResultList();
        //System.out.println(strQuery+"\n"+articles.size()+"\n Notre resultat");
        return articles;
    }
    
    public Article findById(int idArticle){
        List<Article> articles;
        String strQuery ="SELECT a FROM Article a WHERE a.idArticle ="+idArticle;
        Query q = em.createQuery(strQuery);        
        articles = q.getResultList();
        //System.out.println(strQuery+"\n"+articles.size()+"\n Notre resultat");
        return articles.get(0);
    }    

}
