select ret_name,ret_location,sup_name,sup_country
from top_retailers as r join suppliers as s on ret_location=sup_country;


