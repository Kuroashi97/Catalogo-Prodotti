package com.catalogo.esercizioCatalogo.repository;

import org.springframework.data.repository.CrudRepository;

import com.catalogo.esercizioCatalogo.model.Ruolo;

public interface RuoloRepository extends CrudRepository<Ruolo, Long> {
	Ruolo findByNome(String nome);
}