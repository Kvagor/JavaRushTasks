select top_retailers.rank as company_rank, top_retailers.name as company_name,
annual_revenue_billions as supplier_revenue from top_retailers,suppliers
where annual_revenue_billions>25;
