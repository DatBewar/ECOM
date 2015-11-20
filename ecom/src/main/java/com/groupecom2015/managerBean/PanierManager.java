/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entities.Article;
import com.groupecom2015.entities.ArticlePanier;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;

/**
 *
 * @author Erwan
 */
@Named(value = "PanierManager")
@Stateful
public class PanierManager {

    private List<ArticlePanier> listArt;
    
    public PanierManager(){
        this.listArt = new ArrayList<ArticlePanier>();
    }
    
    public void ajoutArticle(Article a){
        ArticlePanier ap = new ArticlePanier(1,a);
        this.listArt.add(ap);
    }
    
    public List<ArticlePanier> getPanier(){
        return this.listArt;
    }
}
