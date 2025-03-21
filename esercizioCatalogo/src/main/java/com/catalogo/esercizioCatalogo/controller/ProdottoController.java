package com.catalogo.esercizioCatalogo.controller;

import com.catalogo.esercizioCatalogo.model.Prodotto;
import com.catalogo.esercizioCatalogo.model.Utente;
import com.catalogo.esercizioCatalogo.service.ProdottoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    // Pagina di ricerca prodotti (accessibile a tutti)
    @GetMapping("/ricercaProdotti")
    public String ricercaProdotti() {
        return "ricercaProdotti";
    }

    // Ricerca prodotti (accessibile a tutti)
    @PostMapping("/ricercaProdotti")
    public ModelAndView ricerca(@RequestParam(required = false) String nome, @RequestParam(required = false) Float prezzo) {
        List<Prodotto> prodotti = prodottoService.ricercaProdotti(nome, prezzo);
        return new ModelAndView("risultatiRicerca").addObject("prodotti", prodotti);
    }

    // Pagina di creazione prodotto (solo per admin)
    @GetMapping("/creaProdotto")
    public ModelAndView paginaCreaProdotto(HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null && "admin".equals(utente.getRuolo().getNome())) {
            return new ModelAndView("creaProdotto");
        } else {
            return new ModelAndView("redirect:/homeInterna").addObject("messaggio", "Accesso negato: solo gli admin possono creare prodotti.");
        }
    }

    // Creazione prodotto (solo per admin)
    @PostMapping("/creaProdotto")
    public ModelAndView creaProdotto(@RequestParam String nome, @RequestParam Float prezzo, HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null && "admin".equals(utente.getRuolo().getNome())) {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(nome);
            prodotto.setPrezzo(prezzo);
            prodottoService.creaProdotto(prodotto);
            return new ModelAndView("esito").addObject("messaggio", "Prodotto creato con successo");
        } else {
            return new ModelAndView("redirect:/homeInterna").addObject("messaggio", "Accesso negato: solo gli admin possono creare prodotti.");
        }
    }

    // Pagina di modifica prodotto (solo per admin)
    @GetMapping("/modificaProdotto/{id}")
    public ModelAndView paginaModificaProdotto(@PathVariable Long id, HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null && "admin".equals(utente.getRuolo().getNome())) {
            Prodotto prodotto = prodottoService.trovaProdottoPerId(id);
            if (prodotto != null) {
                return new ModelAndView("modificaProdotto").addObject("prodotto", prodotto);
            } else {
                return new ModelAndView("esito").addObject("messaggio", "Prodotto non trovato");
            }
        } else {
            return new ModelAndView("redirect:/homeInterna").addObject("messaggio", "Accesso negato: solo gli admin possono modificare prodotti.");
        }
    }

    // Modifica prodotto (solo per admin)
    @PostMapping("/modificaProdotto/{id}")
    public ModelAndView modificaProdotto(@PathVariable Long id, @RequestParam String nome, @RequestParam Float prezzo, HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null && "admin".equals(utente.getRuolo().getNome())) {
            Prodotto prodotto = prodottoService.trovaProdottoPerId(id);
            if (prodotto != null) {
                prodotto.setNome(nome);
                prodotto.setPrezzo(prezzo);
                prodottoService.aggiornaProdotto(id, prodotto);
                return new ModelAndView("esito").addObject("messaggio", "Prodotto modificato con successo");
            } else {
                return new ModelAndView("esito").addObject("messaggio", "Prodotto non trovato");
            }
        } else {
            return new ModelAndView("redirect:/homeInterna").addObject("messaggio", "Accesso negato: solo gli admin possono modificare prodotti.");
        }
    }

    // Cancellazione prodotto (solo per admin)
    @GetMapping("/cancellaProdotto/{id}")
    public ModelAndView cancellaProdotto(@PathVariable Long id, HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null && "admin".equals(utente.getRuolo().getNome())) {
            Prodotto prodotto = prodottoService.trovaProdottoPerId(id);
            if (prodotto != null) {
                prodottoService.cancellaProdotto(id);
                return new ModelAndView("esito").addObject("messaggio", "Prodotto cancellato con successo");
            } else {
                return new ModelAndView("esito").addObject("messaggio", "Prodotto non trovato");
            }
        } else {
            return new ModelAndView("redirect:/homeInterna").addObject("messaggio", "Accesso negato: solo gli admin possono cancellare prodotti.");
        }
    }
}