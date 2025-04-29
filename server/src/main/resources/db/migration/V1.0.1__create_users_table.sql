CREATE TABLE IF NOT EXISTS Users(
    id BIGINT DEFAULT nextval('GlobalIdSequence') PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255)
);