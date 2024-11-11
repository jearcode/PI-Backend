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
     
     
     
     
     
     
     
     

