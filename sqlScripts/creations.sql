CREATE table customer
(
	f_name varchar(10) not null,
	l_name varchar(10),
	phone varchar(10),
	primary key(phone)
);

CREATE table supplier
(
	s_id serial primary key,
	s_name varchar(20) not null,
	contact_name varchar(10) not null,
	contact_phone varchar(10) not null
);

CREATE table rik_order
(
	order_num serial primary key,
	o_date date not null default CURRENT_DATE,
	description text,
	phone varchar(10),
	s_id serial,
	foreign key (phone) references customer,
	foreign key (s_id) references supplier
	
);