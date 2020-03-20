CREATE TABLE region_info
    ADD COLUMN id serial PRIMARY KEY,
    ADD COLUMN region_name varchar (100) NOT NULL,
    ADD COLUMN region_short_name varchar (20) NOT NULL UNIQUE,
    ADD COLUMN flag_url Text DEFAULT 'https://ruxpert.ru/Файл:Flag_of_Russia.png';