CREATE TABLE todo
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    todo           VARCHAR(100)          NOT NULL,
    status		   boolean 				 NOT NULL
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
