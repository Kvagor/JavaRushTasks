select country as author_country,count(book_id) as book_count
from authors as author join books as book on author.author_id=book.author_id
where genre='novel' group by country having book_count>2;
