/* Clientes */
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Mariela', 'Flor', 'mariela.asuncion@hotmail.com', '2017-08-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Montserrat', 'Martínez', 'monmar@gmail.com', '2017-08-02');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Amani', 'Molinas', 'amanimoli@gmail.com', '2017-08-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Fernando', 'Benítez', 'fer_ben@gmail.com', '2017-08-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Valentina', 'Norte', 'valen@outlook.com', '2017-08-05');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Ada', 'Silvero', 'ada.silvero@gmail.com', '2017-08-06');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Mauro', 'Rebollo', 'maureb@gmail.com', '2017-08-07');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Lourdes', 'Maldonado', 'lou_maldonado@hotmail.com', '2017-08-08');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Cristhel', 'Leguizamón', 'crisleguizamo@gmail.com', '2017-08-09');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Elisa', 'Acosta', 'eli.acosta@hotmail.com', '2017-08-010');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Alice', 'Franco', 'alicefr@gmail.com', '2017-08-11');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Matías', 'Trinidad', 'matitrinidad@outlook.com', '2017-08-12');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Iván', 'Herrero', 'herreroivan@outlook.com', '2017-08-13');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Johana', 'Galeano', 'joey_galeano@gmail.com', '2017-08-14');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Diego', 'Morínigo', 'morinigod@outlook.com', '2017-08-15'); 

/* Productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('BluRay Bohemian Rhapsody', 300000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('DVD Pacific Rim', 110000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Vinilo Innuendo', 350000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('CD American Idiot', 90000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('VHS Casablanca', 80000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('DVD Inside Out', 85000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('BluRay The Avengers', 230000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('CD After Laughter', 90000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Vinilo Elvis', 200000, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('VHS Gone With The Wind', 60000, NOW());

/* Facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Multimedia', null, 'Gs', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, moneda, cliente_id, create_at) VALUES('Factura DVD', '¡Alguna nota importante!', 'USD', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);