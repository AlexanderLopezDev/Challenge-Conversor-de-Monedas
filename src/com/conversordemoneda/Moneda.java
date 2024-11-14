package com.conversordemoneda;

import java.util.Map;
import java.util.Set;

public record Moneda(String base_code,
                     Map<String, Double> conversion_rates) {

    public static final Set<String> MONEDAS_PERMITIDAS = Set.of(
            "USD", "EUR", "COP", "CLP", "BRL", "ARS"
    );

    public Moneda {
        try {
            if (!MONEDAS_PERMITIDAS.contains(base_code.toUpperCase())) {
                throw new IllegalArgumentException("com.conversordemoneda.modelo.Moneda no permitida: " + base_code);
            }
        } catch (IllegalArgumentException e) {
            System.out.print("************************************************************************");
        }
    }
}
