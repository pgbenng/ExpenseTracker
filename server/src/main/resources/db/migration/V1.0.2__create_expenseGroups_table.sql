CREATE TABLE IF NOT EXISTS expense_groups
(
    id                 BIGINT DEFAULT nextval('global_id_sequence') PRIMARY KEY,
    user_id            BIGINT       NOT NULL,
    expense_group_name VARCHAR(255) NOT NULL,
    colour VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE
);