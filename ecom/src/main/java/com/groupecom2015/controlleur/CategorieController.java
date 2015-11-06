/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.Categorie;
import com.groupecom2015.services.CategorieFacadeLocal;
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
public class CategorieController {

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public ArrayList<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categorie> categories) {
        this.categories = categories;
    }

    public CategorieFacadeLocal getCategorieFacadeLocal() {
        return categorieFacadeLocal;
    }

    public void setCategorieFacadeLocal(CategorieFacadeLocal categorieFacadeLocal) {
        this.categorieFacadeLocal = categorieFacadeLocal;
    }
    @EJB
    private Categorie categorie = new Categorie();
    private ArrayList<Categorie> categories = new ArrayList<Categorie>();
    private CategorieFacadeLocal categorieFacadeLocal;
    
    
    /**
     * Creates a new instance of CategorieArticleControlleur
     */
    public CategorieController() {
    }
    
}
