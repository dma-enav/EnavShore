
CREATE DATABASE msi;

CREATE USER 'msi'@'localhost' IDENTIFIED BY 'msi';
GRANT ALL PRIVILEGES ON *.* TO 'msi'@'localhost' WITH GRANT OPTION;
CREATE USER 'msi'@'%' IDENTIFIED BY 'msi';
GRANT ALL PRIVILEGES ON *.* TO 'msi'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;


