package com.pandemia.model;

public class Caso {
    
    private String morador;
    private String situacao;
    private String data;
    
    public Caso() {
    }
    
    public String getMorador() {
        return morador;
    }
    
    public void setMorador(String morador) {
        this.morador = morador;
    }
    
    public String getSituacao() {
        return situacao;
    }
    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
}