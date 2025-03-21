package com.catalogo.esercizioCatalogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.esercizioCatalogo.model.Prodotto;
import com.catalogo.esercizioCatalogo.repository.ProdottoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;

    // Trova tutti i prodotti
    public List<Prodotto> trovaTuttiProdotti() {
        return (List<Prodotto>) prodottoRepository.findAll();
    }

    // Ricerca prodotti per nome e/o prezzo
    public List<Prodotto> ricercaProdotti(String nome, Float prezzo) {
        if (nome != null && prezzo != null) {
            return prodottoRepository.findByNomeContainingAndPrezzoLessThan(nome, prezzo);
        } else if (nome != null) {
            return prodottoRepository.findByNomeContaining(nome);
        } else if (prezzo != null) {
            return prodottoRepository.findByPrezzoLessThan(prezzo);
        }
        return trovaTuttiProdotti();
    }

    // Trova un prodotto per ID
    public Prodotto trovaProdottoPerId(Long id) {
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        return prodotto.orElse(null); // Restituisce null se il prodotto non è trovato
    }

    // Crea un nuovo prodotto
    public Prodotto creaProdotto(Prodotto prodotto) {
        return prodottoRepository.save(prodotto);
    }

    // Aggiorna un prodotto esistente
    public Prodotto aggiornaProdotto(Long id, Prodotto prodotto) {
        Prodotto prodottoEsistente = trovaProdottoPerId(id);
        if (prodottoEsistente != null) {
            prodottoEsistente.setNome(prodotto.getNome());
            prodottoEsistente.setPrezzo(prodotto.getPrezzo());
            return prodottoRepository.save(prodottoEsistente);
        }
        return null; // Restituisce null se il prodotto non è trovato
    }

    // Cancella un prodotto per ID
    public void cancellaProdotto(Long id) {
        prodottoRepository.deleteById(id);
    }
}