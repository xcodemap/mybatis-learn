package com.xcodemap.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

    public static void main(String[] args) throws Exception {
        String resource = "mappers/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Map<String, Object> params = new HashMap<>();
            params.put("age", 101);
            List<User> users = mapper.findUser(params);
            System.out.printf("Size:%d %s\n", users.size(), users);
        }
    }
}
