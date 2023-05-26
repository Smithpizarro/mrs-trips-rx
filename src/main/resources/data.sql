CREATE TABLE IF NOT EXISTS trip (id INT NOT NULL AUTO_INCREMENT, start_date VARCHAR(255), start_address VARCHAR(255), start_type VARCHAR(255), start_coordinates VARCHAR(255),
 end_date VARCHAR(255), end_address VARCHAR(255), end_type VARCHAR(255), end_coordinates VARCHAR(255), country VARCHAR(255), city VARCHAR(255), passenger VARCHAR(255), driver VARCHAR(255), car VARCHAR(255), status VARCHAR(40),check_code INT,price DECIMAL, PRIMARY KEY (id));

DELETE FROM trip;
INSERT INTO trip (start_date, start_address, start_type, start_coordinates, end_date, end_address, end_type, end_coordinates, country, city, passenger, driver, car, status, check_code, price) VALUES ('2022-06-14 04:00','Cl. 90 #19-41, Bogotá, Colombia','Point','-74.0565192,4.6761959','2022-06-15 04:00','Ac. 100 #13-21, Bogotá, Colombia', 'Point','-74.0565192,4.6761959','Colombia','Bogotá','Ricardo Sarmiento', 'Julio Alberto', 'ESM308', 'started', 66, 13800);

--DELETE FROM location;
--INSERT INTO location (id,type, coordinatex, coordinatey) VALUES (1, 'Point','-74.0565192','4.6761959');
--INSERT INTO location (id,type, coordinatex, coordinatey) VALUES (2, 'Point','-74.0465655','4.6830892');

-- FROM address;
--INSERT INTO address (id,dates, addresss, location_id) VALUES (1,'2022-06-14 04:00','Cl. 90 #19-41, Bogotá, Colombia',1);
--INSERT INTO address (id,dates, addresss, location_id) VALUES (2,'2022-06-15 04:00','Ac. 100 #13-21, Bogotá, Colombia',2);
--DELETE FROM trip;
--INSERT INTO trip (start_date, start_address, start_type, start_coordinates, end_date, end_address, end_type, end_coordinates, country, city, passenger, driver, car, status, check_code, price) VALUES ('2022-06-14 04:00','Cl. 90 #19-41, Bogotá, Colombia','Point','-74.0565192,4.6761959','2022-06-15 04:00','Ac. 100 #13-21, Bogotá, Colombia', 'Point','-74.0565192,4.6761959','Colombia','Bogotá','Ricardo Sarmiento', 'Julio Alberto', 'ESM308', 'started', 66, 13800);
