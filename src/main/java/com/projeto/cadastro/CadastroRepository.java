package com.projeto.cadastro;

import org.springframework.data.repository.CrudRepository;
import com.projeto.cadastro.model.Cadastro;


public interface CadastroRepository extends CrudRepository<Cadastro, String>{
	Cadastro findByCodigo(long codigo);
}
