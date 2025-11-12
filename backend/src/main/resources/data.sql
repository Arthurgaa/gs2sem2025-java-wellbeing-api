INSERT INTO especialidades (id, nome) VALUES (1, 'Terapia Cognitivo-Comportamental');
INSERT INTO especialidades (id, nome) VALUES (2, 'Psiquiatria');

INSERT INTO pacientes (id, nome, email, data_nascimento) VALUES (1, 'Ana Souza', 'ana@example.com', '1995-05-10');
INSERT INTO pacientes (id, nome, email, data_nascimento) VALUES (2, 'Carlos Lima', 'carlos@example.com', '1990-02-20');

INSERT INTO profissionais_saude (id, nome, email, registro_profissional) VALUES (1, 'Dra. Paula', 'paula@clinica.com', 'CRP-123');
INSERT INTO profissionais_saude (id, nome, email, registro_profissional) VALUES (2, 'Dr. Marcos', 'marcos@clinica.com', 'CRM-456');

INSERT INTO profissional_especialidade (profissional_id, especialidade_id) VALUES (1, 1);
INSERT INTO profissional_especialidade (profissional_id, especialidade_id) VALUES (2, 2);

INSERT INTO registros_diarios (id, data_registro, nivel_humor, nivel_ansiedade, horas_sono, paciente_id) VALUES
(1, '2025-11-01', 4, 2, 7, 1),
(2, '2025-11-02', 3, 5, 6, 1),
(3, '2025-11-03', 5, 1, 8, 2);

INSERT INTO consultas (id, data_hora_consulta, status_consulta, paciente_id, profissional_id) VALUES
(1, '2025-11-20T15:00:00', 'AGENDADA', 1, 1),
(2, '2025-11-22T10:30:00', 'AGENDADA', 2, 2);

INSERT INTO recursos_apoio (id, titulo, tipo_recurso, url) VALUES
(1, 'Guia de Ansiedade', 'ARTIGO', 'https://exemplo.com/ansiedade'),
(2, 'Meditação Guiada 10min', 'MEDITACAO', 'https://exemplo.com/meditacao'),
(3, 'Dormir Melhor', 'VIDEO', 'https://exemplo.com/sono');
