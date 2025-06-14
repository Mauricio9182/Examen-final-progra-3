package com.beesion.ms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.beesion.ms.dto.Temperatura;


import com.beesion.ms.service.ITemperaturaService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TemperaturaService implements ITemperaturaService {

	private List<Temperatura> valores = new ArrayList<>();

	@Override
	public void addTemperatura(Temperatura t) {
		valores.add(t);
	}

	@Override
	public List<Temperatura> obtenerTemperaturas() {
		return Collections.unmodifiableList(valores);
	}

	@Override
	public int maxima() {
		return valores.stream().mapToInt(Temperatura::getMaxima).max().orElseThrow(() ->
				new IllegalStateException("No hay temperaturas registradas"));
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return valores.isEmpty();
	}

}
