select last_name as author,country as author_country,genre as book_genre
from authors as author left join books as book on author.author_id=book.author_id
where genre='fantasy' group by last_name, country, genre order by country asc limit 5;
