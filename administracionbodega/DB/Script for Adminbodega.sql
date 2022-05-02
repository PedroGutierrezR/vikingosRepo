/*  alter session set “_ORACLE_SCRIPT”=true;
	CREATE USER adminbodega IDENTIFIED BY 1234;
	GRANT ALL PRIVILEGES TO adminbodega;
	DISCONNECT adminbodega;
	CONNECT adminbodega;
 */

create table bodega (
id_bodega integer NOT NULL primary key, 
nombre_bodega varchar2(50),
fecha_ingreso DATE
);

create table materiales (
id_producto integer NOT NULL primary key, 
bodega_id integer NOT NULL,
precio integer,
nombre_producto varchar2(50),
fecha_ingreso DATE,
FOREIGN KEY(bodega_id) REFERENCES bodega (id_bodega)
);

DROP TABLE MATERIALES ;
SELECT * FROM materiales;
SELECT * FROM bodega;

CREATE TABLE usuario (
id_usuario integer NOT NULL PRIMARY KEY, 
nombre varchar2(25),
email varchar2(30),
password varchar2(255),
rol_id integer NOT NULL,
FOREIGN KEY (rol_id) REFERENCES rol(id_rol)
);

CREATE TABLE rol (
id_rol integer NOT NULL PRIMARY KEY, 
descripcion varchar2(10)
);