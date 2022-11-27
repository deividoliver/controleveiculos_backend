--este sql criar um banco de dados chamado com privilégios para o usuários postgres
--se você estiver usando outro usuário é possível alterar o nome do mesmo na linha criação do banco de dados
--caso você faça alteração de usuário para um específico o mesmo deve ser alterado no arquivo de application.properties
--na linha spring.datasource.username
--caso seu usuário tenha senha também é possível adiciona-lá
--na linha spring.datasource.password 

--criando banco
CREATE DATABASE controleveiculo OWNER postgres;

--Modelo
CREATE SEQUENCE sequence_modelo;

CREATE TABLE modelo (
  modelo_id bigint NOT NULL,
  nome character VARYING(255),
  CONSTRAINT pk_modelo PRIMARY KEY (modelo_id)
)

--Veiculo
CREATE SEQUENCE sequence_veiculo;

CREATE TABLE veiculo (
  veiculo_id bigint NOT NULL,
  renavam character VARYING(255),
  placa character VARYING(255),
  cadastro timestamp without time zone,
  valor NUMERIC (20, 2),
  modelo_id bigint NOT NULL,
  CONSTRAINT pk_veiculo PRIMARY KEY (veiculo_id)
)

--Opcional
CREATE SEQUENCE sequence_opcional;

CREATE TABLE opcional (
  opcional_id bigint NOT NULL,
  nome character VARYING(255),
  CONSTRAINT pk_opcional PRIMARY KEY (opcional_id)
)

--Veiculo-Opcional
CREATE TABLE veiculo_opcional (
  veiculo_id BIGINT NOT NULL,
  opcional_id BIGINT NOT NULL,
PRIMARY KEY(veiculo_id, opcional_id));

--criação de chaves
ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) REFERENCES modelo (modelo_id);
CREATE INDEX idx_veiculo_modelo ON veiculo (modelo_id);

ALTER TABLE veiculo_opcional ADD CONSTRAINT fk_veiculo_opcional_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculo (veiculo_id);
ALTER TABLE veiculo_opcional ADD CONSTRAINT fk_veiculo_opcional_opcional FOREIGN KEY (opcional_id) REFERENCES opcional (opcional_id);

CREATE INDEX idx_veiculo_opcional_veiculo ON veiculo_opcional (veiculo_id);
CREATE INDEX idx_veiculo_opcional_opcional ON veiculo_opcional (opcional_id);

--inserts modelo
INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'kwid');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'Gol');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'Mobi');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'Fox');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'HB20');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'Onix');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'KA');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'Strada');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'Fastback');

INSERT INTO public.modelo(modelo_id, nome) VALUES (nextval('sequence_modelo'), 'Prisma');

--inserts opcionais
INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Sensor de Ré');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Câmera de Ré');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Multimidia Digital');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Trava Elétrica');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Vidros Elétricos');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Ar-condicionado');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Direção Elétrica');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Direção Hidráulica');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Som');

INSERT INTO public.opcional(opcional_id, nome) VALUES (nextval('sequence_opcional'), 'Bancos de couro');

