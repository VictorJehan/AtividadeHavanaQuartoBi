package com.Biblioteca.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gerentes")
public class Gerente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @Column(name = "data_contratacao")
    private String dataContratacao;
    
    @OneToMany(mappedBy = "gerente")
    private List<Biblioteca> bibliotecas = new ArrayList<>();
    
    // Construtores
    public Gerente() {}
    
    public Gerente(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    
    public Gerente(String nome, String email, String telefone, String cpf, String dataContratacao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataContratacao = dataContratacao;
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
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getDataContratacao() {
        return dataContratacao;
    }
    
    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    
    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }
    
    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }
    
    public void adicionarBiblioteca(Biblioteca biblioteca) {
        bibliotecas.add(biblioteca);
        biblioteca.setGerente(this);
    }
}