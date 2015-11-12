/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.CompteUserFacade;
import com.groupecom2015.entities.CompteUser;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author malick
 */
@Named(value = "compteUserView")
@RequestScoped
public class CompteUserView {
    @EJB
    private CompteUserFacade compteUserFacade;
    private CompteUser compte;

    
    public CompteUserView() {
        compte = new CompteUser();
    }

    public CompteUser getCompte() {
        return compte;
    }
    
    public String addUser(){
        compteUserFacade.create(compte);
        return "messageInscription";
    }
    
}
