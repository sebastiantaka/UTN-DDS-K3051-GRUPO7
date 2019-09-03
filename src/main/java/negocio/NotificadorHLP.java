package negocio;

import api.gmailClient.GmailClient;
import dominio.Notificacion;
import dominio.Usuario;

public class NotificadorHLP {
	
	public void notificarPorEmail(Usuario usuario, Notificacion notificacion) {
		GmailClient clienteGmail = new GmailClient();
		if (usuario.getEmail() != null) {
			clienteGmail.enviarConGMail(usuario.getEmail(), notificacion.getTitulo(), notificacion.getDetalle());
		}
		if (usuario.getNumeroDeTelefono() != null) {
			
		}
		
	}
	
}
