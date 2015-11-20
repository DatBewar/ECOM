/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entities;

import javax.ejb.Stateless;

/**
 *
 * @author Erwan
 */
@Stateless
public class ArticlePanier {

    private int quantArt;
    private int idArticle;

    public ArticlePanier() {
    }
    
    public ArticlePanier(int n, int id){
        this.quantArt = n;
        this.idArticle = id;
    }
    
    public int getQuantArticle(){
        return this.quantArt;
    }
    
    public int getArticle(){
        return this.idArticle;
    }
    
    public void setNumArticle(int n){
        this.quantArt = n;
    }
    
    public void setArticle(int id){
        this.idArticle = id;
    }
    
    public void incrQuantite(){
        this.quantArt++;
    }
    
    public void decrQuantite(){
        if(this.quantArt>0)
            this.quantArt--;
    }
}
