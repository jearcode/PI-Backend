USE LuxeVision;

CREATE TABLE IF NOT EXISTS Policies (
	Id 				INT 			AUTO_INCREMENT,
    title		 	VARCHAR(100) 	NOT NULL,
    desciption	 	VARCHAR(255) 	NOT NULL,
    
    CONSTRAINT pk_policy PRIMARY KEY (Id)
);

CREATE TABLE IF NOT EXISTS Studio_Policies (
	Id 				INT	AUTO_INCREMENT,
    policy_Id		INT	NOT NULL,
    studio_Id 		INT	NOT NULL,
    
    CONSTRAINT pk_studio_policy PRIMARY KEY (Id),
    CONSTRAINT fk_studio_policy_policy FOREIGN KEY (policy_Id) REFERENCES Policies(Id),
    CONSTRAINT fk_studio_policy_studio FOREIGN KEY (studio_Id) REFERENCES Studios(Id)
 );
 
 CREATE TABLE IF NOT EXISTS Days_of_Week (
	Id 				INT 			AUTO_INCREMENT,
    day_name	 	VARCHAR(20) 	NOT NULL,
    
    CONSTRAINT pk_day_of_week PRIMARY KEY (Id)
);

CREATE TABLE IF NOT EXISTS Studio_Hours (
	Id 				INT	AUTO_INCREMENT,
    opening_time 	TIME NOT NULL,
    closing_time 	TIME NOT NULL,
    studio_Id 		INT	NOT NULL,
    day_Id 			INT	NOT NULL,
    
    CONSTRAINT pk_studio_hours PRIMARY KEY (Id),
    CONSTRAINT fk_studio_hours_day FOREIGN KEY (studio_Id) REFERENCES Studios(Id),
    CONSTRAINT fk_studio_hours_studio FOREIGN KEY (day_Id) REFERENCES Days_of_Week(Id)
 );
 