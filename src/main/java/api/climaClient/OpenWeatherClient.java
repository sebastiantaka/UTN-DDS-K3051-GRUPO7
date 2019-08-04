package api.climaClient;

import org.json.JSONObject;
import utn.dds.HTTPClient;
import utn.dds.Request;
import utn.dds.Response;

import java.io.IOException;

public class OpenWeatherClient {
    private String APIKEY = "086885e0d049565663674732cd09eb43";

    public Double getTemperaturaEnC(Integer codigoDeCiudad) throws IOException {

        if (codigoDeCiudad == null){
            throw new NullPointerException();
        }
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "id=" + codigoDeCiudad +
                "&appid=" + this.APIKEY
                + "&units=metric";
        Response response = null;
        Request request = new Request(url);
        Double temperatura = null;
        response = request.execute(new HTTPClient());

        if (response.getStatusCode() == 200){
            JSONObject respuesta = new JSONObject(response.getContent());
            JSONObject main = respuesta.getJSONObject("main");
            temperatura = main.getDouble("temp");

        }
        return temperatura;
    }
}
