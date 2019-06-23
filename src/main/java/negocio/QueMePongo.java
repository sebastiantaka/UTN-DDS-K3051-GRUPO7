package negocio;

import java.util.Collection;

import dominio.Atuendo;
import dominio.Categoria;
import dominio.Color;
import dominio.Guardarropa;
import dominio.Prenda;
import dominio.TipoDePrenda;
import dominio.TipoDeTela;
import dominio.Usuario;

public class QueMePongo {

	public QueMePongo() {}

	public Collection<Atuendo> obtenerSugerencias(Guardarropa guardarropa) {
		return new GuardarropaHLP().obtenerSugerencias(guardarropa);
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa) {
		return new GuardarropaHLP().obtenerSugerencia(guardarropa);
	}
	
	public Usuario crearUsuario() {
		return new UsuarioHLP().crearUsuario();
	}
		
	public void adquirirGuardarropa(Usuario usuario) {
		new UsuarioHLP().adquirirGuardarropa(usuario, new Guardarropa());
	}
	
	public TipoDePrenda crearTipoDePrenda(String nombre, Categoria categoria, Collection<TipoDeTela>tiposDeTelaPermitidos) {
		return new TipoDePrendaHLP().crearTipoDePrenda(nombre, categoria, tiposDeTelaPermitidos);
	}
	
	public Prenda CrearPrendaDeDosColores(TipoDePrenda unTipoDePrenda, TipoDeTela unTipoDeTela, Color colorPrimario, Color colorSecundario) {
		return new PrendaHLP().crearPrenda(unTipoDePrenda, unTipoDeTela, colorPrimario, colorSecundario);
	}
}
