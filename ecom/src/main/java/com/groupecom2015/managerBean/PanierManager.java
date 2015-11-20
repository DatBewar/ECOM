/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.ArticleFacade;
import com.groupecom2015.entities.Article;
import com.groupecom2015.entities.ArticlePanier;
import com.groupecom2015.entities.ArticlePanierAffichage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    private ArticleFacade articleFacade;
    
    public PanierManager(){
        this.listArt = new ArrayList<ArticlePanier>();
    }
    
    public String ajoutArticle(int id){
        ArticlePanier ap;
        int index = verifArticle(id);
        if(index > -1){
            ap = this.listArt.get(index);
            ap.incrQuantite();
        }else{
            ap = new ArticlePanier(1,id);
            this.listArt.add(ap);
        }
        return "article ajouté au panier";
    }
    
    public void viderPanier(){
        this.listArt.clear();
    }
    
    public void decrArticle(int id){
        ArticlePanier ap;
        int index = verifArticle(id);
        if(index > -1){
            ap = this.listArt.get(index);
            ap.decrQuantite();
        }
    }
    
    public int verifArticle(int id){
        for(int cpt = 0 ; cpt < this.listArt.size() ; cpt++)
        {
            if(this.listArt.get(cpt).getArticle() == id)
                return cpt;
        }
        return -1;
    }
    
    public List<ArticlePanierAffichage> getPanier(){
        List<ArticlePanierAffichage> newList = new ArrayList<ArticlePanierAffichage>();
        
        for(int cpt = 0 ; cpt < this.listArt.size() ; cpt++)
        {
            List<Article> l = articleFacade.searchArticleById(this.listArt.get(cpt).getArticle());
            ArticlePanierAffichage apa = new ArticlePanierAffichage(this.listArt.get(cpt).getQuantArticle(),l.get(0));
            newList.add(apa);
        }
        
        return newList;
    }
    
    
}
