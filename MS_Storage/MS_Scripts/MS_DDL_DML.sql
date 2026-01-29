DROP VIEW  IF EXISTS MS_vwExobotDetalle;
DROP TABLE IF EXISTS MS_Exobot;
DROP TABLE IF EXISTS MS_Arma;
DROP TABLE IF EXISTS MS_TipoExobot;

CREATE TABLE MS_TipoExobot (
    IdTipoExobot    INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(30) NOT NULL UNIQUE,

    Estado          VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME DEFAULT (datetime('now','localtime'))
);

CREATE TABLE MS_Arma (
    IdArma      INTEGER PRIMARY KEY AUTOINCREMENT,
    Tipo        VARCHAR(30) NOT NULL,
    Accion      VARCHAR(50) NOT NULL,
    Entrenada   INTEGER DEFAULT 0, -- 0 = NO, 1 = SI

    Estado          VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME DEFAULT (datetime('now','localtime'))
);

CREATE TABLE MS_Exobot (
    IdExobot        INTEGER PRIMARY KEY AUTOINCREMENT,
    IdTipoExobot    INTEGER NOT NULL,
    IdArmaDerecha   INTEGER,
    IdArmaIzquierda INTEGER,

    Serie           VARCHAR(30) NOT NULL UNIQUE,
    Nombre          VARCHAR(30) NOT NULL,

    Entreno         VARCHAR(2) DEFAULT 'NO', -- SI / NO
    NoAccion        INTEGER DEFAULT 0,

    Estado          VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME DEFAULT (datetime('now','localtime')),
    FechaModifica   DATETIME DEFAULT (datetime('now','localtime')),

    FOREIGN KEY (IdTipoExobot)    REFERENCES MS_TipoExobot(IdTipoExobot),
    FOREIGN KEY (IdArmaDerecha)   REFERENCES MS_Arma(IdArma),
    FOREIGN KEY (IdArmaIzquierda) REFERENCES MS_Arma(IdArma)
);

INSERT INTO MS_TipoExobot (Nombre)
VALUES ('Infantería'), ('Defensa'), ('Explorador');

INSERT INTO MS_Arma (Tipo, Accion, Entrenada)
VALUES
('Misil', 'Disparar', 0),
('Mortero', 'Lanzar', 0),
('Escudo', 'Proteger', 1);

INSERT INTO MS_Exobot
(IdTipoExobot, IdArmaDerecha, IdArmaIzquierda, Serie, Nombre)
VALUES
(1, 1, 2, 'INF-001', 'ExoAlpha'),
(2, 3, 3, 'DEF-001', 'ExoShield');

CREATE VIEW MS_vwExobotDetalle AS
SELECT
    e.IdExobot,
    e.Nombre,
    e.Serie,
    t.Nombre AS TipoExobot,
    e.Entreno,
    e.NoAccion,
    ad.Tipo AS ArmaDerecha,
    ai.Tipo AS ArmaIzquierda
FROM MS_Exobot e
JOIN MS_TipoExobot t ON e.IdTipoExobot = t.IdTipoExobot
LEFT JOIN MS_Arma ad ON e.IdArmaDerecha = ad.IdArma
LEFT JOIN MS_Arma ai ON e.IdArmaIzquierda = ai.IdArma
WHERE e.Estado = 'A';
