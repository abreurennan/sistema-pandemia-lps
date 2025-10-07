package com.pandemia.controller;

import com.pandemia.model.Morador;
import com.pandemia.dao.MoradorDAO;

public class MoradorController {
    
    public boolean salvar(Morador morador) {
        // Chamar DAO (Singleton)
        MoradorDAO dao = MoradorDAO.getInstance();
        return dao.salvar(morador);
    }
    
    public boolean atualizar(Morador morador) {
        //Implementar lógica de negócio
        return true;
    }
    
    public boolean excluir(Long id) {
        //Implementar lógica de negócio
        return true;
    }
    
    public Morador buscarPorId(Long id) {
        //Implementar lógica de negócio
        return null;
    }
}