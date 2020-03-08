CREATE DATABASE seresvivos;

USE seresvivos;

CREATE TABLE animales (
    id int AUTO_INCREMENT,
    nombre varchar(30) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO animales (nombre) VALUES ('perro'), ('gato'), ('pinguino'), ('conejo'), ('gallina'), ('tortuga');

SELECT * FROM animales;