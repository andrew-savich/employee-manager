create table departments(
    id bigserial not null primary key,
    title varchar(250) not null unique
)
GO