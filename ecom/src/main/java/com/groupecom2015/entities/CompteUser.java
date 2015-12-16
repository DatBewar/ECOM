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
import javax.persistence.Lob;
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
@Table(name = "CompteUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteUser.findAll", query = "SELECT c FROM CompteUser c"),
    @NamedQuery(name = "CompteUser.findByIdCompte", query = "SELECT c FROM CompteUser c WHERE c.idCompte = :idCompte"),
    @NamedQuery(name = "CompteUser.findByEmail", query = "SELECT c FROM CompteUser c WHERE c.email = :email"),
    @NamedQuery(name = "CompteUser.findByMotDePasse", query = "SELECT c FROM CompteUser c WHERE c.motDePasse = :motDePasse"),
    @NamedQuery(name = "CompteUser.findByTelephone", query = "SELECT c FROM CompteUser c WHERE c.telephone = :telephone")})
public class CompteUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idCompte")
    private int idCompte;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "motDePasse")
    private String motDePasse;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompte")
    private Collection<Commentaire> commentaireCollection;
    private String nom;
    private String prenom;
    private String typeCompte;

    public CompteUser() {
    }

    public CompteUser(String email) {
        this.email = email;
    }

    public CompteUser(String email, int idCompte, String motDePasse, String adresse, String telephone, String typeCompte) {
        this.email = email;
        this.idCompte = idCompte;
        this.motDePasse = motDePasse;
        this.adresse = adresse;
        this.telephone = telephone;
        this.typeCompte = typeCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }
    
    @XmlTransient
    public Collection<Commentaire> getCommentaireCollection() {
        return commentaireCollection;
    }

    public void setCommentaireCollection(Collection<Commentaire> commentaireCollection) {
        this.commentaireCollection = commentaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteUser)) {
            return false;
        }
        CompteUser other = (CompteUser) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.groupecom2015.entities.CompteUser[ email=" + email + " ]";
    }   
}