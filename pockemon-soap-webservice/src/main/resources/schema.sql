DROP TABLE IF EXISTS PETICIONES;

CREATE TABLE PETICIONES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  ip VARCHAR(20) NOT NULL,
  fecha TIMESTAMP NOT NULL,
  metodo VARCHAR(50) NOT NULL
);
