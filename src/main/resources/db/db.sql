    create database probe;

    CREATE TABLE public.address
    (
        id SERIAL PRIMARY KEY NOT NULL,
        city TEXT,
        street TEXT,
        home_number VARCHAR(5)
    );
    CREATE UNIQUE INDEX address_id_uindex ON public.address (id);

    CREATE TABLE public.users
    (
        id SERIAL NOT NULL,
        name TEXT,
        email VARCHAR(20),
        address_id INT PRIMARY KEY,
        CONSTRAINT users_address_id_fk FOREIGN KEY (address_id) REFERENCES address (id)
    );
    CREATE UNIQUE INDEX users_id_uindex ON public.users (id);