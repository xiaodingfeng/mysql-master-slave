package com.xiaobai.sqlmasterslave;

import com.xiaobai.sqlmasterslave.dao.UserDao;
import com.xiaobai.sqlmasterslave.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/getById")
    public Object getById(Integer id) {
        return userDao.getById(id);
    }

    @RequestMapping("/insert")
    public Object insert(@RequestBody User user) {
        return userDao.insert(user);
    }
}
