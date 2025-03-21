package com.catalogo.esercizioCatalogo.repository;

import org.springframework.data.repository.CrudRepository;

import com.catalogo.esercizioCatalogo.model.Prodotto;

import java.util.List;

public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {
	List<Prodotto> findByNomeContaining(String nome);

	List<Prodotto> findByPrezzoLessThan(Float prezzo);

	List<Prodotto> findByNomeContainingAndPrezzoLessThan(String nome, Float prezzo);
}