select monthname(date),count(*) from event where status in('ERROR','FAILED')
group by 1 order by 2 desc limit 1;
