package org.example.crud_jdbc_proyect.dao;

import org.example.crud_jdbc_proyect.model.User;

public interface UserDAO {

    User create(User usuario);

    User findByUsername(String username);
}
