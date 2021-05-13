drop database Prestamos;
CREATE SCHEMA IF NOT EXISTS Prestamos;
USE  Prestamos;

CREATE TABLE IF NOT EXISTS Encargado(curp varchar(18) NOT NULL, 
  nombre varchar(200) NOT NULL, 
  numPersonal varchar(20) NOT NULL, turno varchar(30) NOT NULL, 
  correoElectronico varchar(100) NOT NULL, contrasenia blob NOT NULL,
  primary key (curp));