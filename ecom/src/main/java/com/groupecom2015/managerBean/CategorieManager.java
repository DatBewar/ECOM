/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.CategorieFacade;
import com.groupecom2015.entities.Categorie;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author malick
 */
@Named(value = "categorieManager")
@RequestScoped
public class CategorieManager {
    @EJB
    private CategorieFacade categorieFacade;
    private Categorie categorie;
   
    public CategorieManager() {
        categorie = new  Categorie();
    }
    
    public Categorie getCategorie(){
        return categorie;
    }
    
    public String addCategorie(){
        categorieFacade.create(categorie);
        return "messageAjoutCategorie";
    }
    
    public List<Categorie> getListCategorie(){
        
        return categorieFacade.findAll();
        
    }
    
    
}
