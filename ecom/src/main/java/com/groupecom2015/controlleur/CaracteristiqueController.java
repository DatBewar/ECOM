/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.Caracteristique;
import com.groupecom2015.services.CaracteristiqueFacadeLocal;
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
public class CaracteristiqueController {

    public Caracteristique getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
    }

    public ArrayList<Caracteristique> getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(ArrayList<Caracteristique> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public CaracteristiqueFacadeLocal getCaracteristiqueFacadeLocal() {
        return caracteristiqueFacadeLocal;
    }

    public void setCaracteristiqueFacadeLocal(CaracteristiqueFacadeLocal caracteristiqueFacadeLocal) {
        this.caracteristiqueFacadeLocal = caracteristiqueFacadeLocal;
    }
    @EJB
    private Caracteristique caracteristique = new Caracteristique();
    private ArrayList<Caracteristique> caracteristiques = new ArrayList<Caracteristique>();
    private CaracteristiqueFacadeLocal caracteristiqueFacadeLocal;
    
    /**
     * Creates a new instance of CaracteristiqueArticleControlleur
     */
    public CaracteristiqueController() {
    }
    
}
