-- Write your code here:
select * from car where model not like '%a%' and (quantity-booked_quantity) between 5 and 500;