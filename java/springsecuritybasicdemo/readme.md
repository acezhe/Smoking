Spring Security Demo
===

## 创建 Springboot 项目

创建 Springboot 项目，用 Spring initializr 生成。这里用了 maven 做管理，也可以用 gradle。

依赖选择：

- security
- web
- jpa
- thymeleaf
- devtools
- lombok
- mysql

pom.xml 配置

```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.19.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.acezhe</groupId>
    <artifactId>springsecuritybasicdemo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springsecuritybasicdemo</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
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
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity4</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

## 配置数据库连接

在 `application.properties` 中加入如下配置：

```properties
# datasource config
spring.datasource.url=jdbc:mysql://localhost:3306/springsecuritydemo?characterEncoding=utf8&characterSetResults=utf8&autoReconnect=true&serverTimezone=GMT%2B8&useSSL=false
spring.datasource.username=root
spring.datasource.password=8721

# jpa config
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

# security config
security.user.name=user
security.user.password=user

# thymeleaf config
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.content-type=text/html
spring.thymeleaf.suffix=.html
spring.thymeleaf.mode=HTML5

```

这里省略了数据库安装和创建过程。
配置完成后就可以运行下 gradle 的 `bootRun`，然后在浏览器访问 `http://localhost:8080` 。
此时应该可以看到 springboot 提供的默认登录页面。输入上面配置的用户名密码，页面可跳转到错误页面。

## 创建页面模板

用 thymeleaf 在 resources/templates 目录下创建几个页面模板：

> 注意：模板保存路径可以在 application.properties 中通过 `spring.thymeleaf.prefix` 配置，其他 thymeleaf 的配置项也可在该配置文件中配置。

