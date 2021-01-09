package com.bojukafinancial.controller;

import java.math.BigDecimal;

//--------------------------------------------------------------
//Used in a previous version, will still be used in the future
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
//--------------------------------------------------------------

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bojukafinancial.Client;
import com.bojukafinancial.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientBillingFinancial {
	
	private final ClientRepository repository;
	
	ClientBillingFinancial(ClientRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	List<Client> all(){
		return repository.findAll();
	}
	
	@PostMapping
	Client newClient(@RequestBody Client newClient) {
		return repository.save(newClient);
	}
	
	@GetMapping("/{id}")
	Client singleClient(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
	}
	
	@PutMapping("/{id}")
	Client updateClient(@RequestBody Client newClient, @PathVariable Long id) {
		return repository.findById(id)
				.map(client -> {
					client.setName(newClient.getName());
					client.setAmountDue(newClient.getAmountDue());
					return repository.save(client);
				})
				.orElseGet(() -> { 
						newClient.setId(id);
						return repository.save(newClient);
				});
	}
	
	@DeleteMapping("/{id}")
	void deleteClient(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
