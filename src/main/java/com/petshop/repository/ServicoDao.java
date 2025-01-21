package com.petshop.repository;


import com.petshop.model.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDao implements Dao<Servico>{

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


        private List<Servico> executeQuery(String sql, Object... params) {
            List<Servico> servicos = new ArrayList<>();
            try (Connection conn = DBconnection.connect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Servico servico = new Servico();
                        servico.setTipo(resultSet.getString("tipo"));
                        servico.setValor(resultSet.getFloat("valor"));
                        servico.setDescricaoServ(resultSet.getString("descricao"));
                        servicos.add(servico);
                    }
                }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return servicos;
        }

        @Override
        public Servico findById(Long id) {
            String sql = "SELECT * FROM servico WHERE id = ?";
            List<Servico> servicos = executeQuery(sql, id);
            return servicos.isEmpty() ? null : servicos.get(0);
        }

        @Override
        public List<Servico> findAll() {
            String sql = "SELECT * FROM servico";
            return executeQuery(sql);
        }

        @Override
        public boolean save(Servico servico) {
            String sql = "INSERT INTO servico (tipo, valor, descricao) VALUES (?, ?, ?)";
            return executeUpdate(sql, servico.getTipo(), servico.getValor(), servico.getDescricaoServ());

        }

        @Override
        public boolean update(Servico servico) {
            String sql = "UPDATE produto SET nome = ?, qtd_estoque = ?, valor = ?, data_validade = ?, descricao = ?, categoria = ? WHERE id = ?";
            return executeUpdate(sql, servico.getTipo(), servico.getValor(), servico.getDescricaoServ());
        }

        @Override
        public boolean delete(Long id) {
            String sql = "DELETE FROM servico WHERE id = ?";
            return executeUpdate(sql, id);
        }
}



