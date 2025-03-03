-- Tabla de Usuarios
CREATE TABLE USUARIOS (
    DNI_USUARIO NUMBER(15) GENERATED ALWAYS AS IDENTITY NOT NULL,
    NOMBRE VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(150)  NOT NULL,
    CONTRASEÑA VARCHAR2(100) NOT NULL,
    CONSTRAINT PK_USUARIOS PRIMARY KEY(DNI_USUARIO)
);

ALTER TABLE USUARIOS
ADD CONSTRAINT CK_EMAIL (EMAIL LIKE '%@%');

-- Tabla de Organizadores
CREATE TABLE ORGANIZADORES (
    ID_ORGANIZADOR NUMBER(15) GENERATED ALWAYS AS IDENTITY NOT NULL,
    NOMBRE VARCHAR(100) NOT NULL,
    TELEFONO NUMBER(9) NOT NULL,
    EMAIL VARCHAR2(150)  NOT NULL,
    ID_TIPOORGANIZADOR NUMBER(15),
    CONSTRAINT PK_ORGANZADORES PRIMARY KEY(ID_ORGANIZADOR),
    CONSTRAINT FK_ORGANIZADORES_TIPO_ORGANIZADOR FOREIGN KEY (ID_TIPOORGANIZADOR)
    REFERENCES TIPO_ORGANIZADOR(ID_TIPOORGANIZADOR)
);

ALTER TABLE ORGANIZADORES
ADD CONSTRAINT CK_EMAIL (EMAIL LIKE '%@%');

-- Tabla de Eventos
CREATE TABLE EVENTOS (
    ID_EVENTO NUMBER(15) GENERATED ALWAYS AS IDENTITY NOT NULL ,
    NOMBRE VARCHAR(100) NOT NULL,
    DESCRIPCION VARCHAR2(100),
    FECHA DATE NOT NULL,
    ID_TIPOEVENTOS NUMBER(15) NOT NULL,
    CONSTRAINT PK_EVENTO PRIMARY KEY(ID_EVENTO),
    CONSTRAINT FK_EVENTOS_TIPO_EVENTOS  FOREIGN KEY ( ID_TIPOEVENTOS )
    REFERENCES TIPO_EVENTOS(ID_TIPOEVENTOS )
);

ALTER TABLE EVENTOS
ADD CONSTRAINT CK_FECHA CHECK(FECHA >= SYSDATE);


-- Tabla de Inscripciones
CREATE TABLE INSCRIPCIONES (
    ID_INSCRIPCION NUMBER(15) GENERATED ALWAYS AS IDENTITY NOT NULL,
    DNI_USUARIO NUMBER(25) NOT NULL,
    ID_EVENTO NUMBER(15) NOT NULL,
    CONSTRAINT PK_INSCRIPCIONES PRIMARY KEY(ID_INSCRIPCION),
    CONSTRAINT FK_INSCRIPCIONES_USUARIOS FOREIGN KEY (DNI_USUARIO)
    REFERENCES USUARIO(DNI_USUARIO),
    CONSTRAINT FK_INSCRIPCIONES_EVENTOS FOREIGN KEY (ID_EVENTO) 
    REFERENCES EVENTOS(ID_EVENTO)
);

CREATE TABLE TIPO_ORGANIZADOR(
ID_TIPOORGANIZADOR NUMBER(15) NOT NULL,
NOMBRE VARCHAR2(25) NOT NULL,
TIPO VARCHAR2(1),
CONSTRAINT PK_TIPO_ORGANIZADOR PRIMARY KEY(ID_TIPOORGANIZADOR)
);
ALTER TABLE TIPO_ORGANIZADOR
ADD CONSTRAINT CK_TIPO CHECK(TIPO IN('E','I'));

CREATE TABLE TIPO_EVENTOS(
ID_TIPOEVENTOS NUMBER(15) NOT NULL,
NOMBRE VARCHAR2(25) NOT NULL,
TIPO VARCHAR2(1),
CONSTRAINT PK_TIPO_EVENTOS PRIMARY KEY(ID_TIPOEVENTOS)
);
ALTER TABLE TIPO_EVENTOS
ADD CONSTRAINT CK_TIPO CHECK(TIPO IN('T','C'));

CREATE TABLE ORGANIZAN(
ID_ORGANIZADOR NUMBER(15),
ID_EVENTO NUMBER(15),
FECHA DATE,
DIRECCION VARCHAR2(100),
CONSTRAINT PK_ORGANIZAN PRIMARY KEY (ID_ORGANIZADOR,ID_EVENTO,FECHA),
CONSTRAINT FK_ORGANIZAN_EVENTOS FOREIGN KEY (ID_EVENTO)
REFERENCES EVENTOS(ID_EVENTO),
CONSTRAINT FK_ORGANIZAN_ORGANIZADORES FOREIGN KEY (ID_ORGANIZADOR)
REFERENCES EVENTOS(ID_ORGANIZADOR)
);