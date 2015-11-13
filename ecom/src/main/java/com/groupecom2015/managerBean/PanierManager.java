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

/**
 *
 * @author Erwan
 */
@Stateful
public class PanierManager {

    private List<ArticlePanier> listArt;
    
    public PanierManager(){
        listArt = new ArrayList<ArticlePanier>();
    }
    
    public void ajoutArticle(ArticlePanier a){
        listArt.add(a);
    }
    
    public List<ArticlePanier> getPanier(){
        return this.listArt;
    }
}
