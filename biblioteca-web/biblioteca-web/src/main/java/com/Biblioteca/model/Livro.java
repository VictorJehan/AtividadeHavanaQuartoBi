package com.Biblioteca.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String autor;
    
    @Column(nullable = false, unique = true)
    private String isbn;
    
    @Column(nullable = false)
    private int anoPublicacao;
    
    @Column(nullable = false)
    private boolean disponivel = true;
    
    @Column(name = "numero_paginas")
    private int numeroPaginas;
    
    @Column(length = 50)
    private String categoria;
    
    @Column(length = 50)
    private String editora;
    
    @ManyToOne
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;
    
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    // Construtores
    public Livro() {}
    
    public Livro(String titulo, String autor, String isbn, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }
    
    public Livro(String titulo, String autor, String isbn, int anoPublicacao, 
                 int numeroPaginas, String categoria, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
        this.categoria = categoria;
        this.editora = editora;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    public boolean isDisponivel() {
        return disponivel;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        emprestimo.setLivro(this);
    }
}