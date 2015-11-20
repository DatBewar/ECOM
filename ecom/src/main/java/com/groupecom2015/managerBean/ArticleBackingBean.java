/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author umar
 */
@Named(value = "articleBackingBean")
@ManagedBean
@SessionScoped
public class ArticleBackingBean implements Serializable {

    private int idArticle;
    /**
     * Creates a new instance of ArticleBackingBean
     */
    public ArticleBackingBean() {
    }
    
    public int getIdArticle(){
        return idArticle;
    }
    
    public void setIdArticle(int id){
        idArticle = id;
    }
    
    public void print(){
        System.out.println(idArticle);
    }
}
