select ret_name,ret_revenue,sup_name,sup_revenue from top_retailers join suppliers
on ret_revenue=sup_revenue;
