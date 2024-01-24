select * from film_directors where full_name like
(select concat(first_name,concat(' ',last_name)) from film_directors  limit 1);
