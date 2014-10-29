--Script para la creacion de las tablas de la base de datos de SISCONDOC

--Creacion de tabla perfiles (Ejem:digitador, administrador, etc) 
CREATE TABLE Perfiles(
	id_perfil VARCHAR(30) NOT NULL PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL
);

--Creacion de tabla usuario (Ejem: admin1, digitador1, etc)
CREATE TABLE Usuario(
	name VARCHAR(30) NOT NULL,
	lastname VARCHAR(30) NOT NULL,
	userName VARCHAR(30) NOT NULL,
	cedula VARCHAR(30) PRIMARY KEY NOT NULL, 
	contrasena VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	id_perfil VARCHAR(30) NOT NULL,
	CONSTRAINT fk_idPerfil FOREIGN KEY(id_perfil) REFERENCES Perfiles(id_perfil)
);


--Insert de los tres perfiles de usuario (digitador, administrador, coordinador)

INSERT INTO Perfiles VALUES('3', 'Adiministrador');
INSERT INTO Perfiles VALUES('1', 'Digitador');
INSERT INTO Perfiles VALUES('2', 'Coordinador');

