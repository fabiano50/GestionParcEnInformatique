create database gestionparcinformatique;

\c gestionparcinformatique;

/* ENTITE */
create table equipement (
	id_equipement integer primary key,
	nom varchar(150),
	date_achat date,
	etat varchar(100),
	configuration varchar(150)
);

create table logiciel (
	id_logiciel integer primary key,
	nom varchar(150),
	version varchar(20),
	editeur varchar(100),
	date_installation date
);

create table utilisateur (
	id_utilisateur integer primary key,
	nom varchar(150)
);

create table departement (
	id_departement integer primary key,
	nom varchar(150),
	localisation varchar(150),
	type varchar(50)
);
