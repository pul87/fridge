package tk.puldev.ws.fridge.service;

import java.util.Collection;

import tk.puldev.ws.fridge.model.Refrigerator;

public interface RefrigeratorService {

	public Collection<Refrigerator> findAll();
	public Refrigerator findById(Long id);
	public Refrigerator createRefrigerator(Refrigerator refrigerator);
}
