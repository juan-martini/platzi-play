INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Shrek', 90, 'ANIMADA', NULL, '2024-06-01', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Shrek');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Inception', 148, 'CIENCIA_FICCION', NULL, '2010-07-16', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Inception');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Titanic', 195, 'DRAMA', 4.6, '1997-12-19', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Titanic');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'John Wick', 101, 'ACCION', NULL, '2014-10-24', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'John Wick');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'El Conjuro', 112, 'TERROR', 3.0, '2013-07-19', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'El Conjuro');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Coco', 105, 'ANIMADA', 4.7, '2017-10-27', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Coco');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Interstellar', 169, 'CIENCIA_FICCION', 5.0, '2014-11-07', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Interstellar');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Joker', 122, 'DRAMA', NULL, '2019-10-04', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Joker');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Toy Story', 81, 'ANIMADA', 4.5, '1995-11-22', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Toy Story');

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
SELECT 'Avengers: Endgame', 181, 'ACCION', 3.9, '2019-04-26', 'D'
WHERE NOT EXISTS (SELECT 1 FROM platzi_play_peliculas WHERE titulo = 'Avengers: Endgame');