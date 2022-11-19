CREATE SCHEMA if NOT EXISTS service;

DROP TABLE if EXISTS service.users;
CREATE TABLE if NOT EXISTS service.users
(
    identifier serial primary key,
    email      text unique not null
)