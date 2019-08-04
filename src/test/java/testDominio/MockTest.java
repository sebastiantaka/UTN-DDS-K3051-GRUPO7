package testDominio;

import api.climaClient.MockClient;
import dominio.Ciudad;
import dominio.Pais;
import dominio.Provincia;
import exceptions.APIClimaExeption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MockTest {
    private Ciudad ciudad;
    private MockClient mock;

    @Before
    public void init() {
        ciudad = new Ciudad(new Provincia(new Pais("Argentina"), "Buenos Aires"), "Ciudad De Buenos Aires", 3433955);
        mock = new MockClient(20.5);
    }

    @Test
    public void test_respuestaNoEsNull() throws APIClimaExeption {
        assertNotNull(mock.getTemperaturaEnC(ciudad));
    }

    @Test(expected = APIClimaExeption.class)
    public void test_respuestaFallaConNull() throws APIClimaExeption {
        mock.getTemperaturaEnC(null);
    }


}
