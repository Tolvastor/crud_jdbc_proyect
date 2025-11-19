package org.example.crud_jdbc_proyect.dao;


import org.example.crud_jdbc_proyect.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserDAOImplSQL implements UserDAO {
    private JdbcTemplate jdbcTemplate;

    //Inyeccion de jdbcTemplate por contructor
    public UserDAOImplSQL(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public User create(User user) {
        String sql = """
                insert into user (username, password)
                values (                ?,      ?)
                """;
        String[] ids = {"id"};
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, ids);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());

            return ps;
        }, keyHolder);
        user.setId(keyHolder.getKey().longValue());

        return user;
    }

    @Override
    public User findByUsername(String username){
        List<User> users = jdbcTemplate.query("select * from user where username = ?",)
        String sql = """
                insert into user (username, password)
                values (                ?,      ?)
                """;
        (ResultSet rs, int rowNum) -> User.builder()
                .id(rs.getLong("id"))
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                .build()
                , username);
return users.isEmpty() ? null : users.get(0);
    }

}
