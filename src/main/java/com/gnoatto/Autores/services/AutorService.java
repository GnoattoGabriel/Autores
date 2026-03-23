package com.gnoatto.Autores.services;

import com.gnoatto.Autores.models.AutorModel;
import com.gnoatto.Autores.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorModel criarAutor(AutorModel novoAutor){
        return autorRepository.save(novoAutor);
    }

    public List<AutorModel> listarTodos(){
        return autorRepository.findAll();
    }

    public void deletarAutor(Long id){
        autorRepository.deleteById(id);
    }

    public Optional<AutorModel> buscarPorId(Long id){
        return autorRepository.findById(id);
    }

    public AutorModel atualizarAutor(Long id, AutorModel novoAutor){
        Optional<AutorModel> autorNobanco = autorRepository.findById(id);

        if(autorNobanco.isPresent()){
            AutorModel autorEditar = autorNobanco.get();

            autorEditar.setNome(novoAutor.getNome());
            autorEditar.setDataNascimento(novoAutor.getDataNascimento());
            autorEditar.setNacionalidade(novoAutor.getNacionalidade());

            return autorRepository.save(autorEditar);

        } else return null;

    }


}
