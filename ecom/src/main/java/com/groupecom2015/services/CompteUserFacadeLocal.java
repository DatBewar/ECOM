/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.services;

import com.groupecom2015.entities.CompteUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BXDN
 */
@Local
public interface CompteUserFacadeLocal {

    void create(CompteUser compteUser);

    void edit(CompteUser compteUser);

    void remove(CompteUser compteUser);

    CompteUser find(Object id);

    List<CompteUser> findAll();

    List<CompteUser> findRange(int[] range);

    int count();
    
}
