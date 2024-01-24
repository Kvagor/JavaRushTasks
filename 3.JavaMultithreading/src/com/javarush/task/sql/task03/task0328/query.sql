select phone as cust_phone,order_date, total_cost, store_id
from customers right join orders on customers.customer_id=orders.customer_id
where city='New York' and order_status='PROCESSING';
