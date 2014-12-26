create sequence house_seq start 1 increment by 1;

create table if not exists house (
  id bigint default nextval('house_seq') primary key,
  name varchar(100) unique not null
);

create index house_name_idx on house (name);