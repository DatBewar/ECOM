/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.Commentaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
