package com.catalogo.esercizioCatalogo.controller;

import com.catalogo.esercizioCatalogo.model.Ruolo;
import com.catalogo.esercizioCatalogo.model.Utente;
import com.catalogo.esercizioCatalogo.service.RuoloService;
import com.catalogo.esercizioCatalogo.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrazioneController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private RuoloService ruoloService; // Aggiungi il servizio per gestire i ruoli

    // Pagina di registrazione
    @GetMapping("/registrazione")
    public String paginaRegistrazione() {
        return "paginaRegistrazione";
    }

    // Gestione della registrazione
    @PostMapping("/registra")
    public ModelAndView registra(@RequestParam String username, @RequestParam String password) {
        // Trova il ruolo "user"
        Ruolo ruoloUser = ruoloService.trovaRuoloPerNome("user");
        if (ruoloUser == null) {
            return new ModelAndView("paginaRegistrazione").addObject("messaggio", "Errore durante la registrazione: ruolo non trovato.");
        }

        // Crea un nuovo utente e assegna il ruolo "user"
        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setPassword(password);
        utente.setLogged(false); // Imposta lo stato di login a false
        utente.setRuolo(ruoloUser); // Assegna il ruolo "user"

        boolean registrazioneSuccesso = utenteService.registra(utente);
        if (registrazioneSuccesso) {
            return new ModelAndView("paginaLogin").addObject("messaggio", "Registrazione completata. Effettua il login.");
        } else {
            return new ModelAndView("paginaRegistrazione").addObject("messaggio", "Username già esistente.");
        }
    }
}