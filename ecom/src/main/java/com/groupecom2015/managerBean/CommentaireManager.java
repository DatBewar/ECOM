/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.CommentaireFacade;
import com.groupecom2015.entities.Commentaire;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BXDN
 */
@ManagedBean
@RequestScoped
public class CommentaireManager {

    private CommentaireFacade commentaireFacade;
    private List<Commentaire> commentaires;
    private Commentaire commentaire;

    /**
     * Creates a new instance of CommentaireManager
     */
    public CommentaireManager() {
    }

    public CommentaireFacade getCommentaireFacade() {
        return commentaireFacade;
    }

    public void setCommentaireFacade(CommentaireFacade commentaireFacade) {
        this.commentaireFacade = commentaireFacade;
    }

    public List<Commentaire> getCommentaires() {
        this.commentaires = commentaireFacade.findAll();
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public List<Commentaire> getCommentaireByArticle(int idArticle) {
        commentaires = commentaireFacade.findByArticleId(idArticle);
        return commentaires;
    }
}
