CREATE TABLE IF NOT EXISTS user_account
(
    id       int auto_increment,
    username varchar,
    user_pass varchar,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contact
(
    id        int auto_increment,
    firstName varchar,
    lastName  varchar,
    phone     varchar,
    user_account_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (user_account_id) REFERENCES user_account(id)
);