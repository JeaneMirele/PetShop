package com.petshop.repository;

import com.petshop.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuncionarioDao implements Dao<Funcionario> {
    @Override
    public Funcionario findById(Long id){
        Funcionario funcionario = null;
        String sql = "select * from funcionario where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;

    }
}
