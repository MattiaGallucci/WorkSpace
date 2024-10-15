DROP database IF EXISTS SwaGGedDB;
CREATE database SwaGGedDB;
USE SwaGGedDB;

DROP TABLE IF EXISTS utente;
CREATE TABLE utente
(
    email        varchar(30)  NOT NULL,
    username     varchar(20)  NOT NULL,
    password     varchar(64)  NOT NULL,
    immagine     varchar(512) NOT NULL DEFAULT "",
    segnalazioni int          NOT NULL DEFAULT '0',
    bandito      tinyint(1)   NOT NULL DEFAULT '0',
    admin        tinyint(1)   NOT NULL DEFAULT '0',
    PRIMARY KEY (email),
    UNIQUE (username)
);

DROP TABLE IF EXISTS community;
CREATE TABLE community
(
    id           int          NOT NULL AUTO_INCREMENT,
    nome         varchar(20)  NOT NULL,
    descrizione  varchar(512) NOT NULL DEFAULT "",
    segnalazioni int          NOT NULL DEFAULT '0',
    utenteEmail  varchar(30)  NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS post;
CREATE TABLE post
(
    id           int          NOT NULL AUTO_INCREMENT,
    titolo       varchar(50)  NOT NULL,
    corpo        varchar(512) NOT NULL DEFAULT "",
    immagine     varchar(512) NOT NULL DEFAULT "",
    segnalazioni int          NOT NULL DEFAULT '0',
    utenteEmail  varchar(30)  NOT NULL,
    communityId  int          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (communityId) REFERENCES community (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS commento;
CREATE TABLE commento
(
    id           int          NOT NULL AUTO_INCREMENT,
    corpo        varchar(512) NOT NULL DEFAULT "",
    segnalazioni int          NOT NULL DEFAULT '0',
    padre        int          NOT NULL DEFAULT '0',
    utenteEmail  varchar(30)  NOT NULL,
    postId       int          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (postId) REFERENCES post (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS segnalaUtente;
CREATE TABLE segnalaUtente
(
    segnalatoreEmail varchar(30) NOT NULL,
    segnalatoEmail   varchar(30) NOT NULL,
    PRIMARY KEY (segnalatoreEmail, segnalatoEmail),
    FOREIGN KEY (segnalatoreEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (segnalatoEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS segnalaCommunity;
CREATE TABLE segnalaCommunity
(
    utenteEmail varchar(30) NOT NULL,
    communityId int         NOT NULL,
    PRIMARY KEY (utenteEmail, communityId),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (communityId) REFERENCES community (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS seguiCommunity;
CREATE TABLE seguiCommunity
(
    utenteEmail varchar(30) NOT NULL,
    communityId int         NOT NULL,
    PRIMARY KEY (utenteEmail, communityId),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (communityId) REFERENCES community (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS segnalaPost;
CREATE TABLE segnalaPost
(
    utenteEmail varchar(30) NOT NULL,
    postId      int         NOT NULL,
    PRIMARY KEY (utenteEmail, postId),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (postId) REFERENCES post (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS apprezzaPost;
CREATE TABLE apprezzaPost
(
    utenteEmail   varchar(30) NOT NULL,
    postId        int         NOT NULL,
    apprezzamento int         NOT NULL DEFAULT '0',
    PRIMARY KEY (utenteEmail, postId),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (postId) REFERENCES post (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS salvaPost;
CREATE TABLE salvaPost
(
    utenteEmail varchar(30) NOT NULL,
    postId      int         NOT NULL,
    PRIMARY KEY (utenteEmail, postId),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (postId) REFERENCES post (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS segnalaCommento;
CREATE TABLE segnalaCommento
(
    utenteEmail varchar(30) NOT NULL,
    commentoId  int         NOT NULL,
    PRIMARY KEY (utenteEmail, commentoId),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (commentoId) REFERENCES commento (id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS apprezzaCommento;
CREATE TABLE apprezzaCommento
(
    utenteEmail   varchar(30) NOT NULL,
    commentoId    int         NOT NULL,
    apprezzamento int         NOT NULL DEFAULT '0',
    PRIMARY KEY (utenteEmail, commentoId),
    FOREIGN KEY (utenteEmail) REFERENCES utente (email) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (commentoId) REFERENCES commento (id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO utente(email, username, password, immagine, segnalazioni, bandito, admin)
VALUES ("Email@email.email", "Username", "Password", "Immagine", 0, 0, 0);