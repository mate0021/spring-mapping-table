DROP DATABASE IF EXISTS orderservice;
CREATE DATABASE IF NOT EXISTS orderservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP USER IF EXISTS `orderadmin`@`%`;
CREATE USER IF NOT EXISTS `orderadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
    GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
    CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `orderservice`.* TO `orderadmin`@`%`;

DROP USER IF EXISTS `orderuser`@`%`;
CREATE USER IF NOT EXISTS `orderuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
    GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `orderservice`.* TO `orderuser`@`%`;

FLUSH PRIVILEGES;
