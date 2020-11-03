package com.gym.manager.domain.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.manager.domain.model.Medidas;
import com.gym.manager.domain.repository.MedidasRepository;

@Service
public class MedidasService {
	
	@Autowired
	private MedidasRepository medidasRepository;

	
	public Float calcularImc(Float altura, Float peso) {
		Float imc = ((peso*10000)/(altura*altura));
		return imc;
	}
	
	
	public Medidas salvar(Medidas medidas) {
		medidas.setData(LocalDateTime.now());
		return this.medidasRepository.save(medidas);
	}


	public Optional<Medidas> buscar(Long id) {
		return this.medidasRepository.findById(id);
	}


	public List<Medidas> listar() {
		return this.medidasRepository.findAll();
	}
	
	public Boolean medidasExiste(Long id) {
		return this.medidasRepository.existsById(id);
	}
	
	public Boolean medidasNaoExiste(Long id) {
		return (!this.medidasRepository.existsById(id));
	}


	public void deletar(Long id) {
		this.medidasRepository.deleteById(id);
		
	}
	
}

