--USERS
INSERT INTO users(id, email, firstname, lastname, password)
VALUES ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James', 'Bond', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'),
       ('48ccfd66-6a63-4436-ac92-fe230614aaca', 'karma@example.com', 'Karma', 'Tselha', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6');

--ROLES
INSERT INTO role(id, name)
VALUES ('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
       ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER') ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
       ('d5866d24-d7d2-4b1e-9b4c-dc8b0c8d4bd7', 'USER_READ'),
       ('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
       ('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DELETE'),
       ('64030c3a-c260-453c-847f-a46950a6ac21', 'MOVIE_READ'),
       ('aa04799f-35c7-48bc-94b0-c156b8802969', 'MOVIE_READ_ALL'),
       ('82e779f6-21fd-49df-84b4-c01f00766eff', 'MOVIE_CREATE'),
       ('45ba7560-8459-4ae6-8edf-ffe204c7ddc3', 'MOVIE_MODIFY'),
       ('430f4ad9-55cc-4cc4-a182-24a829de36e0', 'MOVIE_DELETE') ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values ('48ccfd66-6a63-4436-ac92-fe230614aaca', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02') ON CONFLICT DO NOTHING;

--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'aa04799f-35c7-48bc-94b0-c156b8802969'), -- USER    - MOVIE_READ_ALL
       ('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'), -- ADMIN   - USER_MODIFY
       ('ab505c92-7280-49fd-a7de-258e618df074', '21c942db-a275-43f8-bdd6-d048c21bf5ab'), -- ADMIN   - USER_DELETE
       ('ab505c92-7280-49fd-a7de-258e618df074', 'd5866d24-d7d2-4b1e-9b4c-dc8b0c8d4bd7'), -- ADMIN   - USER_READ
       ('ab505c92-7280-49fd-a7de-258e618df074', '45ba7560-8459-4ae6-8edf-ffe204c7ddc3'), -- ADMIN   - MOVIE_MODIFY
       ('ab505c92-7280-49fd-a7de-258e618df074', '64030c3a-c260-453c-847f-a46950a6ac21'), -- ADMIN   - MOVIE_READ
       ('ab505c92-7280-49fd-a7de-258e618df074', 'aa04799f-35c7-48bc-94b0-c156b8802969'), -- ADMIN   - MOVIE_READ_ALL
       ('ab505c92-7280-49fd-a7de-258e618df074', '82e779f6-21fd-49df-84b4-c01f00766eff'), -- ADMIN   - MOVIE_CREATE
       ('ab505c92-7280-49fd-a7de-258e618df074', '430f4ad9-55cc-4cc4-a182-24a829de36e0')  -- ADMIN   - MOVIE_DELETE
    ON CONFLICT DO NOTHING;

CREATE TABLE IF NOT EXISTS movies (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    genre VARCHAR NOT NULL,
    "cast" VARCHAR NOT NULL,
    release_date DATE NOT NULL,
    summary VARCHAR NOT NULL,
    image VARCHAR NOT NULL
);

-- Insert data into movies table
INSERT INTO movies(id, name, genre, "cast", release_date, summary, image)
VALUES
    ( 'a87c95be-2f2a-4bbb-b535-6c6f0e2f2c1c', 'Inception', 'Sci-Fi', 'Leonardo DiCaprio, Joseph Gordon-Levitt', '2010-07-16', 'A thief enters the dreams of others to steal their secrets.', 'inception.jpg'),
    ( '21955201-213e-4783-8ee9-14a21daa1003', 'The Shawshank Redemption', 'Drama', 'Tim Robbins, Morgan Freeman', '1994-09-10', 'Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.', 'shawshank_redemption.jpg'),
    ( '9ab68393-7477-42f3-a827-271b92fd8163', 'The Dark Knight', 'Action', 'Christian Bale, Heath Ledger', '2008-07-18', 'Batman must confront the mysterious and anarchic Joker.', 'dark_knight.jpg'),
    ( '12f9a571-7789-4b08-ae77-894a68d520b7', 'Pulp Fiction', 'Crime', 'John Travolta, Uma Thurman', '1994-10-14', 'Various interconnected stories of crime and redemption.', 'pulp_fiction.jpg'),
    ( 'e58bf52e-b5a9-496e-9eee-13f0add0dd23', 'The Godfather', 'Crime', 'Marlon Brando, Al Pacino', '1972-03-24', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'godfather.jpg'),
    ( '687292b1-86e2-459b-ae48-ead67a33ff87', 'The Matrix', 'Sci-Fi', 'Keanu Reeves, Laurence Fishburne', '1999-03-31', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'matrix.jpg'),
    ( '41e2d58c-27b1-40f3-8812-487edfc60890', 'Forrest Gump', 'Drama', 'Tom Hanks, Robin Wright', '1994-07-06', 'A man with a low IQ embarks on a journey through decades of American history.', 'forrest_gump.jpg'),
    ( '387e8315-47f6-47f8-850e-5e4a5adeef12', 'Schindlers List', 'Biography', 'Liam Neeson, Ben Kingsley', '1993-12-15', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.', 'schindlers_list.jpg'),
    ( 'dd5b9fe4-33da-4146-8682-b26ed20900cd', 'Fight Club', 'Drama', 'Brad Pitt, Edward Norton', '1999-10-15', 'An insomniac office worker and a soap salesman form an underground fight club.', 'fight_club.jpg'),
    ( '9653f621-9237-4b82-b1db-06d44f4e66d1', 'The Lord of the Rings: The Fellowship of the Ring', 'Adventure', 'Elijah Wood, Ian McKellen', '2001-12-19', 'A young hobbit, Frodo, is tasked with destroying a powerful ring to prevent the dark lord Sauron from taking over the world.', 'lotr_fellowship.jpg'),
    ( '7a7c28df-6b3a-4b0b-b3a7-caa2de470625', 'Titanic', 'Romance', 'Leonardo DiCaprio, Kate Winslet', '1997-12-19', 'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.', 'titanic.jpg'),
    ( '1a6889a7-39e0-41af-ada5-f44694ce1cbe', 'Inglourious Basterds', 'War', 'Brad Pitt, Christoph Waltz', '2009-08-21', 'In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owners vengeful plans for the same.', 'inglourious_basterds.jpg'),
    ( 'de08dd01-07d8-4403-a559-20c17c9d9581', 'The Silence of the Lambs', 'Crime', 'Jodie Foster, Anthony Hopkins', '1991-02-14', 'A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.', 'silence_of_the_lambs.jpg'),
    ( '593c2c09-e356-4e61-b0c1-b592d6d23022', 'Jurassic Park', 'Adventure', 'Sam Neill, Laura Dern', '1993-06-11', 'A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs cloned from prehistoric DNA.', 'jurassic_park.jpg'),
    ( '5db40e80-bf56-4b01-b14c-d5c92146876f', 'The Departed', 'Crime', 'Leonardo DiCaprio, Matt Damon', '2006-10-06', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in Boston.', 'the_departed.jpg'),
    ( '8a6f70d1-e5c7-4de4-b189-79d796a46698', 'Avatar', 'Action', 'Sam Worthington, Zoe Saldana', '2009-12-18', 'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.', 'avatar.jpg'),
    ( '4700a719-532a-4067-aca2-4f7680746b65', 'The Green Mile', 'Crime', 'Tom Hanks, Michael Clarke Duncan', '1999-12-10', 'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.', 'green_mile.jpg'),
    ( '246f781d-b62f-4f9d-a46b-2ac92d6a32cc', 'Goodfellas', 'Crime', 'Robert De Niro, Ray Liotta', '1990-09-12', 'The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.', 'goodfellas.jpg'),
    ( '58e43f01-5213-46a1-a9c6-ce1688f2dc90', 'Eternal Sunshine of the Spotless Mind', 'Drama', 'Jim Carrey, Kate Winslet', '2004-03-19', 'When their relationship turns sour, a couple undergoes a medical procedure to have each other erased from their memories.', 'eternal_sunshine.jpg'),
    ( '88e43f01-5213-42a1-a9c6-ce1688f2fc90', 'The Usual Suspects', 'Crime', 'Kevin Spacey, Gabriel Byrne', '1995-09-15', 'A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.', 'usual_suspects.jpg');




