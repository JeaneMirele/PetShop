package com.petshop.repository;

import java.util.List;

public interface Dao<T>{



        T findById(Long id);
        List<T> findAll();
        boolean save(T t);
        boolean update(T t);
        boolean delete(Long id);
        boolean executeUpdate(String sql, Object... params);
    }

