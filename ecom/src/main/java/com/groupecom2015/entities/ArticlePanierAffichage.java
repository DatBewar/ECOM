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
public class ArticlePanierAffichage {
    private int quantArt;
    private Article article;
    
    public ArticlePanierAffichage(){
    }
    
    public ArticlePanierAffichage(int q, Article a){
        this.quantArt = q;
        this.article = a;
    }
    
    public int getQuantArticle(){
        return this.quantArt;
    }
    
    public Article getArticle(){
        return this.article;
    }
    
    public void setQuantArticle(int n){
        this.quantArt = n;
    }
    
    public void setArticle(Article a){
        this.article = a;
    }
}
