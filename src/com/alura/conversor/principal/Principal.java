package com.alura.conversor.principal;

import com.alura.conversor.modelos.Conversor;
import com.alura.conversor.modelos.ExchangeRate;
import com.alura.conversor.peticiones.GestorPeticiones;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        final String[] MONEDAS_NECESARIAS = {"ARS", "BRL", "COP", "USD"};
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(true){
            System.out.println("*********************************************************************\n" +
                    "BIENVENIDO AL CONVERSOR DE MONEDAS\n" +
                    "1) Dólar >>> Peso Argentino\n" +
                    "2) Peso Argentino >>> Dólar\n" +
                    "3) Dólar >>> Real Brasileño\n" +
                    "4) Real Brasileño >>> Dólar\n" +
                    "5) Dólar >>> Peso Colombiano\n" +
                    "6) Peso Colombiano >>> Dólar\n" +
                    "7) Salir\n" +
                    "Eliga una opcion valida\n" +
                    "*********************************************************************\n");

            try{
                int opcion = lectura.nextInt();

                if(opcion == 7){
                    break;
                }

                System.out.println("Ingresa el valor a convertir");
                double valor = lectura.nextDouble();

                Conversor conversor = new Conversor();
                conversor.asignarMonedas(opcion);

                String direccion = "https://v6.exchangerate-api.com/v6/a012ae51f5e93292bcc4bde2/latest/"+ conversor.getMonedaActual();

                HttpClient client = GestorPeticiones.crearCliente();
                HttpRequest request = GestorPeticiones.crearRequest(direccion);
                HttpResponse<String> response = GestorPeticiones.crearResponse(client, request);

                ExchangeRate exchangeRate = gson.fromJson(response.body(), ExchangeRate.class);

                Map<String, Double> tasasFiltradas = exchangeRate.getFilteredRates(MONEDAS_NECESARIAS);

                double valorConvertido = conversor.convertirValor(valor, tasasFiltradas.get(conversor.getMonedaConvertir()));

                DecimalFormat formato = new DecimalFormat("#.##");
                System.out.println("El valor " + formato.format(valor) + " [" + conversor.getMonedaActual() + "]"
                + " corresponde al valor final de " + formato.format(valorConvertido) + " [" + conversor.getMonedaConvertir() + "]");


            } catch(IllegalArgumentException e){
                System.out.println("Error en la URI, verifique la dirección.");
            }catch (IOException | InterruptedException e){
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("Ingresa un numero valido");
                lectura.nextLine();
            }
        }


    }

}
