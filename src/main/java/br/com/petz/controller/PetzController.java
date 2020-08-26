package br.com.petz.controller;

import java.util.List;

import javax.management.relation.RoleInfoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.model.Retorno;
import br.com.petz.service.PetzService;

@RestController
@RequestMapping("/api/petz")
public class PetzController {

	@Autowired
	private PetzService petzService;

	@PostMapping("/create/cliente")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(petzService.createCliente(cliente), HttpStatus.OK);
	}

	@PostMapping("/create/pet")
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
		return new ResponseEntity<>(petzService.createPet(pet), HttpStatus.OK);
	}

	@GetMapping("/retrieve/cliente")
	public ResponseEntity<List<Cliente>> listandoCliente() {
		return new ResponseEntity<>(petzService.retrieveCliente(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/retrieve/pet")
	public ResponseEntity<List<Pet>> listandoPet() {
		return new ResponseEntity<>(petzService.retrievePet(), new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/update/cliente/{id}")
	public ResponseEntity<Retorno> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {

		petzService.updateClienteById(id, cliente);

		return ResponseEntity.ok(petzService.updateClienteById(id, cliente));

	}

	@PutMapping("/update/pet/{id}")
	public ResponseEntity<Retorno> updatePet(@PathVariable("id") long id, @RequestBody Pet pet) {

		petzService.updatePetById(id, pet);

		return ResponseEntity.ok(petzService.updatePetById(id, pet));
	}

	@DeleteMapping("/delete/cliente")
	public ResponseEntity<HttpStatus> deleteClienteById(@RequestParam long id) throws RoleInfoNotFoundException {

		petzService.deleteClienteById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/pet")
	public ResponseEntity<HttpStatus> deletePetById(@RequestParam long id) throws RoleInfoNotFoundException {

		petzService.deletePetById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}