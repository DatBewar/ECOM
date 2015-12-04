/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.Photo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author umar
 */
@Stateless
public class PhotoFacade extends AbstractFacade<Photo> {
    @PersistenceContext(unitName = "com.groupecom2015_ecom_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PhotoFacade() {
        super(Photo.class);
    }
    
    public List<Photo> findPicturesByIdArticle(int idArt){
        List<Photo> listPhoto;
        String query = "SELECT p FROM Photo p WHERE p.idArticle.idArticle = "+idArt;
        listPhoto = em.createQuery(query).getResultList();
        return listPhoto;
    }
    
    public Photo findDisplayPhoto(int idArt){
        String query = "SELECT p FROM Photo p WHERE p.idArticle.idArticle ="+idArt;
        return (Photo) em.createQuery(query).getResultList().get(0);
    }
}
