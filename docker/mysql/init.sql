CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    document VARCHAR(11) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    category VARCHAR(10) NOT NULL,
    CONSTRAINT uq_document UNIQUE (document),
    CONSTRAINT uq_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    CONSTRAINT uq_user_id UNIQUE (user_id),
    CONSTRAINT fk_user_account FOREIGN KEY (user_id) REFERENCES users(id)
);