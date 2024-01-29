CREATE TABLE IF NOT EXISTS movies (
    id INTEGER PRIMARY KEY,
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
    ( 1, 'Inception', 'Sci-Fi', 'Leonardo DiCaprio, Joseph Gordon-Levitt', '2010-07-16', 'A thief enters the dreams of others to steal their secrets.', 'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg'),
    ( 2, 'The Shawshank Redemption', 'Drama', 'Tim Robbins, Morgan Freeman', '1994-09-10', 'Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.', 'https://m.media-amazon.com/images/I/51x65RBuFnL._AC_UF894,1000_QL80_.jpg'),
    ( 3, 'The Dark Knight', 'Action', 'Christian Bale, Heath Ledger', '2008-07-18', 'Batman must confront the mysterious and anarchic Joker.', 'https://musicart.xboxlive.com/7/abb02f00-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080'),
    ( 4, 'Pulp Fiction', 'Crime', 'John Travolta, Uma Thurman', '1994-10-14', 'Various interconnected stories of crime and redemption.', 'https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg'),
    ( 5, 'The Godfather', 'Crime', 'Marlon Brando, Al Pacino', '1972-03-24', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg'),
    ( 6, 'The Matrix', 'Sci-Fi', 'Keanu Reeves, Laurence Fishburne', '1999-03-31', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg'),
    ( 7, 'Forrest Gump', 'Drama', 'Tom Hanks, Robin Wright', '1994-07-06', 'A man with a low IQ embarks on a journey through decades of American history.', 'https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p15829_v_v13_aa.jpg'),
    ( 8, 'Schindlers List', 'Biography', 'Liam Neeson, Ben Kingsley', '1993-12-15', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.', 'https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg'),
    ( 9, 'Fight Club', 'Drama', 'Brad Pitt, Edward Norton', '1999-10-15', 'An insomniac office worker and a soap salesman form an underground fight club.', 'https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg'),
    ( 10, 'The Lord of the Rings: The Fellowship of the Ring', 'Adventure', 'Elijah Wood, Ian McKellen', '2001-12-19', 'A young hobbit, Frodo, is tasked with destroying a powerful ring to prevent the dark lord Sauron from taking over the world.', 'lotr_fellowship.jpg'),
    ( 11, 'Titanic', 'Romance', 'Leonardo DiCaprio, Kate Winslet', '1997-12-19', 'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.', 'titanic.jpg'),
    ( 12, 'Inglourious Basterds', 'War', 'Brad Pitt, Christoph Waltz', '2009-08-21', 'In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owners vengeful plans for the same.', 'inglourious_basterds.jpg'),
    ( 13, 'The Silence of the Lambs', 'Crime', 'Jodie Foster, Anthony Hopkins', '1991-02-14', 'A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.', 'silence_of_the_lambs.jpg'),
    ( 14, 'Jurassic Park', 'Adventure', 'Sam Neill, Laura Dern', '1993-06-11', 'A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs cloned from prehistoric DNA.', 'jurassic_park.jpg'),
    ( 15, 'The Departed', 'Crime', 'Leonardo DiCaprio, Matt Damon', '2006-10-06', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in Boston.', 'the_departed.jpg'),
    ( 16, 'Avatar', 'Action', 'Sam Worthington, Zoe Saldana', '2009-12-18', 'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.', 'avatar.jpg'),
    ( 17, 'The Green Mile', 'Crime', 'Tom Hanks, Michael Clarke Duncan', '1999-12-10', 'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.', 'green_mile.jpg'),
    ( 18, 'Goodfellas', 'Crime', 'Robert De Niro, Ray Liotta', '1990-09-12', 'The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.', 'goodfellas.jpg'),
    ( 19, 'Eternal Sunshine of the Spotless Mind', 'Drama', 'Jim Carrey, Kate Winslet', '2004-03-19', 'When their relationship turns sour, a couple undergoes a medical procedure to have each other erased from their memories.', 'eternal_sunshine.jpg'),
    ( 20, 'The Usual Suspects', 'Crime', 'Kevin Spacey, Gabriel Byrne', '1995-09-15', 'A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.', 'usual_suspects.jpg');




