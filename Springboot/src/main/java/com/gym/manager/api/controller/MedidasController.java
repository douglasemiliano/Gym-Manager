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

import com.gym.manager.domain.model.Medidas;
import com.gym.manager.domain.service.MedidasService;

@RestController
@RequestMapping("/medidas")
public class MedidasController {
	
	@Autowired
	private MedidasService medidasService;
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medidas addMedidas(@Valid @RequestBody Medidas medidas) {
		return this.medidasService.salvar(medidas);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Medidas> buscarPorId(@PathVariable Long id) {
		Optional<Medidas> medidas = this.medidasService.buscar(id);
		
		if (medidas.isPresent()) {
			return ResponseEntity.ok(medidas.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	

	
	@GetMapping("")
	public List<Medidas> listar(){
		return this.medidasService.listar();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Medidas> atualizar(@Valid @PathVariable Long id, @RequestBody Medidas medidas) {
		
		if(medidasService.medidasNaoExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		
		medidas.setId(id);
		medidasService.salvar(medidas);
		
		return ResponseEntity.ok(medidas);	
		}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		if (medidasService.medidasNaoExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.medidasService.deletar(id);;
		
		return ResponseEntity.noContent().build();
	}
	
}
