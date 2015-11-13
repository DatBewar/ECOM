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

    private int numArt;
    private Article article;

    public ArticlePanier() {
    }
    
    public ArticlePanier(int n, Article a){
        this.numArt = n;
        this.article = a;
    }
    
    public int getNumArticle(){
        return this.numArt;
    }
    
    public Article getArticle(){
        return this.article;
    }
    
    public void setNumArticle(int n){
        this.numArt = n;
    }
    
    public void setArticle(Article a){
        this.article = a;
    }
}
