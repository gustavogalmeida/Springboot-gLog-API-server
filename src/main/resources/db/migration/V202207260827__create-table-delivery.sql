create table delivery (
	id bigint not null auto_increment,
    client_id bigint not null,
    feedelivery decimal(10, 2) not null,
    status varchar(20) not null,
    date_order datetime not null,
    date_finishing datetime, 
    
    recipient_name varchar (60) not null,
    recipient_address varchar (255) not null,
    recipeint_number varchar (30) not null, 
    recipient_complement varchar (60) not null, 
    recipient_district varchar (30) not null,
    
    PRIMARY KEY (id)
);

alter table delivery add constraint fk_delivery_client foreign key (client_id) references client (id);
