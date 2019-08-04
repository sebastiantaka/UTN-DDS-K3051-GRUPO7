package testDominio;

import api.climaClient.OpenWeatherClient;
import api.climaClient.OpenWeatherClientAdapter;
import dominio.Ciudad;
import dominio.Pais;
import dominio.Provincia;
import exceptions.APIClimaExeption;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OpenWeatherClientTest {

    private OpenWeatherClient clienteDirecto;
    private OpenWeatherClientAdapter clienteAdapter;
    private Ciudad ciudad;

    @Before
    public void init() {
        clienteAdapter = new OpenWeatherClientAdapter();
        clienteDirecto = new OpenWeatherClient();
        ciudad = new Ciudad(new Provincia(new Pais("Argentina"), "Buenos Aires"), "Ciudad De Buenos Aires", 3433955);
    }

    @Test
    public void test_cienteDirectoRespondeAlgo() throws IOException {
        Double respuesta = clienteDirecto.getTemperaturaEnC(1);
        assertNotNull(respuesta);
    }

    @Test
    public void test_cienteAdapterRespondeAlgo() throws APIClimaExeption {
        Double respuesta = clienteAdapter.getTemperaturaEnC(ciudad);
        assertNotNull(respuesta);
    }

}
