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
INSERT INTO Perfiles VALUES (3,'Administrador');
INSERT INTO Usuario VALUES ('Daniel','Correa','danielcb','1144067772','1144067772DC','danielc.web@gmail.com',3);
--"SELECT usuario.cedula, usuario.name, usuario.lastName,usuario.userName, usuario.password, usuario.email ,  perfil.nombre FROM  usuario, perfil WHERE usuario.id_perfil=perfil.id_perfil AND nombre_usuario='" + username +  "'"


