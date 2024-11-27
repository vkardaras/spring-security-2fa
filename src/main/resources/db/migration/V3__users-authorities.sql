CREATE TABLE IF NOT EXISTS users_authorities(
    user_id INT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    authority_id INT NOT NULL REFERENCES authorities (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, authority_id)
);
