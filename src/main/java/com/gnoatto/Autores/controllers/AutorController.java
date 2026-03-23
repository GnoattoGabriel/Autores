package com.gnoatto.Autores.controllers;


import com.gnoatto.Autores.models.AutorModel;
import com.gnoatto.Autores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @PostMapping
    public AutorModel criarAutor(@RequestBody AutorModel novoAutor){
        return autorService.criarAutor(novoAutor);
    }

    @GetMapping
    public List<AutorModel> buscarTodos(){
        return autorService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
    }

    @GetMapping("/{id}")
    public Optional<AutorModel> buscarPorId(@PathVariable Long id){
        return autorService.buscarPorId(id);
    }


    public AutorModel atualizarAutor(@PathVariable Long id,@RequestBody AutorModel autorNovo){
        return autorService.atualizarAutor(id, autorNovo);
    }

}
