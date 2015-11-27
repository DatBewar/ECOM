/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.CaracteristiqueFacade;
import com.groupecom2015.entities.Caracteristique;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author umar
 */
@Named(value = "caracteristiqueManager")
@ManagedBean
@RequestScoped
public class CaracteristiqueManager {

    @EJB
    private CaracteristiqueFacade caracteristiqueFacade;

    private Caracteristique caracteristique;
    private List<Caracteristique> caracteristiqueList;
    /**
     * Creates a new instance of CaracteristiqueManager
     */
    
    public CaracteristiqueManager() {
        caracteristique = new Caracteristique();       
    }
    
    public Caracteristique getCaracteristique(){
        return caracteristique;
    }
    
    public String addCaracteristique(){
        caracteristiqueFacade.create(caracteristique);
        return "manageCaracteristics";
    }
    
    public List<Caracteristique> getAllCaracteristique(){
        if(caracteristiqueList == null){
            caracteristiqueList = caracteristiqueFacade.getAllCaracteristique();
        }
        return caracteristiqueList;
    } 
    
    public void delCaracteristique(){
        caracteristiqueFacade.remove(caracteristique);
    }
    
    
}
