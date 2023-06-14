package com.qxm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qxm.mapper.AdminMapper;
import com.qxm.pojo.Admin;
import com.qxm.service.AdminService;
import com.qxm.util.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Boolean login(Admin admin) {

        //根据用户名和状态查询
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("login_name",admin.getLoginName());
        Admin admin1 = adminMapper.selectOne(adminQueryWrapper);
        //判断 验证
        if(admin1 == null){
            return false;
        }else {
        return BCrypt.checkpw(admin.getPassword(),admin1.getPassword());//密码是否相同
        }
    }

    @Override
    public void add(Admin admin) {
        String hashpw = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
        admin.setPassword(hashpw);
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectList(null);
    }
}
