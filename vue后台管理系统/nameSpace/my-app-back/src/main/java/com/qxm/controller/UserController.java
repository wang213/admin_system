package com.qxm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qxm.common.Result;
import com.qxm.common.StatusCode;
import com.qxm.pojo.User;
import com.qxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/demo")
    String hello(){
        return "hello";
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        userService.add(user);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @GetMapping(value = "/search/{page}/{pageSize}")
    public Result selectPage(@RequestParam Map searchMap, @PathVariable int page, @PathVariable int pageSize){
        Page<User> userPage = userService.selectPage(page, pageSize, searchMap);
        return new Result(true,StatusCode.OK,"查询成功",userPage);
    }

    @PutMapping(value = "/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable int id){
        userService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");

    }

}
