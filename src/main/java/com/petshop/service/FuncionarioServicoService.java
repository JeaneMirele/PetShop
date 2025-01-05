package com.petshop.service;

import com.petshop.model.FuncionarioServico;
import com.petshop.repository.FuncionarioServicoDao;
import java.util.List;

public class FuncionarioServicoService {
    private FuncionarioServicoDao funcionarioServicoDao;

    public FuncionarioServicoService(){
        funcionarioServicoDao = new FuncionarioServicoDao();
    }

    public List<FuncionarioServico> getFuncionarioServicos(){
        return funcionarioServicoDao.findAll();
    }

    public boolean save(FuncionarioServico funcionarioServico){
        return funcionarioServicoDao.save(funcionarioServico);
    }

    public boolean update(FuncionarioServico funcionarioServico, String[] params){
        return funcionarioServicoDao.update(funcionarioServico, params);
    }

    public boolean delete(Long id){
        return funcionarioServicoDao.delete(id);
    }
}
}
