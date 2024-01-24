select * from customers join orders on customers.customer_id=orders.customer_id
where total_cost>100;
