 CREATE TABLE login (
	 id serial PRIMARY KEY,
	 name varchar(55),
	 pass text
 );
 
  CREATE TABLE authority (
	 id serial PRIMARY KEY,
	 loginId integer REFERENCES login (id),
	 roleName varchar(15)
 );