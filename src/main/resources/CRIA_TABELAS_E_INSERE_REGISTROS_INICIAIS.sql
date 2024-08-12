CREATE TABLE exame (rowid bigint PRIMARY KEY auto_increment, nm_exame VARCHAR(255));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue'), ('Toxicologico'), ('Ultrassonografia'), ('Tomografia'), ('Audiometria'), ('Eletroencefalograma'), ('Espirometria'), ('Radiografia');

CREATE TABLE funcionario (rowid bigint PRIMARY KEY auto_increment, nm_funcionario VARCHAR(255));
INSERT INTO funcionario (nm_funcionario) VALUES ('Joseilmo Costa'), ('Alex Pizzato'), ('Alexandre Matos'), ('Guilherme Simoes'), ('Felipe Nascimento'), ('Glaucio Dias'), ('Matheus Azevedo'), ('Ryan Alves');

CREATE TABLE exameFuncionario (id_funcionario bigint, id_exame bigint, dataExame date,
primary key (id_funcionario, id_exame, dataExame),
foreign key (id_funcionario) references funcionario (rowid) on delete cascade,
foreign key (id_exame) references exame (rowid));

INSERT INTO exameFuncionario (id_funcionario, id_exame, dataExame) VALUES (3, 4, '2024-08-16');

INSERT INTO exameFuncionario (id_funcionario, id_exame, dataExame) 
VALUES 
    (1, 1, '2024-08-10'), 
    (2, 2, '2024-08-11'), 
    (3, 3, '2024-08-12'), 
    (4, 4, '2024-08-13'), 
    (5, 5, '2024-08-14'), 
    (2, 10, '2024-08-19');