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
import javax.persistence.Id;
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
@Table(name = "ArticleVendu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleVendu.findAll", query = "SELECT a FROM ArticleVendu a"),
    @NamedQuery(name = "ArticleVendu.findByIdArticleVendu", query = "SELECT a FROM ArticleVendu a WHERE a.idArticleVendu = :idArticleVendu"),
    @NamedQuery(name = "ArticleVendu.findByIdArticle", query = "SELECT a FROM ArticleVendu a WHERE a.idArticle = :idArticle"),
    @NamedQuery(name = "ArticleVendu.findByNomArticle", query = "SELECT a FROM ArticleVendu a WHERE a.nomArticle = :nomArticle"),
    @NamedQuery(name = "ArticleVendu.findByPrixAchatArticle", query = "SELECT a FROM ArticleVendu a WHERE a.prixAchatArticle = :prixAchatArticle"),
    @NamedQuery(name = "ArticleVendu.findByPrixVenteArticle", query = "SELECT a FROM ArticleVendu a WHERE a.prixVenteArticle = :prixVenteArticle")})
public class ArticleVendu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArticleVendu")
    private Integer idArticleVendu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArticle")
    private int idArticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomArticle")
    private String nomArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixAchatArticle")
    private float prixAchatArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixVenteArticle")
    private float prixVenteArticle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleVendu")
    private Collection<ArticleCommande> articleCommandeCollection;

    public ArticleVendu() {
    }

    public ArticleVendu(Integer idArticleVendu) {
        this.idArticleVendu = idArticleVendu;
    }

    public ArticleVendu(Integer idArticleVendu, int idArticle, String nomArticle, float prixAchatArticle, float prixVenteArticle) {
        this.idArticleVendu = idArticleVendu;
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.prixAchatArticle = prixAchatArticle;
        this.prixVenteArticle = prixVenteArticle;
    }

    public Integer getIdArticleVendu() {
        return idArticleVendu;
    }

    public void setIdArticleVendu(Integer idArticleVendu) {
        this.idArticleVendu = idArticleVendu;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
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
    public Collection<ArticleCommande> getArticleCommandeCollection() {
        return articleCommandeCollection;
    }

    public void setArticleCommandeCollection(Collection<ArticleCommande> articleCommandeCollection) {
        this.articleCommandeCollection = articleCommandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticleVendu != null ? idArticleVendu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleVendu)) {
            return false;
        }
        ArticleVendu other = (ArticleVendu) object;
        if ((this.idArticleVendu == null && other.idArticleVendu != null) || (this.idArticleVendu != null && !this.idArticleVendu.equals(other.idArticleVendu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.groupecom2015.entities.ArticleVendu[ idArticleVendu=" + idArticleVendu + " ]";
    }
    
}
