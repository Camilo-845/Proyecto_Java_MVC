CREATE SCHEMA spotifytic;
USE spotifytic;
CREATE TABLE autor(
id integer auto_increment,
nombre char(30) NOT NULL,
nacionalidad char(30) NOT NULL,
edad smallint not null,
PRIMARY KEY(id)
);
/*Inserción de datos */
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Carlos Vives", "Colombiano", 60);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Juanes", "Colombiano", 49);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Elton Jhon", "Británico", 74);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Justin Bieber", "Estadounidense", 27);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Beyoncé", "Estadounidense", 39);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Thalía", "Mexicana", 49);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Paulina Rubio", "Mexicana", 50);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Ricardo Montaner", "Venezolano", 63);
INSERT INTO autor(nombre, nacionalidad, edad) VALUES ("Axel", "Argentino", 44);