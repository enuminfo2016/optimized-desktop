create table t_country (
    id serial primary key, 
    name varchar(50), 
    isd varchar(20)
);

create table t_location (
    id serial primary key, 
    name varchar(50), 
    pin integer, 
    city varchar(50), 
    state varchar(50),
    country integer,
    constraint location_country_fkey foreign key (country)
	      references t_country (id) match simple
	      on update no action on delete no action
);

create table t_category (
    id serial primary key, 
    name varchar(50)
);

create table t_product (
    id serial primary key,  
    name varchar(50),
    sku_code varchar(25),
    category integer,
    constraint product_category_fkey foreign key (category)
	      references t_category (id) match simple
	      on update no action on delete no action
);

create table t_address (
    id serial primary key,
    value1 varchar(100),
    value2 varchar(100),
    value3 varchar(100),
    location integer,
    constraint address_location_fkey foreign key (location)
	      references t_location (id) match simple
	      on update no action on delete no action
);

create table t_bank (
    id serial primary key, 
    name varchar(50),
    ifsc varchar(20),
    micr varchar(20),
    branch varchar(20),
    address integer,
    constraint bank_address_fkey foreign key (address)
	      references t_address (id) match simple
	      on update no action on delete no action,
    contact integer
);

create table t_vendor_detail (
    id serial primary key, 
    company_name varchar(100),
    company_address integer,
    constraint vendor_company_address_fkey foreign key (company_address)
	      references t_address (id) match simple
	      on update no action on delete no action,
    company_contact varchar(50),
    company_fax varchar(50),
    company_web_site varchar(50),
    company_email varchar(50),
    person_name varchar(50),
    person_fax varchar(50),
    person_mobile varchar(50),
    person_email varchar(50),
    person_designation varchar(50),
    address_works varchar(500),
    type_ownership varchar(50),
    company_nsic varchar(50),
    company_msme varchar(50),
    nature_business varchar(50),
    company_bank integer,
    constraint vendor_company_bank_fkey foreign key (company_bank)
	      references t_bank (id) match simple
	      on update no action on delete no action,
    company_bank_account varchar(50)
);

create table t_customer_detail (
    id serial primary key, 
    company_name varchar(100),
    company_address integer,
    constraint customer_company_address_fkey foreign key (company_address)
	      references t_address (id) match simple
	      on update no action on delete no action,
    company_contact varchar(50),
    company_fax varchar(50),
    company_web_site varchar(50),
    company_email varchar(50),
    person_name varchar(50),
    person_fax varchar(50),
    person_mobile varchar(50),
    person_email varchar(50),
    person_designation varchar(50),
    address_works varchar(500),
    type_ownership varchar(50),
    company_nsic varchar(50),
    company_msme varchar(50),
    nature_business varchar(50),
    company_bank integer,
    constraint customer_company_bank_fkey foreign key (company_bank)
	      references t_bank (id) match simple
	      on update no action on delete no action,
    company_bank_account varchar(50)
);

create table t_sale_order (
    id serial primary key,
    customer integer,
    constraint customer_sale_order_fkey foreign key (customer)
	      references t_customer_detail (id) match simple
	      on update no action on delete no action
);

create table t_order_line (
    id serial primary key,
    product integer,
    constraint line_product_fkey foreign key (product)
	      references t_product (id) match simple
	      on update no action on delete no action,
    quantity decimal, 
    unit_price decimal,
    sale_order integer,
    constraint line_sale_order_fkey foreign key (sale_order)
	      references t_sale_order (id) match simple
	      on update no action on delete no action
);
