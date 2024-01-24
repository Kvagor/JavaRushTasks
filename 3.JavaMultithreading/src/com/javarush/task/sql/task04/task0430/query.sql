select year(date_time),month(date_time),day(date_time), count(*) from event
group by 1,2,3 having count(*)>5;
