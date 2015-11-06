/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.services;

import com.groupecom2015.entities.Caracteristique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BXDN
 */
@Local
public interface CaracteristiqueFacadeLocal {

    void create(Caracteristique caracteristique);

    void edit(Caracteristique caracteristique);

    void remove(Caracteristique caracteristique);

    Caracteristique find(Object id);

    List<Caracteristique> findAll();

    List<Caracteristique> findRange(int[] range);

    int count();
    
}
