/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.CompteUserFacade;
import com.groupecom2015.entities.CompteUser;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author malick
 */
@Named(value = "compteUserManager")
@RequestScoped
public class CompteUserManager {
    @EJB
    private CompteUserFacade compteUserFacade;
    private List<CompteUser> comptes = new ArrayList<>();
    private CompteUser compte = new CompteUser();

    
    public CompteUserManager() {
        compte = new CompteUser();
    }

    public CompteUser getCompte() {
        return compte;
    }
    
    public String addUser(){
        compteUserFacade.create(compte);
        return "messageInscription";
    }
    
    public List<CompteUser> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteUser> comptes) {
        this.comptes = comptes;
    }
    //Fiston, find a compte by id  
    public String getCompteByID(int compteId){
        compte = compteUserFacade.find(compteId);
        return null;
    }
    
    //Fiston, find a compte by email
    public String getCompteByEmail(String email){
        if(!email.equals("")){
            compte = compteUserFacade.findByEmail(email);
            return "modifierCompteUser";
        }
        else{
            compte = new CompteUser();
         return null;   
        }        
    }
    //Fiston, update compte infos
    public String updateCompte(){
        compteUserFacade.updateCompte(compte);
        compte = new CompteUser();
        return "index";
    }
}
