package com.petshop.repository;

import com.petshop.model.FuncionarioServico;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncionarioServicoDao implements Dao<FuncionarioServico> {

    @Override
    public FuncionarioServico findById(Long id) {
        FuncionarioServico funcionarioServico = null;
        String sql = "select * from funcionarioServico where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            conn = DBconnection.connect();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                funcionarioServico = new FuncionarioServico();
                funcionarioServico.setIdFunc(resultSet.getLong("id_func"));
                funcionarioServico.setIdServ(resultSet.getLong("id_serv"));
                funcionarioServico.setDataAgendamento(resultSet.getTimestamp("data_agendamento").toLocalDateTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return funcionarioServico;
    }

}