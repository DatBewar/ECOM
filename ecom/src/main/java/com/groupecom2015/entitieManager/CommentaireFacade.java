/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.Article;
import com.groupecom2015.entities.Commentaire;
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
public class CommentaireFacade extends AbstractFacade<Commentaire> {
    @PersistenceContext(unitName = "com.groupecom2015_ecom_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentaireFacade() {
        super(Commentaire.class);
    }
    public List<Commentaire> findByArticle(int IdArticle){
        List<Commentaire> commentaires;
        String query = "SELECT c FROM Commentaire c WHERE c.idArticle.idArticle = "+IdArticle;
        Query q = em.createQuery(query); 
        commentaires = q.getResultList();
        System.out.println("La nombres de "+query+" mes commentaires "+commentaires.size()+"***********************************\n");
        return commentaires;
    }
}
