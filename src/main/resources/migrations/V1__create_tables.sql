CREATE TABLE IF NOT EXISTS account (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    type TEXT NOT NULL,
    balance REAL NOT NULL DEFAULT 0,
    currency TEXT NOT NULL DEFAULT 'EUR',
    created_at TEXT NOT NULL DEFAULT (datetime('now'))
);

CREATE TABLE IF NOT EXISTS category (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    type TEXT NOT NULL,
    color TEXT
);

CREATE TABLE IF NOT EXISTS transaction (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    account_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    amount REAL NOT NULL,
    type TEXT NOT NULL,
    description TEXT,
    date TEXT NOT NULL,
    created_at TEXT NOT NULL DEFAULT (datetime('now')),
    FOREIGN KEY (account_id) REFERENCES account(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS budget (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    account_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    limit_amount REAL NOT NULL,
    period TEXT NOT NULL,
    year INTEGER NOT NULL,
    month INTEGER NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);