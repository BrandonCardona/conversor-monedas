package com.alura.conversor.modelos;

public class Conversor {

    private String monedaActual;
    private String monedaConvertir;

    public String getMonedaActual() {
        return monedaActual;
    }

    public String getMonedaConvertir() {
        return monedaConvertir;
    }

    public void asignarMonedas(int opcion){

        String[] monedas;

        switch (opcion) {
            case 1:
                monedas = new String[]{"USD", "ARS"};
                break;
            case 2:
                monedas = new String[]{"ARS", "USD"};
                break;
            case 3:
                monedas = new String[]{"USD", "BRL"};
                break;
            case 4:
                monedas = new String[]{"BRL", "USD"};
                break;
            case 5:
                monedas = new String[]{"USD", "COP"};
                break;
            case 6:
                monedas = new String[]{"COP", "USD"};
                break;
            default:
                monedas = new String[]{};
                break;
        }
        this.monedaActual = monedas[0];
        this.monedaConvertir = monedas[1];
    }

    public double convertirValor(double valorActual, double tasaCambio){
        return valorActual*tasaCambio;
    }

}
