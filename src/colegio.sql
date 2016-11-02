create table assignatura (
	codi int not null,
	nom varchar(100) not null,
	primary key(codi)
);

create table tutoria (
	codi int not null,
	nom varchar(100) not null,
	maxParticipants int not null,
	codiAssignatura int,
	primary key(codi),
	foreign key(codiAssignatura) references assignatura(codi)
);

create table alumne (
	codi int not null,
	nom varchar(100) not null,
	primary key(codi)
);

create table tutoriaAlumne (
  codiTutoria int not null,
  codiAlumne int not null,
  actiu boolean not null default false,
  primary key (codiTutoria, codiAlumne),
  foreign key(codiTutoria) references tutoria(codi),
  foreign key(codiAlumne) references alumne(codi)
);

insert into assignatura (codi, nom) values (1,'Programació');
insert into assignatura (codi, nom) values (2,'Xarxes');
insert into assignatura (codi, nom) values (3,'Bases de Dades');
insert into assignatura (codi, nom) values (4,'Sistemes Operatius');

insert into tutoria (codi, nom, maxParticipants, codiAssignatura) values (1, 'Tutoria 1 Programació', 10, 1);
insert into tutoria (codi, nom, maxParticipants, codiAssignatura) values (2, 'Tutoria 2 Programació', 5, 1);
insert into tutoria (codi, nom, maxParticipants, codiAssignatura) values (3, 'Tutoria 1 Xarxes', 7, 2);
insert into tutoria (codi, nom, maxParticipants, codiAssignatura) values (4, 'Tutoria 1 Bases de Dades', 15, 3);
insert into tutoria (codi, nom, maxParticipants, codiAssignatura) values (5, 'Tutoria 2 Bases de Dades', 12, 3);
insert into tutoria (codi, nom, maxParticipants, codiAssignatura) values (6, 'Tutoria 1 Sistemes Operatius', 20, 4);

insert into alumne (codi, nom) values (1, 'Rafel Mateu');
insert into alumne (codi, nom) values (2, 'Jose Martinez');
insert into alumne (codi, nom) values (3, 'Angel Martorell');
insert into alumne (codi, nom) values (4, 'Dolores Pons');
insert into alumne (codi, nom) values (5, 'Antonia Sanç');
insert into alumne (codi, nom) values (6, 'Alberto Perez');
insert into alumne (codi, nom) values (7, 'Jaume Frau');
insert into alumne (codi, nom) values (8, 'Pere Pons');

insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (1, 1, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (1, 2, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (1, 3, 0);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (1, 4, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (2, 2, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (2, 5, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (2, 6, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (2, 7, 0);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (2, 8, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (3, 1, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (3, 7, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (4, 3, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (4, 6, 0);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (4, 8, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (5, 4, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (6, 4, 1);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (6, 5, 0);
insert into tutoriaAlumne (codiTutoria, codiAlumne, actiu) values (6, 6, 1);