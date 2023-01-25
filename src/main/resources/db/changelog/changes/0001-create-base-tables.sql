--liquibase formatted sql
--changeset liquibase-docs:1
CREATE TABLE computer_parts (
                               id BIGINT PRIMARY KEY NOT NULL,
                               type VARCHAR(255) NOT NULL,
                               brand VARCHAR(255) NOT NULL,
                               model VARCHAR(255) NOT NULL,
                               price DECIMAL(6, 2) NOT NULL
);

CREATE TABLE computer_forms (
                               id BIGINT PRIMARY KEY NOT NULL,
                               part_id BIGINT NOT NULL,
                               justification VARCHAR(255) NOT NULL,
                               time_stamp TIMESTAMP NOT NULL,
                               FOREIGN KEY (part_id) REFERENCES computer_parts(id)
);