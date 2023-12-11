BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS leagues;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS league_golfer;
DROP TABLE IF EXISTS match_golfer;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(100),
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE courses(
    course_id SERIAL,
    course_name varchar(100) NOT NULL,
    street_address varchar(100),
    city varchar (50) NOT NULL,
    state_abb varchar (2) NOT NULL,
    zip_code varchar(10) NOT NULL,
    latitude decimal(10,8),
    longitude decimal (11,8),
    website varchar (100),
    CONSTRAINT PK_course PRIMARY KEY (course_id),
    CONSTRAINT legit_zip CHECK (zip_code < 100000)
    );

CREATE TABLE leagues(
     league_id SERIAL,
     league_name varchar(50) NOT NULL UNIQUE,
     coordinator_id integer NOT NULL,
     course_id integer NOT NULL,
     CONSTRAINT PK_league PRIMARY KEY (league_id),
     CONSTRAINT FK_league_coordinator FOREIGN KEY (coordinator_id) REFERENCES users(user_id),
     CONSTRAINT FK_league_course FOREIGN KEY (course_id) REFERENCES courses(course_id)
     );



CREATE TABLE matches(
    match_id SERIAL,
    league_id integer NOT NULL,
    tee_date date NOT NULL,
	tee_time time NOT NULL,
	CONSTRAINT PK_match PRIMARY KEY (match_id),
    CONSTRAINT FK_league_match FOREIGN KEY (league_id) REFERENCES leagues(league_id)
    );

CREATE TABLE league_golfer (
	league_id int NOT NULL,
	user_id int NOT NULL,
	league_score int NOT NULL,
	handicap int,
	CONSTRAINT PK_league_user PRIMARY KEY (league_id, user_id),
	CONSTRAINT FK_league_golfer_league FOREIGN KEY (league_id) REFERENCES leagues(league_id),
	CONSTRAINT FK_league_golfer_golfer FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT handicap_positive CHECK (handicap >= 0)
);

CREATE TABLE match_golfer (
    match_id int NOT NULL,
    user_id int NOT NULL,
    match_score int NOT NULL,
    CONSTRAINT PK_match_user PRIMARY KEY (match_id, user_id),
    CONSTRAINT FK_match_golfer_match FOREIGN KEY (match_id) REFERENCES matches(match_id),
    CONSTRAINT FK_match_golfer_golfer FOREIGN KEY (user_id) REFERENCES users(user_id)

);

COMMIT TRANSACTION;