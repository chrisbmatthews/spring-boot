create database springbootmysql;
GRANT ALL PRIVILEGES ON springbootmysql.* to 'springbootmysql'@'localhost' identified by 'password';
use springbootmysql;

BEGIN;

DROP TABLE customer;

#the InnoDB engine supports transactionality
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(128),
    last_name VARCHAR(128),
    created_date DATETIME,
    created_user VARCHAR(32),
    modified_date DATETIME,
    modified_user VARCHAR(32)
) ENGINE=InnoDB;

commit;