select ret_name,ret_revenue,sup_name,sup_revenue from top_retailers as retailer join
suppliers as supplier on ret_revenue=sup_revenue where sup_revenue>50;
