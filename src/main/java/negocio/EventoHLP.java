package negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

import api.climaClient.IClimaClient;
import dominio.Atuendo;
import dominio.Evento;
import dominio.Usuario;
import exceptions.APIClimaExeption;

public class EventoHLP {

	public EventoHLP() {}

	public Boolean esAtuendoApto(Atuendo atuendo, Evento evento, Double climaActual) throws APIClimaExeption {
		ClimaHLP climaH = new ClimaHLP();
		return atuendo.nivelDeCalor() > 100 - climaActual;
	}

	public Set<Atuendo> obtenerMejoresSugerencias(Set<Atuendo> sugerencias) {
		return null;
	}

	public Set<Evento> obtenerEventosDeHoy(Usuario usuario){
		return usuario.getEventosRegistrados().stream().filter(evento -> esHoy(evento)).collect(Collectors.toSet());
	}

	public Boolean esHoy(Evento evento){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		fmt.setTimeZone(TimeZone.getTimeZone(evento.getCiudad().getZonaHoraria())); // your time zone
		return fmt.format(evento.getFecha()).equals(fmt.format(new Date()));
	}
}
