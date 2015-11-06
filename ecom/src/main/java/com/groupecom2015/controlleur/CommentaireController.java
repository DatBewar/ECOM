/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupecom2015.controlleur;

import com.groupecom2015.entities.Commentaire;
import com.groupecom2015.services.CommentaireFacadeLocal;
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
public class CommentaireController {

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public ArrayList<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(ArrayList<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public CommentaireFacadeLocal getCommentaireFacadeLocal() {
        return commentaireFacadeLocal;
    }

    public void setCommentaireFacadeLocal(CommentaireFacadeLocal commentaireFacadeLocal) {
        this.commentaireFacadeLocal = commentaireFacadeLocal;
    }
    @EJB
    private Commentaire commentaire = new Commentaire();
    private ArrayList<Commentaire> commentaires = new ArrayList<Commentaire>();
    private CommentaireFacadeLocal commentaireFacadeLocal;
    
    
    
    /**
     * Creates a new instance of CommentaireControlleur
     */
    public CommentaireController() {
    }
    
}
