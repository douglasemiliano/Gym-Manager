package com.gym.manager.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.manager.domain.model.Medidas;


public interface MedidasRepository extends JpaRepository<Medidas, Long>{
	
	
	Medidas findByPeso(Integer peso);
	Medidas findByAltura(Float altura);


}
