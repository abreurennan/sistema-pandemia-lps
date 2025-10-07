package com.pandemia.dao;

import com.pandemia.model.Morador;

public class MoradorDAO {
    
    private static MoradorDAO instance;
    
    private MoradorDAO() {
        // Construtor privado para Singleton
    }
    
    public static MoradorDAO getInstance() {
        if (instance == null) {
            instance = new MoradorDAO();
        }
        return instance;
    }
    
    public boolean salvar(Morador morador) {
        //Implementar persistência JPA/Hibernate
        return true;
    }
    
    public boolean atualizar(Morador morador) {
        //Implementar persistência JPA/Hibernate
        return true;
    }
    
    public boolean excluir(Long id) {
        //Implementar persistência JPA/Hibernate
        return true;
    }
    
    public Morador buscarPorId(Long id) {
        //Implementar persistência JPA/Hibernate
        return null;
    }
}