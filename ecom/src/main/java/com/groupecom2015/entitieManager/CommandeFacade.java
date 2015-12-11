/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.Commande;
import java.util.Date;
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
public class CommandeFacade extends AbstractFacade<Commande> {

    @PersistenceContext(unitName = "com.groupecom2015_ecom_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }

    public Commande getCommandeByDate(Date date) {
        Query q = em.createQuery("SELECT c FROM Commande c WHERE c.dateCommande = :dateCommande");
        q.setParameter("dateCommande", date);               
        return (Commande)q.getSingleResult();
    }
    
    //Recuperer les commande par compte utilisateur
    public List<Commande> findMyCommande(int idCompteUser){        
        List<Commande> cmd;
        String query = "SELECT c FROM Commande c WHERE c.idCompteUser = "+idCompteUser;
        System.out.println(query+"\n *********************************************");
        Query q = em.createQuery(query);
        cmd = q.getResultList();
        return cmd;
    }
}
