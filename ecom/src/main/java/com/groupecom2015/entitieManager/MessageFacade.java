/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupecom2015.entitieManager;

import com.groupecom2015.entities.ArticlePanier;
import com.groupecom2015.entities.CompteUser;
import com.groupecom2015.entities.Message;
import com.itextpdf.text.Document;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.mail.Transport;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author umar
 */
@Stateless
public class MessageFacade extends AbstractFacade<Message> {
    @PersistenceContext(unitName = "com.groupecom2015_ecom_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessageFacade() {
        super(Message.class);
    }
    
    public void sendEmailToAdmin(Message msg){
        final String from = "ecomgroup2015@gmail.com"; //ecomgroup2015@gmail.com
        final String to = msg.getDestination();

      try{
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); //587
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        Authenticator auth;
        auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "groupeecom"); //groupeecom
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        javax.mail.Message msgx = new MimeMessage(session);
 
        msgx.setFrom(new InternetAddress(from));
        InternetAddress[] toAddresses = { new InternetAddress(to) };
        msgx.setRecipients(javax.mail.Message.RecipientType.TO, toAddresses);
        msgx.addRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(from));
        msgx.setSubject(msg.getSubject());
        msgx.setText(msg.getMessage());
         Transport.send(msgx);
        }catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    
     public void sendMailToAllClients(Message msg){
        final String from = "ecomgroupe2015@gmail.com"; //ecomgroupe2015@gmail.com
        List<String> listMail = new ArrayList<>();
        listMail = em.createQuery("SELECT email FROM ecomBd.CompteUser").getResultList();
        
      try{
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); //587
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        Authenticator auth;
        auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "groupeecom");//groupeecom
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        javax.mail.Message msgx = new MimeMessage(session);
 
        msgx.setFrom(new InternetAddress(from));
          for (String lm : listMail) {
              msgx.addRecipients(javax.mail.Message.RecipientType.BCC, InternetAddress.parse(lm));
          }
        msgx.setSubject(msg.getSubject());
        msgx.setText(msg.getMessage());
         Transport.send(msgx);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
   
     public void sendBuyingConfirmationEmail(List<ArticlePanier> listArt, CompteUser cu){
        
        Date d = new Date(System.currentTimeMillis());
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font font_2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
         Font font_3 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
           double total = 0.0;
            String resume="";
        try{
         // new File( System.getProperty( "user.home" ) +"/"+ cu.getIdCompte()).mkdirs();
        //String FILE = System.getProperty("user.home") +"/"+ cu.getIdCompte()+"/commandeRecu.pdf";
        new File("/home/umar/webapp_photo/uploads/"+cu.getIdCompte()).mkdirs();
        String FILE = "/home/umar/webapp_photo/uploads/"+cu.getIdCompte()+"/commandRecu.pdf";
            Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();
       
            Paragraph para = new Paragraph();
            para.add(new Paragraph(d+""));
            para.add(new Paragraph(""));
            para.add(new Paragraph("Bonjour, "+cu.getNom(), font));
            para.add(new Paragraph("Veuillez trouvez ci-dessous votre le résumé de vos achat",font));
            para.add(new Paragraph(""));
          
            for(ArticlePanier l : listArt){
                para.add(new Paragraph(""+l.getArticle().getNomArticle()+"     "+l.getArticle().getPrixVenteArticle(), font_2));
                total += l.getArticle().getPrixVenteArticle();
                resume = resume + "\n" + l.getArticle().getNomArticle()+"  "+l.getArticle().getPrixVenteArticle()+"\n";
            }
            para.add(new Paragraph("Total : "+total, font_3));
            para.add(new Paragraph(""));
            para.add(new Paragraph("Nous vous remercions pour votre achat",font_2));
        document.add(para);
        document.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //sending email with the pdf attached --> dropped
        
        final String from = "ecomgroup2015@gmail.com"; //ecomgroup2015@gmail.com
        final String to = ""+cu.getEmail();
        final String fileUpload = "/uploads/"+cu.getIdCompte()+"/commandRecu.pdf";
      try{
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); //587
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        Session session = Session.getInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "groupeecom");
                }
            });
      
         javax.mail.Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(javax.mail.Message.RecipientType.TO,
            InternetAddress.parse(to));
         message.setSubject("Votre recipissé d'achat");
         message.setText("Bonjour "+cu.getNom()+"\n Veuillez trouvez ci-joint votre résumé d'achat\n"
                 + "\n  "+ resume +"  \n" + total);
         
         /*BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("Cher(e) "+cu.getNom()+"\n veuillez trouver ci-joint votre recipissé d'achat");
         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);
         messageBodyPart = new MimeBodyPart();
         String filename = "/uploads/"+cu.getIdCompte()+"/commandRecu.pdf";
         DataSource source = new FileDataSource(FILE);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(FILE);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);*/
        Transport.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }       
    
        
    }
}
