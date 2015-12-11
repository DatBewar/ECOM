package com.groupecom2015.managerBean;

import com.groupecom2015.entities.CompteUser;
import com.groupecom2015.entitieManager.CompteUserFacade;
import com.groupecom2015.managerBean.util.SessionManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("compteUserManager")
@SessionScoped
public class CompteUserManager implements Serializable {

    private CompteUser compte = new CompteUser();
    private List<CompteUser> comptes = new ArrayList<>();
    private boolean isClient = false;
    @EJB
    private CompteUserFacade compteUserFacade;

    public CompteUserManager() {
    }

    public boolean isIsClient() {
        return isClient;
    }

    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }
    
    public CompteUserFacade getCompteUserFacade() {
        return compteUserFacade;
    }

    public void setCompteUserFacade(CompteUserFacade compteUserFacade) {
        this.compteUserFacade = compteUserFacade;
    }

    public void setCompte(CompteUser compte) {
        this.compte = compte;
    }

    public void setComptes(List<CompteUser> comptes) {
        this.comptes = comptes;
    }

    public String addUser() {
        compteUserFacade.create(compte);
        return "login";
    }

    public String connecter() {
        if (compte.getEmail() != null && compte.getMotDePasse() != null){            
            boolean valide = compteUserFacade.connect(compte);
            if (valide) {
                compte = compteUserFacade.findByEmail(compte.getEmail());
                return "index";
            }
        }
        return "login";
    }
    public String verifier(){
        if(compte.getEmail()!=null){
            if(compte.getTypeCompte().equals("admin")){
                isClient = false;
            }
            else{
                isClient = true;
            }
            return "generation";
        }  
        return "login";
    }

    public String deconnecter() {
        SessionManager session = SessionManager.getInstance();
        session.set("email", null);
        compte = null;
        return "login";
    }

    public String supprimerCompteUser() {
        SessionManager session = SessionManager.getInstance();
        String email = session.get("email").toString();
        compteUserFacade.remove(compteUserFacade.find(email));
        compte = null;        
        return "index";
    }

    public String adminSupprimerCompteUser(String email) {
        if (email.isEmpty()) {
            return "";
        } else {
            compteUserFacade.remove(compteUserFacade.find(email));
            comptes = compteUserFacade.findAll();
            return "displayCompteUser";
        }
    }

    public String supprimerCompteUser(String email) {
        compteUserFacade.remove(compteUserFacade.find(email));
        return "displayCompteUser";
    }

    public CompteUser getCompte() {
        if (compte == null) {
            compte = new CompteUser();
        }
        return compte;
    }

    private CompteUserFacade getFacade() {
        return compteUserFacade;
    }  

    public String prepareEdit() {
        compte = compteUserFacade.find(compte.getEmail());
        return "modifierCompteUser";
    }

    public String update() {
        try {
            getFacade().edit(compte);
            return "displayCompteUser";
        } catch (Exception e) {
            return null;
        }
    }

    public List<CompteUser> getComptes() {
        if (comptes == null) {
            comptes = compteUserFacade.findAll();
        }
        return comptes;
    }    

    public CompteUser getCompteUser(String id) {
        return compteUserFacade.find(id);
    }       
}