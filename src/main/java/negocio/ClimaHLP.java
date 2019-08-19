package negocio;

import api.climaClient.IClimaClient;
import api.climaClient.OpenWeatherClientAdapter;
import dominio.Ciudad;
import exceptions.APIClimaExeption;

public class ClimaHLP {

    public Double obtenerClimaActualEnC(Ciudad ciudad) throws APIClimaExeption {
        IClimaClient cliente = new OpenWeatherClientAdapter();
        return cliente.getTemperaturaEnC(ciudad);
    }
}
