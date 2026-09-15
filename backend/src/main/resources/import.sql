-- Carga inicial: cada INSERT deve permanecer em uma única linha.

INSERT INTO tb_category (name) VALUES ('Fantasia');
INSERT INTO tb_category (name) VALUES ('Ficção científica');
INSERT INTO tb_category (name) VALUES ('Romance');
INSERT INTO tb_category (name) VALUES ('Tecnologia');
INSERT INTO tb_category (name) VALUES ('História');

INSERT INTO tb_author (name) VALUES ('J. R. R. Tolkien');
INSERT INTO tb_author (name) VALUES ('Isaac Asimov');
INSERT INTO tb_author (name) VALUES ('Jane Austen');
INSERT INTO tb_author (name) VALUES ('Robert C. Martin');
INSERT INTO tb_author (name) VALUES ('Yuval Noah Harari');

INSERT INTO tb_book (title, description, year_publication, total_quantity, quantity_available, registration_date) VALUES ('O Senhor dos Anéis', 'Uma jornada pela Terra-média para destruir o Um Anel.', 1954, 4, 3, TIMESTAMP WITH TIME ZONE '2026-09-01T10:00:00Z');
INSERT INTO tb_book (title, description, year_publication, total_quantity, quantity_available, registration_date) VALUES ('Fundação', 'Uma obra clássica de ficção científica sobre o futuro da humanidade.', 1951, 3, 2, TIMESTAMP WITH TIME ZONE '2026-09-01T10:05:00Z');
INSERT INTO tb_book (title, description, year_publication, total_quantity, quantity_available, registration_date) VALUES ('Orgulho e Preconceito', 'Romance sobre relações sociais, costumes e primeiras impressões.', 1813, 5, 5, TIMESTAMP WITH TIME ZONE '2026-09-01T10:10:00Z');
INSERT INTO tb_book (title, description, year_publication, total_quantity, quantity_available, registration_date) VALUES ('Código Limpo', 'Práticas para escrever código legível, simples e sustentável.', 2008, 4, 4, TIMESTAMP WITH TIME ZONE '2026-09-01T10:15:00Z');
INSERT INTO tb_book (title, description, year_publication, total_quantity, quantity_available, registration_date) VALUES ('Sapiens', 'Uma análise da história e da evolução da humanidade.', 2011, 2, 1, TIMESTAMP WITH TIME ZONE '2026-09-01T10:20:00Z');

INSERT INTO tb_book_author (book_id, author_id) VALUES (1, 1);
INSERT INTO tb_book_author (book_id, author_id) VALUES (2, 2);
INSERT INTO tb_book_author (book_id, author_id) VALUES (3, 3);
INSERT INTO tb_book_author (book_id, author_id) VALUES (4, 4);
INSERT INTO tb_book_author (book_id, author_id) VALUES (5, 5);
INSERT INTO tb_book_author (book_id, author_id) VALUES (1, 2);

INSERT INTO tb_book_category (book_id, category_id) VALUES (1, 1);
INSERT INTO tb_book_category (book_id, category_id) VALUES (1, 5);
INSERT INTO tb_book_category (book_id, category_id) VALUES (2, 2);
INSERT INTO tb_book_category (book_id, category_id) VALUES (3, 3);
INSERT INTO tb_book_category (book_id, category_id) VALUES (4, 4);
INSERT INTO tb_book_category (book_id, category_id) VALUES (4, 5);
INSERT INTO tb_book_category (book_id, category_id) VALUES (5, 5);

INSERT INTO tb_reader (name, email, birth_date, creation_date) VALUES ('Ana Souza', 'ana.souza@example.com', DATE '1995-04-12', TIMESTAMP WITH TIME ZONE '2026-09-02T09:00:00Z');
INSERT INTO tb_reader (name, email, birth_date, creation_date) VALUES ('Bruno Oliveira', 'bruno.oliveira@example.com', DATE '1990-11-23', TIMESTAMP WITH TIME ZONE '2026-09-02T09:10:00Z');
INSERT INTO tb_reader (name, email, birth_date, creation_date) VALUES ('Carla Mendes', 'carla.mendes@example.com', DATE '1988-07-08', TIMESTAMP WITH TIME ZONE '2026-09-02T09:20:00Z');

INSERT INTO tb_loan (reader_id, book_id) VALUES (1, 1);
INSERT INTO tb_loan (reader_id, book_id) VALUES (2, 2);
INSERT INTO tb_loan (reader_id, book_id) VALUES (3, 5);
