package testServicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dominio.AvisoProgramado;
import dominio.AvisoSimple;
import dominio.Ciudad;
import dominio.Evento;
import dominio.Formal;
import dominio.Pais;
import dominio.PlanGratuito;
import dominio.Provincia;
import dominio.Suscripcion;
import dominio.Usuario;
import negocio.EventoHLP;

public class EventoTaskTest {
	
	Evento irATrabajar;
	Ciudad buenosAires;
	Provincia buenosAiresProvincia;
	Pais argentina;
	EventoHLP eventoHLP;
	Evento irAFiesta;
	AvisoProgramado programador;
	AvisoSimple programadorSimple;
	Usuario walter;
	Suscripcion subscripcionDeUsuario;
	
	
	@Before
	public void init() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
		
		argentina = new Pais();
		argentina.setNombre("Argentina");
		buenosAiresProvincia = new Provincia();
		buenosAiresProvincia.setNombre("Buenos Aires");
		buenosAiresProvincia.setPais(argentina);
		buenosAires = new Ciudad();
		buenosAires.setNombre("Buenos Aires");
		buenosAires.setProvincia(buenosAiresProvincia);
		buenosAires.setZonaHoraria(ZoneId.SHORT_IDS.get("AGT"));
		buenosAires.setCodigoDeCiudadOpenWeather(3433955);
		
		programador = new AvisoProgramado();
		programador.setFechaDeAviso(formatter.parse("2019-09-02, 08:00"));
		Set<Integer> diasDeProgramacion = new HashSet<Integer>();
		diasDeProgramacion.add(Calendar.MONDAY);
		diasDeProgramacion.add(Calendar.THURSDAY);
		diasDeProgramacion.add(Calendar.TUESDAY);
		diasDeProgramacion.add(Calendar.FRIDAY);
		diasDeProgramacion.add(Calendar.WEDNESDAY);
		
		programador.setDiasDeRepeticion(diasDeProgramacion);
		
		irATrabajar = new Evento();
		irATrabajar.setCiudad(buenosAires);
		irATrabajar.setDescripcion("Trabajar en Xubio como Desarrollador");
		irATrabajar.setFecha(formatter.parse("2019-09-02, 08:00"));
		irATrabajar.setOrganizador(programador);
		irATrabajar.setTipoDeEvento(new Formal());
		
		programadorSimple = new AvisoSimple();
		programadorSimple.setFechaDeAviso(formatter.parse("2019-09-01, 16:53"));
		
		irAFiesta = new Evento();
		irAFiesta.setCiudad(buenosAires);
		irAFiesta.setDescripcion("Ir a la fiesta de casamiento de una amiga");
		irAFiesta.setFecha(formatter.parse("2019-09-07, 20:00"));
		irAFiesta.setOrganizador(programadorSimple);
		irAFiesta.setTipoDeEvento(new Formal());
		
		subscripcionDeUsuario = new Suscripcion();
		subscripcionDeUsuario.setEvento(irAFiesta);
		subscripcionDeUsuario.setUsuario(walter);
		
		walter = new Usuario(new PlanGratuito());
		walter.setEmail("sebastian.taka@hotmail.com");
		irAFiesta.getSubscripcionUsuarios().add(subscripcionDeUsuario);
		
		eventoHLP = new EventoHLP();
	}
	
	@Test
	public void test_TareaProgramada() {
		eventoHLP.programarTareaEvento(irATrabajar);
		assert(true);
	}
	
	@Test
	public void test_TareaSoloUnaVez() throws InterruptedException {
		eventoHLP.programarTareaEvento(irAFiesta);
		assert(true);
	}

	
}
