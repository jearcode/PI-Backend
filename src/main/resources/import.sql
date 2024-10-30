-- Fake test data

-- 1. Insert data into the Location table
INSERT INTO location (id, city, state, country, address) VALUES (1, 'New York', 'NY', 'USA', '123 Main St, New York, NY 10001');
INSERT INTO location (id, city, state, country, address) VALUES (2, 'Los Angeles', 'CA', 'USA', '456 Elm St, Los Angeles, CA 90001');
INSERT INTO location (id, city, state, country, address) VALUES (3, 'Chicago', 'IL', 'USA', '789 Oak St, Chicago, IL 60601');
INSERT INTO location (id, city, state, country, address) VALUES (4, 'San Francisco', 'CA', 'USA', '123 Bay St, San Francisco, CA 94101');
INSERT INTO location (id, city, state, country, address) VALUES (5, 'Seattle', 'WA', 'USA', '456 Pine St, Seattle, WA 98101');
INSERT INTO location (id, city, state, country, address) VALUES (6, 'Miami', 'FL', 'USA', '789 Ocean Dr, Miami, FL 33139');
INSERT INTO location (id, city, state, country, address) VALUES (7, 'Houston', 'TX', 'USA', '101 Texas St, Houston, TX 77001');
INSERT INTO location (id, city, state, country, address) VALUES (8, 'Boston', 'MA', 'USA', '202 Freedom Ave, Boston, MA 02101');
INSERT INTO location (id, city, state, country, address) VALUES (9, 'Denver', 'CO', 'USA', '303 Mile High St, Denver, CO 80201');
INSERT INTO location (id, city, state, country, address) VALUES (10, 'Austin', 'TX', 'USA', '404 Music Ln, Austin, TX 78701');
INSERT INTO location (id, city, state, country, address) VALUES (11, 'Orlando', 'FL', 'USA', '505 Magic Way, Orlando, FL 32801');
INSERT INTO location (id, city, state, country, address) VALUES (12, 'Atlanta', 'GA', 'USA', '606 Peach St, Atlanta, GA 30301');
INSERT INTO location (id, city, state, country, address) VALUES (13, 'Las Vegas', 'NV', 'USA', '707 Vegas Blvd, Las Vegas, NV 89101');
INSERT INTO location (id, city, state, country, address) VALUES (14, 'Phoenix', 'AZ', 'USA', '808 Sun Dr, Phoenix, AZ 85001');
INSERT INTO location (id, city, state, country, address) VALUES (15, 'Philadelphia', 'PA', 'USA', '909 Liberty Rd, Philadelphia, PA 19101');
INSERT INTO location (id, city, state, country, address) VALUES (16, 'San Diego', 'CA', 'USA', '1010 Coastline Ave, San Diego, CA 92101');
INSERT INTO location (id, city, state, country, address) VALUES (17, 'Detroit', 'MI', 'USA', '1111 Motor St, Detroit, MI 48201');
INSERT INTO location (id, city, state, country, address) VALUES (18, 'Nashville', 'TN', 'USA', '1212 Music Row, Nashville, TN 37201');

-- 2. Insert data into the Specialties table
INSERT INTO specialty (id, specialty_name) VALUES (1, 'Wedding Photography');
INSERT INTO specialty (id, specialty_name) VALUES (2, 'Product Photography');
INSERT INTO specialty (id, specialty_name) VALUES (3, 'Portrait Photography');
INSERT INTO specialty (id, specialty_name) VALUES (4, 'Event Photography');

-- 3. Insert data into the Studio table
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (1, 'Luxe Wedding Studio', 'info@luxewedding.com', '123-456-7890', 'Specializing in wedding photography.', NOW(), 5, 'https://fake-s3-bucket.s3.amazonaws.com/profile1.jpg', 1);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (2, 'LA Product Shots', 'contact@laproductshots.com', '987-654-3210', 'Expert in product photography.', NOW(), 3, 'https://fake-s3-bucket.s3.amazonaws.com/profile2.jpg', 2);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (3, 'Chicago Portraits', 'hello@chicagoportraits.com', '555-123-4567', 'Capturing portraits that tell a story.', NOW(), 10, 'https://fake-s3-bucket.s3.amazonaws.com/profile3.jpg', 3);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (4, 'Sunset Photography', 'contact@sunsetphoto.com', '111-222-3333', 'Golden hour specialists.', NOW(), 8, 'https://fake-s3-bucket.s3.amazonaws.com/profile4.jpg', 4);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (5, 'Urban Shots', 'info@urbanshots.com', '222-333-4444', 'Specialized in cityscapes.', NOW(), 4, 'https://fake-s3-bucket.s3.amazonaws.com/profile5.jpg', 5);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (6, 'Nature Focus', 'contact@naturefocus.com', '333-444-5555', 'Capturing natures beauty.', NOW(), 12, 'https://fake-s3-bucket.s3.amazonaws.com/profile6.jpg', 6);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (7, 'Architectural Lens', 'hello@archlens.com', '444-555-6666', 'Experts in architectural photography.', NOW(), 7, 'https://fake-s3-bucket.s3.amazonaws.com/profile7.jpg', 7);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (8, 'Foodtography', 'info@foodtography.com', '555-666-7777', 'Specialists in food photography.', NOW(), 6, 'https://fake-s3-bucket.s3.amazonaws.com/profile8.jpg', 8);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (9, 'Fashion Frames', 'contact@fashionframes.com', '666-777-8888', 'Capturing the latest trends.', NOW(), 9, 'https://fake-s3-bucket.s3.amazonaws.com/profile9.jpg', 9);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (10, 'Pet Portraits', 'hello@petportraits.com', '777-888-9999', 'Adorable pet portraits.', NOW(), 5, 'https://fake-s3-bucket.s3.amazonaws.com/profile10.jpg', 10);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (11, 'Vintage Vibes', 'info@vintagevibes.com', '888-999-0000', 'Specializing in vintage photography.', NOW(), 10, 'https://fake-s3-bucket.s3.amazonaws.com/profile11.jpg', 11);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (12, 'Studio Portraits', 'contact@studioportraits.com', '999-000-1111', 'Professional studio portraits.', NOW(), 11, 'https://fake-s3-bucket.s3.amazonaws.com/profile12.jpg', 12);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (13, 'Travelography', 'hello@travelography.com', '000-111-2222', 'Travel photography experts.', NOW(), 3, 'https://fake-s3-bucket.s3.amazonaws.com/profile13.jpg', 13);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (14, 'Abstract Arts', 'info@abstractarts.com', '111-333-5555', 'Abstract and creative photography.', NOW(), 6, 'https://fake-s3-bucket.s3.amazonaws.com/profile14.jpg', 14);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (15, 'Lifestyle Shoots', 'contact@lifestyleshoots.com', '222-444-6666', 'Lifestyle and candid shots.', NOW(), 8, 'https://fake-s3-bucket.s3.amazonaws.com/profile15.jpg', 15);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (16, 'Nightscape Studio', 'hello@nightscapestudio.com', '333-555-7777', 'Specialized in night photography.', NOW(), 2, 'https://fake-s3-bucket.s3.amazonaws.com/profile16.jpg', 16);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (17, 'Black & White Classics', 'info@bwclassics.com', '444-666-8888', 'Black and white photography.', NOW(), 10, 'https://fake-s3-bucket.s3.amazonaws.com/profile17.jpg', 17);
INSERT INTO studio (id, studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES (18, 'Sports Moments', 'contact@sportsmoments.com', '555-777-9999', 'Capturing action in sports.', NOW(), 9, 'https://fake-s3-bucket.s3.amazonaws.com/profile18.jpg', 18);

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
