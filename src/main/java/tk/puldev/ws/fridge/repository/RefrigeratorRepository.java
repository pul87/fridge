package tk.puldev.ws.fridge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tk.puldev.ws.fridge.model.Refrigerator;

@Repository
public interface RefrigeratorRepository extends CrudRepository<Refrigerator, Long>{

}
