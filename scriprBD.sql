--Script para la creacion de las tablas de la base de datos de SISCONDOC


--Creacion de tabla perfiles (Ejem:digitador, administrador, etc) 
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Perfiles;
CREATE TABLE Perfiles(
	id_perfil VARCHAR(30) NOT NULL PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL
);

--Creacion de tabla usuario (Ejem: admin1, digitador1, etc). relacionada con perfiles

CREATE TABLE Usuario(
	name VARCHAR(30) NOT NULL,
	lastname VARCHAR(30) NOT NULL,
	userName VARCHAR(30) NOT NULL UNIQUE,
	cedula VARCHAR(30) PRIMARY KEY NOT NULL, 
	contrasena VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL UNIQUE,
	id_perfil VARCHAR(30) NOT NULL,
	estado BOOL NOT NULL,
	CONSTRAINT fk_idPerfil FOREIGN KEY(id_perfil) REFERENCES perfiles(id_perfil) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creacion de la tabla convocatoria 
CREATE TABLE Convocatoria(
	codigo INT NOT NULL PRIMARY KEY, 
	fecha_Ini DATE NOT NULL, 
	fecha_Fin DATE NOT NULL, 	
 	nombre VARCHAR(40) NOT NULL, 
	estado BOOL NOT NULL, 
	descripcion TEXT NOT NULL
);

--Creacion de la tabla aspirante relacionada con convocatoria
CREATE TABLE Aspirante(
	cedula VARCHAR(30) NOT NULL PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	municipio VARCHAR(30) NOT NULL,
	puntuacion INT,
	codigo INT NOT NULL,
	CONSTRAINT fk_codigo FOREIGN KEY(codigo) REFERENCES Convocatoria(codigo) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creacion de la tabla formacion relacionada con aspirante

CREATE TABLE Formacion(
	Universidad VARCHAR(40) NOT NULL,
	Titulo VARCHAR(40) NOT NULL,
	nivel VARCHAR(30) NOT NULL,
	pathArchivo VARCHAR(100) NOT NULL,
	cedula VARCHAR(30) NOT NULL,
	CONSTRAINT Pk_formacion PRIMARY KEY(cedula, Universidad, Titulo),
	CONSTRAINT Fk_cedula FOREIGN KEY(cedula) REFERENCES Aspirante(cedula) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creacion de la tabla formacion en tic relacionada con aspirante

CREATE TABLE FormacionTic(
	Institucion VARCHAR(40) NOT NULL,
	Titulo VARCHAR(40) NOT NULL,
	horas VARCHAR(30) NOT NULL,
	pathArchivo VARCHAR(100) NOT NULL,
	cedula VARCHAR(30) NOT NULL,
	CONSTRAINT Pk_formacionTIC PRIMARY KEY(cedula, Institucion, Titulo),
	CONSTRAINT Fk_cedula FOREIGN KEY(cedula) REFERENCES Aspirante(cedula) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creacion de la tabla idioma relacionada con aspirante

CREATE TABLE Idioma(
	lenguaje VARCHAR(40) NOT NULL,
	nivelLee VARCHAR(20) NOT NULL,
	nivelEscribe VARCHAR(20) NOT NULL,
	nivelHabla VARCHAR(20) NOT NULL,
	pathArchivo VARCHAR(100) NOT NULL,
	cedula VARCHAR(30) NOT NULL,
	CONSTRAINT Pk_Idioma PRIMARY KEY(cedula,  lenguaje),
	CONSTRAINT Fk_cedula FOREIGN KEY(cedula) REFERENCES Aspirante(cedula)
);

--Creacion de la tabla conocimientos especificos relacionada con aspirante

CREATE TABLE conocimientosEspecificos(
	ofimaticas VARCHAR(100) NOT NULL,
	web2 VARCHAR(100) NOT NULL,
	educaDig VARCHAR(100) NOT NULL,
	multimedia VARCHAR(100) NOT NULL,
	elearning VARCHAR(100) NOT NULL,
	proyeTIC VARCHAR(100) NOT NULL,
	evaluaCompe VARCHAR(100) NOT NULL,
	libroDig VARCHAR(100) NOT NULL,
	cedula VARCHAR(30) NOT NULL,
	CONSTRAINT Pk_conoEspe PRIMARY KEY(cedula),
	CONSTRAINT Fk_cedula FOREIGN KEY(cedula) REFERENCES Aspirante(cedula) ON UPDATE CASCADE ON DELETE NO ACTION
);


--Creacion de la tabla formadorTic relacionada con aspirante

CREATE TABLE formadorTic(
	formados VARCHAR(30) NOT NULL,
	experiencia INT NOT NULL,
	cedula VARCHAR(30) NOT NULL,
	pathArchivo VARCHAR(100) NOT NULL,
	CONSTRAINT Pk_formadorTic PRIMARY KEY(cedula,  formados),
	CONSTRAINT Fk_cedula FOREIGN KEY(cedula) REFERENCES Aspirante(cedula) ON UPDATE CASCADE ON DELETE NO ACTION
);

--Creacion de la tabla convoAspirante

CREATE TABLE convoUsuario(	
	cedula VARCHAR(30) NOT NULL,
	codigo INT NOT NULL,
	estado BOOL NOT NULL,
	CONSTRAINT pk_convoAspirante PRIMARY KEY(cedula, codigo),
	CONSTRAINT Fk_cedula FOREIGN KEY(cedula) REFERENCES Usuario(cedula) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_codigo FOREIGN KEY(codigo) REFERENCES Convocatoria(codigo) ON UPDATE CASCADE ON DELETE NO ACTION
);


--Insert perfiles

INSERT INTO perfiles VALUES(1, 'Digitador');
INSERT INTO perfiles VALUES(2, 'Coordinador');
INSERT INTO perfiles VALUES(3, 'Administrador');
--Insert first admin

INSERT INTO Usuario VALUES('Daniel','Correa','danielcb','1144067772','1144067772DC','danielc.web@gmail.com',3,true);

