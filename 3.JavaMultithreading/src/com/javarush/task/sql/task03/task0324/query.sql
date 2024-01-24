select c.customer_id,order_id from customers as c left join orders as o
on c.customer_id=o.customer_id where shipped_date is null;
