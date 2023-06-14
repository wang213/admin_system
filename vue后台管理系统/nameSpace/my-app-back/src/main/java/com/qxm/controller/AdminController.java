package com.qxm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qxm.common.Result;
import com.qxm.common.StatusCode;
import com.qxm.mapper.MenueMapper;
import com.qxm.pojo.Admin;
import com.qxm.pojo.Menue;
import com.qxm.pojo.User;
import com.qxm.service.AdminService;
import com.qxm.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MenueMapper menueMapper;

    // 检查属性是否为空值
    private static boolean isPropertyEmpty(Object property) {
        return property == null || property.toString().isEmpty();
    }


    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){

        Boolean isSuccess = adminService.login(admin);

        if(isSuccess){
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("username",admin.getLoginName());
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(),admin.getLoginName(),null);
            resultMap.put("token",token);
            /**
             * 获取二级菜单
             */
            if("qxm".equals(admin.getLoginName())){
                List<Menue> menues = menueMapper.selectList(null);

                for (Menue menue : menues) {

                    QueryWrapper<Menue> MenuePararm = new QueryWrapper<Menue>();
                    MenuePararm.eq("path","page1")
                            .or()
                            .eq("path","page2");
                    List<Menue> menueList = menueMapper.selectList(MenuePararm);
                    menue.setStaus("0");
                    if("其他".equals(menue.getLabel())){
                        menue.setChildren(menueList);
                        //修改子菜单属性
                        menue.getChildren().forEach((a)->{
                            a.setStaus("1");
                        });
                    }
                }
                //遍历删除元素
                Iterator<Menue> iterator = menues.iterator();
                while(iterator.hasNext()){
                    Menue s =iterator.next();
                    if("0".equals(s.getStaus()) && "页面1".equals(s.getLabel())){
                        iterator.remove();
                    }
                    if("0".equals(s.getStaus()) && "页面2".equals(s.getLabel())){
                        iterator.remove();
                    }
                }

                menues.stream().forEach(System.out::println);
                System.out.println("==============================");

                resultMap.put("menueData",menues);
            } else if("zy".equals(admin.getLoginName())){
                List<Menue> menues = menueMapper.selectList(null);
                List<Menue> menuesNew = new ArrayList<>();
                menues.forEach((a)->{
                    if("首页".equals(a.getLabel())){
                        menuesNew.add(a);
                    }
                    if("商品管理".equals(a.getLabel())){
                        menuesNew.add(a);
                    }
                });

                menuesNew.stream().forEach(System.out::println);
                System.out.println("==============================");

                resultMap.put("menueData",menuesNew);
            }

            return new Result(true,StatusCode.OK,"登录成功",resultMap);

        }else{
            return new Result(false,StatusCode.ERROR,"登录失败");
        }

    }

    @PostMapping("/add")
    public Result add(@RequestBody Admin admin){
        adminService.add(admin);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @GetMapping("/selectAll")
    public Result selectAll(){
        List<Admin> admins = adminService.selectAll();
        return new Result(true,StatusCode.OK,"查询成功");
    }

}
