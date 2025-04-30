CREATE TABLE IF NOT EXISTS Users(
                                    id         BIGINT DEFAULT nextval('global_id_sequence') PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
                                    first_name VARCHAR(255)
);