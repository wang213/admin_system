package com.qxm.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qxm.mapper.UserMapper;
import com.qxm.pojo.User;
import com.qxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Page<User> selectPage(int page, int pageSize, Map user) {

        QueryWrapper<User> userPararm = new QueryWrapper<User>();
        userPararm.like("name",user.get("name"));
//        userPararm.eq("age",user.get("age"));
//        userPararm.eq("sex",user.get("sex"));
//        userPararm.eq("birth",user.get("birth"));
//        userPararm.eq("address",user.get("address"));

        Page<User> pages = new Page<>(page, pageSize);
        if(user.get("name")!=null){
            Page<User> userPage = userMapper.selectPage(pages, userPararm);
            return userPage;
        }
        if(pages==null && user.get("name")==null){
            Page<User> userPage = userMapper.selectPage(null, null);
            return userPage;
        }
        Page<User> userPage = userMapper.selectPage(pages,null);
        return userPage;
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateById(user);

    }

    @Override
    public void delete(Serializable id) {
        userMapper.deleteById(id);
    }
}
