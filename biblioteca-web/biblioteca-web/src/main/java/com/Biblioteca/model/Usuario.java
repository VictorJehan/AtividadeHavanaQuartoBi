package com.Biblioteca.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    // Construtores
    public Usuario() {}
    
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        emprestimo.setUsuario(this);
    }
    
    // Método abstrato para obter o tipo de usuário
    public abstract String getTipoUsuario();
}