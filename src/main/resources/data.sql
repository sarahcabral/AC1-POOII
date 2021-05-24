INSERT INTO TB_BASEUSER (name, email) VALUES ('Sarah','sarah@outlook.com');   
INSERT INTO TB_BASEUSER (name, email) VALUES ('Jhow','jho.jhow@hotmail.com');   
INSERT INTO TB_BASEUSER (name, email) VALUES ('Emilly','emy.sla@gmail.com');   
INSERT INTO TB_BASEUSER (name, email) VALUES ('José','jr_jose@yahoo.br');   
INSERT INTO TB_BASEUSER (name, email) VALUES ('Maria','ma.maria@outlook.com');   
INSERT INTO TB_BASEUSER (name, email) VALUES ('Ana','ana123@email.com');   

INSERT INTO TB_ADMIN (id, phone_Number) VALUES (1, 988295251);
INSERT INTO TB_ADMIN (id, phone_Number) VALUES (2, 988294658);
INSERT INTO TB_ADMIN (id, phone_Number) VALUES (3, 992845683);

INSERT INTO TB_ATTEND (id, balance) VALUES (4, 1800.00);
INSERT INTO TB_ATTEND (id, balance) VALUES (5, 280.00);
INSERT INTO TB_ATTEND (id, balance) VALUES (6, 750.00);

INSERT INTO TB_EVENT (start_Date, end_Date, start_Time, end_Time, email_Contact, name, description, amount_Free_Tickets, amount_Payed_Tickets, price_Ticket) VALUES ('2021-10-26', '2022-10-26', '15:00', '17:00', 'niver_aqui@email.com', 'Aniversario de 1 ano', 'Tema do Detona Ralf', 50, 185, 100.0);
INSERT INTO TB_EVENT (start_Date, end_Date, start_Time, end_Time, email_Contact, name, description, amount_Free_Tickets, amount_Payed_Tickets, price_Ticket) VALUES ('2021-11-26', '2022-10-26', '18:00', '22:00', 'sarinhah@email.com', 'Aniversario de Joaquin', 'Tema do Wall-e', 100, 1000, 500.0);
INSERT INTO TB_EVENT (start_Date, end_Date, start_Time, end_Time, email_Contact, name, description, amount_Free_Tickets, amount_Payed_Tickets, price_Ticket) VALUES ('2021-12-26', '2022-10-26', '21:00', '23:00', 'janaubadosul@email.com', 'Aniversario de Rochele', 'Tema Harry Potter', 15, 40, 30.00);

INSERT INTO TB_PLACE (name, address) VALUES ('Tomorrowland', 'Wall Street, Nº 1889');
INSERT INTO TB_PLACE (name, address) VALUES ('Lollapalooza', 'Rodeo Drive, Nº 85');
INSERT INTO TB_PLACE (name, address) VALUES ('Independence Day', 'Wantill Road, Nº 4500');

INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(1L, 1L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(2L, 2L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(3L, 3L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(1L, 2L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(2L, 3L);
INSERT INTO EVENTS_PLACES (EVENTS_ID, PLACES_ID) VALUES(1L, 3L);