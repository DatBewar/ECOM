/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.services;

import com.groupecom2015.entities.Commentaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BXDN
 */
@Local
public interface CommentaireFacadeLocal {

    void create(Commentaire commentaire);

    void edit(Commentaire commentaire);

    void remove(Commentaire commentaire);

    Commentaire find(Object id);

    List<Commentaire> findAll();

    List<Commentaire> findRange(int[] range);

    int count();
    
}
