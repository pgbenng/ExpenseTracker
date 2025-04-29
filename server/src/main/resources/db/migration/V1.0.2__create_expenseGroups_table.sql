CREATE TABLE IF NOT EXISTS ExpenseGroups(
    id BIGINT DEFAULT nextval('GlobalIdSequence') PRIMARY KEY,
    userId BIGINT NOT NULL,
    expenseGroupName VARCHAR(255) NOT NULL,
    colour VARCHAR(255) NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(id) ON DELETE CASCADE
);