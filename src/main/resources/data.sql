INSERT INTO TB_BASEUSER (name, email) VALUES ('Sarah','sarah@email.com');   --1l
INSERT INTO TB_BASEUSER (name, email) VALUES ('Jhow','jho.jhow@email.com');   --2l
INSERT INTO TB_BASEUSER (name, email) VALUES ('Emilly','emy.sla@email.com');   --3l
INSERT INTO TB_BASEUSER (name, email) VALUES ('José','jr_jose@email.com');   --4l
INSERT INTO TB_BASEUSER (name, email) VALUES ('Maria','ma.maria@email.com');   --5l
INSERT INTO TB_BASEUSER (name, email) VALUES ('Ana','ana123@email.com');   --6l

INSERT INTO TB_ADMIN (id, phone_Number) VALUES (1L, 988295251);
INSERT INTO TB_ADMIN (id, phone_Number) VALUES (2L, 988294658);
INSERT INTO TB_ADMIN (id, phone_Number) VALUES (3L, 992845683);

INSERT INTO TB_ATTEND (id, balance) VALUES (4, 1800.00);
INSERT INTO TB_ATTEND (id, balance) VALUES (5, 280.00);
INSERT INTO TB_ATTEND (id, balance) VALUES (6, 750.00);

INSERT INTO TB_EVENT (start_Date, end_Date, start_Time, end_Time, email_Contact, name, description) VALUES ('2021-10-26', '2022-10-26', '15:00', '17:00', 'niver_aqui@email.com', 'Aniversario de 1 ano', 'Tema do Detona Ralf');
INSERT INTO TB_EVENT (start_Date, end_Date, start_Time, end_Time, email_Contact, name, description) VALUES ('2021-11-26', '2022-10-26', '18:00', '22:00', 'sarinhah@email.com', 'Aniversario de Joaquin', 'Tema do Wall-e');
INSERT INTO TB_EVENT (start_Date, end_Date, start_Time, end_Time, email_Contact, name, description) VALUES ('2021-12-26', '2022-10-26', '21:00', '23:00', 'janaubadosul@email.com', 'Aniversario de Rochele', 'Tema Harry Potter');

INSERT INTO TB_PLACE (name, address) VALUES ('Tomorrowland', 'Wall Street, Nº 1889');
INSERT INTO TB_PLACE (name, address) VALUES ('Tomorrowland', 'Rua 3');
INSERT INTO TB_PLACE (name, address) VALUES ('Tomorrowland', 'Rua 2');

INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(1L, 1L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(2L, 2L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(3L, 3L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(1L, 2L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(2L, 3L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(1L, 3L);