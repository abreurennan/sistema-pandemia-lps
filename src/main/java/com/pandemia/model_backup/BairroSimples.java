package com.pandemia.model;

/**
 * Model Bairro - Estrutura básica
 * Primeira entrega - sem JPA ainda
 */
public class Bairro {
    
    private String nome;
    private String cidade;
    private String estado;
    
    public Bairro() {
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}