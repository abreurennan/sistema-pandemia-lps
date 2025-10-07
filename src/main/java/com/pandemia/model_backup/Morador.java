package com.pandemia.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

/**
 * Entidade Morador - Sistema Pandemia
 * Padrão MVC + JPA/Hibernate
 */
@Entity
@Table(name = "moradores")
public class Morador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 150)
    @Column(name = "nome", nullable = false, length = 150)
    private String nome;
    
    @NotBlank(message = "CPF é obrigatório")
    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    private String cpf;
    
    @Past(message = "Data de nascimento deve ser no passado")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Email(message = "Email deve ter um formato válido")
    @Column(name = "email", length = 100)
    private String email;
    
    @Column(name = "telefone", length = 15)
    private String telefone;
    
    @NotBlank(message = "Endereço é obrigatório")
    @Size(min = 5, max = 200)
    @Column(name = "endereco", nullable = false, length = 200)
    private String endereco;
    
    @NotBlank(message = "CEP é obrigatório")
    @Column(name = "cep", nullable = false, length = 9)
    private String cep;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;
    private Boolean ativo;
    private Bairro bairro;
    
    // Enum para Sexo
    public enum Sexo {
        MASCULINO("Masculino"),
        FEMININO("Feminino"),
        OUTROS("Outros");
        
        private final String descricao;
        
        Sexo(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    // Construtores
    public Morador() {
        this.ativo = true;
    }
    
    public Morador(String nome, String cpf) {
        this();
        this.nome = nome;
        this.cpf = cpf;
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
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public Sexo getSexo() {
        return sexo;
    }
    
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public Boolean getAtivo() {
        return ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public Bairro getBairro() {
        return bairro;
    }
    
    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    
    // Métodos utilitários
    public Integer getIdade() {
        if (dataNascimento != null) {
            return Period.between(dataNascimento, LocalDate.now()).getYears();
        }
        return null;
    }
    
    public String getEnderecoCompleto() {
        return String.format("%s, %s - %s", 
            endereco != null ? endereco : "", 
            bairro != null ? bairro.getNome() : "N/A", 
            cep != null ? cep : "");
    }
    
    @Override
    public String toString() {
        return String.format("Morador{nome='%s', cpf='%s'}", nome, cpf);
    }
}