import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Solicitud {
    public void realizarSolicitud(String monedaBase, String monedaObjetivo, double monto) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/ec9be77f42db38584c6591c8/pair/"
                                    + monedaBase + "/" + monedaObjetivo))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();
            Moneda moneda = gson.fromJson(json, Moneda.class);

            Convertor convertor = new Convertor(moneda);
            convertor.setMonto(monto);
            convertor.hacerConversion();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la solicitud: " + e.getMessage());
        }

    }
}