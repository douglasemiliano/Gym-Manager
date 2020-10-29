package com.gym.manager.api.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gym.manager.domain.model.Cliente;
import com.gym.manager.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente addCliente(@Valid @RequestBody Cliente cliente) {
		cliente.setNome(cliente.getNome().trim());
		return this.clienteService.salvar(cliente);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		Optional<Cliente> cliente = this.clienteService.buscar(id);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/search={nome}")
	public ResponseEntity<List<Cliente>> procurar(@PathVariable String nome) {
		List<Cliente> cliente = this.clienteService.encontrar(nome);
		
		if (!cliente.isEmpty()) {
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("")
	public List<Cliente> listar(){
		return this.clienteService.listar();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		
		if(clienteService.clienteNaoExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		clienteService.salvar(cliente);
		
		return ResponseEntity.ok(cliente);	
		}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		if (clienteService.clienteNaoExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.clienteService.deletar(id);;
		
		return ResponseEntity.noContent().build();
	}

}
