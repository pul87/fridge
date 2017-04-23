package tk.puldev.ws.fridge.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.puldev.ws.fridge.model.Refrigerator;
import tk.puldev.ws.fridge.service.RefrigeratorService;

@RestController
@RequestMapping("/api")
public class RefrigeratorController extends BaseController {
	
	@Autowired
	private RefrigeratorService fridgeService;
	
	@GetMapping(value="/refrigerators", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Refrigerator>> getRefrigerators() {
		Collection<Refrigerator> refrigerators = fridgeService.findAll();
		
		return new ResponseEntity<Collection<Refrigerator>>(refrigerators, HttpStatus.OK);
	}
	
	@GetMapping(value="/refrigerators/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Refrigerator> getRefrigerator(@PathVariable("id") Long id) {
		Refrigerator refrigerator = fridgeService.findById(id);
		return new ResponseEntity<Refrigerator>(refrigerator, HttpStatus.OK);
	}
	
	@PostMapping(value="/refrigerators", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Refrigerator> createRefrigerator(@RequestBody Refrigerator refrigerator) {
		
		logger.info("Questo è quello che arriva", refrigerator);
		
		Refrigerator newRefrigerator = fridgeService.createRefrigerator(refrigerator);
		
		return new ResponseEntity<Refrigerator>(newRefrigerator, HttpStatus.OK);
	}
}
