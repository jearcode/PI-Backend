USE LuxeVision;

/* SEARCH BAR: SEARCH STUDIOS BY SPECIALTY */
CREATE VIEW vw_studios_by_specialty AS
SELECT 
    s.*,
    sp.specialty_name AS specialty_name
FROM Studios s
JOIN Studio_Specialties ss ON s.Id = ss.studio_Id 
JOIN Specialties sp ON ss.specialty_Id = sp.Id;
