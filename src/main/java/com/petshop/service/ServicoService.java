package com.petshop.service;

import com.petshop.repository.ServicoDao;
import com.petshop.model.Servico;
import java.util.List;

public class ServicoService {

    private ServicoDao servicoDao;

    public ServicoService(){
        servicoDao = new ServicoDao();
    }

    public List<Servico> getServicos(){
        return servicoDao.findAll();
    }

    public boolean save(Servico servico){
        return servicoDao.save(servico);
    }

    public boolean update(Servico servico, String[] params){
        return servicoDao.update(servico);
    }

    public boolean delete(Long id){
        return servicoDao.delete(id);
    }
}
