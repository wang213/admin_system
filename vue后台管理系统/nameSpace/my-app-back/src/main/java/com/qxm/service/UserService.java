package com.qxm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qxm.pojo.User;

import java.io.Serializable;
import java.util.Map;

public interface UserService {

    Page<User> selectPage(int page, int pageSize, Map user);

    void add(User user);

    void update(User user);

    void delete(Serializable id);
}
