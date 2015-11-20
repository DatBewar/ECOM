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
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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
        categorie = new Categorie();
    }



    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    
    //malick
    public String addCategorie() {
        categorieFacade.create(categorie);
        return "messageAjoutCategorie";
    }


    public List<Categorie> getListCategorie() {
        return categorieFacade.findAll();

    }

    /*
     //malick
     public List<SelectItem> getListCategorieSelectItem() {
     List<SelectItem> categories = new LinkedList<>();
     List<Categorie> l = categorieFacade.findAll();
     for (Categorie cat : l) {
     categories.add(new SelectItem(cat, cat.getNomCategorie()));
     }
     return categories;
     }
     */
 
}
