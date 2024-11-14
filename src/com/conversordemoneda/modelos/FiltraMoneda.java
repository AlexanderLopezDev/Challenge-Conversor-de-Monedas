package com.conversordemoneda.modelos;

import com.conversordemoneda.Moneda;

public class FiltraMoneda {
    private ConsultaMoneda consulta = new ConsultaMoneda();

    public Moneda consultaMonedaBase(String monedaBase) {
        Moneda resultado = consulta.buscarMoneda(monedaBase);
        if (resultado == null ) {
            System.out.println("No se encontró información para la moneda base: " + monedaBase);
        } else {
            System.out.println("Moneda base seleccionada: " + resultado.base_code());
        }
        return resultado;
    }
    public Moneda consultaMonedaDestino(String monedaDestino) {
        Moneda resultado = consulta.buscarMoneda(monedaDestino);
        if (resultado == null) {
            System.out.println("No se encontró información para la moneda destino: " + monedaDestino);
        } else {
            System.out.println("Moneda destino seleccionada: " + resultado.base_code());
        }
        return resultado;
    }
    public double montoCambio(double monto) {
        return monto;
    }
    public Double tasaDeConversion(Moneda monedaBase, String monedaDestino) {
        try {
            if (monedaBase == null) {
                System.out.println("Error: la moneda base no es valida.");
                return null;
            }
            if (monedaBase.conversion_rates() == null) {
                System.out.println("Error: tasa de la moneda no encontrada.");
                return null;
            }
            Double tasa = monedaBase.conversion_rates().get(monedaDestino);
            if (tasa == null) {
                System.out.println("************************************************************************");
                System.out.println("No se encontró la tasa de conversión de " + monedaBase.base_code() + " a " + monedaDestino);
                return null;
            }
            System.out.println("************************************************************************");
            System.out.println("Tasa de conversión: 1 " + monedaBase.base_code() + " = " + tasa + " " + monedaDestino);
            return tasa;
        } catch (NullPointerException e) {
            System.out.println("Error inesperado. No haz utilizado una moneda valida o tasa de conversión no encontrada.");
            return null;
        }
    }
    public double calculoDeConversion (double monto, Double tasa, Moneda monedaBase, String monedaDestino) {
        double conversionFinal = monto * tasa;
        System.out.println("Monto calculado: " + monto + " " + monedaBase.base_code() + " = " + conversionFinal + " " + monedaDestino);
        System.out.println("************************************************************************");
        return conversionFinal;
    }

    public void mostrarOpcionesDeMoneda(String tipoMoneda) {
        System.out.println("************************************************************************");
        System.out.println("Escribe " + tipoMoneda + " (por ejemplo, USD, EUR, COP, CLP, BRL, BOB, ARS): ");
        System.out.println("************************************************************************");
    }

    public class CurrencyNotFoundException extends Exception {
        public CurrencyNotFoundException(String mensaje) {
            super(mensaje);
        }
    }
}
