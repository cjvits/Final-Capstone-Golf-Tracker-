BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('MikeG', 'Mike', 'Gaudino','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('BenH', 'Ben','Hoffman','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('MegL', 'Meg','Lemon','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('BryceY', 'Bryce', 'Yoder','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('TomA', 'Tom','Anderson','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('WaltI', 'Walt','Impellicceiri','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('JimM', 'Jim', 'Marghella','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,first_name, last_name, password_hash,role) VALUES ('CalebV', 'Caleb','Vits','$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');

INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Chartiers Country Club', '601 Baldwin Rd.', 'Pittsburgh', 'PA', 15205, 40.4347404, -80.0929396, 'https://chartierscc.com/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Totteridge Golf Club', '2029 Totteridge Dr.', 'Greensburg', 'PA', 15601, 40.3578107, -79.5065938, 'https://www.totteridge.com/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('South Hills Country Club', '4305 Brownsville Rd.', 'Pittsburgh', 'PA', 15236, 40.3609486, -79.9856915, 'https://www.southhillscc.org/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Pittsburgh Field Club', '121 Field Club Rd.', 'Pittsburgh', 'PA', 15238, 40.51304874, -79.89004612, 'https://fieldclub.org/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Fox Chapel Golf Club', '426 Fox Chapel Rd.', 'Pittsburgh', 'PA', 15238, 40.5228106, -79.8773786, 'https://www.foxchapelgolfclub.org/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Edgewood Country Club', '100 Churchill Rd.', 'Pittsburgh', 'PA', 15235, 40.4340465, -79.8334654, 'https://eccgolf.com/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('St. Clair Country Club', '2300 Old Washington Rd.', 'Pittsburgh', 'PA', 15241, 40.331386, -80.0780578, 'https://www.stclaircc.org/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Lindenwood Golf Club', '360 Galley Rd.', 'Canonsburg', 'PA', 15317, 40.24803, -80.1339012, 'https://www.lindenwoodgolf.com/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Westwood Golf Club', '825 Commonwealth Ave.', 'West Mifflin', 'PA', 15122, 40.3766558, -79.888783, 'https://westwoodlinks.net/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Longue Vue Club', '400 Longue Vue Dr.', 'Verona', 'PA', 15147, 40.4812932, -79.8586421, 'https://longuevue.org/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Grand View Golf Club', '1000 Clubhouse Dr.', 'Braddock', 'PA', 15104, 40.4952833, -80.2035128, 'https://pittsburghgolf.com/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('The Club At Nevillewood', '1000 Nevillewood Dr.', 'Presto', 'PA', 15142, 40.3824025, -80.1244945, 'https://www.nevillewood.org/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Oakmont Country Club', '1233 Hulton Rd.', 'Oakmont', 'PA', 15139, 40.5260435, -79.827508, 'https://www.oakmontcc.org/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Moon Golf Club', '505 McCormick Rd.', 'Moon Township', 'PA', 15108, 40.48253, -80.1887034, 'https://www.moongolfclub.com/');
INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, latitude, longitude, website) VALUES ('Southpointe Golf Club', '360 SouthPointe Blvd.', 'Canonsburg', 'PA', 15317, 40.2923305, -80.1730783, 'https://www.southpointegolfclub.com/');

INSERT INTO leagues (league_name, coordinator_id, course_id) VALUES ('BallerTime', 4, 1);
INSERT INTO leagues (league_name, coordinator_id, course_id) VALUES ('Puttsburghers', 8, 1);

INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (1, 3, 0);
INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (1, 4, 0);
INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (1, 5, 0);
INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (1, 6, 0);

INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (2, 7, 0);
INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (2, 8, 0);
INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (2, 9, 0);
INSERT INTO league_golfer (league_id, user_id, league_score) VALUES (2, 10, 0);

INSERT INTO matches (league_id, tee_date, tee_time) VALUES (1, '2023-12-26', '10:00');
INSERT INTO matches (league_id, tee_date, tee_time) VALUES (1, '2023-12-26', '10:15');
INSERT INTO matches (league_id, tee_date, tee_time) VALUES (2, '2023-12-26', '11:15');
INSERT INTO matches (league_id, tee_date, tee_time) VALUES (2, '2023-12-26', '11:30');

INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (1,3,0);
INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (1,4,0);
INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (2,5,0);
INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (2,6,0);

INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (3,7,0);
INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (3,8,0);
INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (4,9,0);
INSERT INTO match_golfer (match_id, user_id, match_score) VALUES (4,10,0);













COMMIT TRANSACTION;

