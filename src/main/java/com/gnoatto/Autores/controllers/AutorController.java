package com.gnoatto.Autores.controllers;


import com.gnoatto.Autores.models.AutorModel;
import com.gnoatto.Autores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @PostMapping
    public ResponseEntity<AutorModel> criarAutor(@RequestBody AutorModel novoAutor){
        AutorModel autor = autorService.criarAutor(novoAutor);
        return ResponseEntity.status(201).body(autor);
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> buscarTodos(){
        return ResponseEntity.ok(autorService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> buscarPorId(@PathVariable Long id){
        return autorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorModel> atualizarAutor(@PathVariable Long id,@RequestBody AutorModel autorNovo){
        AutorModel autor = autorService.atualizarAutor(id, autorNovo);
        return ResponseEntity.ok(autor);
    }

}
