package negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import dominio.Atuendo;
import dominio.Evento;
import dominio.Guardarropa;
import dominio.Suscripcion;
import dominio.Usuario;
import exceptions.APIClimaExeption;

public class EventoHLP {

	public EventoHLP() {}

	public void programarTareaEvento(Evento evento) {
		evento.getOrganizador().configurarNotificacion(evento);
	}
	
	public Atuendo obtenerSugerenciasPara(Suscripcion suscripcion, Guardarropa guardarropa){
		if (suscripcion.getAtuendos() != null) {
			suscripcion.getAtuendos().get(suscripcion.getIndex());
		} else {
			AtuendoHLP atuendoHLP = new AtuendoHLP();
			List<Atuendo> atuendos = new ArrayList(atuendoHLP.obtenerSugerencias(guardarropa));
			suscripcion.setAtuendos(atuendos);
			suscripcion.setIndex(0);
		}
		
		return suscripcion.getAtuendos().get(suscripcion.getIndex());
	}
	
	
	public Boolean esAtuendoApto(Atuendo atuendo, Evento evento, Double climaActual) throws APIClimaExeption {
		Boolean respuesta = atuendo.getPrendas().stream().allMatch(prenda -> evento.getTipoDeEvento().esPrendaValida(prenda));
		
		ClimaHLP climaH = new ClimaHLP();
		return respuesta && atuendo.nivelDeCalor() > 100 - climaActual;
	}

	public Set<Atuendo> obtenerMejoresSugerencias(Set<Atuendo> sugerencias) {
		return null;
	}

	public Set<Evento> obtenerEventosDeHoy(Usuario usuario){
		return null;//usuario.getEventosRegistrados().stream().filter(evento -> esHoy(evento)).collect(Collectors.toSet());
	}

	public Boolean esHoy(Evento evento){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		fmt.setTimeZone(TimeZone.getTimeZone(evento.getCiudad().getZonaHoraria())); // your time zone
		return fmt.format(evento.getFecha()).equals(fmt.format(new Date()));
	}
}
