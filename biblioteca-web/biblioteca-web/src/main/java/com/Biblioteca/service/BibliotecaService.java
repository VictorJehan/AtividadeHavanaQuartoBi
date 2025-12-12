package com.biblioteca.service;

import com.biblioteca.model.Biblioteca;
import com.biblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {
    
    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    
    public List<Biblioteca> listarTodas() {
        return bibliotecaRepository.findAll();
    }
    
    public Optional<Biblioteca> buscarPorId(Long id) {
        return bibliotecaRepository.findById(id);
    }
    
    public List<Biblioteca> buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return listarTodas();
        }
        return bibliotecaRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public List<Biblioteca> buscarPorEndereco(String endereco) {
        return bibliotecaRepository.findByEnderecoContainingIgnoreCase(endereco);
    }
    
    public Biblioteca salvar(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }
    
    public void deletar(Long id) {
        bibliotecaRepository.deleteById(id);
    }
    
    public boolean existe(Long id) {
        return bibliotecaRepository.existsById(id);
    }
}