/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.Caracteristique;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author umar
 */
@Stateless
public class CaracteristiqueFacade extends AbstractFacade<Caracteristique> {

    @PersistenceContext(unitName = "com.groupecom2015_ecom_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaracteristiqueFacade() {
        super(Caracteristique.class);
    }
    
    public List<Caracteristique> getAllCaracteristique(){
        return em.createNamedQuery("Caracteristique.findAll").getResultList();
    }
    
   
}
