INSERT INTO member (email, password, address, phone_number, nickname)
VALUES ('sparta@sparta.com', '4321', '부산시', '01012341234', '스파르타');

INSERT INTO book_store (name, address)
VALUES ('스파르타 서울', '서울시 강남구');
INSERT INTO book_store (name, address)
VALUES ('스파르타 부산', '부산시 해운대구');

INSERT INTO book (title, author, price, stock, book_store_id)
VALUES ('자바의정석', '남궁성', 10000, 10, 1);
INSERT INTO book (title, author, price, stock, book_store_id)
VALUES ('자바 ORM 표준 JPA 프로그래밍', '김영한', 20000, 4, 2);