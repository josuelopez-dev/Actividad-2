create database if not exists veterinaria;
use veterinaria;

create table paciente (
	idMascota int not null primary key auto_increment,
    aliasMascota varchar(50) not null,
    especie varchar(50) not null,
    raza varchar(50) not null,
    colorPelo varchar(50) not null,
    fechaNacimiento date not null
);


select * from paciente;

