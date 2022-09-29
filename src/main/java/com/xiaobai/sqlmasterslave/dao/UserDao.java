package com.xiaobai.sqlmasterslave.dao;

import com.xiaobai.sqlmasterslave.annotation.sourceWith;
import com.xiaobai.sqlmasterslave.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {
    @sourceWith(value = "slave")
    User getById(Integer id);

    @sourceWith(value = "master")
    Integer insert(User user);
}
