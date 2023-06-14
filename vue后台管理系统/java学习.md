# java后台项目

## 一、版本选择

https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-extension  依赖版本地址

springBoot 3.1.0 

 jdk17

热部署、lombok、spring-boot-starter( 自动加载第三方模块 )、spring-boot-starter-web(web启动容器)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>my-app-back</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>my-app-back</name>
    <description>my-app-back</description>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!--spring-boot-starter-web 依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

```

## 二、部署

1.服务打成jar包

2.下载jdk17

3.启动命令

```shell
nohup java -jar my-app-back-0.0.1-SNAPSHOT.jar >spring.log &
注意：
nohup意思是不挂断运行命令，当账户退出或终端关闭时，程序仍然运行
>spring.log代表将命令的输出定向存储到spring.log这个文件中，文件名可以自己定义。
&代表在后台运行
执行命令之后，然后直接再回车，此时jar包就已经在运行了
```

4.暴露端口

```shell
#查看jar包
jps -l
# 暴露端口
firewall-cmd --zone=public --add-port=8083/tcp --permanent
# 查看是否开放该端口
lsof -i:8083
# 重新加载
firewall-cmd --reload
```

