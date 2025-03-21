package com.catalogo.esercizioCatalogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.esercizioCatalogo.model.Utente;
import com.catalogo.esercizioCatalogo.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepository;

	public Utente login(String username, String password) {
		Utente utente = utenteRepository.findByUsername(username);
		if (utente != null && utente.getPassword().equals(password)) {
			utente.setLogged(true);
			return utente;
		}
		return null;
	}

	public void logout(Utente utente) {
		utente.setLogged(false);
	}

	public boolean registra(Utente utente) {
		if (utenteRepository.findByUsername(utente.getUsername()) != null) {
			return false; // Username già esistente
		}
		utenteRepository.save(utente);
		return true;
	}
}