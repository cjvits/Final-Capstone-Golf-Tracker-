BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role) VALUES ('MikeG', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('BenH', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('MegL', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('BryceY', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('TomA', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('WaltI', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('JimM', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('CalebV', '$2a$10$jAB3Q9eNuYV1651tTNwCFOR.WycntGgYwhY/FvBSbwKUiFRjAl2ea', 'ROLE_USER');

INSERT INTO courses (course_name, street_address, city, state_abb, zip_code, course_rating) VALUES ('TE Golf Club', '123 Tee St.', 'Pittsburgh', 'PA', 15045,2);

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

