

-- Crear la base de datos UsuariosControlPuerta
CREATE DATABASE UsuariosControlPuerta;

-- Usar la base de datos creada
USE UsuariosControlPuerta;

-- Crear la tabla EstadoObjeto
CREATE TABLE EstadoObjeto (
    idEstadoObj INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    Estado BOOLEAN NOT NULL
);

-- Crear la tabla Objeto
CREATE TABLE Objeto (
    idObjeto INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    fkEstadoObj INT,
    FOREIGN KEY (fkEstadoObj) REFERENCES EstadoObjeto(idEstadoObj)
);

-- Crear la tabla Usuario
CREATE TABLE Usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    User VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL
);

/*Insertar Usuarios*/
use usuarioscontrolpuerta;

INSERT INTO Objeto (idObjeto, Nombre, fkEstadoObj)
VALUES 
    (1, 'Primera Puerta', 1),
    (2, 'Segunda Puerta', 2);
    
    INSERT INTO EstadoObjeto (idEstadoObj, fecha, Estado)
VALUES 
    (1, '2023-07-18', TRUE),
    (2, '2023-07-17', FALSE);
    
    INSERT INTO Usuario (idUsuario, User, Password)
VALUES 
    (1, 'Juan123', '12345'),
    (2, 'Marco123', 'Marco12345'),
    (3, 'usuario3', 'contrasena3');
