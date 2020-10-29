package com.gym.manager.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.manager.domain.model.Cliente;
import com.gym.manager.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Cliente salvar (Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	
	public Optional<Cliente> buscar(Long id){
		return this.clienteRepository.findById(id);

	}


	public List<Cliente> listar() {
		return this.clienteRepository.findAll();
	}
	
	public Boolean clienteExiste(Long id) {
		return this.clienteRepository.existsById(id);
	}
	
	public Boolean clienteNaoExiste(Long id) {
		return (!this.clienteRepository.existsById(id));
	}
	
	public void deletar(Long id) {
		this.clienteRepository.deleteById(id);
	}
	
	public List<Cliente> encontrar(String nome) {
		return this.clienteRepository.findByNomeContaining(nome);
	}

}
