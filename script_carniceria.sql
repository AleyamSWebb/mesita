CREATE DATABASE carniceria_mesitas;
USE carniceria_mesitas;

CREATE TABLE producto (
                          id_producto INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          descripcion VARCHAR(255),
                          precio DECIMAL(10,2) NOT NULL,
                          cantidad_stock INT NOT NULL,
                          categoria VARCHAR(50)
);

-- Insertamos un dato de prueba para ver que funciona
INSERT INTO producto (nombre, descripcion, precio, cantidad_stock, categoria)
VALUES ('Corte Ribeye', 'Corte premium de res especial para asar', 8500.00, 15, 'Res');