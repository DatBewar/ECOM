/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.converter;

import com.groupecom2015.entities.Categorie;
import java.util.StringTokenizer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author malick
 */
@FacesConverter("categorieConverter")
public class CategorieConverter implements Converter {
    //malick 

    /**
     *convertir un string en objet categorie
     * @param context
     * @param component
     * @param value
     * @return categorie
     */ // malick
        @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
        if(value==null ||value.trim().length()==0)
            return null;
        Categorie categorie = new Categorie();
        StringTokenizer tab = new StringTokenizer(value, "-");
        int i=0;
        while(tab.hasMoreTokens()){
            try{
                String token = tab.nextToken();
                if(i==0)
                    categorie.setIdCategorie((Integer)Integer.parseInt(token));
                if(i==1)
                    categorie.setNomCategorie(token);
                
                    i++;
            }catch(Exception exception){
                throw new ConverterException();
            }
        }
        //categorie.toString();
        return categorie;   
    }

    /**
     * Convertie un objet categorie 
     * @param context
     * @param component
     * @param value
     * @return un string
     */ //malick
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Categorie)value).toString();
    }
    
}