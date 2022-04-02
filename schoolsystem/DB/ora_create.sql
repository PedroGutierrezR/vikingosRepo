/************ Update: Tables ***************/

/******************** Add Table: dbo.alumno ************************/

/* Build Table Structure */
CREATE TABLE dbo.alumno
(
	id_alumno INTEGER DEFAULT 'nextval('dbo.alumno_id_alumno_seq'::regclass)' NOT NULL,
	nombre VARCHAR(25) NOT NULL,
	apellido VARCHAR NOT NULL,
	fecha_nac DATE NOT NULL,
	curso_id INTEGER NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE dbo.alumno ADD CONSTRAINT pkalumno
	PRIMARY KEY (id_alumno);


/******************** Add Table: dbo.asignatura ************************/

/* Build Table Structure */
CREATE TABLE dbo.asignatura
(
	id_asignatura INTEGER DEFAULT 'nextval('dbo.asignatura_id_asignatura_seq'::regclass)' NOT NULL,
	descripcion VARCHAR(25) NOT NULL,
	tipo_asignatura_id INTEGER NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE dbo.asignatura ADD CONSTRAINT pkasignatura
	PRIMARY KEY (id_asignatura);


/******************** Add Table: dbo.curso ************************/

/* Build Table Structure */
CREATE TABLE dbo.curso
(
	id_curso INTEGER DEFAULT 'nextval('dbo.curso_id_curso_seq'::regclass)' NOT NULL,
	descripcion VARCHAR NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE dbo.curso ADD CONSTRAINT pkcurso
	PRIMARY KEY (id_curso);


/******************** Add Table: dbo.curso_asignatura ************************/

/* Build Table Structure */
CREATE TABLE dbo.curso_asignatura
(
	curso_id INTEGER NOT NULL,
	asignatura_id INTEGER NOT NULL,
	profesor_id INTEGER NOT NULL
) WITHOUT OIDS;


/******************** Add Table: dbo.profesor ************************/

/* Build Table Structure */
CREATE TABLE dbo.profesor
(
	id_profesor INTEGER DEFAULT 'nextval('dbo.profesor_id_profesor_seq'::regclass)' NOT NULL,
	nombre VARCHAR(25) NOT NULL,
	apellido VARCHAR(25) NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE dbo.profesor ADD CONSTRAINT pkprofesor
	PRIMARY KEY (id_profesor);


/******************** Add Table: dbo.tipo_asignatura ************************/

/* Build Table Structure */
CREATE TABLE dbo.tipo_asignatura
(
	id_tipo_asignatura INTEGER DEFAULT 'nextval('dbo.tipo_asignatura_id_tipo_asignatura_seq'::regclass)' NOT NULL,
	descripcion VARCHAR(25) NOT NULL
) WITHOUT OIDS;

/* Add Primary Key */
ALTER TABLE dbo.tipo_asignatura ADD CONSTRAINT pktipo_asignatura
	PRIMARY KEY (id_tipo_asignatura);





/************ Add Foreign Keys ***************/

/* Add Foreign Key: fk_alumno_curso */
ALTER TABLE dbo.alumno ADD CONSTRAINT fk_alumno_curso
	FOREIGN KEY (curso_id) REFERENCES dbo.curso (id_curso);

/* Add Foreign Key: fk_asignatura_tipo_asignatura */
ALTER TABLE dbo.asignatura ADD CONSTRAINT fk_asignatura_tipo_asignatura
	FOREIGN KEY (tipo_asignatura_id) REFERENCES dbo.tipo_asignatura (id_tipo_asignatura);

/* Add Foreign Key: fk_curso_asignatura_asignatura */
ALTER TABLE dbo.curso_asignatura ADD CONSTRAINT fk_curso_asignatura_asignatura
	FOREIGN KEY (asignatura_id) REFERENCES dbo.asignatura (id_asignatura);

/* Add Foreign Key: fk_curso_asignatura_curso */
ALTER TABLE dbo.curso_asignatura ADD CONSTRAINT fk_curso_asignatura_curso
	FOREIGN KEY (curso_id) REFERENCES dbo.curso (id_curso);

/* Add Foreign Key: fk_curso_asignatura_profesor */
ALTER TABLE dbo.curso_asignatura ADD CONSTRAINT fk_curso_asignatura_profesor
	FOREIGN KEY (profesor_id) REFERENCES dbo.profesor (id_profesor);