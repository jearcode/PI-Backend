-- 1. Insert data into the Location table
INSERT INTO location (city, state, country, address) VALUES ('New York', 'NY', 'USA', '123 Main St, New York, NY 10001');
INSERT INTO location (city, state, country, address) VALUES ('Los Angeles', 'CA', 'USA', '456 Elm St, Los Angeles, CA 90001');
INSERT INTO location (city, state, country, address) VALUES ('Chicago', 'IL', 'USA', '789 Oak St, Chicago, IL 60601');
INSERT INTO location (city, state, country, address) VALUES ('San Francisco', 'CA', 'USA', '123 Bay St, San Francisco, CA 94101');
INSERT INTO location (city, state, country, address) VALUES ('Seattle', 'WA', 'USA', '456 Pine St, Seattle, WA 98101');
INSERT INTO location (city, state, country, address) VALUES ('Miami', 'FL', 'USA', '789 Ocean Dr, Miami, FL 33139');
INSERT INTO location (city, state, country, address) VALUES ('Houston', 'TX', 'USA', '101 Texas St, Houston, TX 77001');
INSERT INTO location (city, state, country, address) VALUES ('Boston', 'MA', 'USA', '202 Freedom Ave, Boston, MA 02101');
INSERT INTO location (city, state, country, address) VALUES ('Denver', 'CO', 'USA', '303 Mile High St, Denver, CO 80201');
INSERT INTO location (city, state, country, address) VALUES ('Austin', 'TX', 'USA', '404 Music Ln, Austin, TX 78701');
INSERT INTO location (city, state, country, address) VALUES ('Orlando', 'FL', 'USA', '505 Magic Way, Orlando, FL 32801');
INSERT INTO location (city, state, country, address) VALUES ('Atlanta', 'GA', 'USA', '606 Peach St, Atlanta, GA 30301');
INSERT INTO location (city, state, country, address) VALUES ('Las Vegas', 'NV', 'USA', '707 Vegas Blvd, Las Vegas, NV 89101');
INSERT INTO location (city, state, country, address) VALUES ('Phoenix', 'AZ', 'USA', '808 Sun Dr, Phoenix, AZ 85001');
INSERT INTO location (city, state, country, address) VALUES ('Philadelphia', 'PA', 'USA', '909 Liberty Rd, Philadelphia, PA 19101');
INSERT INTO location (city, state, country, address) VALUES ('San Diego', 'CA', 'USA', '1010 Coastline Ave, San Diego, CA 92101');
INSERT INTO location (city, state, country, address) VALUES ('Detroit', 'MI', 'USA', '1111 Motor St, Detroit, MI 48201');
INSERT INTO location (city, state, country, address) VALUES ('Nashville', 'TN', 'USA', '1212 Music Row, Nashville, TN 37201');

-- 2. Insert data into the Specialty table
INSERT INTO specialty (specialty_name) VALUES ('Wedding Photography');
INSERT INTO specialty (specialty_name) VALUES ('Product Photography');
INSERT INTO specialty (specialty_name) VALUES ('Portrait Photography');
INSERT INTO specialty (specialty_name) VALUES ('Event Photography');

-- 3. Insert data into the Studio table
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Luxe Wedding Studio', 'info@luxewedding.com', '123-456-7890', 'Specializing in wedding photography.', NOW(), 5, 'https://fake-s3-bucket.s3.amazonaws.com/profile1.jpg', 1);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('LA Product Shots', 'contact@laproductshots.com', '987-654-3210', 'Expert in product photography.', NOW(), 3, 'https://fake-s3-bucket.s3.amazonaws.com/profile2.jpg', 2);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Chicago Portraits', 'hello@chicagoportraits.com', '555-123-4567', 'Capturing portraits that tell a story.', NOW(), 10, 'https://fake-s3-bucket.s3.amazonaws.com/profile3.jpg', 3);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Sunset Photography', 'contact@sunsetphoto.com', '111-222-3333', 'Golden hour specialists.', NOW(), 8, 'https://fake-s3-bucket.s3.amazonaws.com/profile4.jpg', 4);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Urban Shots', 'info@urbanshots.com', '222-333-4444', 'Specialized in cityscapes.', NOW(), 4, 'https://fake-s3-bucket.s3.amazonaws.com/profile5.jpg', 5);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Nature Focus', 'contact@naturefocus.com', '333-444-5555', 'Capturing natures beauty.', NOW(), 12, 'https://fake-s3-bucket.s3.amazonaws.com/profile6.jpg', 6);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Architectural Lens', 'hello@archlens.com', '444-555-6666', 'Experts in architectural photography.', NOW(), 7, 'https://fake-s3-bucket.s3.amazonaws.com/profile7.jpg', 7);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Foodtography', 'info@foodtography.com', '555-666-7777', 'Specialists in food photography.', NOW(), 6, 'https://fake-s3-bucket.s3.amazonaws.com/profile8.jpg', 8);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Fashion Frames', 'contact@fashionframes.com', '666-777-8888', 'Capturing the latest trends.', NOW(), 9, 'https://fake-s3-bucket.s3.amazonaws.com/profile9.jpg', 9);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Pet Portraits', 'hello@petportraits.com', '777-888-9999', 'Adorable pet portraits.', NOW(), 5, 'https://fake-s3-bucket.s3.amazonaws.com/profile10.jpg', 10);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Vintage Vibes', 'info@vintagevibes.com', '888-999-0000', 'Specializing in vintage photography.', NOW(), 10, 'https://fake-s3-bucket.s3.amazonaws.com/profile11.jpg', 11);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Studio Portraits', 'contact@studioportraits.com', '999-000-1111', 'Professional studio portraits.', NOW(), 11, 'https://fake-s3-bucket.s3.amazonaws.com/profile12.jpg', 12);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Travelography', 'hello@travelography.com', '000-111-2222', 'Travel photography experts.', NOW(), 3, 'https://fake-s3-bucket.s3.amazonaws.com/profile13.jpg', 13);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Abstract Arts', 'info@abstractarts.com', '111-333-5555', 'Abstract and creative photography.', NOW(), 6, 'https://fake-s3-bucket.s3.amazonaws.com/profile14.jpg', 14);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Lifestyle Shoots', 'contact@lifestyleshoots.com', '222-444-6666', 'Lifestyle and candid shots.', NOW(), 8, 'https://fake-s3-bucket.s3.amazonaws.com/profile15.jpg', 15);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Nightscape Studio', 'hello@nightscapestudio.com', '333-555-7777', 'Specialized in night photography.', NOW(), 2, 'https://fake-s3-bucket.s3.amazonaws.com/profile16.jpg', 16);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Black & White Classics', 'info@bwclassics.com', '444-666-8888', 'Timeless black & white photography.', NOW(), 15, 'https://fake-s3-bucket.s3.amazonaws.com/profile17.jpg', 17);
INSERT INTO studio (studio_name, email, phone, description, signup, years_of_experience, profile_image, location_id) VALUES ('Drone Vision', 'contact@dronevision.com', '555-777-9999', 'Aerial and drone shots.', NOW(), 4, 'https://fake-s3-bucket.s3.amazonaws.com/profile18.jpg', 18);

-- 4. Insert data into the Photographer table
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Alice', 'Smith', 1);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Bob', 'Johnson', 1);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Charlie', 'Brown', 2);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('David', 'Williams', 3);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Eva', 'Jones', 3);

-- 5. Insert data into the Portfolio Photo table
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://fake-s3-bucket.s3.amazonaws.com/wedding1.jpg', 1);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://fake-s3-bucket.s3.amazonaws.com/product1.jpg', 2);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://fake-s3-bucket.s3.amazonaws.com/portrait1.jpg', 3);

-- 6. Insert data into the StudioSpecialty table
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (1, 1, 1);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (2, 2, 2);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (3, 3, 3);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (4, 1, 4);
INSERT INTO studio_specialty (id, studio_id, specialty_id) VALUES (5, 3, 4);