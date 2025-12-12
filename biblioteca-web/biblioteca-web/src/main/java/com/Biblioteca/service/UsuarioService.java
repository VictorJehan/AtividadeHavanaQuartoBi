package com.biblioteca.service;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public List<Usuario> buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return listarTodos();
        }
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public boolean emailJaExiste(String email) {
        return usuarioRepository.existsByEmail(email);
    }
    
    public boolean emailJaExisteParaOutroUsuario(String email, Long id) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.isPresent() && !usuario.get().getId().equals(id);
    }
}