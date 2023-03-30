package com.example.demo.tx.dao;

import com.example.demo.tx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author weizhuang
 * Created on 2019-09-18.
 */

@Service
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void save(User user) {
        jdbcTemplate.update("insert into user(name,age) value(?,?)", user.getName(), user.getAge());
    }
}
