select year(date),month(date),day(date),sum(total) from data group by 1,2,3;
