-- 创建客户表
CREATE TABLE customers (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    customer_database_name VARCHAR(255) NOT NULL,
    expiration_date DATE NOT NULL,
    fee DECIMAL(10,2) NOT NULL,
    database_instance_name VARCHAR(255) NOT NULL,
    disabled BIT NOT NULL DEFAULT 0
);

-- 创建数据库表
CREATE TABLE databases (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    database_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    port INT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- 插入示例数据
INSERT INTO customers (customer_name, customer_database_name, expiration_date, fee, database_instance_name, disabled)
VALUES 
    ('测试客户1', 'test_db_1', '2025-12-31', 1000.00, 'INSTANCE001', 0),
    ('测试客户2', 'test_db_2', '2025-10-15', 1500.00, 'INSTANCE002', 0),
    ('测试客户3', 'test_db_3', '2025-08-20', 2000.00, 'INSTANCE003', 1);

INSERT INTO databases (database_name, address, port, username, password)
VALUES 
    ('主数据库', '192.168.1.100', 1433, 'sa', 'P@ssw0rd'),
    ('备份数据库', '192.168.1.101', 1433, 'backup_user', 'Backup@123');
