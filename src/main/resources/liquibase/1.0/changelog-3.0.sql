CREATE TABLE features
(
    id      INT PRIMARY KEY,
    car_id  INT          NOT NULL,
    feature VARCHAR(255) NOT NULL,
    FOREIGN KEY (car_id) REFERENCES cars (id)
);