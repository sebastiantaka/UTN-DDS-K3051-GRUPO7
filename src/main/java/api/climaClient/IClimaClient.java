package api.climaClient;

import dominio.Ciudad;
import exceptions.APIClimaExeption;

public interface IClimaClient {
	
	public Double getTemperaturaEnC(Ciudad ciudad) throws APIClimaExeption;
	
}
