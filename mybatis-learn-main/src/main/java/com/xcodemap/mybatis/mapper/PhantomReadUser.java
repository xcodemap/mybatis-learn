package com.xcodemap.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhantomReadUser {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhantomReadUser.class);
    private static void doSomeThing(UserMapper mapper) {
        Map<String, Object> params = new HashMap<>();
        params.put("age", 101);
        List<User> users = mapper.findUser(params);
        handleUsers(users);
    }


    private static void handleUsers(List<User> users) {
        boolean hasAdmin = false;
        for (User user : users) {
            if (user.getName().equals("admin")) {
                hasAdmin = true;
            }
        }
        if (!hasAdmin) {
            users.add(new User(0, "admin", 12));
        }
    }

    public static void main(String[] args) throws Exception {
        String resource = "mappers/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            doSomeThing(mapper);
            Map<String, Object> params = new HashMap<>();
            params.put("age", 101);
            List<User> users = mapper.findUser(params);
            System.out.printf("Size:%d %s\n", users.size(), users);
        }
    }
}
