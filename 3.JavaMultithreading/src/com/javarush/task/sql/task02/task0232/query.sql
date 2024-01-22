select is_full_time, count(*) from students where is_full_time in(0,1)
group by is_full_time;