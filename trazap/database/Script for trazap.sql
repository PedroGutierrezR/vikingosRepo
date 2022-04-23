/*  alter session set “_ORACLE_SCRIPT”=true;
	CREATE USER trazap IDENTIFIED BY 1234;
	GRANT ALL PRIVILEGES TO trazap;
	DISCONNECT trazap;
	CONNECT trazap;
*/

create table proveedores (
	id_proveedor integer NOT NULL primary key, 
	rut_proveedor varchar2(10),
	razon_social varchar2(40)
);

create table pedidos (
	id_pedido integer NOT NULL primary key, 
	fecha_ingreso date,
	fecha_recibido DATE
);
 
create table detalle_pedido (
	id_detalle_pedido integer NOT NULL primary key, 
	proveedor_producto_id integer,
	pedido_id integer,
	cantidad integer,
	FOREIGN KEY (pedido_id) REFERENCES pedidos(id_pedido),
	FOREIGN KEY (proveedor_producto_id) REFERENCES productos_proveedores(id_producto_proveedor)
);

create table trazabilidad (
	id_trazabilidad integer NOT NULL primary key, 
	pedido_id integer,
	fecha_inicio_preparacion DATE,
	fecha_fin_preparacion DATE,
	fecha_estimada_envio DATE,
	fecha_envio DATE,
	codigo_trazabilidad varchar2(40),
	trazabilidad_estado_id integer,
	FOREIGN KEY (pedido_id) REFERENCES pedidos(id_pedido),
	FOREIGN KEY (trazabilidad_estado_id) REFERENCES estado_trazabilidad(id_estado_trazabilidad)
);

create table estado_trazabilidad (
	id_estado_trazabilidad integer NOT NULL primary key, 
	descripcion VARCHAR2(40)
);

CREATE SEQUENCE estado_trazabilidad_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;
SELECT * FROM  ESTADO_TRAZABILIDAD;
TRUNCATE TABLE ESTADO_TRAZABILIDAD;

create table productos_proveedores (
	id_producto_proveedor integer NOT null primary key, 
	producto_id  integer,
	proveedor_id integer,
	FOREIGN KEY(producto_id) REFERENCES productos (id_producto),
	FOREIGN KEY(proveedor_id) REFERENCES proveedores (id_proveedor)
);

create table productos_bodega (
	id_producto_bodega integer NOT null primary key, 
	producto_id integer,
	bodega_id integer,
	stock integer,
	FOREIGN KEY(producto_id) REFERENCES productos (id_producto),
	FOREIGN KEY(bodega_id) REFERENCES bodega (id_bodega)
);

create table bodega (
	id_bodega integer NOT NULL primary key, 
	descripcion varchar2(40)
);

CREATE SEQUENCE bodega_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;

SELECT * FROM bodega;

create table categoria_producto (
	id_categoria_producto integer NOT null primary key, 
	desripcion varchar2(40)
);

--me equivoque en el nombre de la columna en la tabla categoria_producto... pero con esto se arregla
ALTER TABLE categoria_producto RENAME COLUMN desripcion TO descripcion;

CREATE SEQUENCE categoria_producto_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;

create table tipo_producto (
	id_tipo_producto integer NOT NULL primary key, 
	descripcion varchar2(40)
);

create table productos (
	id_producto integer NOT null primary key, 
	descripcion varchar2(40),
	categoria_producto_id integer,
	tipo_producto_id integer,
	FOREIGN KEY(tipo_producto_id) REFERENCES tipo_producto (id_tipo_producto),
	FOREIGN KEY(categoria_producto_id) REFERENCES categoria_producto (id_categoria_producto)
);