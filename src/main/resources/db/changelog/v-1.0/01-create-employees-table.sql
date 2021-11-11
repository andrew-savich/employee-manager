create table employees(
    id bigserial not null primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    job_title varchar(255) not null,
    date_of_birth date,
    gender varchar(255) not null,
    department varchar(255) not null
);
GO
