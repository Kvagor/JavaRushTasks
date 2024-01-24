select * from authors where full_name not like
(select concat(first_name,concat(' ',last_name)) from authors where last_name='Shakespeare');
