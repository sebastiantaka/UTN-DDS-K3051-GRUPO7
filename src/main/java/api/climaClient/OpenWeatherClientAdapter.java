package api.climaClient;

import dominio.Ciudad;
import exceptions.APIClimaExeption;

public class OpenWeatherClientAdapter implements IClimaClient {

    @Override
    public Double getTemperaturaEnC(Ciudad ciudad) throws APIClimaExeption {
        OpenWeatherClient cliente = new OpenWeatherClient();
        Double temperatura = null;
        try {
            temperatura = cliente.getTemperaturaEnC(this.getCodigoDeCiudadOpenWeather(ciudad));
        }catch (Exception e){
            e.printStackTrace();
            throw new APIClimaExeption(e.getMessage());
        }
        return temperatura;
    }

    private Integer getCodigoDeCiudadOpenWeather(Ciudad ciudad) {
        return ciudad.getCodigoDeCiudadOpenWeather();
    }
}
