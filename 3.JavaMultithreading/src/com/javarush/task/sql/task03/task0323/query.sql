select last_name as surname, order_id from customers left join orders
on customers.customer_id=orders.customer_id;
