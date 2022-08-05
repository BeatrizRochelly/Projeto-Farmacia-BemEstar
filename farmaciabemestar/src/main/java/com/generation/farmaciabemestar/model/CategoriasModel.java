package com.generation.farmaciabemestar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")
public class CategoriasModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O atributo categoria é Obrigatório!")
	private String nomecategoria;
	
	@OneToMany(mappedBy= "categoria" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutosModel> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}

	public List<ProdutosModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutosModel> produto) {
		this.produto = produto;
	}
	

	
	
}
