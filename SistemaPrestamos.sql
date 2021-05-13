drop database Prestamos;
CREATE SCHEMA IF NOT EXISTS Prestamos;
USE  Prestamos;

CREATE TABLE IF NOT EXISTS Encargado(curp varchar(18) NOT NULL, 
  nombre varchar(200) NOT NULL, 
  numPersonal varchar(20) NOT NULL, turno varchar(30) NOT NULL, 
  correoElectronico varchar(100) NOT NULL, contrasenia blob NOT NULL,
  primary key (curp));
               
   CREATE TABLE IF NOT EXISTS Prestamo (idPrestamo int NOT NULL auto_increment, idPrestamista varchar(10) not null,
 nombrePrestamista varchar(80) not null, fechaPrestamo varchar(15) not null, motivo varchar( 100) not null, horaPrestamo varchar(5) not null,
 lugarPrestamo varchar(50), idDevolucion int not null auto_increment, primary key (idPrestamo),
 foreign key (idDevolucion) REFERENCES Devolucion (idDevolucion));
                                                   
                                                   
 CREATE TABLE IF NOT EXISTS Devolucion (idDevolucion int NOT NULL auto_increment, horaDevolucion varchar(5) not null, fechaDevolucion varchar(15) not null,
                                        comentario varchar(100) not null, presentaProblema varchar(2) not null,
                                        PRIMARY KEY (idDevolucion));
                                                     
 
CREATE TABLE IF NOT EXISTS ControlProyector (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             marca varchar(15) not null, salaAsignada varchar(10) not null,
                                             PRIMARY KEY (clave));
                                                          
CREATE TABLE IF NOT EXISTS Laptop (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             marca varchar(15) not null, modelo varchar(15) not null,
                                             PRIMARY KEY (clave));
                                                          
CREATE TABLE IF NOT EXISTS Cable (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             tipo varchar(15) not null,
                                             PRIMARY KEY (clave));                 
                                                          
CREATE TABLE IF NOT EXISTS Conector (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             tipo varchar(15) not null,
                                             PRIMARY KEY (clave));                                                                           
                                             
