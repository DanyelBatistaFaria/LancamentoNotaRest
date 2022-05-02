package com.notas.restapi.DataBase;

import com.notas.restapi.Entidade.ModeloNotas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseNotas extends JpaRepository<ModeloNotas, Long> {

}
