package com.projeto.cadastro;

import org.springframework.data.repository.CrudRepository;

import com.projeto.cadastro.model.Telefones;

public interface TelefoneRepository extends CrudRepository<Telefones, String>{

}
