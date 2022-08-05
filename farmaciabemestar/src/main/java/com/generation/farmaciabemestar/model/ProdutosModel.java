package com.generation.farmaciabemestar.model;

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class ProdutosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O nome é Obrigatório!")
	private String nomeproduto;
	
    @Positive(message = "Digite um valor maior do que zero")
    private BigDecimal valor;
	
	@NotNull(message = "A descrição é Obrigatória")
    @Size(min = 10, max = 1000, message = "O atributo descricao deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String descricao;
	
	@NotNull(message = "O atributo marca é Obrigatório")
	private String marca;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriasModel categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public CategoriasModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriasModel categoria) {
		this.categoria = categoria;
	}

	
	
}
