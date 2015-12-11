/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.CommandeFacade;
import com.groupecom2015.entities.Commande;
import com.groupecom2015.entities.CompteUser;
import com.groupecom2015.entities.LigneDeCommande;
import com.groupecom2015.managerBean.util.SessionManager;
import java.io.Serializable;
import java.util.List;
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
    private List<Commande> commandes;
    
    public CommandeManager() {
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<Commande> getCommandes() {
        commandes = commandeFacade.findAll();
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    
    public CommandeFacade getCommandeFacade() {
        return commandeFacade;
    }
    
    public void addCommande(Commande c){
        commandeFacade.create(c);
    }
    
    public List<Commande> mesCommande(CompteUser c){
        commandes = commandeFacade.findMyCommande(c.getIdCompte());
        return commandes;      
    }
    public List<LigneDeCommande> getLigneDeCommandes(int idCommande){
        List<LigneDeCommande> ligneDeCommandes = commandeFacade.find(idCommande).getLigneDeCommandeCollection();        
        return ligneDeCommandes;
    }
}