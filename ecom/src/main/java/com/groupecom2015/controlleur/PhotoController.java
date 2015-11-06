/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.Photo;
import com.groupecom2015.services.PhotoFacadeLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BXDN
 */
@ManagedBean
@RequestScoped
public class PhotoController {
    @EJB
    private Photo photo = new Photo();
    private ArrayList<Photo> photos = new ArrayList<Photo>();
    private PhotoFacadeLocal photoFacadeLocal;

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }

    public PhotoFacadeLocal getPhotoFacadeLocal() {
        return photoFacadeLocal;
    }

    public void setPhotoFacadeLocal(PhotoFacadeLocal photoFacadeLocal) {
        this.photoFacadeLocal = photoFacadeLocal;
    }
    
    
    /**
     * Creates a new instance of PhotoControlleur
     */
    public PhotoController() {
    }
    
}
