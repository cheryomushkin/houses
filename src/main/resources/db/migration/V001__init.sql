create sequence house_seq start 1 increment by 1;
create table if not exists house (
  id bigint default nextval('house_seq') primary key,
  name varchar(100) unique not null
);
create index house_name_idx on house (name);

create sequence floor_seq start 1 increment by 1;
create table if not exists floor (
  id bigint default nextval('floor_seq') primary key,
  house_id bigint references house(id)
);
create index floor_house_idx on floor (house_id);

create sequence flat_seq start 1 increment by 1;
create table if not exists flat (
  id bigint default nextval('flat_seq') primary key,
  number varchar (64) not null,
  floor_id bigint references floor(id)
);
create index flat_floor_idx on flat (floor_id);