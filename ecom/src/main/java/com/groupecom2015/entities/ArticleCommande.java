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
@Table(name = "ArticleCommande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleCommande.findAll", query = "SELECT a FROM ArticleCommande a"),
    @NamedQuery(name = "ArticleCommande.findByIdArticle", query = "SELECT a FROM ArticleCommande a WHERE a.articleCommandePK.idArticle = :idArticle"),
    @NamedQuery(name = "ArticleCommande.findByIdCommande", query = "SELECT a FROM ArticleCommande a WHERE a.articleCommandePK.idCommande = :idCommande"),
    @NamedQuery(name = "ArticleCommande.findByQuantiteArticle", query = "SELECT a FROM ArticleCommande a WHERE a.quantiteArticle = :quantiteArticle")})
public class ArticleCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticleCommandePK articleCommandePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantiteArticle")
    private int quantiteArticle;
    @JoinColumn(name = "idCommande", referencedColumnName = "idCommande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "idArticle", referencedColumnName = "idArticleVendu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ArticleVendu articleVendu;

    public ArticleCommande() {
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK, int quantiteArticle) {
        this.articleCommandePK = articleCommandePK;
        this.quantiteArticle = quantiteArticle;
    }

    public ArticleCommande(int idArticle, int idCommande) {
        this.articleCommandePK = new ArticleCommandePK(idArticle, idCommande);
    }

    public ArticleCommandePK getArticleCommandePK() {
        return articleCommandePK;
    }

    public void setArticleCommandePK(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public int getQuantiteArticle() {
        return quantiteArticle;
    }

    public void setQuantiteArticle(int quantiteArticle) {
        this.quantiteArticle = quantiteArticle;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public ArticleVendu getArticleVendu() {
        return articleVendu;
    }

    public void setArticleVendu(ArticleVendu articleVendu) {
        this.articleVendu = articleVendu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleCommandePK != null ? articleCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleCommande)) {
            return false;
        }
        ArticleCommande other = (ArticleCommande) object;
        if ((this.articleCommandePK == null && other.articleCommandePK != null) || (this.articleCommandePK != null && !this.articleCommandePK.equals(other.articleCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.groupecom2015.entities.ArticleCommande[ articleCommandePK=" + articleCommandePK + " ]";
    }
    
}
