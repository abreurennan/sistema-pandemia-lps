package com.pandemia.dao;

import com.pandemia.model.Caso;

public class CasoDAO {
    
    private static CasoDAO instance;
    
    private CasoDAO() {
        // Construtor privado para Singleton
    }
    
    public static CasoDAO getInstance() {
        if (instance == null) {
            instance = new CasoDAO();
        }
        return instance;
    }
    
    public boolean salvar(Caso caso) {
        // Implementar persistência JPA/Hibernate
        return true;
    }
    
    public boolean atualizar(Caso caso) {
        //Implementar persistência JPA/Hibernate
        return true;
    }
    
    public boolean excluir(Long id) {
        // TODO: Implementar persistência JPA/Hibernate
        return true;
    }
    
    public Caso buscarPorId(Long id) {
        // TODO: Implementar persistência JPA/Hibernate
        return null;
    }
}