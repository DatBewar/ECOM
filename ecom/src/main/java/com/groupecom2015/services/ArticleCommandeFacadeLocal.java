/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.services;

import com.groupecom2015.entities.ArticleCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BXDN
 */
@Local
public interface ArticleCommandeFacadeLocal {

    void create(ArticleCommande articleCommande);

    void edit(ArticleCommande articleCommande);

    void remove(ArticleCommande articleCommande);

    ArticleCommande find(Object id);

    List<ArticleCommande> findAll();

    List<ArticleCommande> findRange(int[] range);

    int count();
    
}
