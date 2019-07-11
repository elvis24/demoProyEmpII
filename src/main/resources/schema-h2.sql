
create table producto(
    idProducto  int not null primary key ,
    descripcion varchar (50),
    precio      varchar,
    stock       int,
    categoria   varchar(50),
);

create table cliente(
    idCliente int not null,
    nombre varchar (50),
    apellido varchar (50),
    direccion varchar(100),
    telefono numeric not null

);

create table pedido(
    codigoPedido varchar(7) not null,
    fecha DATE ,
    estado varchar ,
    nombrePedido varchar (100)
);

