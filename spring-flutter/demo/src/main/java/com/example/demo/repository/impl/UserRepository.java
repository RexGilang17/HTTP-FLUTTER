package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
    public User insertUser(User user) {
        String query = "INSERT INTO tb_user(email, nama, gender) "
                + "VALUES(?, ?, ?)";
        jdbcTemplate.update(query,
                new Object[] { user.getEmail(), user.getNama(),  user.getGender() });
        return user;
    }
	
	@Override
    public List<User> getAllUser() {
        String query = "SELECT * FROM tb_user";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User deleteUser(int id) {
        String query = "SELECT * FROM tb_user WHERE id = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), id);

        query = "DELETE FROM tb_user WHERE id = ?";
        jdbcTemplate.update(query, id);

        return result;
    }
	
	
	
}
