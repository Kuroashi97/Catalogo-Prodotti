package com.catalogo.esercizioCatalogo.repository;

import org.springframework.data.repository.CrudRepository;

import com.catalogo.esercizioCatalogo.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
	Utente findByUsername(String username);
}