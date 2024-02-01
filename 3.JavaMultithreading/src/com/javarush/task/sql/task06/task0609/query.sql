insert into sale_addresses
select street, city, state, zip_code, country
from customers
where country = 'Testostan';
