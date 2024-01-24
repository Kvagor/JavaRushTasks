select city,store_id from customers right join orders
on customers.customer_id=orders.customer_id
where order_status='SHIPPED' and total_cost>100;

