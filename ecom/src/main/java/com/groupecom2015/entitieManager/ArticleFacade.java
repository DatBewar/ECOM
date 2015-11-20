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
}
