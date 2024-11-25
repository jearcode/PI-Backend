USE LuxeVision;

/* SEARCH BAR: SEARCH STUDIOS BY SPECIALTY */
CREATE INDEX idx_specialty_name ON Specialties(specialty_name);
CREATE INDEX idx_studio_specialty ON Studio_Specialties(studio_Id, specialty_Id);




