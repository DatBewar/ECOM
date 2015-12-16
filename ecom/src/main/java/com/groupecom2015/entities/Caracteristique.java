/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author malick
 */
@Entity
@Table(name = "Caracteristique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristique.findAll", query = "SELECT c FROM Caracteristique c"),
    @NamedQuery(name = "Caracteristique.findByIdCaracteristique", query = "SELECT c FROM Caracteristique c WHERE c.idCaracteristique = :idCaracteristique"),
    @NamedQuery(name = "Caracteristique.findByLibelleCaracteristique", query = "SELECT c FROM Caracteristique c WHERE c.libelleCaracteristique = :libelleCaracteristique"),
    @NamedQuery(name = "Caracteristique.findByUniteCaracteristique", query = "SELECT c FROM Caracteristique c WHERE c.uniteCaracteristique = :uniteCaracteristique"),
    @NamedQuery(name = "Caracteristique.findByValeurCaracteristique", query = "SELECT c FROM Caracteristique c WHERE c.valeurCaracteristique = :valeurCaracteristique")})
public class Caracteristique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCaracteristique")
    private Integer idCaracteristique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelleCaracteristique")
    private String libelleCaracteristique;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uniteCaracteristique")
    private String uniteCaracteristique;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeurCaracteristique")
    private int valeurCaracteristique;
    @ManyToMany(mappedBy = "caracteristiques")
    private List<Article> articles = new ArrayList<>();

    public Caracteristique() {
    }

    public Caracteristique(Integer idCaracteristique) {
        this.idCaracteristique = idCaracteristique;
    }

    public Caracteristique(Integer idCaracteristique, String libelleCaracteristique, String uniteCaracteristique, int valeurCaracteristique) {
        this.idCaracteristique = idCaracteristique;
        this.libelleCaracteristique = libelleCaracteristique;
        this.uniteCaracteristique = uniteCaracteristique;
        this.valeurCaracteristique = valeurCaracteristique;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Integer getIdCaracteristique() {
        return idCaracteristique;
    }

    public void setIdCaracteristique(Integer idCaracteristique) {
        this.idCaracteristique = idCaracteristique;
    }

    public String getLibelleCaracteristique() {
        return libelleCaracteristique;
    }

    public void setLibelleCaracteristique(String libelleCaracteristique) {
        this.libelleCaracteristique = libelleCaracteristique;
    }

    public String getUniteCaracteristique() {
        return uniteCaracteristique;
    }

    public void setUniteCaracteristique(String uniteCaracteristique) {
        this.uniteCaracteristique = uniteCaracteristique;
    }

    public int getValeurCaracteristique() {
        return valeurCaracteristique;
    }

    public void setValeurCaracteristique(int valeurCaracteristique) {
        this.valeurCaracteristique = valeurCaracteristique;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristique != null ? idCaracteristique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristique)) {
            return false;
        }
        Caracteristique other = (Caracteristique) object;
        if ((this.idCaracteristique == null && other.idCaracteristique != null) || (this.idCaracteristique != null && !this.idCaracteristique.equals(other.idCaracteristique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.groupecom2015.entities.Caracteristique[ idCaracteristique=" + idCaracteristique + " ]";
    }
    
}
