package org.example.crud_jdbc_proyect;

import lombok.extern.slf4j.Slf4j;
import org.example.crud_jdbc_proyect.dao.UserDAO;
import org.example.crud_jdbc_proyect.model.User;
import org.example.crud_jdbc_proyect.util.HasUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
@Slf4j

class CrudJdbcProyectApplicationTests {

    @Autowired
    UserDAO userDAO;
    @Autowired
    HasUtil hasUtil;

    @Test
    void contextLoads() {
    }

    @Test
    void createUserTest(){
        String username = "jose";
        String password= "123456";

        String passwordHashed = null;
        try{
            passwordHashed = hasUtil.hashPassword(password);
            log.info("passwordHashed ={}", passwordHashed);
        } catch (NoSuchAlgorithmException e){
            throw  new RuntimeException(e);
        }
        User user = User.builder() .username(username).password(passwordHashed).build();
        userDAO.create(user);
        Assertions.assertTrue(user.getId()> 0);
    }
}
