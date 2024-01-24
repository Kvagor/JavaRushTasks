select last_name from film_directors left join
(select grossed,director_id from films where grossed>100) as film
on id=director_id where country='UK';
