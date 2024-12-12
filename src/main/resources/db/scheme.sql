CREATE DATABASE IF NOT EXISTS LuxeVision;

USE LuxeVision;

CREATE TABLE IF NOT EXISTS Specialties (
	Id 				INT 		AUTO_INCREMENT,
    specialty_name 	VARCHAR(50) NOT NULL,
    
    CONSTRAINT pk_specialty PRIMARY KEY	(Id)
);

CREATE TABLE IF NOT EXISTS Locations (
	Id		INT 			AUTO_INCREMENT,
    city	VARCHAR(50) 	NOT NULL,
    state	VARCHAR(50)		NULL,
    country	VARCHAR(50) 	NOT NULL,
    address	VARCHAR(255) 	NULL,
    
    CONSTRAINT pk_location PRIMARY KEY (Id)
);

CREATE TABLE IF NOT EXISTS Studios (
	Id 					INT 			AUTO_INCREMENT,
    studio_name 		VARCHAR(255) 	NOT NULL,
    email 				VARCHAR(150) 	NOT NULL,
    phone 				VARCHAR(15) 	NULL,
    description 		VARCHAR(200) 	NULL,
	signup 				DATETIME 		NOT NULL,
    years_of_experience INT 			NOT NULL,
    profile_image 		VARCHAR(255) 	NULL,
    location_Id 		INT 			NOT NULL,
    
    CONSTRAINT pk_studio PRIMARY KEY (Id),
    CONSTRAINT fk_studio_location FOREIGN KEY (location_Id) REFERENCES Locations(Id)
 );

CREATE TABLE IF NOT EXISTS Portfolio_Photos (
	Id				INT 			AUTO_INCREMENT,
    image 			VARCHAR(255) 	NOT NULL,
    studio_Id		INT 			NOT NULL,
    
    CONSTRAINT pk_portfolio_photo PRIMARY KEY (Id),
    CONSTRAINT fk_portfolio_photo_studio FOREIGN KEY (studio_Id) REFERENCES Studios(Id)
);

CREATE TABLE IF NOT EXISTS Studio_Specialties (
	Id				INT AUTO_INCREMENT,
    studio_Id 		INT NOT NULL,
    specialty_Id 	INT NOT NULL,
    
    CONSTRAINT pk_studio_specialty PRIMARY KEY (Id),
    CONSTRAINT fk_studio_specialty_studio FOREIGN KEY (studio_Id) REFERENCES Studios(Id),
    CONSTRAINT fk_studio_specialty_specialty FOREIGN KEY (specialty_Id) REFERENCES Specialties(Id)
);

CREATE TABLE IF NOT EXISTS Photographers (
	Id 			INT 		AUTO_INCREMENT,
    first_name 	VARCHAR(50) NOT NULL,
    last_name 	VARCHAR(50) NOT NULL,
    studio_Id 	INT 		NOT NULL,
    
    CONSTRAINT pk_photographer PRIMARY KEY (Id),
    CONSTRAINT fk_photographer FOREIGN KEY (studio_Id) REFERENCES Studios(Id)
);
         
CREATE TABLE IF NOT EXISTS Features (
	Id 				INT 		AUTO_INCREMENT,
    feature_name 	VARCHAR(50) NOT NULL,
    icon 			VARCHAR(50) NULL,
    
    CONSTRAINT pk_feature PRIMARY KEY (Id)
);

CREATE TABLE IF NOT EXISTS Studio_Features (
	Id				INT AUTO_INCREMENT,
    studio_Id 		INT NOT NULL,
    feature_Id 		INT NOT NULL,
    
    CONSTRAINT pk_studio_feature PRIMARY KEY (Id),
    CONSTRAINT fk_studio_feature_studio FOREIGN KEY (studio_Id) REFERENCES Studios(Id),
    CONSTRAINT fk_studio_feature_feature FOREIGN KEY (feature_Id) REFERENCES Features(Id)
);
     
/* CONFIG */
CREATE TABLE IF NOT EXISTS User_Roles (
	Id		INT			AUTO_INCREMENT,
    role	VARCHAR(50)	NOT NULL, 
    
    CONSTRAINT pk_user_role PRIMARY KEY (Id)
);

CREATE TABLE IF NOT EXISTS Users (
	Id				INT 			AUTO_INCREMENT,
    first_name 		VARCHAR(50) 	NOT NULL,
    last_name		VARCHAR(50) 	NOT NULL,
    password		VARCHAR(255) 	NOT NULL,
    salt			VARCHAR(255)	NULL,
    email			VARCHAR(150) 	NOT NULL,
    signup			DATETIME		NOT NULL,
    user_role_id	INT				NOT NULL,
    
    CONSTRAINT pk_user PRIMARY KEY (Id),
    CONSTRAINT fk_user_role FOREIGN KEY (user_role_Id) REFERENCES User_Roles(Id)
);

CREATE TABLE IF NOT EXISTS User_Favorites (
	Id			INT AUTO_INCREMENT,
    user_Id		INT	NOT NULL,
    studio_Id	INT	NOT NULL,
    
    CONSTRAINT pk_user_favorite PRIMARY KEY (Id),
    CONSTRAINT fk_user_favorite_user FOREIGN KEY (user_Id) REFERENCES Users(Id),
    CONSTRAINT fk_user_favorite_studio FOREIGN KEY (studio_Id) REFERENCES Studios(Id)
);

CREATE TABLE IF NOT EXISTS User_Ratings (
	Id				INT 			AUTO_INCREMENT,
    score			INT 			NOT NULL,
    review 			VARCHAR(255) 	NULL,
    review_date 	DATETIME 		NOT NULL,
    user_Id			INT				NOT NULL,
    studio_Id		INT				NOT NULL,
    
    CONSTRAINT pk_user_rating PRIMARY KEY (Id),
    CONSTRAINT fk_user_rating_user FOREIGN KEY (user_Id) REFERENCES Users(Id),
    CONSTRAINT fk_user_rating_studio FOREIGN KEY (studio_Id) REFERENCES Studios(Id)
);

CREATE TABLE IF NOT EXISTS Bookings (
	Id 				INT 		AUTO_INCREMENT,
    schedule_from 	DATETIME 	NOT NULL,
    schedule_to		DATETIME 	NOT NULL,
    status			VARCHAR(25) NULL, /* CONFIRMED, COMPLETED, CANCELLED */
    /* complete		BIT 		NULL, */
    studio_Id		INT			NOT NULL,
    user_Id			INT			NOT NULL,
    
    CONSTRAINT pk_booking PRIMARY KEY (Id),
    CONSTRAINT fk_booking_studio FOREIGN KEY (studio_Id) REFERENCES Studios(Id),
    CONSTRAINT fk_booking_user FOREIGN KEY (user_Id) REFERENCES Users(Id)
);
     
     
     
     
     
     
     

