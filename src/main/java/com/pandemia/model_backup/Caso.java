package com.pandemia.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Entidade Caso - Sistema Pandemia 
 * Padrão MVC + JPA/Hibernate
 */
@Entity
@Table(name = "casos")
public class Caso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Data do diagnóstico é obrigatória")
    @PastOrPresent(message = "Data do diagnóstico não pode ser futura")
    @Column(name = "data_diagnostico", nullable = false)
    private LocalDate dataDiagnostico;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo do caso é obrigatório")
    @Column(name = "tipo_caso", nullable = false)
    private TipoCaso tipoCaso;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status do caso é obrigatório")
    @Column(name = "status_caso", nullable = false)
    private StatusCaso statusCaso;
    
    @Column(name = "data_recuperacao")
    private LocalDate dataRecuperacao;
    
    @Column(name = "data_obito")
    private LocalDate dataObito;
    
    @Size(max = 1000, message = "Observações devem ter no máximo 1000 caracteres")
    @Column(name = "observacoes", length = 1000)
    private String observacoes;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_vacinal")
    private SituacaoVacinal situacaoVacinal;
    
    @Column(name = "hospitalizado")
    private Boolean hospitalizado;
    private Boolean ativo;
    private Morador morador;
    
    // Enums
    public enum TipoCaso {
        SUSPEITO("Suspeito"),
        CONFIRMADO("Confirmado"),
        DESCARTADO("Descartado");
        
        private final String descricao;
        
        TipoCaso(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    public enum StatusCaso {
        ATIVO("Ativo"),
        RECUPERADO("Recuperado"),
        OBITO("Óbito"),
        EM_MONITORAMENTO("Em Monitoramento");
        
        private final String descricao;
        
        StatusCaso(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    public enum SituacaoVacinal {
        NAO_VACINADO("Não Vacinado"),
        PARCIALMENTE_VACINADO("Parcialmente Vacinado"),
        COMPLETAMENTE_VACINADO("Completamente Vacinado"),
        DOSE_REFORCO("Com Dose de Reforço");
        
        private final String descricao;
        
        SituacaoVacinal(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    // Construtores
    public Caso() {
        this.ativo = true;
        this.hospitalizado = false;
    }
    
    public Caso(LocalDate dataDiagnostico, TipoCaso tipoCaso, StatusCaso statusCaso) {
        this();
        this.dataDiagnostico = dataDiagnostico;
        this.tipoCaso = tipoCaso;
        this.statusCaso = statusCaso;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDate getDataDiagnostico() {
        return dataDiagnostico;
    }
    
    public void setDataDiagnostico(LocalDate dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }
    
    public TipoCaso getTipoCaso() {
        return tipoCaso;
    }
    
    public void setTipoCaso(TipoCaso tipoCaso) {
        this.tipoCaso = tipoCaso;
    }
    
    public StatusCaso getStatusCaso() {
        return statusCaso;
    }
    
    public void setStatusCaso(StatusCaso statusCaso) {
        this.statusCaso = statusCaso;
    }
    
    public LocalDate getDataRecuperacao() {
        return dataRecuperacao;
    }
    
    public void setDataRecuperacao(LocalDate dataRecuperacao) {
        this.dataRecuperacao = dataRecuperacao;
    }
    
    public LocalDate getDataObito() {
        return dataObito;
    }
    
    public void setDataObito(LocalDate dataObito) {
        this.dataObito = dataObito;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public SituacaoVacinal getSituacaoVacinal() {
        return situacaoVacinal;
    }
    
    public void setSituacaoVacinal(SituacaoVacinal situacaoVacinal) {
        this.situacaoVacinal = situacaoVacinal;
    }
    
    public Boolean getHospitalizado() {
        return hospitalizado;
    }
    
    public void setHospitalizado(Boolean hospitalizado) {
        this.hospitalizado = hospitalizado;
    }
    
    public Boolean getAtivo() {
        return ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public Morador getMorador() {
        return morador;
    }
    
    public void setMorador(Morador morador) {
        this.morador = morador;
    }
    
    // Métodos utilitários
    public String getDataDiagnosticoFormatada() {
        if (dataDiagnostico != null) {
            return dataDiagnostico.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return "N/A";
    }
    
    public String getDataRecuperacaoFormatada() {
        if (dataRecuperacao != null) {
            return dataRecuperacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return "N/A";
    }
    
    public String getResumo() {
        return String.format("%s - %s (%s)", 
            morador != null ? morador.getNome() : "N/A",
            tipoCaso != null ? tipoCaso.getDescricao() : "N/A",
            statusCaso != null ? statusCaso.getDescricao() : "N/A");
    }
    
    @Override
    public String toString() {
        return String.format("Caso{morador='%s', tipo='%s', status='%s'}", 
            morador != null ? morador.getNome() : "N/A",
            tipoCaso, 
            statusCaso);
    }
}