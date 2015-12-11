/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author malick
 */
@Entity
@Table(name = "Commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "Commande.findByDateCommande", query = "SELECT c FROM Commande c WHERE c.dateCommande = :dateCommande")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCommande")
    private Integer idCommande;
    @Basic(optional = false)
   
    @Column(name = "dateCommande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<LigneDeCommande> ligneDeCommandeCollection;
    @Column(name = "idCompteUser")
    private Integer idCompteUser;
    
    public Commande() {
    }

    public Commande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(Integer idCommande, Timestamp dateCommande) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getIdCompteUser() {
        return idCompteUser;
    }

    public void setIdCompteUser(Integer idCompteUser) {
        this.idCompteUser = idCompteUser;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @XmlTransient
    public Collection<LigneDeCommande> getLigneDeCommandeCollection() {
        return ligneDeCommandeCollection;
    }

    public void setLigneDeCommandeCollection(Collection<LigneDeCommande> ligneDeCommandeCollection) {
        this.ligneDeCommandeCollection = ligneDeCommandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.groupecom2015.entities.Commande[ idCommande=" + idCommande + " ]";
    }

}
