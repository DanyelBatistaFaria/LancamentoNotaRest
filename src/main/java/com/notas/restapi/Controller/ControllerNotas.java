package com.notas.restapi.Controller;

import java.util.List;

import com.notas.restapi.DataBase.DataBaseNotas;
import com.notas.restapi.Entidade.ModeloNotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class ControllerNotas {

    @Autowired
    private DataBaseNotas database;

    @GetMapping
    public List<ModeloNotas> lista() {
        return database.findAll();

    }

    @PostMapping
    public void salvar(@RequestBody ModeloNotas notas) {
        notas.calculaMedia();
        notas.statusFinal();
        database.save(notas);

    }

    @PutMapping
    public void alterar(@RequestBody ModeloNotas notas) {
        if (notas.getId() > 0)
            database.save(notas);

    }

    @DeleteMapping
    public void excluir(@RequestBody ModeloNotas notas) {

        database.delete(notas);

    }

}
