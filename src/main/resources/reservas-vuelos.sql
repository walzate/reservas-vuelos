-- CREACION DEL USUARIO (LA CLAVE ES: reservas_vuelos)
CREATE ROLE reservas_vuelos LOGIN
  ENCRYPTED PASSWORD 'md5dfb56977134faab574fde0fa87a26dea'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;
  
--CREACION DE LA BASE DE DATOS
CREATE DATABASE reservas_vuelos OWNER reservas_vuelos;

--CREACION DE TABLAS
CREATE TABLE PASAJERO (
  ID SERIAL NOT NULL,
  NOMBRE VARCHAR(45) NOT NULL,
  DIRECCION VARCHAR(45) NULL,
  TELEFONO VARCHAR(45) NULL,
  PRIMARY KEY (ID)
);
ALTER TABLE PASAJERO OWNER TO reservas_vuelos;


CREATE TABLE AVION (
  ID SERIAL NOT NULL,
  MODELO INT NULL,
  CAPACIDAD INT NOT NULL,
  FABRICANTE VARCHAR(45) NULL,
  PRIMARY KEY (ID)
);
ALTER TABLE AVION OWNER TO reservas_vuelos;

CREATE TABLE RUTA (
  ID SERIAL NOT NULL,
  AEROPUERTO_ORIGEN VARCHAR(45) NOT NULL,
  AEROPUERTO_DESTINO VARCHAR(45) NOT NULL,
  DURACION TIME NOT NULL,
  PRIMARY KEY (ID)
);
ALTER TABLE RUTA OWNER TO reservas_vuelos;

CREATE TABLE VUELO (
  ID SERIAL NOT NULL,
  FECHA DATE NOT NULL,
  HORA_INICIO TIME NOT NULL,
  ID_AVION  INT NOT NULL,
  ID_RUTA  INT NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (ID_AVION) REFERENCES AVION (ID),
  FOREIGN KEY (ID_RUTA) REFERENCES RUTA (ID)
);
ALTER TABLE VUELO OWNER TO reservas_vuelos;

CREATE TABLE PASAJERO_POR_VUELO (
  ID SERIAL NOT NULL,
  ID_PASAJERO  INT NOT NULL,
  ID_VUELO  INT NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (ID_PASAJERO) REFERENCES PASAJERO (ID),
  FOREIGN KEY (ID_VUELO) REFERENCES VUELO (ID)
);
ALTER TABLE PASAJERO_POR_VUELO OWNER TO reservas_vuelos;