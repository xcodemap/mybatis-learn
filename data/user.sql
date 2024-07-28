CREATE DATABASE IF NOT EXISTS xcodemap;
USE xcodemap;

CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

INSERT INTO User (name, age) VALUES ('Alice', 25);
INSERT INTO User (name, age) VALUES ('Bob', 30);
INSERT INTO User (name, age) VALUES ('Charlie', 35);
