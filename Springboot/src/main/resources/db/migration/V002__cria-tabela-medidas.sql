create table medidas (

	id bigint not null auto_increment,
	peso bigint(3) not null,
    altura bigint(3) not null,
    cliente_id bigint(1) not null,
    data_medida datetime not null,
    
    primary key (id)
);

alter table medidas add constraint fk_medidas_cliente
foreign key (cliente_id) references cliente (id);