package com.petshop.repository;

import com.petshop.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao implements Dao<Funcionario> {

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

        private List<Funcionario> executeQuery(String sql, Object... params) {
            List<Funcionario> funcionarios = new ArrayList<>();
            try (Connection conn = DBconnection.connect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {


                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Funcionario funcionario = new Funcionario();
                        funcionario.setNome(resultSet.getString("nome"));
                        funcionario.setSalario(resultSet.getFloat("salario"));
                        funcionario.setTelefone(resultSet.getString("telefone"));
                        funcionario.setCargo(resultSet.getString("cargo"));
                        funcionarios.add(funcionario);
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return funcionarios;
        }

        @Override
        public Funcionario findById(Long id) {
            String sql = "SELECT * FROM funcionario WHERE id = ?";
            List<Funcionario> funcionario = executeQuery(sql, id);
            return funcionario.isEmpty() ? null : funcionario.get(0);
        }

        @Override
        public List<Funcionario> findAll() {
            String sql = "SELECT * FROM funcionario";
            return executeQuery(sql);
        }

        @Override
        public boolean save(Funcionario funcionario) {
            String sql = "INSERT INTO funcionario (nome, salario, telefone, cargo) VALUES (?, ?, ?)";
            return executeUpdate(sql, funcionario.getNome(), funcionario.getSalario(), funcionario.getTelefone(), funcionario.getCargo());
        }

        @Override
        public boolean update(Funcionario funcionario) {
            String sql = "UPDATE funcionario SET nome = ?, salario = ?, telefone = ?, cargo = ? WHERE id = ?";
            return executeUpdate(sql, funcionario.getNome(), funcionario.getSalario(), funcionario.getTelefone(), funcionario.getCargo());
        }

        @Override
        public boolean delete(Long id) {
            String sql = "DELETE FROM funcionario WHERE id = ?";
            return executeUpdate(sql, id);
        }
}



