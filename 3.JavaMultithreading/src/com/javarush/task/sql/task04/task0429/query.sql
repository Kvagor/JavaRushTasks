select * from event where date_time between date_sub(curdate(),14) and curdate();
