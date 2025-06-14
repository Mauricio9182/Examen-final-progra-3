package com.beesion.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FibonacciService {

    public List<Integer> generateFibonacci(int[] signature, int n) {
        List<Integer> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        // Validación básica
        if (signature == null || signature.length != 2) {
            throw new IllegalArgumentException("La firma debe tener exactamente dos elementos.");
        }

        // Agrega los primeros elementos de la firma (máximo n)
        for (int i = 0; i < Math.min(2, n); i++) {
            result.add(signature[i]);
        }

        // Genera el resto de la secuencia
        for (int i = 2; i < n; i++) {
            int next = result.get(i - 1) + result.get(i - 2);
            result.add(next);
        }

        return result;
    }
}
