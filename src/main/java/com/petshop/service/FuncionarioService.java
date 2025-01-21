package com.petshop.service;

import com.petshop.model.Funcionario;
import com.petshop.repository.FuncionarioDao;
import java.util.List;

public class FuncionarioService {
    private FuncionarioDao funcionarioDao;

    public FuncionarioService(){
        funcionarioDao = new FuncionarioDao();
    }

    public List<Funcionario> getFuncionarios(){
        return funcionarioDao.findAll();
    }

    public boolean save(Funcionario funcionario){
        return funcionarioDao.save(funcionario);
    }

    public boolean update(Funcionario funcionario, String[] params){
        return funcionarioDao.update(funcionario);
    }

    public boolean delete(Long id){
        return funcionarioDao.delete(id);
    }
}

