/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.CommandeFacade;
import com.groupecom2015.entities.Commande;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author malick
 */
@ManagedBean
@Named(value = "commandeManager")
@SessionScoped
public class CommandeManager implements Serializable{


    @EJB
    private CommandeFacade commandeFacade;
    private Commande commande;
    
    
    public CommandeManager() {
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public CommandeFacade getCommandeFacade() {
        return commandeFacade;
    }
    
    public void addCommande(Commande c){
        commandeFacade.create(c);
    }
    
}
