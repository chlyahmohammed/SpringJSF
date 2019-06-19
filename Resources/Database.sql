CREATE database documents;
USE documents;

CREATE TABLE Document(
	id integer primary key,
	title varchar(80),
	prix double
);

insert into Document values("101","Modèle MVC2 Avec Struts","560");
insert into Document values("102","Le framework MVC2 Java Server Faces","850");
insert into Document values("103","Applications Java EE avec Spring","940");