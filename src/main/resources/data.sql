--DELETE FROM location;
--INSERT INTO location (id,type, coordinatex, coordinatey) VALUES (1, 'Point','-74.0565192','4.6761959');
--INSERT INTO location (id,type, coordinatex, coordinatey) VALUES (2, 'Point','-74.0465655','4.6830892');

-- FROM address;
--INSERT INTO address (id,dates, addresss, location_id) VALUES (1,'2022-06-14 04:00','Cl. 90 #19-41, Bogotá, Colombia',1);
--INSERT INTO address (id,dates, addresss, location_id) VALUES (2,'2022-06-15 04:00','Ac. 100 #13-21, Bogotá, Colombia',2);
DELETE FROM trip;
INSERT INTO trip (start_date, start_address, start_type, start_coordinates, end_date, end_address, end_type, end_coordinates, country, city, passenger, driver, car, status, check_code, price) VALUES ('2022-06-14 04:00','Cl. 90 #19-41, Bogotá, Colombia','Point','-74.0565192,4.6761959','2022-06-15 04:00','Ac. 100 #13-21, Bogotá, Colombia', 'Point','-74.0565192,4.6761959','Colombia','Bogotá','Ricardo Sarmiento', 'Julio Alberto', 'ESM308', 'started', 66, 13800);
