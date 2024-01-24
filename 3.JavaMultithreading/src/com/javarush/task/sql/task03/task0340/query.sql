select * from authors where author_id in
(select author_id from books where author_id is not null and genre='novel');
