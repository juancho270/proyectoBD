﻿--Universidad del Valle
--Escuela de Ingenieria de Sistemas
--Bases de Datos
--Camilo José Cruz Rivera--1428907
--Erik Lopez Pachco--1430406
--Robert leandro quiceno --1422913
--Juan Carlos Viteri --1427543
------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists RUTA CASCADE;
CREATE TABLE  RUTA(
  nombre VARCHAR(30) NOT NULL PRIMARY KEY,
	descripcion VARCHAR(100),fecha_inicio date, fecha_fenal 	date, franja_horaria VARCHAR(20)
   );

 
INSERT INTO RUTA VALUES('Ruta 1','descripcion ruta1', '2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 2','descripcion ruta2', '2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 3','descripcion ruta3', '2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 4','descripcion ruta4', '2000-11-31','2000-11-31','Nocturna'); 
INSERT INTO RUTA VALUES('Ruta 5','descripcion ruta5','2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 6','descripcion ruta6', '2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 7','descripcion ruta7', '2000-11-31','2000-11-31','Nocturna'); 
INSERT INTO RUTA VALUES('Ruta 8','descripcion ruta8', '2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 9','descripcion ruta9', '2000-11-31','2000-11-31','Nocturna'); 
INSERT INTO RUTA VALUES('Ruta 10','descripcion ruta10', '2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 11','descripcion ruta11', '2000-11-31','2000-11-31','Nocturna'); 
INSERT INTO RUTA VALUES('Ruta 12','descripcion ruta12', '2000-11-31','2000-11-31','Diurna'); 
INSERT INTO RUTA VALUES('Ruta 13','descripcion ruta13', '2000-11-31','2000-11-31','Diurna'); 


   
------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists BUS CASCADE;
CREATE TABLE  BUS(
  placa VARCHAR(15) NOT NULL,
	tipo INTEGER,
	nombre_ruta VARCHAR(30),
	CONSTRAINT BUS_PK PRIMARY KEY (placa),
	CONSTRAINT bus_ruta_fk FOREIGN KEY (nombre_ruta) REFERENCES RUTA (nombre)
   );
   
   
INSERT INTO BUS VALUES ('ABC-123',1,'Ruta 1');   
INSERT INTO BUS VALUES ('BCD-234',2,'Ruta 2');   
INSERT INTO BUS VALUES ('CDE-345',3,'Ruta 3');   
INSERT INTO BUS VALUES ('DEF-456',1,'Ruta 4');   
INSERT INTO BUS VALUES ('EFG-567',1,'Ruta 5');   
INSERT INTO BUS VALUES ('FGH-678',2,'Ruta 6');   
INSERT INTO BUS VALUES ('GHI-789',3,'Ruta 7');   
INSERT INTO BUS VALUES ('HIJ-890',1,'Ruta 8');   
INSERT INTO BUS VALUES ('IJK-901',1,'Ruta 9');   

------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE if exists TARJETA CASCADE;
CREATE TABLE  TARJETA
   (
  tarjeta_id INTEGER NOT NULL,
	saldo INTEGER,
	estado BOOLEAN,
	CONSTRAINT TARJETA_PK PRIMARY KEY (tarjeta_id)
   );

   
INSERT INTO TARJETA VALUES (1,5000,TRUE);   
INSERT INTO TARJETA VALUES (2,2000,TRUE);   
INSERT INTO TARJETA VALUES (3,0,TRUE);   
INSERT INTO TARJETA VALUES (4,3200,TRUE);   
INSERT INTO TARJETA VALUES (5,0,FALSE);   
INSERT INTO TARJETA VALUES (6,1800,TRUE);   
INSERT INTO TARJETA VALUES (7,2000,TRUE);   
INSERT INTO TARJETA VALUES (8,5000,TRUE);   
INSERT INTO TARJETA VALUES (9,3000,TRUE);   
INSERT INTO TARJETA VALUES (10,4000,TRUE);   
INSERT INTO TARJETA VALUES (11,0,FALSE);   
INSERT INTO TARJETA VALUES (12,0,FALSE);
INSERT INTO TARJETA VALUES (13,0,TRUE);  
INSERT INTO TARJETA VALUES (14,3500,TRUE);   
INSERT INTO TARJETA VALUES (15,0,FALSE);   
INSERT INTO TARJETA VALUES (16,9300,TRUE);   
INSERT INTO TARJETA VALUES (17,0,FALSE);   
 
   

--------------------------------------------------------------------------------------------------------------------------------
DROP TABLE if exists T_PERSONALIZADA CASCADE;
CREATE TABLE  T_PERSONALIZADA
   (
    tarjeta_id INTEGER NOT NULL,
  	avances_disponibles INTEGER,
	CONSTRAINT T_PERSONALIZADA_PK PRIMARY KEY (tarjeta_id),
	CONSTRAINT T_PERSONALIZADA_FK FOREIGN KEY (tarjeta_id) REFERENCES TARJETA (tarjeta_id));
	
	
INSERT INTO T_PERSONALIZADA VALUES(3,0);	
INSERT INTO T_PERSONALIZADA VALUES(6,3);	
INSERT INTO T_PERSONALIZADA VALUES(8,3);	
INSERT INTO T_PERSONALIZADA VALUES(9,3);	
INSERT INTO T_PERSONALIZADA VALUES(11,3);	
	

------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists VIAJE CASCADE;
CREATE TABLE  VIAJE
   (
  fecha DATE NOT NULL,
	hora TIME NOT NULL,
	tarjeta_id INTEGER NOT NULL,
	placa_bus VARCHAR(15) NOT NULL,
	CONSTRAINT VIAJE_PK PRIMARY KEY (fecha, hora, tarjeta_id, placa_bus),
  CONSTRAINT placa_bus_fk FOREIGN KEY (placa_bus) REFERENCES BUS (placa),
  CONSTRAINT tarjeta_id_fk FOREIGN KEY (tarjeta_id) REFERENCES TARJETA (tarjeta_id)
   );

INSERT INTO VIAJE ('2016-08-15', '05:45 AM', 1,'ABC-123');   
INSERT INTO VIAJE ('2016-08-15', '05:45 AM', 2,'ABC-123');   
INSERT INTO VIAJE ('2016-08-15', '05:45 AM', 3,'ABC-123');   
INSERT INTO VIAJE ('2016-08-15', '05:45 AM', 4,'ABC-123');   
INSERT INTO VIAJE ('2016-08-15', '05:45 AM', 5,'ABC-123');   
INSERT INTO VIAJE ('2016-08-16', '05:45 AM', 3,'BCD-234');   
INSERT INTO VIAJE ('2016-08-16', '05:45 AM', 4,'BCD-234');   
INSERT INTO VIAJE ('2016-08-16', '05:45 AM', 6,'CDE-345');   
INSERT INTO VIAJE ('2016-08-16', '05:45 AM', 7,'CDE-345');   
INSERT INTO VIAJE ('2016-08-16', '05:45 AM', 8,'DEF-456');   
INSERT INTO VIAJE ('2016-08-17', '05:45 AM', 3,'DEF-456');   
INSERT INTO VIAJE ('2016-08-17', '05:45 AM', 9,'EFG-567');   
INSERT INTO VIAJE ('2016-08-17', '05:45 AM', 10,'EFG-567');   
INSERT INTO VIAJE ('2016-08-17', '05:45 AM', 11,'HIJ-890');   
INSERT INTO VIAJE ('2016-08-17', '05:45 AM', 12,'HIJ-890');   
INSERT INTO VIAJE ('2016-08-17', '05:45 PM', 3,'BCD-234');   
INSERT INTO VIAJE ('2016-08-17', '05:45 PM', 4,'BCD-234');   
INSERT INTO VIAJE ('2016-08-17', '05:45 PM', 10,'ABC-123');   

   
------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists EMPLEADO CASCADE;
CREATE TABLE  EMPLEADO
   (
  empleado_id INTEGER NOT NULL,
	cedula INTEGER NOT NULL,
	nombre VARCHAR(15),
	apellido VARCHAR(15),
	telefono INTEGER,
	tipo_empleado VARCHAR(25),
	CONSTRAINT EMPLEADO_PK PRIMARY KEY (empleado_id)
   );
   
INSERT INTO EMPLEADO VALUES (1,12345,'Camilo', 'Cruz',342234,'director');
INSERT INTO EMPLEADO VALUES (2,2314324,'Juan Carlos', 'Viteri',552323,'auxiliar');
INSERT INTO EMPLEADO VALUES (3,546574,'Robert', 'Quiceno',42342,'conductor');
INSERT INTO EMPLEADO VALUES (4,568585,'Camilo', 'Cruz',4363633,'director');

-----------------------------------------------------------------------------------------------------------------------------
DROP TABLE if exists ESTACION CASCADE;
CREATE TABLE  ESTACION
   (
  nombre_estacion VARCHAR(30) NOT NULL,
	director_id INTEGER,
	CONSTRAINT ESTACION_PK PRIMARY KEY (nombre_estacion),
	CONSTRAINT director_id_fk FOREIGN KEY (director_id) REFERENCES EMPLEADO(empleado_id)
   );
   
INSERT INTO ESTACION VALUES ('Estacion 1', 1);   
INSERT INTO ESTACION VALUES ('Estacion 2', 1);   
INSERT INTO ESTACION VALUES ('Estacion 3', 4);   
INSERT INTO ESTACION VALUES ('Estacion 4', 4);   
INSERT INTO ESTACION VALUES ('Estacion 5', 1);   


------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists RUTA_ESTACION CASCADE;
CREATE TABLE  RUTA_ESTACION
   (
     id_ruta VARCHAR(30) NOT NULL,
     id_estacion VARCHAR(30) NOT NULL,
	   CONSTRAINT RUTA_ESTACION_PK PRIMARY KEY (id_ruta, id_estacion),
     CONSTRAINT id_ruta_fk FOREIGN KEY (id_ruta) REFERENCES RUTA (nombre),
     CONSTRAINT id_estacion_fk FOREIGN KEY (id_estacion) REFERENCES ESTACION (nombre_estacion)
   );

   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 1','Estacion 1');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 1','Estacion 2');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 1','Estacion 3');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 1','Estacion 4');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 1','Estacion 5');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 2','Estacion 1');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 2','Estacion 2');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 2','Estacion 3');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 2','Estacion 4');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 2','Estacion 5');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 2','Estacion 6');   
INSERT INTO RUTA_ESTACION VALUES ('Ruta 2','Estacion 7');   



------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists MANEJO_BUSES CASCADE;
CREATE TABLE  MANEJO_BUSES(
  conductor_id INTEGER NOT NULL,
	placa_bus VARCHAR(15) NOT NULL,
	turno TIME NOT NULL,
	CONSTRAINT MANEJO_BUS_PK PRIMARY KEY (conductor_id, placa_bus),
  CONSTRAINT conductor_id_fk FOREIGN KEY (conductor_id) REFERENCES EMPLEADO (empleado_id),
  CONSTRAINT placa_bus_fk FOREIGN KEY (placa_bus) REFERENCES BUS (placa)
   );
   


------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists VENTA_TARJETAS CASCADE;
CREATE TABLE  VENTA_TARJETAS
   (
  auxiliar_id INTEGER NOT NULL,
	nombre_estacion VARCHAR(30) NOT NULL,
	fecha DATE,
	tarjeta_id INTEGER NOT NULL,
	CONSTRAINT VENTA_TARJETA_PK PRIMARY KEY (auxiliar_id, nombre_estacion),
  CONSTRAINT auxiliar_id_fk FOREIGN KEY (auxiliar_id) REFERENCES EMPLEADO(empleado_id),
	CONSTRAINT nombre_est_fk FOREIGN KEY (nombre_estacion) REFERENCES ESTACION (nombre_estacion),
  CONSTRAINT tarjeta_id_fk FOREIGN KEY (tarjeta_id) REFERENCES TARJETA (tarjeta_id)
   );

INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-08-21', 1);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-08-21', 2);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-08-21', 3);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-08-21', 4);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-09-21', 5);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-09-21', 6);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-09-21', 7);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-09-21', 8);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-09-21', 9);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-09-21', 10);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-10-21', 11);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-10-21', 12);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-10-21', 13);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-10-21', 14);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-11-21', 15);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-11-21', 16);
INSERT INTO VENTA_TARJETAS VALUES(2,'Estacion 1','2016-11-21', 17);
------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists CLIENTE CASCADE;
CREATE TABLE  CLIENTE
   (
  cedula INTEGER NOT NULL,
	nombre VARCHAR (50),
	telefono INTEGER,
	tarjeta_id INTEGER,
	CONSTRAINT CLIENTE_PK PRIMARY KEY (cedula),
  CONSTRAINT tarjeta_id_fk FOREIGN KEY (tarjeta_id) REFERENCES T_PERSONALIZADA (tarjeta_id)
   );


INSERT INTO CLIENTE VALUES(123456,'Cliente 1',3113112313,3);
INSERT INTO CLIENTE VALUES(1242414,'Cliente 2',3113112313,6);
INSERT INTO CLIENTE VALUES(35232351,'Cliente 3',3113112313,8);
INSERT INTO CLIENTE VALUES(13413431,'Cliente 4',3113112313,9);
INSERT INTO CLIENTE VALUES(452335,'Cliente 5',3113112313,15);
INSERT INTO CLIENTE VALUES(2463634,'Cliente 6',3113112313,5);
INSERT INTO CLIENTE VALUES(434525,'Cliente 7',3113112313,10);
INSERT INTO CLIENTE VALUES(645642,'Cliente 8',3113112313,4);
INSERT INTO CLIENTE VALUES(465634,'Cliente 9',3113112313,7);
INSERT INTO CLIENTE VALUES(25235,'Cliente 10',3113112313,11);



------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists RECLAMOS CASCADE;
CREATE TABLE  RECLAMOS
   (
	num_tiquete INTEGER NOT NULL,
	cedula_cliente INTEGER,
	fecha DATE,
	motivo VARCHAR,
	descripcion VARCHAR,
	CONSTRAINT RECLAMO_PK PRIMARY KEY (num_tiquete),
	CONSTRAINT CEDULA_FK FOREIGN KEY cedula_cliente REFERENCES CLIENTE(cedula);
   );
   
INSERT INTO RECLAMOS VALUES (1,123456,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,1242414,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,35232351,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,13413431,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,452335,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,2463634,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,434525,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,645642,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,465634,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   
INSERT INTO RECLAMOS VALUES (1,25235,'2016-08-15','Demora','El bus se demoró 2 horas en pasar');   

------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists MEDIDAS CASCADE;
CREATE TABLE  MEDIDAS
   (
  num_tiquete INTEGER NOT NULL,
	medida VARCHAR,
	CONSTRAINT MEDIDAS_PK PRIMARY KEY (num_tiquete),
  CONSTRAINT num_tiquete_fk FOREIGN KEY (num_tiquete) REFERENCES RECLAMOS (num_tiquete)
   );

------------------------------------------------------------------------------------------------------------------------------------------

DROP TABLE if exists RECLAMOS_REALIZADOS CASCADE;
CREATE TABLE  RECLAMOS_REALIZADOS
   (
  num_tiquete INTEGER NOT NULL,
	auxiliar_id INTEGER NOT NULL,
	tarjeta_id INTEGER NOT NULL,
	CONSTRAINT RECLAMOS_REALIZADOS_PK PRIMARY KEY (num_tiquete, auxiliar_id, tarjeta_id),
	CONSTRAINT num_tiquete_fk FOREIGN KEY (num_tiquete) REFERENCES RECLAMOS (num_tiquete),
  CONSTRAINT auxiliar_id_fk FOREIGN KEY (auxiliar_id) REFERENCES EMPLEADO (empleado_id),
	CONSTRAINT tarjeta_id_fk FOREIGN KEY (tarjeta_id) REFERENCES TARJETA (tarjeta_id)
);


---------------------------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS turno CASCADE;

CREATE TABLE turno(
	id_turno VARCHAR(10) NOT NULL,
	fecha date,
	hora_inicio time,
	hora_fin time,
	CONSTRAINT turno_pk PRIMARY KEY (id_turno)
);



-----------------------------------