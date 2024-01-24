select zip_code,order_id from customers as c left join orders as o
on c.customer_id=o.customer_id where shipped_date is not null and store_id=27;
