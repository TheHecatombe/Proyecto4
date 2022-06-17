package com.ipn.mx.utilerias;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utileria {
    public void enviarMail(String correoDestinatario, String asunto, String textoCorreo){
	try {
	    Properties props = new Properties();
	    props.setProperty("mail.smtp.host", "smtp.gmail.com");
	    props.setProperty("mail.smtp.starttls.enable", "true");
	    props.setProperty("mail.smtp.port", "587");
	    
	    Session session = Session.getDefaultInstance(props);
	    
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress("escomequipo1@gmail.com"));
	    message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
	    message.addRecipient(Message.RecipientType.BCC, new InternetAddress(correoDestinatario));
	    message.setSubject(asunto);
	    message.setText(textoCorreo);
	    
	    Transport transporte = session.getTransport("smtp");
	    transporte.connect("escomequipo1@gmail.com","escombros");
	    transporte.sendMessage(message, message.getAllRecipients());
	    transporte.close();
	    // CC A quien se le envia una copia Oculta
	    // BCC A quien se le envia una copia Oculta
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
	Utileria u = new Utileria();
	String correoDestinatario = "erickagabriela99@gmail.com";
	String asunto = "Registro";
	String textoCorreo = "Hemos recibido satisfactoriamente su solicitud de registro...";
	u.enviarMail(correoDestinatario, asunto, textoCorreo);
    }
}
