create table family
(
    id SERIAL PRIMARY KEY,
    family_name varchar(255),
    nr_of_adults int NOT NULL,
    nr_of_children int NOT NULL,
    nr_of_infants int NOT NULL
);