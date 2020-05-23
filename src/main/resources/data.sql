DROP TABLE IF EXISTS student;

CREATE TABLE student (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(250) NOT NULL,
last_name VARCHAR(250) NOT NULL,
prom DOUBLE(3) NOT NULL
);

INSERT INTO student(first_name,last_name,prom) VALUES
('Juan','Arboleda',3.0),
('Vero','Arboleda',3.5),
('Jhon','Rivera',2.5),
('Sebas','Alarcon',4.2),
('Maritza','Ossa',4.7),
('Hector','Murillo',2.3),
('David','Cuassi',4.6)
;