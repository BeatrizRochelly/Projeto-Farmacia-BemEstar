package org.generation.farmaciabemestar.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.farmaciabemestar.model.CategoriaModel;
import org.generation.farmaciabemestar.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // criando uma classe do tipo rest, responsável por responder as requisicões http (get, push, post, delete)
@RequestMapping("/categorias") 
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired 
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id) {
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/categoria/{categoria}")
	public ResponseEntity<List<CategoriaModel>> getByName(@PathVariable String nomeCategoria) {
		return ResponseEntity.ok(categoriaRepository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@PostMapping 
	public ResponseEntity<CategoriaModel> post (@RequestBody @Valid CategoriaModel nomeCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(nomeCategoria));
		
	}
	
	@PutMapping 
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel tema) {
		return ResponseEntity.ok(categoriaRepository.save(tema));
		
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		
	}
	
}
