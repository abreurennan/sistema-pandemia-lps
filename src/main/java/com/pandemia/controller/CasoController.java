package com.pandemia.controller;

import com.pandemia.model.Caso;
import com.pandemia.dao.CasoDAO;

public class CasoController {
    
    public boolean salvar(Caso caso) {
        // Chamar DAO (Singleton)
        CasoDAO dao = CasoDAO.getInstance();
        return dao.salvar(caso);
    }
    
    public boolean atualizar(Caso caso) {
        //Implementar lógica de negócio
        return true;
    }
    
    public boolean excluir(Long id) {
        //Implementar lógica de negócio
        return true;
    }
    
    public Caso buscarPorId(Long id) {
        //Implementar lógica de negócio
        return null;
    }
}