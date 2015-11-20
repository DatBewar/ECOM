/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author malick
 */
@Entity
@Table(name = "Article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIdArticle", query = "SELECT a FROM Article a WHERE a.idArticle = :idArticle"),
    @NamedQuery(name = "Article.findByNomArticle", query = "SELECT a FROM Article a WHERE a.nomArticle = :nomArticle"),
    @NamedQuery(name = "Article.findByStockArticle", query = "SELECT a FROM Article a WHERE a.stockArticle = :stockArticle"),
    @NamedQuery(name = "Article.findByPrixAchatArticle", query = "SELECT a FROM Article a WHERE a.prixAchatArticle = :prixAchatArticle"),
    @NamedQuery(name = "Article.findByPrixVenteArticle", query = "SELECT a FROM Article a WHERE a.prixVenteArticle = :prixVenteArticle")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArticle")
    private Integer idArticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nomArticle")
    private String nomArticle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripArticle")
    private String descripArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockArticle")
    private int stockArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixAchatArticle")
    private float prixAchatArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixVenteArticle")
    private float prixVenteArticle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle")
    private Collection<Commentaire> commentaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private Collection<LigneDeCommande> ligneDeCommandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle")
    private Collection<Photo> photoCollection;
    @JoinColumn(name = "categorieId", referencedColumnName = "idCategorie")
    @ManyToOne(optional = false)
    private Categorie categorie;

    public Article() {
    }

    public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Article(Integer idArticle, String nomArticle, String descripArticle, int stockArticle, float prixAchatArticle, float prixVenteArticle) {
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.descripArticle = descripArticle;
        this.stockArticle = stockArticle;
        this.prixAchatArticle = prixAchatArticle;
        this.prixVenteArticle = prixVenteArticle;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescripArticle() {
        return descripArticle;
    }

    public void setDescripArticle(String descripArticle) {
        this.descripArticle = descripArticle;
    }

    public int getStockArticle() {
        return stockArticle;
    }

    public void setStockArticle(int stockArticle) {
        this.stockArticle = stockArticle;
    }

    public float getPrixAchatArticle() {
        return prixAchatArticle;
    }

    public void setPrixAchatArticle(float prixAchatArticle) {
        this.prixAchatArticle = prixAchatArticle;
    }

    public float getPrixVenteArticle() {
        return prixVenteArticle;
    }

    public void setPrixVenteArticle(float prixVenteArticle) {
        this.prixVenteArticle = prixVenteArticle;
    }

    @XmlTransient
    public Collection<Commentaire> getCommentaireCollection() {
        return commentaireCollection;
    }

    public void setCommentaireCollection(Collection<Commentaire> commentaireCollection) {
        this.commentaireCollection = commentaireCollection;
    }

    @XmlTransient
    public Collection<LigneDeCommande> getLigneDeCommandeCollection() {
        return ligneDeCommandeCollection;
    }

    public void setLigneDeCommandeCollection(Collection<LigneDeCommande> ligneDeCommandeCollection) {
        this.ligneDeCommandeCollection = ligneDeCommandeCollection;
    }

    @XmlTransient
    public Collection<Photo> getPhotoCollection() {
        return photoCollection;
    }

    public void setPhotoCollection(Collection<Photo> photoCollection) {
        this.photoCollection = photoCollection;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.groupecom2015.entities.Article[ idArticle=" + idArticle + " ]";
    }
    
}
