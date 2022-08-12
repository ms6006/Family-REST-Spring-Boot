create table family_member
(
    id SERIAL PRIMARY KEY,
    age int NOT NULL,
    family_id int NOT NULL,
    family_name varchar(255),
    given_name varchar(255)
);