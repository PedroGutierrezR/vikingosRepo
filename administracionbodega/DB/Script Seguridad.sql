CREATE TABLE usuario (
id_usuario integer NOT NULL primary key, 
nombre varchar2(25),
email varchar2(30),
password varchar2(255),
rol_id integer NOT NULL,
FOREIGN KEY (rol_id) REFERENCES rol(id_rol)
);

CREATE TABLE rol (
id_rol integer NOT NULL primary key, 
descripcion varchar2(10)
);	

SELECT * FROM USUARIO u ;

