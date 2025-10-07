package com.pandemia.dao;

import com.pandemia.model.Bairro;

public class BairroDAO {
    
    private static BairroDAO instance;
    
    private BairroDAO() {
        // Construtor privado para Singleton
    }
    
    public static BairroDAO getInstance() {
        if (instance == null) {
            instance = new BairroDAO();
        }
        return instance;
    }
    
    public boolean salvar(Bairro bairro) {
        //Implementar persistência JPA/Hibernate
        return true;
    }
    
    public boolean atualizar(Bairro bairro) {
        //Implementar persistência JPA/Hibernate
        return true;
    }
    
    public boolean excluir(Long id) {
        //Implementar persistência JPA/Hibernate
        return true;
    }
    
    public Bairro buscarPorId(Long id) {
        //Implementar persistência JPA/Hibernate
        return null;
    }
}