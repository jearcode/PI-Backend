-- Fake test data

-- 1. Insert data into the Location table
INSERT INTO location (id, city, state, country, address) VALUES (1, 'New York', 'NY', 'USA', '123 Main St, New York, NY 10001');
INSERT INTO location (id, city, state, country, address) VALUES (2, 'Los Angeles', 'CA', 'USA', '456 Elm St, Los Angeles, CA 90001');
INSERT INTO location (id, city, state, country, address) VALUES (3, 'Chicago', 'IL', 'USA', '789 Oak St, Chicago, IL 60601');

-- 2. Insert data into the Specialties table
INSERT INTO specialties (id, specialty_name) VALUES (1, 'Wedding Photography');
INSERT INTO specialties (id, specialty_name) VALUES (2, 'Product Photography');
INSERT INTO specialties (id, specialty_name) VALUES (3, 'Portrait Photography');
INSERT INTO specialties (id, specialty_name) VALUES (4, 'Event Photography');

-- 3. Insert data into the Studio table
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (1, 'Luxe Wedding Studio', 'info@luxewedding.com', '123-456-7890', 'Specializing in wedding photography.', NOW(), 5, 'https://fake-s3-bucket.s3.amazonaws.com/profile1.jpg', 1);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (2, 'LA Product Shots', 'contact@laproductshots.com', '987-654-3210', 'Expert in product photography.', NOW(), 3, 'https://fake-s3-bucket.s3.amazonaws.com/profile2.jpg', 2);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (3, 'Chicago Portraits', 'hello@chicagoportraits.com', '555-123-4567', 'Capturing portraits that tell a story.', NOW(), 10, 'https://fake-s3-bucket.s3.amazonaws.com/profile3.jpg', 3);

-- 4. Insert data into the Photographer table
INSERT INTO photographer (id, first_name, last_name, studio_id) VALUES (1, 'Alice', 'Smith', 1);
INSERT INTO photographer (id, first_name, last_name, studio_id) VALUES (2, 'Bob', 'Johnson', 1);
INSERT INTO photographer (id, first_name, last_name, studio_id) VALUES (3, 'Charlie', 'Brown', 2);
INSERT INTO photographer (id, first_name, last_name, studio_id) VALUES (4, 'David', 'Williams', 3);
INSERT INTO photographer (id, first_name, last_name, studio_id) VALUES (5, 'Eva', 'Jones', 3);

-- 5. Insert data into the Portfolio Photo table
INSERT INTO portfolio_photo (id, image, studio_id) VALUES (1, 'https://fake-s3-bucket.s3.amazonaws.com/Fake.ico', 1);
INSERT INTO portfolio_photo (id, image, studio_id) VALUES (2, 'https://fake-s3-bucket.s3.amazonaws.com/Real.png', 1);
INSERT INTO portfolio_photo (id, image, studio_id) VALUES (3, 'https://fake-s3-bucket.s3.amazonaws.com/Custom.jpg', 2);
INSERT INTO portfolio_photo (id, image, studio_id) VALUES (4, 'https://fake-s3-bucket.s3.amazonaws.com/Potato.jpg', 3);
INSERT INTO portfolio_photo (id, image, studio_id) VALUES (5, 'https://fake-s3-bucket.s3.amazonaws.com/Apple.png', 3);

-- 6. Insert data into the StudioSpecialty table
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (1, 1, 1);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (2, 2, 2);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (3, 3, 3);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (4, 1, 4);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (5, 3, 4);
