/*  alter session set “_ORACLE_SCRIPT”=true;
	CREATE USER booklet IDENTIFIED BY 1234;
	GRANT ALL PRIVILEGES TO booklet;
	DISCONNECT booklet;
	CONNECT booklet;
 */

CREATE TABLE libro(
	id_libro NUMBER NOT NULL,
	titulo VARCHAR2(100) NOT NULL,
	anio NUMBER NOT NULL,
	autor VARCHAR2(100) NOT NULL,
	imprenta VARCHAR2(100) NOT NULL,
	disponibilidad VARCHAR2(20) DEFAULT 'DISPONIBLE' NOT NULL,
	PRIMARY KEY(id_libro)
);

SELECT * FROM libro;

