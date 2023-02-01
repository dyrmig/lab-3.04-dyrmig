CREATE SCHEMA demo;
CREATE SCHEMA demo_test;

CREATE TABLE author (
	id INT NOT NULL AUTO_INCREMENT,
    author_name VARCHAR(255),
    PRIMARY KEY(id)
    );
CREATE TABLE post (
	id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    word_count INT,
    views INT,
    author_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(author_id) REFERENCES author(id)
	);
    
CREATE TABLE customer (
	id INT NOT NULL AUTO_INCREMENT,
	customer_name VARCHAR(225) NOT NULL,
	customer_status VARCHAR(10),
    customer_mileage INT,
	PRIMARY KEY(id)
	);
CREATE TABLE aircraft (
	id INT NOT NULL AUTO_INCREMENT,
	aircraft_name VARCHAR(225) NOT NULL,
	aircraft_seats INT,
	PRIMARY KEY(id)
	);
CREATE TABLE flight (
	id INT NOT NULL AUTO_INCREMENT,
	flight_number VARCHAR(10) NOT NULL,
	flight_mileage INT,
    aircraft_id INT,
	PRIMARY KEY(id),
    FOREIGN KEY(aircraft_id) REFERENCES aircraft(id)
	);
CREATE TABLE customer_flight (
	customer_id INT NOT NULL,
    flight_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (flight_id) REFERENCES flight(id)
);
INSERT INTO customer(customer_name, customer_status, customer_mileage) VALUES
	("Agustine Riviera", "Silver", 115235),
	("Alaina Sepulvida", "None", 6008),
	("Tom Jones", "Gold", 205767),
	("Sam Rio", "None", 2653),
	("Jessica James", "Silver", 127656),
	("Ana Janco", "Silver", 136773),
	("Jennifer Cortez", "Gold", 300582),
	("Christian Janco", "Silver", 14642)
	;
INSERT INTO aircraft(aircraft_name, aircraft_seats) VALUES
	("Boeing 747", 400),
	("Airbus A330", 236),
	("Boeing 777", 264)
	;
INSERT INTO flight(flight_number, flight_mileage, aircraft_id) VALUES
	("DL143", 135, 1),
	("DL122", 4370, 2),
	("DL53", 2078, 3),
	("DL222", 1765, 3),
	("DL37", 531, 1)
	;
INSERT INTO customer_flight VALUES
	(1,1),
	(1,2),
	(2,2),
	(1,1),
	(3,2),
	(3,3),
	(1,1),
	(4,1),
	(1,1),
	(3,4),
	(5,1),
	(4,1),
	(6,4),
	(7,4),
	(5,2),
	(4,5),
	(8,4)
	;
