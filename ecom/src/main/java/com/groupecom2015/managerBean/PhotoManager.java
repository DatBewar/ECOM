/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.PhotoFacade;
import com.groupecom2015.entities.Photo;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author umar
 */
@Named(value = "photoManager")
@RequestScoped
public class PhotoManager {
    @EJB
    private PhotoFacade photoFacade;

    private Photo photo;
    private List<Photo> listDesPhotos;
    
    
    
    public PhotoManager() {
    }
    
    public List<Photo> getAllPhotos(){
        return photoFacade.findAll();
    }
    
    public List<Photo> findPhotosByIdArticle(int idArt){
        listDesPhotos = photoFacade.findPicturesByIdArticle(idArt);
        return listDesPhotos;
    }
    
    public Photo findDisplayPhoto(int idArt){
        listDesPhotos = photoFacade.findPicturesByIdArticle(idArt);
        return listDesPhotos.get(0);
    }
}
