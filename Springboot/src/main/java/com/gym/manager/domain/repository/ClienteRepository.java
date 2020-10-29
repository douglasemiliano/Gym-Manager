package com.gym.manager.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.manager.domain.model.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNome (String nome);
	List<Cliente> findByNomeContaining (String nome);
	Cliente findByEmail(String email);

}
