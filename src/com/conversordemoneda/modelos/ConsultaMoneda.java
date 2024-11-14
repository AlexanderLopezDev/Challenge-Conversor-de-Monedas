package com.conversordemoneda.modelos;

import com.conversordemoneda.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscarMoneda (String MonedaCambio) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/d03d2a9715af461416ac20b3/latest/" + MonedaCambio))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("Error en consulta. Código HTTP: " + response.statusCode());
                throw new RuntimeException("Error al obtener los datos de la API. Código  HTTP: " + response.statusCode());
            }
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException e) {
            System.out.println("Error de conexión... Verifica tu conexión a internet.");
            throw new RuntimeException("IOException al intentar conectar con la API", e);
        } catch (InterruptedException e) {
            System.out.println("Consulta fue interrumpida inesperadamente.");
            throw new RuntimeException("InterruptedException al intentar consultar con la API", e);
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado.");
            throw new RuntimeException("Exception inesperado", e);
        }
    }
}
