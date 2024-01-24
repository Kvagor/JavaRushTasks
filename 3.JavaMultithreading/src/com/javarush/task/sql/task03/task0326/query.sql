select email,order_id,orders.customer_id,order_date,order_status,total_cost,shipped_date,
store_id,staff_id from customers right join orders on customers.customer_id=orders.customer_id;
