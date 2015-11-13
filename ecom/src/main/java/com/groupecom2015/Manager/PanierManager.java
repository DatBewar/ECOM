/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.Manager;

import com.groupecom2015.entities.Article;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author bewar
 */
@Stateful
public class PanierManager {

    private List<Article> listArt;
    
    public PanierManager(){
        listArt = new ArrayList<Article>() {};
    }
    
    public void ajoutArticle(Article a){
        
    }
    
    public List<Article> getPanier(){
        return null;
    }
}
