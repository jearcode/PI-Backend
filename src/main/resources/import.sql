-- 1. Insert data into the Specialty table
INSERT INTO specialty (specialty_name, description, image) VALUES ('Wedding Photography', 'Capture memorable wedding moments with emotional and professional shots.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Wedding/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Portrait Photography', 'Highlight personality and expression through close-up, detailed portraits.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Portrait/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Product Photography', 'Showcase products with high-quality images to boost brand appeal and sales.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Product/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Corporate Photography', 'Present a professional business image with corporate and branding photos.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Corporate/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Graduation Photography', 'Celebrate academic achievements with timeless graduation portraits.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Graduation/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Fashion Photography', 'Capture the essence of style with dynamic, creative fashion images.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Fashion/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Food Photography', 'Highlight the deliciousness of food with mouthwatering visual details.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Food/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Real Estate Photography', 'Display properties attractively for potential buyers and clients.', 'https://backend-s3-images.s3.amazonaws.com/specialties/RealEstate/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Landscape Photography', 'Capture nature’s beauty with stunning, scenic landscape shots.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Landscape/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Pet Photography', 'Capture the unique charm and personality of pets in beautiful photos.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Pet/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Sports Photography', 'Capture dynamic and exciting moments of sports and athletes.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Sports/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Travel Photography', 'Showcase the beauty and diversity of global travel destinations.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Travel/profile-image');
INSERT INTO specialty (specialty_name, description, image) VALUES ('Artistic Photography', 'Express creativity with unique, experimental artistic images.', 'https://backend-s3-images.s3.amazonaws.com/specialties/Artistic/profile-image');


INSERT INTO feature (feature_name, icon) VALUES ('In-Studio Session', 'simple-icons:photon');
INSERT INTO feature (feature_name, icon) VALUES ('At-Home Session', 'ic:baseline-home');
INSERT INTO feature (feature_name, icon) VALUES ('Makeup', 'icon-park-twotone:makeups');
INSERT INTO feature (feature_name, icon) VALUES ('Wardrobe', 'mdi:wardrobe');
INSERT INTO feature (feature_name, icon) VALUES ('Stylist', 'file-icons:styledcomponents');
INSERT INTO feature (feature_name, icon) VALUES ('Daytime Schedule', 'mingcute:partly-cloud-daytime-fill');
INSERT INTO feature (feature_name, icon) VALUES ('Nighttime Schedule', 'game-icons:night-sky');
INSERT INTO feature (feature_name, icon) VALUES ('Themed Sets', 'catppuccin:folder-themes-open');
INSERT INTO feature (feature_name, icon) VALUES ('Photo Printing', 'tabler:photo-filled');
INSERT INTO feature (feature_name, icon) VALUES ('Digital Album', 'solar:album-bold');
INSERT INTO feature (feature_name, icon) VALUES ('Video', 'majesticons:video');
INSERT INTO feature (feature_name, icon) VALUES ('Editing', 'icon-park-solid:file-editing-one');
INSERT INTO feature (feature_name, icon) VALUES ('Varied Backgrounds', 'fluent-mdl2:background-color');
INSERT INTO feature (feature_name, icon) VALUES ('Pose Guidance', 'arcticons:magic-poser');
INSERT INTO feature (feature_name, icon) VALUES ('Props and Accessories', 'solar:settings-bold');
INSERT INTO feature (feature_name, icon) VALUES ('Natural Lighting', 'icon-park-twotone:natural-mode');
INSERT INTO feature (feature_name, icon) VALUES ('Flash Lighting', 'material-symbols:no-flash');



-- 2. Insert data into the Location table
INSERT INTO location (city, state, country, address) VALUES ('Los Angeles', 'California', 'USA', '123 Adora St, Los Angeles, CA 90001');
INSERT INTO location (city, state, country, address) VALUES ('Miami', 'Florida', 'USA', '456 Ocean Dr, Miami, FL 33139');
INSERT INTO location (city, state, country, address) VALUES ('Seattle', 'Washington', 'USA', '789 Pine St, Seattle, WA 98101');
INSERT INTO location (city, state, country, address) VALUES ('San Francisco', 'California', 'USA', '101 Lombard St, San Francisco, CA 94111');
INSERT INTO location (city, state, country, address) VALUES ('Denver', 'Colorado', 'USA', '202 Broadway, Denver, CO 80203');
INSERT INTO location (city, state, country, address) VALUES ('Chicago', 'Illinois', 'USA', '303 Lake Shore Dr, Chicago, IL 60611');
INSERT INTO location (city, state, country, address) VALUES ('Austin', 'Texas', 'USA', '404 South Congress Ave, Austin, TX 78704');
INSERT INTO location (city, state, country, address) VALUES ('New York', 'New York', 'USA', '505 Park Ave, New York, NY 10022');
INSERT INTO location (city, state, country, address) VALUES ('Portland', 'Oregon', 'USA', '606 SE Grand Ave, Portland, OR 97214');
INSERT INTO location (city, state, country, address) VALUES ('Boston', 'Massachusetts', 'USA', '707 Beacon St, Boston, MA 02215');
INSERT INTO location (city, state, country, address) VALUES ('Phoenix', 'Arizona', 'USA', '808 Grand Canyon Dr, Phoenix, AZ 85004');
INSERT INTO location (city, state, country, address) VALUES ('Chicago', 'Illinois', 'USA', '789 SnapTails Rd, Chicago, IL 60601');
INSERT INTO location (city, state, country, address) VALUES ('San Francisco', 'California', 'USA', '456 Elysium Ave, San Francisco, CA 94101');
INSERT INTO location (city, state, country, address) VALUES ('Los Angeles', 'California', 'USA', '123 Sunset Blvd');
INSERT INTO location (city, state, country, address) VALUES ('New York', 'New York', 'USA', '456 Madison Ave');
INSERT INTO location (city, state, country, address) VALUES ('Toronto', 'Ontario', 'Canada', '789 King St');
INSERT INTO location (city, state, country, address) VALUES ('Paris', 'Île-de-France', 'France', '101 Rue de Rivoli');
INSERT INTO location (city, state, country, address) VALUES ('London', 'Greater London', 'UK', '22 Baker Street');
INSERT INTO location (city, state, country, address) VALUES ('Tokyo', 'Tokyo', 'Japan', '1-1 Chiyoda');
INSERT INTO location (city, state, country, address) VALUES ('Sydney', 'New South Wales', 'Australia', '77 Harbour St');
INSERT INTO location (city, state, country, address) VALUES ('Berlin', 'Berlin', 'Germany', '12 Alexanderplatz');
INSERT INTO location (city, state, country, address) VALUES ('Madrid', 'Community of Madrid', 'Spain', '23 Gran Via');
INSERT INTO location (city, state, country, address) VALUES ('Mexico City', 'CDMX', 'Mexico', '44 Paseo de la Reforma');
INSERT INTO location (city, state, country, address) VALUES ('Rome', 'Lazio', 'Italy', '99 Via del Corso');

-- 3. Insert data into the Studio table
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Adora', 'contact@adora.com', '+1(123)456-7890', 'Adora specializes in wedding and portrait photography, ensuring that every emotion and detail is beautifully captured for lifelong memories.', '2024-10-31T02:51:25.707815', NOW(), 12, 'https://backend-s3-images.s3.amazonaws.com/studios/Adora/profile-image', 1);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Borcelle', 'hello@borcelle.com', '+1(234)567-8901', 'Borcelle focuses on fashion photography, bringing creativity and style to life in every shot, ensuring clients look their absolute best.', '2023-08-12T10:14:37.402831', NOW(), 8, 'https://backend-s3-images.s3.amazonaws.com/studios/Borcelle/profile-image', 2);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Eyelens', 'info@eyelens.com', '+1(345)678-9012', 'Eyelens is your go-to for corporate and product photography, highlighting brand identity with striking visuals that stand out in the marketplace.', '2024-02-28T17:21:12.309485', NOW(), 5, 'https://backend-s3-images.s3.amazonaws.com/studios/Eyelens/profile-image', 3);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Fauget', 'booking@fauget.com', '+1(456)789-0123', 'Fauget excels in real estate photography, creating stunning visuals that showcase properties in their best light, attracting potential buyers and elevating listings.', '2023-11-01T15:37:29.584917', NOW(), 10, 'https://backend-s3-images.s3.amazonaws.com/studios/Fauget/profile-image', 4);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Focus Photography', 'support@focusphotography.com', '+1(567)890-1234', 'Focus Photography captures the thrill of travel and breathtaking landscapes, providing imagery that inspires adventure and wanderlust.', '2024-03-15T08:51:42.216720', NOW(), 7, 'https://backend-s3-images.s3.amazonaws.com/studios/FocusPhotography/profile-image', 5);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('HanOver', 'contact@hanover.com', '+1(678)901-2345', 'HanOver specializes in sports photography, delivering dynamic images that capture the excitement and intensity of every event.', '2022-09-25T21:42:51.198713', NOW(), 15, 'https://backend-s3-images.s3.amazonaws.com/studios/HanOver/profile-image', 6);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Lavana', 'hello@lavana.com', '+1(789)012-3456', 'Lavana creates unforgettable memories through wedding and food photography, blending creativity with authenticity.', '2023-12-07T19:37:50.616712', NOW(), 9, 'https://backend-s3-images.s3.amazonaws.com/studios/Lavana/profile-image', 7);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Matt Zhang', 'bookings@mattzhang.com', '+1(890)123-4567', 'Matt Zhang specializes in artistic and portrait photography, capturing personality with a unique, creative approach.', '2024-01-18T11:29:23.512894', NOW(), 6, 'https://backend-s3-images.s3.amazonaws.com/studios/MattZhang/profile-image', 8);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Moon Studio', 'info@moonstudio.com', '+1(901)234-5678', 'Moon Studio excels in graduation photography, capturing the joy and accomplishment of each graduate in beautiful settings.', '2024-04-05T14:17:06.832194', NOW(), 11, 'https://backend-s3-images.s3.amazonaws.com/studios/MoonStudio/profile-image', 9);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Noah', 'reach@noah.com', '+1(012)345-6789', 'Noah focuses on product photography, ensuring that every detail of your product is highlighted to attract customers.', '2023-05-22T07:11:44.103275', NOW(), 4, 'https://backend-s3-images.s3.amazonaws.com/studios/Noah/profile-image', 10);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Rimberio', 'support@rimberio.com', '+1(234)567-8901', 'Rimberio specializes in product photography, showcasing the details and appeal of your products with stunning and precise images.', '2023-06-19T06:54:32.921387', NOW(), 13, 'https://backend-s3-images.s3.amazonaws.com/studios/Rimberio/profile-image', 11);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ( 'SnapTails', 'info@snaptails.com', '+1(123)456-7892', 'SnapTails captures the essence of your pets through stunning photography, creating joyful memories of your furry companions.', NOW(), NOW(), 5, 'https://backend-s3-images.s3.amazonaws.com/studios/SnapTails/profile-image', 12);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ( 'Elysium', 'info@elysium.com', '+1(123)456-7893', 'Elysium specializes in artistic photography, transforming emotions into visual masterpieces that captivate the soul.', NOW(), NOW(), 4, 'https://backend-s3-images.s3.amazonaws.com/studios/Elysium/profile-image', 13);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Charm Light', 'info@charmlight.com', '+1(213)555-0182', 'Capturing the essence of pets and individuals, Charm Light offers enchanting portraits full of life and personality.', '2024-10-31T02:51:25.707815', NOW(), 5, 'https://backend-s3-images.s3.amazonaws.com/studios/CharmLight/profile-image', 14);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Clix', 'contact@clixrealestate.com', '+1(212)555-0199', 'Specializing in real estate photography, Clix enhances property appeal with stunning visuals, perfect for real estate listings.', '2024-10-31T02:51:25.707815', NOW(), 8, 'https://backend-s3-images.s3.amazonaws.com/studios/Clix/profile-image', 15);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('ColorShot', 'hello@colorshot.com', '+1(416)555-0200', 'From dynamic sports to crisp product photography, ColorShot provides vivid, high-quality images to showcase your brand.', '2024-10-31T02:51:25.707815', NOW(), 10, 'https://backend-s3-images.s3.amazonaws.com/studios/ColorShot/profile-image', 16);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Essence', 'info@essenceportrait.com', '+1(331)555-0211', 'Essence captures timeless portraits that highlight individuality and beauty in each person, creating memories that last.', '2024-10-31T02:51:25.707815', NOW(), 7, 'https://backend-s3-images.s3.amazonaws.com/studios/Essence/profile-image', 17);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Frameo', 'contact@frameoart.com', '+1(437)555-0222', 'Frameo creates unique artistic photography, blending creativity and technique to capture exceptional and inspiring moments.', '2024-10-31T02:51:25.707815', NOW(), 12, 'https://backend-s3-images.s3.amazonaws.com/studios/Frameo/profile-image', 18);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Lumina', 'inquiries@luminafashion.com', '+1(646)555-0233', 'Specializing in fashion photography, Lumina brings style and elegance to every shot, perfect for brands and fashion portfolios.', '2024-10-31T02:51:25.707815', NOW(), 9, 'https://backend-s3-images.s3.amazonaws.com/studios/Lumina/profile-image', 19);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Optix', 'optix@foodphotography.com', '+1(718)555-0244', 'Optix specializes in vibrant food photography that highlights texture and taste, ideal for restaurants and food branding.', '2024-10-31T02:51:25.707815', NOW(), 6, 'https://backend-s3-images.s3.amazonaws.com/studios/Optix/profile-image', 20);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Reflex', 'info@reflexstudio.com', '+1(323)555-0255', 'Reflex offers expert landscape and fashion photography, creating stunning visuals that captivate audiences worldwide.', '2024-10-31T02:51:25.707815', NOW(), 11, 'https://backend-s3-images.s3.amazonaws.com/studios/Reflex/profile-image', 21);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Salford', 'info@salfordcorporate.com', '+1(310)555-0266', 'Salford provides top-quality corporate photography, helping businesses portray professionalism and brand identity.', '2024-10-31T02:51:25.707815', NOW(), 15, 'https://backend-s3-images.s3.amazonaws.com/studios/Salford/profile-image', 22);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Shotter', 'bookings@shotter.com', '+1(305)555-0277', 'Shotter specializes in portrait and graduation photography, capturing life’s milestones with elegance and precision.', '2024-10-31T02:51:25.707815', NOW(), 4, 'https://backend-s3-images.s3.amazonaws.com/studios/Shotter/profile-image', 23);
INSERT INTO studio (studio_name, email, phone, description, signup, last_update, years_of_experience, profile_image, location_id) VALUES ('Visu', 'info@visutravel.com', '+1(212)555-0288', 'Visu specializes in travel photography, capturing breathtaking scenes from around the world to inspire wanderlust.', '2024-10-31T02:51:25.707815', NOW(), 13, 'https://backend-s3-images.s3.amazonaws.com/studios/Visu/profile-image', 24);

-- 4. Insert data into the Photographer table
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Maria', 'Ortiz', 1);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('John', 'Keller', 1);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Sarah', 'Donovan', 1);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Clara', 'Evans', 2);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Leo', 'Thompson', 2);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Grace', 'Miller', 3);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Tom', 'Parker', 3);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Alice', 'Woods', 3);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Emily', 'Clark', 4);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Ryan', 'Hall', 5);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Nathan', 'Brooks', 5);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Jack', 'Scott', 6);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Olivia', 'Baker', 7);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Sophia', 'Green', 7);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Daniel', 'Roberts', 8);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Mia', 'Harris', 8);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Ella', 'Adams', 9);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('James', 'Mitchell', 9);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Benjamin', 'Fisher', 10);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Victoria', 'Wright', 10);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Lucas', 'James', 11);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Isabella', 'Bennett', 11);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Emily', 'Johnson', 12);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Chris', 'Smith', 12);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Olivia', 'Martinez', 12);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Sophia', 'Lee', 13);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Liam', 'Taylor', 13);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Mia', 'Clark', 13);
-- Charm Light
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Ava', 'Wilson', 14);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Noah', 'Miller', 14);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Lucas', 'Davis', 14);

-- Clix
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Ella', 'Garcia', 15);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Jack', 'Martinez', 15);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Zoe', 'Hernandez', 15);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Mason', 'Lopez', 15);

-- ColorShot
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Benjamin', 'Rodriguez', 16);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Amelia', 'Gonzalez', 16);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Maya', 'Perez', 16);

-- Essence
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Isabella', 'Smith', 17);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Ethan', 'Johnson', 17);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Charlotte', 'Williams', 17);

-- Frameo
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('James', 'Brown', 18);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Mila', 'Jones', 18);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Jackson', 'Lee', 18);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Lily', 'Walker', 18);

-- Lumina
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Lucas', 'King', 19);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Emma', 'Scott', 19);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Sebastian', 'Young', 19);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Aiden', 'Green', 19);

-- Optix
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Sophia', 'Adams', 20);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('David', 'Nelson', 20);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Grace', 'Carter', 20);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Matthew', 'Perez', 20);

-- Reflex
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Charlotte', 'Phillips', 21);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Wyatt', 'Evans', 21);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Liam', 'Tucker', 21);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Olivia', 'Baker', 21);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Mason', 'Harris', 21);

-- Salford
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Samuel', 'Gray', 22);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Chloe', 'Thompson', 22);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('John', 'Roberts', 22);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Emily', 'Morris', 22);

-- Shotter
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Oliver', 'Bennett', 23);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Amelia', 'Mitchell', 23);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Aiden', 'Jackson', 23);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Ella', 'Lee', 23);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Henry', 'Clark', 23);

-- Visu
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Maya', 'Allen', 24);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Nathan', 'Martinez', 24);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Sophie', 'Hughes', 24);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Jack', 'Young', 24);
INSERT INTO photographer (first_name, last_name, studio_id) VALUES ('Megan', 'Wright', 24);


INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Adora/photography-1', 1);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Adora/photography-2', 1);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Adora/photography-3', 1);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Adora/photography-4', 1);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Adora/photography-5', 1);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Borcelle/photography-1', 2);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Borcelle/photography-2', 2);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Borcelle/photography-3', 2);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Borcelle/photography-4', 2);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Borcelle/photography-5', 2);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Eyelens/photography-1', 3);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Eyelens/photography-2', 3);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Eyelens/photography-3', 3);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Eyelens/photography-4', 3);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Eyelens/photography-5', 3);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Fauget/photography-1', 4);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Fauget/photography-2', 4);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Fauget/photography-3', 4);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Fauget/photography-4', 4);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Fauget/photography-5', 4);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/FocusPhotography/photography-1', 5);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Focus/photography-2', 5);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/FocusPhotography/photography-3', 5);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/FocusPhotography/photography-4', 5);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/FocusPhotography/photography-5', 5);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/HanOver/photography-1', 6);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/HanOver/photography-2', 6);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/HanOver/photography-3', 6);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/HanOver/photography-4', 6);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/HanOver/photography-5', 6);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lavana/photography-1', 7);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lavana/photography-2', 7);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lavana/photography-3', 7);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lavana/photography-4', 7);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lavana/photography-5', 7);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MattZhang/photography-1', 8);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MattZhang/photography-2', 8);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MattZhang/photography-3', 8);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MattZhang/photography-4', 8);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MattZhang/photography-5', 8);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MoonStudio/photography-1', 9);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MoonStudio/photography-2', 9);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MoonStudio/photography-3', 9);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MoonStudio/photography-4', 9);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/MoonStudio/photography-5', 9);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Noah/photography-1', 10);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Noah/photography-2', 10);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Noah/photography-3', 10);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Noah/photography-4', 10);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Noah/photography-5', 10);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Rimberio/photography-1', 11);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Rimberio/photography-2', 11);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Rimberio/photography-3', 11);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Rimberio/photography-4', 11);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Rimberio/photography-5', 11);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/SnapTails/photography-1', 12);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/SnapTails/photography-2', 12);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/SnapTails/photography-3', 12);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/SnapTails/photography-4', 12);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/SnapTails/photography-5', 12);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Elysium/photography-1', 13);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Elysium/photography-2', 13);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Elysium/photography-3', 13);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Elysium/photography-4', 13);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Elysium/photography-5', 13);
-- Charm Light
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/CharmLight/photography-1', 14);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/CharmLight/photography-2', 14);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/CharmLight/photography-3', 14);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/CharmLight/photography-4', 14);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/CharmLight/photography-5', 14);

-- Clix
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Clix/photography-1', 15);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Clix/photography-2', 15);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Clix/photography-3', 15);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Clix/photography-4', 15);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Clix/photography-5', 15);

-- ColorShot
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/ColorShot/photography-1', 16);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/ColorShot/photography-2', 16);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/ColorShot/photography-3', 16);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/ColorShot/photography-4', 16);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/ColorShot/photography-5', 16);

-- Essence
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Essence/photography-1', 17);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Essence/photography-2', 17);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Essence/photography-3', 17);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Essence/photography-4', 17);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Essence/photography-5', 17);

-- Frameo
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Frameo/photography-1', 18);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Frameo/photography-2', 18);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Frameo/photography-3', 18);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Frameo/photography-4', 18);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Frameo/photography-5', 18);

-- Lumina
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lumina/photography-1', 19);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lumina/photography-2', 19);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lumina/photography-3', 19);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lumina/photography-4', 19);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Lumina/photography-5', 19);

-- Optix
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Optix/photography-1', 20);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Optix/photography-2', 20);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Optix/photography-3', 20);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Optix/photography-4', 20);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Optix/photography-5', 20);

-- Reflex
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Reflex/photography-1', 21);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Reflex/photography-2', 21);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Reflex/photography-3', 21);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Reflex/photography-4', 21);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Reflex/photography-5', 21);

-- Salford
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Salford/photography-1', 22);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Salford/photography-2', 22);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Salford/photography-3', 22);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Salford/photography-4', 22);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Salford/photography-5', 22);

-- Shotter
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Shotter/photography-1', 23);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Shotter/photography-2', 23);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Shotter/photography-3', 23);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Shotter/photography-4', 23);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Shotter/photography-5', 23);

-- Visu
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Visu/photography-1', 24);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Visu/photography-2', 24);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Visu/photography-3', 24);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Visu/photography-4', 24);
INSERT INTO portfolio_photo (image, studio_id) VALUES ('https://backend-s3-images.s3.amazonaws.com/studios/Visu/photography-5', 24);


INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (1, 1);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (2, 1);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (6, 2);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (4, 3);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (3, 3);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (8, 4);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (9, 5);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (12, 5);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (11, 6);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (7, 7);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (1, 7);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (2, 8);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (13, 8);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (5, 9);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (3, 10);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (3, 11);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (10, 12);
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (13, 13);

-- Charm Light (Pet y Portrait)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (10, 14);  -- Pet Photography
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (2, 14);   -- Portrait Photography

-- Clix (Real Estate)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (8, 15);   -- Real Estate Photography

-- ColorShot (Product y Sports)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (3, 16);   -- Product Photography
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (11, 16);  -- Sports Photography

-- Essence (Portrait)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (2, 17);   -- Portrait Photography

-- Frameo (Artistic)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (13, 18);  -- Artistic Photography

-- Lumina (Fashion)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (6, 19);   -- Fashion Photography

-- Optix (Food)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (7, 20);   -- Food Photography

-- Reflex (Landscape y Fashion)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (9, 21);   -- Landscape Photography
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (6, 21);   -- Fashion Photography

-- Salford (Corporate)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (4, 22);   -- Corporate Photography

-- Shotter (Portrait y Graduation)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (2, 23);   -- Portrait Photography
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (5, 23);   -- Graduation Photography

-- Visu (Travel)
INSERT INTO studio_specialty (specialty_id, studio_id) VALUES (12, 24);  -- Travel Photography


---- FEATURES

-- Adora - Wedding & Portrait Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (1, 1);  -- High-Resolution Photos
INSERT INTO studio_feature (feature_id, studio_id) VALUES (2, 1);  -- Digital Album
INSERT INTO studio_feature (feature_id, studio_id) VALUES (4, 1);  -- Makeup
INSERT INTO studio_feature (feature_id, studio_id) VALUES (6, 1);  -- Daytime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (13, 1); -- Props or Accessories


-- Borcelle - Fashion Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (5, 2);  -- Stylist
INSERT INTO studio_feature (feature_id, studio_id) VALUES (6, 2);  -- Daytime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (7, 2);  -- Nighttime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (13, 2); -- Props or Accessories

-- Eyelens - Corporate & Product Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (3, 3);  -- Photo Printing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 3);  -- Editing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (12, 3); -- Variety of Backgrounds

-- Fauget - Real Estate Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (6, 4);  -- Daytime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (7, 4);  -- Nighttime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (12, 4); -- Variety of Backgrounds

-- Focus Photography - Travel & Landscape Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (12, 5); -- Variety of Backgrounds
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 5); -- Natural Lighting

-- HanOver - Sports Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (13, 6); -- Props or Accessories
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 6); -- Natural Lighting

-- Lavana - Wedding & Food Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (1, 7);  -- High-Resolution Photos
INSERT INTO studio_feature (feature_id, studio_id) VALUES (2, 7);  -- Digital Album
INSERT INTO studio_feature (feature_id, studio_id) VALUES (8, 7);  -- Video
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 7); -- Natural Lighting

-- Matt Zhang - Artistic & Portrait Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (5, 8);  -- Stylist
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 8);  -- Editing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (13, 8); -- Props or Accessories

-- Moon Studio - Graduation Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (1, 9);  -- High-Resolution Photos
INSERT INTO studio_feature (feature_id, studio_id) VALUES (2, 9);  -- Digital Album
INSERT INTO studio_feature (feature_id, studio_id) VALUES (4, 9);  -- Makeup

-- Noah - Product Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (3, 10); -- Photo Printing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 10); -- Editing

-- Rimberio - Product Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (3, 11); -- Photo Printing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 11); -- Editing

-- SnapTails - Pet Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (4, 12); -- Makeup
INSERT INTO studio_feature (feature_id, studio_id) VALUES (13, 12); -- Props or Accessories
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 12); -- Natural Lighting

-- Elysium - Artistic Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 13); -- Editing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 13); -- Natural Lighting

-- Charm Light - Pet & Portrait Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (4, 14); -- Makeup
INSERT INTO studio_feature (feature_id, studio_id) VALUES (13, 14); -- Props or Accessories
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 14); -- Natural Lighting

-- Clix - Real Estate Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (6, 15); -- Daytime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (7, 15); -- Nighttime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (12, 15); -- Variety of Backgrounds

-- ColorShot - Sports & Product Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (12, 16); -- Variety of Backgrounds
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 16);  -- Editing

-- Essence - Portrait Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (4, 17); -- Makeup
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 17); -- Editing

-- Frameo - Artistic Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 18); -- Editing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 18); -- Natural Lighting

-- Lumina - Fashion Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (5, 19); -- Stylist
INSERT INTO studio_feature (feature_id, studio_id) VALUES (6, 19); -- Daytime Availability
INSERT INTO studio_feature (feature_id, studio_id) VALUES (7, 19); -- Nighttime Availability

-- Optix - Food Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 20); -- Natural Lighting
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 20);  -- Editing

-- Reflex - Landscape & Fashion Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (12, 21); -- Variety of Backgrounds
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 21);  -- Editing

-- Salford - Corporate Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (3, 22);  -- Photo Printing
INSERT INTO studio_feature (feature_id, studio_id) VALUES (9, 22);  -- Editing

-- Shotter - Portrait & Graduation Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (1, 23);  -- High-Resolution Photos
INSERT INTO studio_feature (feature_id, studio_id) VALUES (2, 23);  -- Digital Album

-- Visu - Travel Photography
INSERT INTO studio_feature (feature_id, studio_id) VALUES (12, 24); -- Variety of Backgrounds
INSERT INTO studio_feature (feature_id, studio_id) VALUES (14, 24); -- Natural Lighting



-- Studio 1
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (1, 1, 1500.0); -- Wedding
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (1, 2, 800.0); -- Portrait

-- Studio 2
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (2, 6, 1800.0); -- Fashion

-- Studio 3
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (3, 4, 1300.0); -- Corporate
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (3, 3, 1100.0); -- Product

-- Studio 4
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (4, 8, 950.0); -- Real Estate

-- Studio 5
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (5, 9, 1300.0); -- LandScape
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (5, 12, 1400.0); -- Travel

-- Studio 6
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (6, 11, 900.0); -- Sports

-- Studio 7
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (7, 7, 750.0); -- Food
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (7, 1, 1000.0); -- Wedding

-- Studio 8
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (8, 2, 800.0); -- Portrait
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (8, 13, 1600.0); -- Artistic

-- Studio 9
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (9, 5, 850.0); -- Graduation

-- Studio 10
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (10, 3, 1100.0); -- Product

-- Studio 11
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (11, 3, 1050.0); -- Product

-- Studio 12
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (12, 10, 1250.0); -- Travel

-- Studio 13
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (13, 13, 1700.0); -- Artistic

-- Studio 14 (Charm Light)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (14, 10, 950.0); -- Pet Photography
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (14, 2, 850.0);  -- Portrait Photography

-- Studio 15 (Clix)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (15, 8, 1000.0); -- Real Estate Photography

-- Studio 16 (ColorShot)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (16, 3, 1150.0); -- Product Photography
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (16, 11, 950.0); -- Sports Photography

-- Studio 17 (Essence)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (17, 2, 900.0);  -- Portrait Photography

-- Studio 18 (Frameo)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (18, 13, 1500.0); -- Artistic Photography

-- Studio 19 (Lumina)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (19, 6, 1100.0);  -- Fashion Photography

-- Studio 20 (Optix)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (20, 7, 800.0);  -- Food Photography

-- Studio 21 (Reflex)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (21, 9, 1350.0); -- Landscape Photography
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (21, 6, 1200.0); -- Fashion Photography

-- Studio 22 (Salford)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (22, 4, 1250.0); -- Corporate Photography

-- Studio 23 (Shotter)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (23, 2, 950.0);  -- Portrait Photography
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (23, 5, 900.0);  -- Graduation Photography

-- Studio 24 (Visu)
INSERT INTO studio_price (studio_id, specialty_id, price) VALUES (24, 12, 1400.0); -- Travel Photography



INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (1, 0, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (1, 1, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (1, 2, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (1, 3, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (1, 4, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (1, 5, '09:00:00', '13:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (2, 0, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (2, 1, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (2, 2, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (2, 3, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (2, 4, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (2, 5, '08:00:00', '14:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (3, 0, '07:30:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (3, 1, '07:30:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (3, 2, '07:30:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (3, 3, '07:30:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (3, 4, '07:30:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (3, 5, '08:00:00', '13:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (4, 0, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (4, 1, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (4, 2, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (4, 3, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (4, 4, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (4, 5, '09:00:00', '13:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (5, 0, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (5, 1, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (5, 2, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (5, 3, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (5, 4, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (5, 5, '10:00:00', '20:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (6, 0, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (6, 1, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (6, 2, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (6, 3, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (6, 4, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (6, 5, '08:00:00', '18:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (7, 0, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (7, 1, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (7, 2, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (7, 3, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (7, 4, '09:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (7, 5, '07:00:00', '15:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (8, 0, '06:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (8, 1, '06:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (8, 2, '06:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (8, 3, '06:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (8, 4, '06:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (8, 5, '07:00:00', '15:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (9, 0, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (9, 1, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (9, 2, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (9, 3, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (9, 4, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (9, 5, '12:00:00', '23:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (10, 0, '07:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (10, 1, '07:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (10, 2, '07:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (10, 3, '07:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (10, 4, '07:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (10, 5, '07:00:00', '15:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (11, 0, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (11, 1, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (11, 2, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (11, 3, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (11, 4, '08:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (11, 5, '08:00:00', '13:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (12, 0, '07:00:00', '19:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (12, 1, '07:00:00', '19:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (12, 2, '07:00:00', '19:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (12, 3, '07:00:00', '19:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (12, 4, '07:00:00', '19:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (12, 5, '08:00:00', '17:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (13, 0, '08:30:00', '17:30:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (13, 1, '08:30:00', '17:30:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (13, 2, '08:30:00', '17:30:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (13, 3, '08:30:00', '17:30:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (13, 4, '08:30:00', '17:30:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (13, 5, '08:30:00', '16:30:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (14, 0, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (14, 1, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (14, 2, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (14, 3, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (14, 4, '11:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (14, 5, '11:00:00', '21:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (15, 0, '10:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (15, 1, '10:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (15, 2, '10:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (15, 3, '10:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (15, 4, '10:00:00', '22:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (15, 5, '10:00:00', '21:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (16, 0, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (16, 1, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (16, 2, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (16, 3, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (16, 4, '08:00:00', '18:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (16, 5, '08:00:00', '17:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (17, 0, '09:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (17, 1, '09:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (17, 2, '09:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (17, 3, '09:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (17, 4, '09:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (17, 5, '09:00:00', '16:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (18, 0, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (18, 1, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (18, 2, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (18, 3, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (18, 4, '10:00:00', '20:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (18, 5, '10:00:00', '19:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (19, 0, '05:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (19, 1, '05:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (19, 2, '05:00:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (19, 3, '05:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (19, 4, '05:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (19, 5, '05:00:00', '15:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (20, 0, '07:00:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (20, 1, '07:00:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (20, 2, '07:00:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (20, 3, '07:00:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (20, 4, '07:00:00', '15:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (20, 5, '07:00:00', '15:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (21, 0, '06:00:00', '14:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (21, 1, '06:00:00', '14:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (21, 2, '06:00:00', '14:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (21, 3, '06:00:00', '14:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (21, 4, '06:00:00', '14:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (21, 5, '06:00:00', '13:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (22, 0, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (22, 1, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (22, 2, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (22, 3, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (22, 4, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (22, 5, '07:00:00', '15:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (23, 0, '11:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (23, 1, '11:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (23, 2, '11:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (23, 3, '11:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (23, 4, '11:00:00', '17:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (23, 5, '11:00:00', '17:00:00');

INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (24, 0, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (24, 1, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (24, 2, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (24, 3, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (24, 4, '07:00:00', '16:00:00');
INSERT INTO studio_working_hours (studio_id, day_of_week, opening_time, closing_time) VALUES (24, 5, '07:00:00', '16:00:00');


