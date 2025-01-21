package com.petshop.repository;

import com.petshop.model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDao implements Dao<Pet>{
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

    private List<Pet> executeQuery(String sql, Object... params) {
        List<Pet> Pets = new ArrayList<>();
        try (Connection conn = DBconnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {


            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Pet pet = new Pet();
                    pet.setNome(resultSet.getString("nome"));
                    pet.setEspecie(resultSet.getString("especie"));
                    pet.setRaca(resultSet.getString("raca"));
                    pet.setDataNascimento(resultSet.getDate("data_nasc").toLocalDate());
                    pet.setPeso(resultSet.getDouble("peso"));
                    Pets.add(pet);
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Pets;
    }

    @Override
    public Pet findById(Long id) {
        String sql = "SELECT * FROM pet WHERE id = ?";
        List<Pet> pet = executeQuery(sql, id);
        return pet.isEmpty() ? null : pet.get(0);
    }

    @Override
    public List<Pet> findAll() {
        String sql = "SELECT * FROM pet";
        return executeQuery(sql);
    }

    @Override
    public boolean save(Pet pet) {
        String sql = "INSERT INTO pet (nome, raca, especie,data_nasc, peso) VALUES (?, ?, ?, ?, ?)";
        return executeUpdate(sql, pet.getNome(), pet.getRaca(), pet.getEspecie(), pet.getDataNascimento(), pet.getPeso());
    }

    @Override
    public boolean update(Pet pet) {
        String sql = "UPDATE pet SET nome = ?, raca = ?, especie = ?, data_nasc = ? WHERE id = ?";
        return executeUpdate(sql, pet.getNome(), pet.getRaca(), pet.getEspecie(), pet.getDataNascimento(), pet.getPeso());
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM pet WHERE id = ?";
        return executeUpdate(sql, id);
    }
}



