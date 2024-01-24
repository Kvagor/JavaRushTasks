select * from authors where author_id not in
(select author_id from books where author_id=7 and title='War and Peace');
