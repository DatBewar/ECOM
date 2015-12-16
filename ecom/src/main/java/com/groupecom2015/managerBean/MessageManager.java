/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.managerBean;

import com.groupecom2015.entitieManager.MessageFacade;
import com.groupecom2015.entities.Message;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author umar
 */
@Named(value = "messageManager")
@RequestScoped
public class MessageManager {
    @EJB
    private MessageFacade messageFacade;

    /**
     * Creates a new instance of MessageManager
     */
    private Message msg;
    
    public MessageManager() {
        msg = new Message();
    }

    public MessageFacade getMessageFacade() {
        return messageFacade;
    }

    public void setMessageFacade(MessageFacade messageFacade) {
        this.messageFacade = messageFacade;
    }
    
      public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }
    public void sendMailtoAdmin(){
       // messageFacade.create(msg);
        messageFacade.sendEmailToAdmin(msg);
        //return "messageSent";
}
    public void sendMailToAllClients(){
        messageFacade.sendMailToAllClients(msg);
       // return "messageSent";
    }
    
}
