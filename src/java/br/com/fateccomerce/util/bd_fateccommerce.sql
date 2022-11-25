create table Brand(
        id_brand serial not null,
	name_brand varchar(256) not null unique,
	description_brand text,
	constraint pk_brand primary key (id_brand)
);


//Tipo usuario: 1 = adm, 2 = cliente
create table Usuario(
    id_usuario serial not null,
    nome_usuario varchar(200) not null,
    username varchar(100) not null unique,
    password varchar(100) not null,
    tipo_usuario integer not null default 1
);