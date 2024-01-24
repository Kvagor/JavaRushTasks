select last_name as author,genre as book_genre, date_released
from authors as auth right join books as book on auth.author_id=book.author_id
where date_released<1900 group by genre,date_released;
