--<ScriptOptions statementTerminator=";"/>

CREATE TABLE kunden (
	KundenNr INT NOT NULL,
	FamName VARCHAR(25),
	Vorname VARCHAR(25),
	Straﬂe VARCHAR(30),
	Hausnummer VARCHAR(8),
	Ort VARCHAR(25),
	PLZ VARCHAR(5),
	Geburtsdatum DATE,
	Geschlecht VARCHAR(1),
	EMail VARCHAR(255),
	passwort VARCHAR(35) NOT NULL,
	admin INT DEFAULT 0,
	PRIMARY KEY (KundenNr)
) ENGINE=InnoDB;

CREATE TABLE produkte (
	ProduktNr INT NOT NULL,
	ArtikelGrp INT NOT NULL,
	Produktname VARCHAR(30) NOT NULL,
	Produktpreis DECIMAL(10 , 2) NOT NULL,
	Menge INT,
	bildpfad VARCHAR(255),
	PRIMARY KEY (ProduktNr)
) ENGINE=InnoDB;

CREATE TABLE bestellung (
	BestellNr INT NOT NULL,
	KundenNr INT NOT NULL,
	Gesamtpreis DECIMAL(10 , 2) NOT NULL,
	PRIMARY KEY (BestellNr)
) ENGINE=InnoDB;

CREATE TABLE artikelgruppe (
	ArtikelGrpNr INT NOT NULL,
	Name VARCHAR(20) NOT NULL,
	PRIMARY KEY (ArtikelGrpNr)
) ENGINE=InnoDB;

CREATE TABLE position (
	Pos INT NOT NULL,
	BestellNr INT NOT NULL,
	Produkt INT NOT NULL,
	Menge INT NOT NULL,
	PosPreis DECIMAL(10 , 2) NOT NULL,
	PRIMARY KEY (Pos,BestellNr)
) ENGINE=InnoDB;

CREATE INDEX BestellNr ON position (BestellNr ASC);

CREATE INDEX KundenNr ON bestellung (KundenNr ASC);

CREATE INDEX ArtikelGrp ON produkte (ArtikelGrp ASC);

CREATE INDEX Produkt ON position (Produkt ASC);

