select dayname(date),count(*) from event where type='REGISTRATION' group by 1
order by 2 desc limit 1;
