package org.generation.farmaciabemestar.repository;

import java.math.BigDecimal;
import java.util.List;

import org.generation.farmaciabemestar.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoModel, Long>{

	public List<ProdutoModel> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
	
	public List<ProdutoModel> findAllByPrecoBetween(@Param ("inicio") BigDecimal inicio, @Param ("fim") BigDecimal fim);
}
