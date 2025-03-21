package com.catalogo.esercizioCatalogo.service;

import com.catalogo.esercizioCatalogo.model.Ruolo;
import com.catalogo.esercizioCatalogo.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    // Trova un ruolo per nome
    public Ruolo trovaRuoloPerNome(String nome) {
        return ruoloRepository.findByNome(nome);
    }
}