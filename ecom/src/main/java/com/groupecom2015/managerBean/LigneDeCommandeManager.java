/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.LigneDeCommandeFacade;
import com.groupecom2015.entities.LigneDeCommande;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author malick
 */
@Named(value = "ligneDeCommandeManager")
@Dependent
public class LigneDeCommandeManager {
    
    @EJB
    private LigneDeCommandeFacade ligneDeCommandeFacade;
    
    private LigneDeCommande ligneCommande;

    public LigneDeCommandeFacade getLigneDeCommandeFacade() {
        return ligneDeCommandeFacade;
    }

    public LigneDeCommandeManager() {
        ligneCommande = new LigneDeCommande();
    }
    
    public void addLigneCommande(){
        ligneDeCommandeFacade.create(ligneCommande);
    }
    
     public void addLigneCommande(LigneDeCommande l){
        ligneDeCommandeFacade.create(l);
    }
}
