package com.catalogo.esercizioCatalogo.controller;

import com.catalogo.esercizioCatalogo.model.Utente;
import com.catalogo.esercizioCatalogo.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UtenteService utenteService;

    // Pagina di login
    @GetMapping("/login")
    public String paginaLogin() {
        return "paginaLogin";
    }

    // Gestione del login
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Utente utente = utenteService.login(username, password);
        if (utente != null) {
            session.setAttribute("utente", utente);
            return new ModelAndView("redirect:/homeInterna"); // Reindirizza alla home interna
        }
        return new ModelAndView("paginaLogin").addObject("messaggio", "Login fallito");
    }

    // Pagina home interna (solo per utenti loggati)
    @GetMapping("/homeInterna")
    public ModelAndView homeInterna(HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null && utente.isLogged()) {
            return new ModelAndView("homeInterna").addObject("utente", utente);
        } else {
            return new ModelAndView("redirect:/login"); // Reindirizza al login se l'utente non è loggato
        }
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null) {
            utenteService.logout(utente);
            session.invalidate();
        }
        return "redirect:/login";
    }
}