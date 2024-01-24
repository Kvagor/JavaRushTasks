select sex as author_sex,country as author_country,copies_sold_millions as books_sold
from authors as a join books as b on a.author_id=b.author_id
where copies_sold_millions>10 group by sex,country,copies_sold_millions
order by copies_sold_millions desc;
