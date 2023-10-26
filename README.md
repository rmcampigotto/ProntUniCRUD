# ProntUni
CRUD do projeto de Desafio Profissional - ProntUni

## SQL Utilizado:
```SQL
CREATE TABLE Paciente(
	id NUMBER PRIMARY KEY NOT NULL,
	nome VARCHAR2(100) NOT NULL,
	dt_nasc VARCHAR2(10) NOT NULL,
	genero VARCHAR2(1) NOT NULL,
	endereco VARCHAR2(100) NOT NULL,
	cidade VARCHAR2(50) NOT NULL,
	telefone NUMBER(11),
	ubs VARCHAR2(100) NOT NULL
);

CREATE TABLE Paciente_Log (
	log_id NUMBER PRIMARY KEY NOT NULL,
	paciente_id NUMBER NOT NULL,
	data_hora VARCHAR2(100) NOT NULL,
	FOREIGN KEY (paciente_id) REFERENCES Paciente(id)
);

COMMIT;

CREATE SEQUENCE seq_idlogPaciente
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_insere_paciente
AFTER INSERT OR UPDATE ON Paciente
FOR EACH ROW
DECLARE
    data_hora VARCHAR2(100);
BEGIN
    data_hora := TO_CHAR(SYSTIMESTAMP, 'DD/MM/YYYY HH24:MI:SS');
    case
        when UPDATING then
            INSERT INTO Paciente_Log (log_id,paciente_id, data_hora, operacao)
            VALUES (seq_idlogPaciente.nextval,:NEW.id, data_hora, 'UPDATE');
        else 
            INSERT INTO Paciente_Log (log_id,paciente_id, data_hora, operacao)
            VALUES (seq_idlogPaciente.nextval,:NEW.id, data_hora, 'INSERT');
    end case;
END;
/

COMMIT;

INSERT INTO Paciente(id,nome,dt_nasc,genero,endereco,cidade,telefone,ubs) 
VALUES (1, 'Rafael', '14/10/2004','M','Rua Interventor Manoel Ribas, 56','Mandaguari',44997003374,'CENTRO - MANDAGUARI');

SELECT * FROM Paciente;
select * from Paciente_Log;
```
