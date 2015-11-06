/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.CompteUser;
import com.groupecom2015.services.CompteUserFacadeLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author BXDN
 */
@ManagedBean
@SessionScoped
public class CompterUserController {
    @EJB
    private CompteUser compteUser = new CompteUser();
    private ArrayList<CompteUser> compteUsers = new ArrayList<CompteUser>();
    private CompteUserFacadeLocal compteUserFacadeLocal;

    public CompteUser getCompteUser() {
        return compteUser;
    }

    public void setCompteUser(CompteUser compteUser) {
        this.compteUser = compteUser;
    }

    public ArrayList<CompteUser> getCompteUsers() {
        return compteUsers;
    }

    public void setCompteUsers(ArrayList<CompteUser> compteUsers) {
        this.compteUsers = compteUsers;
    }

    public CompteUserFacadeLocal getCompteUserFacadeLocal() {
        return compteUserFacadeLocal;
    }

    public void setCompteUserFacadeLocal(CompteUserFacadeLocal compteUserFacadeLocal) {
        this.compteUserFacadeLocal = compteUserFacadeLocal;
    }
    
    
    /**
     * Creates a new instance of CompterUserControlleur
     */
    public CompterUserController() {
    }
    
}
