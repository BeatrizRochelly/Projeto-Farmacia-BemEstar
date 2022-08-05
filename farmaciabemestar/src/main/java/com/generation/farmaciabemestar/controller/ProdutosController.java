package com.generation.farmaciabemestar.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmaciabemestar.model.ProdutosModel;
import com.generation.farmaciabemestar.repository.ProdutosRepository;

@RestController
@RequestMapping ("/produtos")
@CrossOrigin("*")
public class ProdutosController {

	@Autowired
	private ProdutosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutosModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}


	
	
}
