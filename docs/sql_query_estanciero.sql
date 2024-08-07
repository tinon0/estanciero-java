CREATE DATABASE grupo6_estanciero
go
use grupo6_estanciero
go
CREATE TABLE TIPOS_BARAJAS(
id_tipo_baraja INT,--PK
tipo VARCHAR(200)
CONSTRAINT pk_tipos_barajas PRIMARY KEY(id_tipo_baraja)
)

CREATE TABLE JUGADORES(
id_jugador INT,--PK
jugador VARCHAR(200),
cant_victorias INT,
cant_derrotas INT
CONSTRAINT pk_jugadores PRIMARY KEY(id_jugador)
)

CREATE TABLE TIPOS_TARJETAS(
id_tipo_tarjeta INT,--PK
descripcion VARCHAR(500)
CONSTRAINT pk_tipos_tarjetas PRIMARY KEY(id_tipo_tarjeta)
)

CREATE TABLE TIPOS_EFECTOS(
id_tipo_efecto INT,--PK
descripcion VARCHAR(500)
CONSTRAINT pk_tipos_efectos PRIMARY KEY(id_tipo_efecto)
)

CREATE TABLE TIPOS_MODOS(
id_tipo_modo INT,--PK
descripcion VARCHAR(500)
CONSTRAINT pk_tipos_modos PRIMARY KEY(id_tipo_modo)
)

CREATE TABLE TIPOS_JUGADORES(
id_tipo_jugador INT,--PK
tipo varchar(50)--ENTERO PARA SEPARARLO POR TIPOS
CONSTRAINT pk_tipos_jugadores PRIMARY KEY(id_tipo_jugador)
)

CREATE TABLE TIPOS_CELDAS(
id_tipo_celda INT,--PK
descripcion VARCHAR(500)
CONSTRAINT pk_tipos_celdas PRIMARY KEY(id_tipo_celda)
)

CREATE TABLE CELDAS(
id_celda INT,--PK
id_tipo_celda INT
CONSTRAINT pk_celdas PRIMARY KEY(id_celda),
CONSTRAINT fk_tipos_celdas_celdas FOREIGN KEY(id_tipo_celda)
REFERENCES TIPOS_CELDAS (id_tipo_celda)
)

CREATE TABLE PROVINCIAS(
id_provincia INT,--PK
descripcion VARCHAR(500)
CONSTRAINT pk_provincias PRIMARY KEY(id_provincia)
)

CREATE TABLE PROPIEDADES(
id_propiedad INT,--PK
nombre VARCHAR(200),
id_provincia INT,
precio_compra int,
precio_mejora int,
alquiler_base int,
alquiler_1chacra int,
alquiler_2chacra int,
alquiler_3chacra int,
alquiler_4chacra int,
alquiler_1estancia int,
valor_hipotecario int,
id_celda INT
CONSTRAINT pk_propiedades PRIMARY KEY(id_propiedad),
CONSTRAINT fk_id_provincia_propiedades FOREIGN KEY (id_provincia)
REFERENCES PROVINCIAS(id_provincia),
CONSTRAINT fk_celdas_propiedades FOREIGN KEY(id_celda)
REFERENCES CELDAS(id_celda)
)

CREATE TABLE POSESIONES(
id_posesion INT,--PK
nombre VARCHAR(200),
precio MONEY,
id_celda INT
CONSTRAINT pk_posesiones PRIMARY KEY(id_posesion),
CONSTRAINT fk_celdas_posesiones FOREIGN KEY(id_celda)
REFERENCES CELDAS(id_celda)
)




CREATE TABLE PARTIDAS_GUARDADAS(
id_partida INT,--PK
nombre_partida VARCHAR(100),
id_jugador INT,
id_tipo_modo INT,
ultimo_turno INT,
valor_ganar INT
CONSTRAINT pk_partidas_guardadas PRIMARY KEY(id_partida),
CONSTRAINT fk_jugadores_partidas_guardadas FOREIGN KEY(id_jugador)
REFERENCES JUGADORES(id_jugador),
CONSTRAINT fk_tipos_modos_partidas_guardadas FOREIGN KEY(id_tipo_modo)
REFERENCES TIPOS_MODOS(id_tipo_modo)
)

CREATE TABLE TARJETAS(
id_tarjeta INT,--PK
mensaje VARCHAR(600),
effecto_modificador int,
id_tipo_efecto INT,
id_tipo_tarjeta INT
CONSTRAINT pk_tarjetas PRIMARY KEY(id_tarjeta),
CONSTRAINT fk_tipos_efectos_tarjetas FOREIGN KEY(id_tipo_efecto)
REFERENCES TIPOS_EFECTOS(id_tipo_efecto),
CONSTRAINT fk_tipos_tarjetas_tarjetas FOREIGN KEY(id_tipo_tarjeta)
REFERENCES TIPOS_TARJETAS(id_tipo_tarjeta)
)

CREATE TABLE ORDEN_BARAJAS(
id_orden INT,--PK
id_partida INT,
id_tipo_baraja INT,
orden INT,--CHEQUEAR
id_tarjeta INT
CONSTRAINT pk_orden_barajas PRIMARY KEY(id_orden),
CONSTRAINT fk_partidas_orden_barajas FOREIGN KEY(id_partida)
REFERENCES PARTIDAS_GUARDADAS(id_partida),
CONSTRAINT fk_tipos_barajas_partidas FOREIGN KEY(id_tipo_baraja)
REFERENCES TIPOS_BARAJAS(id_tipo_baraja),
CONSTRAINT fk_tarjetas_orden_barajas FOREIGN KEY(id_tarjeta)
REFERENCES TARJETAS(id_tarjeta)
)

CREATE TABLE DETALLES_PARTIDAS_GUARDADAS(
id_detalle INT,--PK
id_partida INT,
jugador VARCHAR(200),
id_tipo_jugador INT,
dinero MONEY,
orden_turnos INT --CHEQUEAR
CONSTRAINT pk_detalles_partidas_guardadas PRIMARY KEY(id_detalle),
CONSTRAINT fk_partidas_detalles_partidas_guardadas FOREIGN KEY(id_partida)
REFERENCES PARTIDAS_GUARDADAS(id_partida),
CONSTRAINT fk_tipos_jugadores_detalles_partidas_guardadas FOREIGN KEY(id_tipo_jugador)
REFERENCES TIPOS_JUGADORES(id_tipo_jugador)
)

CREATE TABLE PROPIEDADES_x_DETALLES(
id_PROPIEDADES_x_DETALLES INT,--PK
id_propiedad INT,
id_detalle int,
chacra INT, --CHEQUEAR
estancia INT --CHEQUEAR
CONSTRAINT pk_PROPIEDADES_x_DETALLES PRIMARY KEY (id_PROPIEDADES_x_DETALLES),
CONSTRAINT fk_propiedades_PROPIEDADES_x_DETALLES FOREIGN KEY (id_propiedad)
REFERENCES PROPIEDADES(id_propiedad),
constraint fk_detalle_PROPIEDADES_x_DETALLES foreign key (id_detalle)
references DETALLES_PARTIDAS_GUARDADAS(id_detalle)
)


CREATE TABLE POSESIONES_x_DETALLES(
id_posesione_x_detalle INT,--PK
id_posesion INT,
id_detalle int
CONSTRAINT pk_POSESIONES_x_DETALLES PRIMARY KEY(id_posesione_x_detalle),
CONSTRAINT fk_posesiones_posesiones_X_detalles FOREIGN KEY(id_posesion)
REFERENCES POSESIONES(id_posesion),
constraint fk_DETALLES_PARTIDAS_GUARDADAS_posesiones_X_detalles foreign key(id_detalle)
references DETALLES_PARTIDAS_GUARDADAS(id_detalle)
)


go

insert into TIPOS_JUGADORES(id_tipo_jugador,tipo) 
values 
	(1,'usuario'),
	(2,'bot agresivo'),
	(3,'bot equilibrado'),
	(4,'bot conservador');


insert into TIPOS_MODOS(id_tipo_modo,descripcion)
values 
	(1,'dificil'),
	(2,'normal'),
	(3,'facil');

INSERT INTO TIPOS_CELDAS (id_tipo_celda, descripcion) VALUES
(1, 'propiedades'),
(2, 'suerte'),
(3, 'destino'),
(4, 'premio'),
(5, 'salida'),
(6, 'impuesto'),
(7, 'ferrocarril'),
(8, 'compania'),
(9, 'comisaria'),
(10, 'marche preso'),
(11, 'libre estacionamiento'),
(12, 'descanso');

insert into TIPOS_BARAJAS(id_tipo_baraja,tipo)
values 
	(1,'destino'),
	(2,'suerte');

insert into TIPOS_TARJETAS(id_tipo_tarjeta,descripcion)
values 
	(1,'destino'),
	(2,'suerte');
INSERT INTO TIPOS_EFECTOS(id_tipo_efecto,descripcion) VALUES
(1, 'pagar'),
(2, 'movimiento'),
(3, 'cobrar'),
(4, 'marche preso'),
(5, 'salir de la comisaria'),
(6, 'pagar o suerte');

INSERT INTO provincias (id_provincia, descripcion) VALUES
(1, 'Formosa'),
(2, 'Rio Negro'),
(3, 'Salta'),
(4, 'Mendoza'),
(5, 'Santa Fe'),
(6, 'Tucuman'),
(7, 'Cordoba'),
(8, 'Buenos Aires');

INSERT INTO TARJETAS (id_tarjeta, id_tipo_tarjeta,effecto_modificador, id_tipo_efecto, mensaje) VALUES
    (1, 1,null, 5, 'Con esta tarjeta sale usted de la comisaria. Conservela hasta utilizarla o venderla.'),
    (2, 1,14, 4, 'Marche preso directamente.'),
    (3, 1,0, 2, 'Siga hasta la salida.'),
    (4, 1,1, 2, 'Vuelve atras hasta Formosa Zona Sur'),
    (5, 1,1000, 1, 'Gastos de Farmacia. Pague 1000'),
    (6, 1,1000, 1, 'Pague su poliza de seguro con 1000'),
    (7, 1,200, 6, 'Pague 200 de multa o levante una tarjeta de SUERTE'),
    (8, 1,2000, 3, 'Ha obtenido un segundo premio de belleza. Cobre 2000'),
    (9, 1,200, 3, 'Es su cumpleaños. Cobre 200 de cada uno de sus jugadores.'),
    (10, 1,400, 3, 'Devolucion de impuesto. Cobre 400'),
    (11, 1,1000, 3, 'Por venta de acciones. cobre 1000'),
    (12, 1,4000, 3, 'Error en los calculos del Banco. Cobre 4000'),
    (13, 1,2000, 3, 'ha ganado un concurso agricola. Cobre 2000'),
    (14, 1,2000, 3, 'Ha ganado un concurso ganadero. Cobre 2000'),
    (15, 1,500, 3, '5% de interes sobre cedulas hipotecarias. Cobre 500'),
    (16, 1,2000, 3, 'Hereda 2000'),
    (17, 2,null, 5, 'Habeas Corpus concedido. Con esta tarjeta sale Usted gratuitamente de la Comisaria. Conservela o vendala'),
    (18, 2,14, 4, 'Marche preso directamente'),
    (19, 2,1000, 3, 'Cobre 1000 por intereses bancarios.'),
    (20, 2,10000, 3, 'Ha ganado la grande. Cobre 10000'),
    (21, 2,3000, 3, 'Gano en las carreras. Cobre 3000'),
    (22, 2,400, 1, 'Multa caminera. Pague 400'),
    (23, 2,2500500, 1, 'Sus propiedades tienen que ser reparadas. Pague al Banco 500 por cada chacra y 2500 por cada estancia.'),
    (24, 2,300, 1, 'Multa por exceso de velocidad. Pague 300'),
    (25, 2,4000800, 1, 'Por compra de semilla pague al Banco 800 por cada chacra. 4000 por cada estancia'),
    (26, 2,3000, 1, 'Pague 3000 por gastos colegiales.'),
    (27, 2,0, 3, 'Siga hasta la salida.'),
    (28, 2,3, 3, 'Vuelva tres pasos atras.'),
    (29, 2,26, 3, 'Siga hasta Santa Fe Zona Norte. Si pasa por la salida Cobre 5000'),
    (30, 2,16, 3, 'Haga un paseo hasta la Bodega. Si pasa por la salida cobre 5000'),
    (31, 2,11, 3, 'Siga hasta Salta Zona Norte. Si pasa por la salida cobre 5000'),
    (32, 2,40, 3, 'Siga hasta Buenos Aires, Zona Norte.');

INSERT INTO CELDAS (id_celda, id_tipo_celda) VALUES
(0, 5),
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 1),
(6, 1),
(7, 4),
(8, 8),
(9, 1),
(10, 3),
(11, 1),
(12, 7),
(13, 1),
(14, 9),
(15, 2),
(16, 8),
(17, 1),
(18, 7),
(19, 1),
(20, 1),
(21, 12),
(22, 7),
(23, 1),
(24, 1),
(25, 3),
(26, 1),
(27, 7),
(28, 11),
(29, 1),
(30, 1),
(31, 6),
(32, 1),
(33, 1),
(34, 1),
(35, 10),
(36, 2),
(37, 1),
(38, 3),
(39, 1),
(40, 1),
(41, 6);

-- Insert propiedades

INSERT INTO PROPIEDADES (id_propiedad, id_provincia, id_celda, precio_compra,precio_mejora,alquiler_base,alquiler_1chacra,alquiler_2chacra,alquiler_3chacra,alquiler_4chacra,alquiler_1estancia, valor_hipotecario, nombre) VALUES
(1, 1, 1, 1000,1000,40,200,600,1700,3000,4750, 500, 'Zona Sur'),
(2, 1, 2, 1000,1000,40,200,600,1700,3000,4750, 500, 'Zona Centro'),
(3, 1, 3, 1200,1000,80,400,800,3400,6000,9500, 600, 'Zona Norte'),
(4, 2, 5, 2000,1000,110,570,1700,5150,7600,9500, 1000, 'Zona Sur'),
(5, 2, 6, 2200,1000,150,750,2000,5700,8500,11500, 1100, 'Zona Norte'),
(6, 3, 9, 2600,1500,200,1000,2800,8500,12000,14200, 1300, 'Zona Sur'),
(7, 3, 11, 2600,1500,200,1000,2800,8500,12000,14200, 1300, 'Zona Centro'),
(8, 3, 13, 3000,1500,230,1150,3400,9500,13000,17000, 1500, 'Zona Norte'),
(9, 4, 17, 3400,2000,250,1350,3800,10500,14200,18000, 1700, 'Zona Sur'),
(10, 4, 19, 3400,2000,250,1350,3800,10500,14200,18000, 1700, 'Zona Centro'),
(11, 4, 20, 3800,2000,300,1500,4200,11500,15000,19000, 1900, 'Zona Norte'),
(12, 5, 23, 4200,2500,350,1700,4750,13000,16000,20000, 2100, 'Zona Sur'),
(13, 5, 24, 4200,2500,350,1700,4750,13000,16000,20000, 2100, 'Zona Centro'),
(14, 5, 26, 4600,2500,400,2000,5750,14000,17000,21000, 2300, 'Zona Norte'),
(15, 6, 29, 5000,3000,400,2000,6000,15000,18000,21000, 2500, 'Zona Sur'),
(16, 6, 30, 5400,3000,450,2400,6800,16000,19500,23000, 2700, 'Zona Norte'),
(17, 7, 32, 6000,3000,500,2500,6500,17000,21000,24000, 3000, 'Zona Sur'),
(18, 7, 33, 6000,3000,450,2400,6800,16000,19500,23000, 3000, 'Zona Centro'),
(19, 7, 34, 6400,3000,550,2850,8500,19000,23000,27000, 3200, 'Zona Norte'),
(20, 8, 37, 7000,4000,650,3300,9500,22000,25000,30000, 3500, 'Zona Sur'),
(21, 8, 39, 7000,4000,650,3300,9500,22000,25000,30000, 3500, 'Zona Centro'),
(22, 8, 40, 7400,4000,1000,4000,12000,26000,31000,36000, 3700, 'Zona Norte');

INSERT INTO POSESIONES (id_posesion, id_celda, precio, nombre) VALUES
(1, 8, 3800, 'Compa�ia Petrolera'),
(2, 12, 3600, 'Ferrocarril Gral. Belgrano'),
(3, 8, 3800, 'Bodega'),
(4, 8, 3600, 'Ferrocarril Gral. San Martin'),
(5, 8, 3600, 'Ferrocarril Gral. B. Mitre'),
(6, 8, 3600, 'Ferrocarril Gral. Urquiza');