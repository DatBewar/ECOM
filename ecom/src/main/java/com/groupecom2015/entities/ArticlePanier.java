/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entities;


/**
 *
 * @author Erwan
 */

public class ArticlePanier {

    private int quantite;
    private Article article;

    public ArticlePanier() {
    }
    
    public ArticlePanier(int n, Article article){
        this.quantite = n;
        this.article = article;
    }
    
    public int getQuantite(){
        return this.quantite;
    }
    
    public Article getArticle(){
        return this.article;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }   
    
    public void setArticle(Article article){
        this.article = article;
    }
    
    public void incrQuantite(){
        this.quantite++;
    }
    
    public void decrQuantite(){
        if(this.quantite>0)
            this.quantite--;
    }
}
