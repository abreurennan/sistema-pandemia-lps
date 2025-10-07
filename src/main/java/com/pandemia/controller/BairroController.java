package com.pandemia.controller;

import com.pandemia.model.Bairro;
import com.pandemia.dao.BairroDAO;

public class BairroController {
    
    public boolean salvar(Bairro bairro) {
        // Chamar DAO (Singleton)
        BairroDAO dao = BairroDAO.getInstance();
        return dao.salvar(bairro);
    }
    
    public boolean atualizar(Bairro bairro) {
        //Implementar lógica de negócio
        return true;
    }
    
    public boolean excluir(Long id) {
        //Implementar lógica de negócio
        return true;
    }
    
    public Bairro buscarPorId(Long id) {
        //Implementar lógica de negócio
        return null;
    }
}