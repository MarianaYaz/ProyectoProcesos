drop database prestamos;
CREATE SCHEMA IF NOT EXISTS Prestamos;
USE  Prestamos;

  CREATE TABLE IF NOT EXISTS Encargado(curp varchar(18) NOT NULL, 
  nombre varchar(200) NOT NULL, 
  numPersonal varchar(20) NOT NULL, turno varchar(30) NOT NULL, 
  primary key (curp));
  
  
CREATE TABLE IF NOT EXISTS Jefe(curp varchar(18) NOT NULL, 
  nombre varchar(200) NOT NULL, 
  numPersonal varchar(20) NOT NULL, 
  primary key (curp));
  
  
CREATE TABLE IF NOT EXISTS Credenciales(
  correoElectronico varchar(100) NOT NULL, contrasenia blob NOT NULL, tipo varchar(50) NOT NULL,
  primary key (correoElectronico));
  
CREATE TABLE IF NOT EXISTS Prestamo (idPrestamo int NOT NULL auto_increment, idPrestamista varchar(12) not null,
 nombrePrestamista varchar(80) not null, fechaPrestamo varchar(15) not null, motivo varchar( 100) not null, horaPrestamo varchar(5) not null,
 lugarPrestamo varchar(50), primary key (idPrestamo));
  
   CREATE TABLE IF NOT EXISTS Devolucion (idDevolucion int NOT NULL auto_increment, horaDevolucion varchar(5) not null, fechaDevolucion varchar(15) not null,
                                        comentario varchar(100) not null, presentaProblema varchar(2) not null, idPrestamo int NOT NULL,
                                        PRIMARY KEY (idDevolucion), foreign key (idPrestamo) REFERENCES Prestamo(idPrestamo));
               

 
                                                   
                                                   

                                                     
 
CREATE TABLE IF NOT EXISTS ControlProyector (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             marca varchar(15) not null, salaAsignada varchar(10) not null,
                                             PRIMARY KEY (clave));
                                                          
CREATE TABLE IF NOT EXISTS Laptop (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             marca varchar(15) not null, modelo varchar(30) not null,
                                             PRIMARY KEY (clave));
                                                          
CREATE TABLE IF NOT EXISTS Cable (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             tipo varchar(15) not null,
                                             PRIMARY KEY (clave));                 
                                                          
CREATE TABLE IF NOT EXISTS Conector (clave varchar(12) not null, estado varchar(15) not null, 
                                             fechaRegistro varchar(15) not null, descripcion varchar(50) not null,
                                             tipo varchar(15) not null,
                                             PRIMARY KEY (clave));   
                                                         
                                                          
INSERT INTO Conector (clave, estado, fechaRegistro, descripcion, tipo) 
VALUES ('FEI-CON-001', 'Disponible','2020-05-17', 'Conector HDMI color negro','HDMI');
                                                          
INSERT INTO Conector (clave, estado, fechaRegistro, descripcion, tipo) 
VALUES ('FEI-CON-002', 'Disponible','2020-05-17', 'Conector VGA color azul','VGA');
                                                          
INSERT INTO Conector (clave, estado, fechaRegistro, descripcion, tipo) 
VALUES ('FEI-CON-003', 'Disponible','2020-05-17', 'Conector HDMI color rojo','HDMI');
                                                       
INSERT INTO Laptop (clave, estado, fechaRegistro, descripcion, marca, modelo) 
VALUES ('FEI-LAP-100', 'Disponible','2020-05-17', 'Laptop color negra para préstamos','Lenovo', 'ideapad330');
                                                          
INSERT INTO Laptop (clave, estado, fechaRegistro, descripcion, marca, modelo) 
VALUES ('FEI-LAP-101', 'Disponible','2020-05-17', 'Laptop color gris para préstamos','Dell', 'Inspiron serie 3000');
                                                          
INSERT INTO Laptop (clave, estado, fechaRegistro, descripcion, marca, modelo) 
VALUES ('FEI-LAP-102', 'Disponible','2020-05-17', 'Laptop color azul para préstamos','Lenovo', 'Yoga 530-14arr'); 
                                                                                                                    

INSERT INTO ControlProyector (clave, estado, fechaRegistro, descripcion, marca, salaAsignada) 
VALUES ('FEI-CNT-200', 'Disponible','2020-05-17', 'Control del proyector de la sala CC2','Epson', 'CC2');
                                                          
INSERT INTO ControlProyector (clave, estado, fechaRegistro, descripcion, marca, salaAsignada) 
VALUES ('FEI-CNT-201', 'Disponible','2020-05-17', 'Control del proyector de la sala CC3','BENQ', 'CC3');
                                                          
INSERT INTO ControlProyector (clave, estado, fechaRegistro, descripcion, marca, salaAsignada) 
VALUES ('FEI-CNT-202', 'Disponible','2020-05-17', 'Control del proyector de la sala CC1','BENQ', 'CC1');

INSERT INTO Cable (clave, estado, fechaRegistro, descripcion, tipo) 
VALUES ('FEI-CAB-154', 'Disponible','2020-05-17', 'Cable de extensión color naranja','Extensión'); 
                                                          
INSERT INTO Cable (clave, estado, fechaRegistro, descripcion, tipo) 
VALUES ('FEI-CAB-155', 'Disponible','2020-05-17', 'Cable de ethernet color azul','Ethernet'); 
                                                          
INSERT INTO Cable (clave, estado, fechaRegistro, descripcion, tipo) 
VALUES ('FEI-CAB-156', 'Disponible','2020-05-17', 'Cable USB de tipo C color negro','USB-C'); 

CREATE TABLE IF NOT EXISTS PrestamoConector(idPrestamo int , claveDispositivo varchar(12) , foreign key (idPrestamo) REFERENCES Prestamo(idPrestamo), foreign key (claveDispositivo) REFERENCES Conector(clave));
CREATE TABLE IF NOT EXISTS PrestamoCable(idPrestamo int , claveDispositivo varchar(12) , foreign key (idPrestamo) REFERENCES Prestamo(idPrestamo), foreign key (claveDispositivo) REFERENCES Cable(clave));
CREATE TABLE IF NOT EXISTS PrestamoLaptop(idPrestamo int , claveDispositivo varchar(12) , foreign key (idPrestamo) REFERENCES Prestamo(idPrestamo), foreign key (claveDispositivo) REFERENCES Laptop(clave));
CREATE TABLE IF NOT EXISTS PrestamoControlProyector(idPrestamo int , claveDispositivo varchar(12) , foreign key (idPrestamo) REFERENCES Prestamo(idPrestamo), foreign key (claveDispositivo) REFERENCES ControlProyector(clave));

alter table devolucion drop column presentaProblema;    

create user 'empleado'@'localhost' IDENTIFIED BY 'password1';

GRANT SELECT,INSERT,DELETE,UPDATE ON prestamos.* TO 'empleado'@'localhost';


