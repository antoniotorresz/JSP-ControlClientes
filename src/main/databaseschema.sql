--esquema completo de la base de datos
create table cliente
(
    id        int auto_increment primary key,
    nombre    varchar(45)      not null,
    apellidos varchar(45)      not null,
    email     varchar(45)      null,
    telefono  varchar(15)      null,
    saldo     double default 0 null
);
