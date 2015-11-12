/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author malick
 */
@Entity
@Table(name = "LigneDeCommande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LigneDeCommande.findAll", query = "SELECT l FROM LigneDeCommande l"),
    @NamedQuery(name = "LigneDeCommande.findByIdArticle", query = "SELECT l FROM LigneDeCommande l WHERE l.ligneDeCommandePK.idArticle = :idArticle"),
    @NamedQuery(name = "LigneDeCommande.findByIdCommande", query = "SELECT l FROM LigneDeCommande l WHERE l.ligneDeCommandePK.idCommande = :idCommande"),
    @NamedQuery(name = "LigneDeCommande.findByQuantite", query = "SELECT l FROM LigneDeCommande l WHERE l.quantite = :quantite"),
    @NamedQuery(name = "LigneDeCommande.findByPrixVente", query = "SELECT l FROM LigneDeCommande l WHERE l.prixVente = :prixVente")})
public class LigneDeCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LigneDeCommandePK ligneDeCommandePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantite")
    private int quantite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixVente")
    private float prixVente;
    @JoinColumn(name = "idCommande", referencedColumnName = "idCommande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "idArticle", referencedColumnName = "idArticle", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;

    public LigneDeCommande() {
    }

    public LigneDeCommande(LigneDeCommandePK ligneDeCommandePK) {
        this.ligneDeCommandePK = ligneDeCommandePK;
    }

    public LigneDeCommande(LigneDeCommandePK ligneDeCommandePK, int quantite, float prixVente) {
        this.ligneDeCommandePK = ligneDeCommandePK;
        this.quantite = quantite;
        this.prixVente = prixVente;
    }

    public LigneDeCommande(int idArticle, int idCommande) {
        this.ligneDeCommandePK = new LigneDeCommandePK(idArticle, idCommande);
    }

    public LigneDeCommandePK getLigneDeCommandePK() {
        return ligneDeCommandePK;
    }

    public void setLigneDeCommandePK(LigneDeCommandePK ligneDeCommandePK) {
        this.ligneDeCommandePK = ligneDeCommandePK;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ligneDeCommandePK != null ? ligneDeCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneDeCommande)) {
            return false;
        }
        LigneDeCommande other = (LigneDeCommande) object;
        if ((this.ligneDeCommandePK == null && other.ligneDeCommandePK != null) || (this.ligneDeCommandePK != null && !this.ligneDeCommandePK.equals(other.ligneDeCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.groupecom2015.entities.LigneDeCommande[ ligneDeCommandePK=" + ligneDeCommandePK + " ]";
    }
    
}
