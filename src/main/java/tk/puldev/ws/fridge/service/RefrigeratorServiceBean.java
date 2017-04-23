package tk.puldev.ws.fridge.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.puldev.ws.fridge.model.Refrigerator;
import tk.puldev.ws.fridge.repository.RefrigeratorRepository;

@Service
public class RefrigeratorServiceBean implements RefrigeratorService {

	@Autowired
	private RefrigeratorRepository fridgeRepository;
	
	@Override
	public Collection<Refrigerator> findAll() {
		return (Collection<Refrigerator>) fridgeRepository.findAll();
	}

	@Override
	public Refrigerator createRefrigerator(Refrigerator refrigerator) {
		return fridgeRepository.save(refrigerator);
	}

	@Override
	public Refrigerator findById(Long id) {
		return fridgeRepository.findOne(id);
	}

}
