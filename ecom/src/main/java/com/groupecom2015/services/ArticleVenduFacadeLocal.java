/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.services;

import com.groupecom2015.entities.ArticleVendu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BXDN
 */
@Local
public interface ArticleVenduFacadeLocal {

    void create(ArticleVendu articleVendu);

    void edit(ArticleVendu articleVendu);

    void remove(ArticleVendu articleVendu);

    ArticleVendu find(Object id);

    List<ArticleVendu> findAll();

    List<ArticleVendu> findRange(int[] range);

    int count();
    
}
