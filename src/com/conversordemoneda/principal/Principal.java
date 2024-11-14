package com.conversordemoneda.principal;

import com.conversordemoneda.modelos.ConsultaMoneda;
import com.conversordemoneda.modelos.FiltraMoneda;
import com.conversordemoneda.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        FiltraMoneda filtra = new FiltraMoneda();
        try {
            filtra.mostrarOpcionesDeMoneda("com.conversordemoneda.modelo.Moneda base");
            String MonedaCambio = lectura.nextLine().toUpperCase();
            Moneda mBase = filtra.consultaMonedaBase(MonedaCambio);
            if (!Moneda.MONEDAS_PERMITIDAS.contains(MonedaCambio)) {
                System.out.println("com.conversordemoneda.modelo.Moneda base no válida. Terminando programa...");
                return;
            }

            filtra.mostrarOpcionesDeMoneda("com.conversordemoneda.modelo.Moneda destino");
            String MonedaRecibir = lectura.nextLine().toUpperCase();
            Moneda mDestino = filtra.consultaMonedaDestino(MonedaRecibir);
            if (!Moneda.MONEDAS_PERMITIDAS.contains(MonedaRecibir)) {
                System.out.println("com.conversordemoneda.modelo.Moneda destino no válida. Terminando programa...");
                return;
            }

            System.out.println("Qué monto deseas calcular?");
            double ingresaMonto = Double.parseDouble(lectura.nextLine());
            double monto = filtra.montoCambio(ingresaMonto);

            Double tasaConversion = filtra.tasaDeConversion(mBase, MonedaRecibir);
            double calculoDeConversion = filtra.calculoDeConversion(monto, tasaConversion,mBase, MonedaRecibir);
        } catch (NumberFormatException e) {
            System.out.println("Error: Se esperaba un número.");
        }
        lectura.close();
    }
}
