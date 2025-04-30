CREATE TABLE IF NOT EXISTS Expenses(
                                       id               BIGINT                DEFAULT nextval('global_id_sequence') PRIMARY KEY,
                                       user_id          BIGINT       NOT NULL,
                                       expense_group_id BIGINT                DEFAULT NULL,
                                       expense_name     VARCHAR(255) NOT NULL,
    amount NUMERIC(12, 2) NOT NULL,
                                       date_created     TIMESTAMP    NOT NULL DEFAULT NOW(),
                                       FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE,
                                       FOREIGN KEY (expense_group_id) REFERENCES expense_groups (id) ON DELETE SET DEFAULT
);