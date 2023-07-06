CREATE TABLE Member (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        address VARCHAR(255) NOT NULL,
                        phone_number VARCHAR(20) NOT NULL,
                        nickname VARCHAR(50) NOT NULL
);

CREATE TABLE book_store (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             name VARCHAR(255) NOT NULL,
                             address VARCHAR(255) NOT NULL
);

CREATE TABLE Book (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      price INT NOT NULL,
                      stock INT NOT NULL DEFAULT 0,
                      book_store_id INT,
                      FOREIGN KEY (book_store_id) REFERENCES book_store(id)
);