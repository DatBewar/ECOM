/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.CompteUser;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author malick
 */
@Stateless
public class CompteUserFacade extends AbstractFacade<CompteUser> {

    @PersistenceContext(unitName = "com.groupecom2015_ecom_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteUserFacade() {
        super(CompteUser.class);
    }

    //Fiston, to find an account by Mail
    public CompteUser findByEmail(String email) {
        List<CompteUser> comptes;
        Query q = em.createQuery("SELECT c FROM CompteUser c WHERE c.email ='" + email + "'");
        comptes = q.getResultList();
        return comptes.get(0);
    }

    //Fiston, to find an account by Mail
    public CompteUser findById(int idCompte) {
        List<CompteUser> comptes;
        Query q = em.createQuery("SELECT c FROM CompteUser c WHERE c.idCompte = " + idCompte + "");
        comptes = q.getResultList();
        return comptes.get(0);
    }

    //Fiston, Authentification 
    public boolean connect(CompteUser c) {
        CompteUser compte = find(c.getEmail());
        if (compte == null) {
            return false;
        } else {
            if (compte.getMotDePasse().equals(c.getMotDePasse())) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String MD5(String md5) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }
}
