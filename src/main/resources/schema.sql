start transaction;

drop index if exists users_name;
drop table if exists users_authorities;
drop table if exists user_authority;
drop table if exists link;
drop table if exists users;

create table users (
    id  uuid default gen_random_uuid() primary key,
    username varchar(255) unique,
    password varchar(255));

create index users_name on users(username);

create table user_authority (
    id integer not null primary key,
    name varchar(255));

create table users_authorities (
    user_id uuid not null references users(id),
    authorities_id integer not null references user_authority(id) default 1,
    primary key (authorities_id, user_id)
);

create table link (
    id uuid default gen_random_uuid() primary key,
    is_http boolean default false not null,
    is_permanent_redirect boolean default false not null,
    user_id uuid references users(id),
    url varchar(255)
);

commit;