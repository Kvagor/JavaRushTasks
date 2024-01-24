select c.customer_id,email,order_id,order_status from customers as c
join orders as o on c.customer_id=o.customer_id
where order_status='PAID' or order_status='PROCESSING';
