package com.pandemia.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entidade Bairro - Sistema Pandemia
 * Padrão MVC + JPA/Hibernate
 */
@Entity
@Table(name = "bairros")
public class Bairro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @NotBlank(message = "Código é obrigatório")
    @Size(min = 2, max = 20)
    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;
    
    @Column(name = "latitude")
    private Double latitude;
    
    @Column(name = "longitude") 
    private Double longitude;
    
    @Size(max = 500)
    @Column(name = "descricao", length = 500)
    private String descricao;
    
    @Column(name = "ativo")
    private Boolean ativo;
    
    // Construtores
    public Bairro() {
        this.ativo = true;
    }
    
    public Bairro(String nome, String codigo) {
        this();
        this.nome = nome;
        this.codigo = codigo;
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
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    public Double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Boolean getAtivo() {
        return ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public String toString() {
        return String.format("Bairro{nome='%s', codigo='%s'}", nome, codigo);
    }
}