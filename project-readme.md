# 客户管理系统

这是一个基于Spring Boot的客户管理系统，用于管理客户和数据库信息。

## 技术栈

* Spring Boot 2.7.5
* JDK 1.8
* Spring Security
* Spring Data JPA
* SQL Server 2008
* Thymeleaf
* Bootstrap 5

## 功能特性

* 用户登录认证
* 客户信息管理（增删改查）
* 客户启用/禁用功能
* 数据库信息管理（增删改查）
* 响应式界面设计

## 项目结构

```
customer-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── management/
│   │   │           ├── CustomerManagementApplication.java (主程序入口)
│   │   │           ├── config/ (配置类)
│   │   │           │   ├── SecurityConfig.java (安全配置)
│   │   │           ├── controller/ (控制器)
│   │   │           │   ├── CustomerController.java (客户控制器)
│   │   │           │   ├── DatabaseController.java (数据库控制器)
│   │   │           │   ├── LoginController.java (登录控制器)
│   │   │           ├── model/ (实体类)
│   │   │           │   ├── Customer.java (客户实体)
│   │   │           │   ├── Database.java (数据库实体)
│   │   │           ├── repository/ (数据访问层)
│   │   │           │   ├── CustomerRepository.java
│   │   │           │   ├── DatabaseRepository.java
│   │   │           ├── service/ (服务层)
│   │   │           │   ├── CustomerService.java
│   │   │           │   ├── DatabaseService.java
│   │   ├── resources/ (资源文件)
│   │   │   ├── application.properties (应用配置)
│   │   │   ├── static/ (静态资源)
│   │   │   │   ├── css/
│   │   │   │   │   ├── style.css
│   │   │   │   ├── js/
│   │   │   │   │   ├── script.js
│   │   │   ├── templates/ (Thymeleaf模板)
│   │   │   │   ├── login.html (登录页面)
│   │   │   │   ├── index.html (主页)
│   │   │   │   ├── customers.html (客户管理页面)
│   │   │   │   ├── databases.html (数据库管理页面)
│   │   │   │   ├── fragments/ (页面片段)
│   │   │   │   │   ├── header.html (页头)
│   │   │   │   │   ├── footer.html (页脚)
├── pom.xml (Maven配置)
```

## 数据库设计

### 客户表 (customers)

| 字段名                 | 类型         | 描述             |
|----------------------|--------------|-----------------|
| id                   | BIGINT       | 主键             |
| customer_name        | VARCHAR(255) | 客户名称         |
| customer_database_name| VARCHAR(255) | 客户数据库名     |
| expiration_date      | DATE         | 客户到期时间     |
| fee                  | DECIMAL      | 费用             |
| database_instance_name| VARCHAR(255) | 数据库实例名     |
| disabled             | BOOLEAN      | 是否禁用         |

### 数据库表 (databases)

| 字段名       | 类型         | 描述         |
|------------|--------------|--------------|
| id         | BIGINT       | 主键         |
| database_name| VARCHAR(255)| 数据库名称   |
| address    | VARCHAR(255) | 数据库地址   |
| port       | INTEGER      | 端口        |
| username   | VARCHAR(255) | 用户名      |
| password   | VARCHAR(255) | 密码        |

## 运行说明

1. 确保已安装JDK 1.8和Maven
2. 配置SQL Server 2008数据库连接信息（修改application.properties）
3. 在项目根目录执行命令：`mvn spring-boot:run`
4. 访问 http://localhost:8080
5. 使用默认账号登录：
   - 用户名：admin
   - 密码：admin123

## 注意事项

1. 本项目默认用户名和密码保存在application.properties文件中
2. 数据库表将在首次运行时自动创建（JPA自动生成）
3. 请修改application.properties中的数据库连接信息为您自己的环境配置
