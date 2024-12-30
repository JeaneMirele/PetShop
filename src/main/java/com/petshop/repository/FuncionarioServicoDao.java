package com.petshop.repository;

import com.petshop.model.FuncionarioServico;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioServicoDao implements Dao<FuncionarioServico> {

        @Override
        public boolean executeUpdate(String sql, Object... params) {
            try (Connection conn = DBconnection.connect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        private List<FuncionarioServico> executeQuery(String sql, Object... params) {
            List<FuncionarioServico> funcServ = new ArrayList<>();
            try (Connection conn = DBconnection.connect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {


                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        FuncionarioServico funcionarioServico = new FuncionarioServico();
                        funcionarioServico.setIdFunc(resultSet.getLong("id_func"));
                        funcionarioServico.setIdServ(resultSet.getLong("id_serv"));
                        funcionarioServico.setDataAgendamento(resultSet.getTimestamp("data_agendamento").toLocalDateTime());
                        funcServ.add(funcionarioServico);
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return funcServ;
        }

        @Override
        public FuncionarioServico findById(Long id) {
            String sql = "SELECT * FROM funcionarioServico WHERE id = ?";
            List<FuncionarioServico> FuncServ = executeQuery(sql, id);
            return FuncServ.isEmpty() ? null : FuncServ.get(0);
        }

        @Override
        public List<FuncionarioServico> findAll() {
            String sql = "SELECT * FROM funcionarioServico";
            return executeQuery(sql);
        }

        @Override
        public boolean save(FuncionarioServico funcionarioServico) {
            String sql = "INSERT INTO funcionarioServico (id_func, id_serv, data_agendamento) VALUES (?, ?, ?)";
            return executeUpdate(sql, funcionarioServico.getIdFunc(), funcionarioServico.getIdServ(), funcionarioServico.getDataAgendamento());
        }

        @Override
        public boolean update(FuncionarioServico funcionarioServico, String[] params) {
            String sql = "UPDATE funcionarioServico SET id_func = ?, id_serv = ?, data_agendamento = ? WHERE id = ?";
            return executeUpdate(sql, funcionarioServico.getIdFunc(), funcionarioServico.getIdServ(), funcionarioServico.getDataAgendamento());
        }

        @Override
        public boolean delete(Long id) {
            String sql = "DELETE FROM funcionarioServico WHERE id = ?";
            return executeUpdate(sql, id);
        }
}

