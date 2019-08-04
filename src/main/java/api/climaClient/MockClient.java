package api.climaClient;

import dominio.Ciudad;
import exceptions.APIClimaExeption;

public class MockClient implements IClimaClient {

    private Double respuesta;

    public MockClient(Double respuesta){
        this.setRespuesta(respuesta);
    }

    @Override
    public Double getTemperaturaEnC(Ciudad ciudad) throws APIClimaExeption {
        return null;
    }

    public Double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Double respuesta) {
        this.respuesta = respuesta;
    }
}
