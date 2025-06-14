package com.beesion.ms.service;

import java.util.List;

import com.beesion.ms.dto.Temperatura;

public interface ITemperaturaService {

    void addTemperatura(Temperatura t);

    List<Temperatura> obtenerTemperaturas();

    boolean isEmpty();

    int maxima();

}