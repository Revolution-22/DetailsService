CREATE TABLE addresses (
       id BIGSERIAL PRIMARY KEY,
       user_id BIGINT NOT NULL,
       country VARCHAR(255),
       voivodeship VARCHAR(255),
       city VARCHAR(255),
       street VARCHAR(255),
       apartment_number VARCHAR(255),
       house_number VARCHAR(255),
       zip_code VARCHAR(255)
);
