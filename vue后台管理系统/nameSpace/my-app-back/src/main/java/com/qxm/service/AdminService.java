package com.qxm.service;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qxm.pojo.Admin;
import com.qxm.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface AdminService  {

    public Boolean login(Admin admin);

    void add(Admin admin);

    List<Admin> selectAll();
}
