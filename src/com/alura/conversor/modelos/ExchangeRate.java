package com.alura.conversor.modelos;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.stream.Collectors;

public record ExchangeRate(@SerializedName("conversion_rates") Map<String, Double> conversionRates) {

    public Map<String, Double> getFilteredRates(String[] tasasCambio) {
        return conversionRates.entrySet().stream()
                .filter(entry -> java.util.Arrays.asList(tasasCambio).contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
