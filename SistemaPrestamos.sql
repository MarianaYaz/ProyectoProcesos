drop database Prestamos;
CREATE SCHEMA IF NOT EXISTS Prestamos;
USE  Prestamos;

CREATE TABLE IF NOT EXISTS Encargado(curp varchar(18) NOT NULL, 
  nombre varchar(200) NOT NULL, curpJefe varchar(18) NOT NULL, 
  numPersonal varchar(20) NOT NULL, turno varchar(30) NOT NULL, 
  primary key (curp),foreign key(curpJefe) references Jefe(curp));
  
  CREATE TABLE IF NOT EXISTS inicioSesion(correoElectronico varchar(100) NOT NULL,
  contrasenia blob NOT NULL,primary key(correoEkectronico,contrasenia));
 
CREATE TABLE IF NOT EXISTS Jefe(curp varchar(18) NOT NULL, 
  nombre varchar(200) NOT NULL, 
  numPersonal varchar(20) NOT NULL,
  primary key (curp));
  
   CREATE TABLE IF NOT EXISTS Prestamo (idPrestamo int NOT NULL auto_increment, idPrestamista varchar(10) not null,
 nombrePrestamista varchar(80) not null, fechaPrestamo varchar(15) not null, motivo varchar( 100) not null, horaPrestamo varchar(5) not null,
 lugarPrestamo varchar(50), idDevolucion int not null auto_increment, primary key (idPrestamo),
 foreign key (idDevolucion) REFERENCES Devolucion (idDevolucion));
 
