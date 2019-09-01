package api.gmailClient;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailClient {
	
	private final String REMITENTE = "No.Responder.Que.Me.Pongo";
	private final String CLAVE = "q1q1qqqq";
	
	public void enviarConGMail(String destinatario, String asunto, String cuerpo) {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", this.getREMITENTE());
		props.put("mail.smtp.clave", this.getCLAVE()); 
		props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
		props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(this.getREMITENTE()));
			message.addRecipients(Message.RecipientType.TO, destinatario); 
			message.setSubject(asunto);
			message.setText(cuerpo);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", this.getREMITENTE(), this.getCLAVE());
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException me) {
			me.printStackTrace(); 
		}
	}

	public String getREMITENTE() {
		return REMITENTE;
	}

	public String getCLAVE() {
		return CLAVE;
	}
}
