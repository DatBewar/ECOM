/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.Commande;
import com.groupecom2015.services.CommandeFacadeLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BXDN
 */
@ManagedBean
@RequestScoped
public class CommandeController {

    public Commande getCategorie() {
        return categorie;
    }

    public void setCategorie(Commande categorie) {
        this.categorie = categorie;
    }

    public ArrayList<Commande> getcCommandeategories() {
        return cCommandeategories;
    }

    public void setcCommandeategories(ArrayList<Commande> cCommandeategories) {
        this.cCommandeategories = cCommandeategories;
    }

    public CommandeFacadeLocal getCommandeFacadeLocal() {
        return commandeFacadeLocal;
    }

    public void setCommandeFacadeLocal(CommandeFacadeLocal commandeFacadeLocal) {
        this.commandeFacadeLocal = commandeFacadeLocal;
    }
    @EJB
    private Commande categorie = new Commande();
    private ArrayList<Commande> cCommandeategories = new ArrayList<Commande>();
    private CommandeFacadeLocal commandeFacadeLocal;
    /**
     * Creates a new instance of CommandeArticleControlleur
     */    
    public CommandeController() {
    }
    
}
