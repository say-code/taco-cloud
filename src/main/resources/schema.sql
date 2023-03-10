create table if not exists ingredient (
    id varchar(4) not null primary key ,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists taco (
    id identity,
    name varchar(50) not null,
    created_at timestamp not null
);

create table if not exists taco_ingredients (
    taco bigint not null,
    ingredient varchar(4) not null
);

alter table taco_ingredients
    add foreign key (taco) references taco(id);
alter table taco_ingredients
    add foreign key (ingredient) references ingredient(id);

create table if not exists taco_order(
    id identity,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip varchar(10) not null,
    ccNumber varchar(16) not null ,
    ccExpiration varchar(5) not null ,
    ccCVV varchar(3) not null ,
    placedAt timestamp not null
);

create table if not exists taco_order_tacos(
    taco_order bigint not null ,
    taco bigint not null
);

alter table taco_order_tacos
    add foreign key (taco_order) references taco_order(id);
alter table taco_order_tacos
    add foreign key (taco) references taco(id);


