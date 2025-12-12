package com.Biblioteca.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("COMUM")
public class UsuarioComum extends Usuario {
    
    @Column(name = "limite_emprestimos")
    private int limiteEmprestimos = 3;
    
    @Column(name = "prazo_devolucao_dias")
    private int prazoDevolucaoDias = 14;
    
    @Column(name = "pode_renovar")
    private boolean podeRenovar = true;
    
    // Construtores
    public UsuarioComum() {
        super();
    }
    
    public UsuarioComum(String nome, String email) {
        super(nome, email);
    }
    
    public UsuarioComum(String nome, String email, int limiteEmprestimos) {
        super(nome, email);
        this.limiteEmprestimos = limiteEmprestimos;
    }
    
    public UsuarioComum(String nome, String email, int limiteEmprestimos, int prazoDevolucaoDias) {
        super(nome, email);
        this.limiteEmprestimos = limiteEmprestimos;
        this.prazoDevolucaoDias = prazoDevolucaoDias;
    }
    
    // Getters e Setters
    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }
    
    public void setLimiteEmprestimos(int limiteEmprestimos) {
        this.limiteEmprestimos = limiteEmprestimos;
    }
    
    public int getPrazoDevolucaoDias() {
        return prazoDevolucaoDias;
    }
    
    public void setPrazoDevolucaoDias(int prazoDevolucaoDias) {
        this.prazoDevolucaoDias = prazoDevolucaoDias;
    }
    
    public boolean isPodeRenovar() {
        return podeRenovar;
    }
    
    public void setPodeRenovar(boolean podeRenovar) {
        this.podeRenovar = podeRenovar;
    }
    
    @Override
    public String getTipoUsuario() {
        return "COMUM";
    }
    
    // Método para verificar se pode realizar mais empréstimos
    public boolean podeEmprestar() {
        return getEmprestimos().size() < limiteEmprestimos;
    }
}