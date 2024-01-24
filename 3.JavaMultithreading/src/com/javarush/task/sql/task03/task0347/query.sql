select * from film_directors right join (select title,director_id from films where year_released>1990)
as film on id=director_id where country='USA' limit 5;
