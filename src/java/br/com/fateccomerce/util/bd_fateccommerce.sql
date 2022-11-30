create table Brand(
        id_brand serial not null,
	name_brand varchar(256) not null unique,
	description_brand text,
	constraint pk_brand primary key (id_brand)
);

create table Category(
    id_category serial not null,
    name_category varchar(255) not null unique,
    description_category text,
    constraint pk_category primary key(id_category)
);

create table Product(
    id_product serial not null,
    name_product varchar(255) not null unique,
    description_product text,
    cst_price_product numeric(10,2) not null,
    sale_price_product numeric(10,2) not null,
    id_brand integer not null references Brand(id_brand),
    id_category integer not null references Category(id_category),
);

//Tipo usuario: 1 = adm, 2 = cliente
create table Usuario(
    id_usuario serial not null,
    nome_usuario varchar(200) not null,
    username varchar(100) not null unique,
    password varchar(100) not null,
    tipo_usuario integer not null default 1
);