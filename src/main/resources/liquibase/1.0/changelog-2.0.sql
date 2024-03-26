CREATE TABLE cars
(
    id               INT PRIMARY KEY,
    city             VARCHAR(255) NOT NULL,
    seller_id        INT          NOT NULL,
    brand            VARCHAR(255) NOT NULL,
    model            VARCHAR(255) NOT NULL,
    year_made        INT          NOT NULL,
    ban_type         VARCHAR(255) NOT NULL,
    mileage          INT,
    color            VARCHAR(255),
    engine           VARCHAR(255) NOT NULL,
    gear_box         VARCHAR(255) NOT NULL,
    gear             VARCHAR(255) NOT NULL,
    car_is_new       VARCHAR(255) NOT NULL,
    seats            INT          NOT NULL,
    owners           INT          NOT NULL,
    condition_of_car VARCHAR(255) NOT NULL,
    market           VARCHAR(255) NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES sellers (id)
);