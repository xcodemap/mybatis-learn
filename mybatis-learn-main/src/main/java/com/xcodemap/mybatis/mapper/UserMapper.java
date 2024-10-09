package com.xcodemap.mybatis.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> findUser(Map<String, Object> paras);
}
