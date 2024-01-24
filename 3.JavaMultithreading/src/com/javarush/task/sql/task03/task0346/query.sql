select * from films join (select year_born,id from film_directors where year_born<1940)
as director on id=director_id where genre='sci-fi';
