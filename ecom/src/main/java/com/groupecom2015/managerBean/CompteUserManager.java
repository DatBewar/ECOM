package com.groupecom2015.managerBean;

import com.groupecom2015.entities.CompteUser;
import com.groupecom2015.managerBean.util.JsfUtil;
import com.groupecom2015.managerBean.util.PaginationHelper;
import com.groupecom2015.entitieManager.CompteUserFacade;
import com.groupecom2015.managerBean.util.SessionManager;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("compteUserManager")
@SessionScoped
public class CompteUserManager implements Serializable {

    private CompteUser compte;
    private DataModel comptes = null;
    @EJB
    private CompteUserFacade compteUserFacade;
    private PaginationHelper pagination;

    public CompteUserManager() {
    }

    public CompteUserFacade getCompteUserFacade() {
        return compteUserFacade;
    }

    public void setCompteUserFacade(CompteUserFacade compteUserFacade) {
        this.compteUserFacade = compteUserFacade;
    }

    public String addUser() {
        compteUserFacade.create(compte);
        return "messageInscription";
    }

    public String connecter() {
        if (compte.getEmail() != null && compte.getMotDePasse() != null) {
            boolean valide = compteUserFacade.connect(compte);
            if (valide){
                SessionManager session = SessionManager.getInstance();
                session.set("email",compte.getEmail());
                return "deconnecter";
            }
        }
        return "login";
    }

    public String deconnecter() {
        SessionManager session = SessionManager.getInstance();
        session.set("email",null);
        compte = null;
        return "login";
    }
    public String supprimerCompteUser(){
        SessionManager session = SessionManager.getInstance();
        String email = session.get("email").toString();
        compteUserFacade.remove(compteUserFacade.find(email));
        compte = null;
        //deconnecter();        
        return "index";
    }
    
    public String supprimerCompteUser(String email){        
        compteUserFacade.remove(compteUserFacade.find(email));                
        return "displayCompteUser";
    }
    
    public CompteUser getCompte() {
        if (compte == null) {
            compte = new CompteUser();
        }
        return compte;
    }

    private CompteUserFacade getFacade() {
        return compteUserFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "displayCompteUser";
    }

    public String prepareEdit() {        
        compte = compteUserFacade.find(compte.getEmail());
        return "modifierCompteUser";
    }

    public String update() {
        try {
            getFacade().edit(compte);
            return "displayCompteUser";
        } catch (Exception e) {
            return null;
        }
    }

    public DataModel getComptes() {
        if (comptes == null) {
            comptes = getPagination().createPageDataModel();
        }
        return comptes;
    }

    private void recreateModel() {
        comptes = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(compteUserFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(compteUserFacade.findAll(), true);
    }

    public CompteUser getCompteUser(java.lang.String id) {
        return compteUserFacade.find(id);
    }

    @FacesConverter(forClass = CompteUser.class)
    public static class compteUserManagerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompteUserManager controller = (CompteUserManager) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "compteUserManager");
            return controller.getCompteUser(getKey(value));
        }

        String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CompteUser) {
                CompteUser o = (CompteUser) object;
                return getStringKey(o.getEmail());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CompteUser.class.getName());
            }
        }
    }
}
